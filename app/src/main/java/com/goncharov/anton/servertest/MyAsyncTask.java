package com.goncharov.anton.servertest;

import android.os.AsyncTask;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class MyAsyncTask extends AsyncTask<String, String, String> {

    private Retrofit retrofit;
    private Data data;
    private Post post;

    @Override  protected String doInBackground(String... params) {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        data = retrofit.create(Data.class);
        Call<Post> call = data.getData(26853294);

        try {
            Response<Post> response = call.execute();
            post = response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override  protected void onPostExecute(String result) {
        super.onPostExecute(result);
        MainActivity.getTextView().setText(post.login + "\n" + post.url + "\n" + post.created_at);
    }
}