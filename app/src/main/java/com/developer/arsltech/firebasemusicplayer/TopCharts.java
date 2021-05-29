package com.developer.arsltech.firebasemusicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TopCharts extends AppCompatActivity {
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_charts);

        getSupportActionBar().setTitle("Acoustix");

        rv = (RecyclerView) findViewById(R.id.recyclerview);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.musixmatch.com/ws/1.1/").addConverterFactory(GsonConverterFactory.create()).build();
        GetData getData = retrofit.create(GetData.class);

        Call<TopTrackModel> cl = getData.getData();

        cl.enqueue(new Callback<TopTrackModel>() {
            @Override
            public void onResponse(Call<TopTrackModel> call, Response<TopTrackModel> response) {
                rv.setLayoutManager(new LinearLayoutManager(getParent()));
                ChartsAdaptor adaptor = new ChartsAdaptor(response.body().getMessage().getBody().getTrack_list(), getApplicationContext());
                rv.setAdapter(adaptor);
                System.out.println(response.body().getMessage().getBody().getTrack_list().get(0).getTrack().getTrack_name());
            }

            @Override
            public void onFailure(Call<TopTrackModel> call, Throwable t) {
                System.out.println(t);
            }
        });
    }
}
