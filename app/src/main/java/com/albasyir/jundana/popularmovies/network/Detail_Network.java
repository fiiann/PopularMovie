package com.albasyir.jundana.popularmovies.network;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import com.albasyir.jundana.popularmovies.network.intern.BaseNetwork;
import com.albasyir.jundana.popularmovies.network.intern.BaseUrl;
import com.albasyir.jundana.popularmovies.ui.DetailActivity;

import org.json.JSONObject;

public class Detail_Network extends AsyncTask<String, Void, String> implements BaseUrl {
    String id;
    Activity context;
    String response;

    public Detail_Network(Activity context, String id) {
        this.id = id;
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        response = new BaseNetwork().setNetwork("https://api.themoviedb.org/3/movie/" + id, apikey);
        Log.e("response", response);
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        parsingdata(response);
    }

    void parsingdata(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            String title = jsonObject.getString("original_title");
            String desc = jsonObject.getString("overview");
            String image ="http://image.tmdb.org/t/p/w500"+ jsonObject.getString("backdrop_path");
            String imageposter ="http://image.tmdb.org/t/p/w500"+ jsonObject.getString("poster_path");
            String date = jsonObject.getString("release_date");
            String urltriler = jsonObject.getString("homepage");

            ((DetailActivity) context).setData(title, date, desc, image,urltriler,imageposter);
        } catch (Exception e) {

        }

    }
}
