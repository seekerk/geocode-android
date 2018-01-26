package org.fruct.oss.geocode;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.fruct.oss.geopoint.GeoPoint;
import org.fruct.oss.smartjavalog.base.BaseRDF;
import org.fruct.oss.smartjavalog.base.KPIproxy;
import org.fruct.oss.smartjavalog.base.SIBFactory;
import org.fruct.oss.smartjavalog.base.SubscribeListener;
import org.fruct.oss.smartjavalog.base.SubscribeQuery;
import org.fruct.oss.smartjavalog.base.TaskListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import sofia_kp.KPICore;
import sofia_kp.SIBResponse;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static Logger log = Logger.getLogger(MainActivityFragment.class.getName());

    /**
     * Хост СИБа
     */
    @BindView(R.id.tbHost)
    EditText tbHost;

    /**
     * порт СИБа
     */
    @BindView(R.id.tbPort)
    EditText tbPort;

    /**
     * запуск СИБа
     */
    @BindView(R.id.btnOk)
    Button btnOk;

    @BindView(R.id.dataItems)
    ListView lvItems;

    ItemAdapter adapter;
    List<GeoPoint> items = new ArrayList<>();

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        for(int i = 0; i < 10; i++) {
//            GeoPoint itm = new GeoPoint();
//            itm.setHasLatitude(Math.random());
//            itm.setHasLongitude(Math.random());
//            items.add(itm);
//        }
    }

    private Runnable updateAdapter = new Runnable() {
        @Override
        public void run() {
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        //TODO: загрузка данных сервера с преференсов
        tbHost.setText("etourism.cs.petrsu.ru");
        tbPort.setText(String.valueOf(20203));
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: загрузка данных в список
                //TODO: продумать отключение от сиба и переконнект?
                KPIproxy core = SIBFactory.getInstance().getAccessPoint();
                if (core.isConnected()) {
                    // disconnect
                    core.disconnect().addListener(new TaskListener() {
                        @Override
                        public void onSuccess(SIBResponse response) {
                            Toast.makeText(getContext(), "Disconnected", Toast.LENGTH_LONG).show();
                            btnOk.setText("CONNECT");
                            btnOk.setEnabled(true);
                        }

                        @Override
                        public void onError(Exception ex) {
                            btnOk.setEnabled(true);
                        }
                    });
                } else {
                    btnOk.setEnabled(false);
                    // connect
                    core.setAddr(tbHost.getText().toString(), Integer.parseInt(tbPort.getText().toString()));
                    core.connect().addListener(new TaskListener() {
                        public void onSuccess(SIBResponse resp) {
                            Toast.makeText(getContext(), "Connection was successful!", Toast.LENGTH_LONG).show();
                            log.info("SUCCESS CONNECTION");
                            btnOk.setText("DISCONNECT");
                            btnOk.setEnabled(true);
                            SubscribeQuery.getInstance().addSubscription(GeoPoint.getClassUri(), new SubscribeListener() {
                                @Override
                                public void addItem(BaseRDF item) {
                                    for (GeoPoint pt : items) {
                                        if (pt.getID().equals(item.getID()))
                                            return;
                                    }
                                    log.info(Thread.currentThread().getName() + ": Add point with id=" + item.getID());
                                    items.add((GeoPoint) item);
                                    lvItems.post(updateAdapter);
                                }

                                @Override
                                public void removeItem(BaseRDF item) {
                                    Iterator<GeoPoint> iter = items.iterator();

                                    while(iter.hasNext()) {
                                        GeoPoint pt = iter.next();

                                        if (pt.getID().equals(item.getID())) {
                                            log.info(Thread.currentThread().getName() + ": Remove point with id=" + item.getID());
                                            iter.remove();
                                            lvItems.post(updateAdapter);
                                            return;
                                        }
                                    }
                                }

                                @Override
                                public void onError(Exception ex) {
                                    Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            });
                        }

                        public void onError(Throwable ex) {
                            Toast.makeText(getContext(), "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                            ex.printStackTrace();
                            btnOk.setEnabled(true);
                        }
                    });
                    log.info("Main thread: " + Thread.currentThread().getName());
                }
            }
        });

        adapter = new ItemAdapter(getContext(), items);
        lvItems.setAdapter(adapter);

        return view;
    }
}
