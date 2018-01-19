package org.fruct.oss.geocode;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.fruct.oss.geopoint.GeoPoint;

import java.util.List;

/**
 * Created by kulakov on 11.01.18.
 */

public class ItemAdapter extends BaseAdapter {
    private static String TAG = ItemAdapter.class.getName();

    Context ctx;

    // спиоск точек
    List<GeoPoint> items;

    LayoutInflater lInflater;

    ItemAdapter(Context ctx, List<GeoPoint> items) {
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

        GeoPoint itm = (GeoPoint) getItem(i);
        Log.d(TAG, "Point latitude: \"" + itm.getHasLatitude().get(0) + "\"");
        ((TextView) view.findViewById(R.id.latitude)).setText(String.format("%1$,.6f", Double.valueOf(itm.getHasLatitude().get(0))));
        ((TextView) view.findViewById(R.id.longitude)).setText(String.format("%1$,.6f", Double.valueOf(itm.getHasLongitude().get(0))));

        return view;
    }
}
