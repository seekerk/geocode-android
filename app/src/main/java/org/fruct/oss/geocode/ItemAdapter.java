package org.fruct.oss.geocode;

import android.content.Context;
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
        ((TextView) view.findViewById(R.id.latitude)).setText(String.format("%1$,.2f", itm.hasLatitude().get(0)));
        ((TextView) view.findViewById(R.id.longitude)).setText(String.format("%1$,.2f", itm.hasLongitude().get(0)));

        return view;
    }
}
