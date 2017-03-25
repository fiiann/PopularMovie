package com.albasyir.jundana.popularmovies.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;

import com.albasyir.jundana.popularmovies.R;
import com.albasyir.jundana.popularmovies.adapter.Movie_Adapter2;
import com.albasyir.jundana.popularmovies.item.Movie_Item;
import com.albasyir.jundana.popularmovies.network.Movie_Network;

import java.util.ArrayList;

public class Movie_Fragment extends android.support.v4.app.Fragment {
    ArrayList<Movie_Item> itemlist;
    int tabposisi;

    public static Movie_Fragment newInstance(int tabposisi) {
        Bundle args = new Bundle();
        args.putInt("id", tabposisi);
        Movie_Fragment fragment = new Movie_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        tabposisi = getArguments().getInt("id");
        itemlist = new ArrayList<>();
        ProgressBar progressbar = (ProgressBar) view.findViewById(R.id.progressbar);
        GridView gridView = (GridView) view.findViewById(R.id.gridview);

        Movie_Adapter2 adapter = new Movie_Adapter2(getActivity(), R.layout.item_movie, itemlist);
        gridView.setAdapter(adapter);

        new Movie_Network(progressbar, itemlist, adapter).execute(tabposisi);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                Bundle b = new Bundle();
                b.putString("id", itemlist.get(position).getId());
                intent.putExtras(b);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }
}
