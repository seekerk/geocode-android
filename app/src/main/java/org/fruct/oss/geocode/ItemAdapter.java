package org.fruct.oss.geocode;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.fruct.oss.geopoint.Place;
import org.fruct.oss.smartjavalog.base.UpdateListener;

import java.util.List;

/**
 * Created by kulakov on 11.01.18.
 */

public class ItemAdapter extends BaseAdapter {
    private static String TAG = ItemAdapter.class.getName();

    Context ctx;

    // спиоск точек
    List<Place> items;

    LayoutInflater lInflater;

    ItemAdapter(Context ctx, List<Place> items) {
        this.ctx = ctx;
        this.items = items;

        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item, parent, false);
        }

        Place itm = (Place) getItem(i);
        View finalView = view;
        itm.addListener(new UpdateListener() {
            @Override
            public void onUpdate() {
                if (itm.getHasPoint().size() > 0) {
                    itm.getHasPoint().get(0).addListener(itm);
                    if (!itm.getHasPoint().get(0).getHasLatitude().isEmpty()) {
                        Log.d(TAG, "Point latitude: \"" + itm.getHasPoint().get(0).getHasLatitude().get(0) + "\"");
                        ((TextView) finalView.findViewById(R.id.latitude)).setText(String.format("%1$,.6f", Double.valueOf(itm.getHasPoint().iterator().next().getHasLatitude().iterator().next())));
                    } else {
                        ((TextView) finalView.findViewById(R.id.latitude)).setText("n/a");
                    }
                    if (!itm.getHasPoint().get(0).getHasLongitude().isEmpty()) {
                        ((TextView) finalView.findViewById(R.id.longitude)).setText(String.format("%1$,.6f", Double.valueOf(itm.getHasPoint().iterator().next().getHasLongitude().iterator().next())));
                    } else {
                        ((TextView) finalView.findViewById(R.id.latitude)).setText("n/a");
                        ((TextView) finalView.findViewById(R.id.longitude)).setText("n/a");
                    }
                } else {
                    ((TextView) finalView.findViewById(R.id.latitude)).setText("n/a");
                    ((TextView) finalView.findViewById(R.id.longitude)).setText("n/a");
                }
            }

            @Override
            public void onError(Exception ex) {
                Toast.makeText(finalView.getContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        if (!itm.isDownloaded())
            itm.download(true);

        return view;
    }
}
