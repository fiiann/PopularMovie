package com.albasyir.jundana.popularmovies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.albasyir.jundana.popularmovies.R;
import com.albasyir.jundana.popularmovies.item.Movie_Item;
import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Movie_Adapter2 extends ArrayAdapter<Movie_Item> {
    ArrayList<Movie_Item> itemlist;
    Context context;
    int resource;
    LayoutInflater vi;
    SimpleDateFormat sdf;
    public Movie_Adapter2(Context context, int resource, ArrayList<Movie_Item> itemlist) {
        super(context, resource, itemlist);
        vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.itemlist = itemlist;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        v = vi.inflate(resource, null);
        if (vi != null) {
            final String NEW_FORMAT = "dd MMMM, yyyy";
            String newDateString = itemlist.get(position).getDate();
            final String OLD_FORMAT = "yyyy-MM-dd";
            sdf = new SimpleDateFormat(OLD_FORMAT);

            try {
                Date d = sdf.parse(itemlist.get(position).getDate());
                sdf.applyPattern(NEW_FORMAT);
                newDateString = sdf.format(d);
            } catch (Exception e) {

            }

            ImageView imageTitle = (ImageView) v.findViewById(R.id.imageTitle);

            Glide.with(context)
                    .load(itemlist.get(position).getImage())
                    .error(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageTitle);

        }


        return v;
    }
}
