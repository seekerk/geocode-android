package org.fruct.oss.geocode;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
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
import org.fruct.oss.geopoint.base.KPIproxy;
import org.fruct.oss.geopoint.base.SIBFactory;
import org.fruct.oss.geopoint.base.TaskListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sofia_kp.KPICore;
import sofia_kp.SIBResponse;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private static String TAG = "MainActivityFragment";

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

        for(int i = 0; i < 10; i++) {
            GeoPoint itm = new GeoPoint();
            itm.hasLatitude(Math.random());
            itm.hasLongitude(Math.random());
            items.add(itm);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        //TODO: загрузка данных сервера с преференсов
        tbHost.setText("smartroom.cs.petrsu.ru");
        tbPort.setText(String.valueOf(10010));
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: коннект к СИБу, подписка на тройки, загрузка данных в список
                //TODO: продумать отключение от сиба и переконнект?
                KPIproxy core = SIBFactory.getInstance().getAccessPoint();
                core.setAddr(tbHost.getText().toString(), Integer.parseInt(tbPort.getText().toString()));
                core.connect().addListener(new TaskListener() {
                    public void onSuccess() {
                        Toast.makeText(getContext(), "Connection was successful!", Toast.LENGTH_LONG).show();
                    }

                    public void onError(Throwable ex) {
                        Toast.makeText(getContext(), "Error: " + ex.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        adapter = new ItemAdapter(getContext(), items);
        lvItems.setAdapter(adapter);

        return view;
    }
}
