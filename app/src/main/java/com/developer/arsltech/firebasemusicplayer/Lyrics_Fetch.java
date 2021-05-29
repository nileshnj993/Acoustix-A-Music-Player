package com.developer.arsltech.firebasemusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.view.View.GONE;

public class Lyrics_Fetch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics__fetch);

        getSupportActionBar().setTitle("Acoustix");
        Button br = (Button) findViewById(R.id.button3);
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("BHai??");
                EditText edit1 = (EditText) findViewById(R.id.editTextTextPersonName);
                EditText edit2 = (EditText) findViewById(R.id.editTextTextPersonName2);

                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.musixmatch.com/ws/1.1/").addConverterFactory(GsonConverterFactory.create()).build();

                GetData getLyrics = retrofit.create(GetData.class);
                System.out.println(edit1.getText().toString());
                System.out.println(edit2.getText().toString());
                Call<TopTrackModel> cl = getLyrics.getLyrics("f141ed965b8f97393f387009770795b8", edit1.getText().toString(), edit2.getText().toString());

                cl.enqueue(new Callback<TopTrackModel>() {
                    @Override
                    public void onResponse(Call<TopTrackModel> call, Response<TopTrackModel> response) {
                        System.out.println(response.body().getMessage().getBody().getLyrics().getLyrics_body());
                        EditText et = (EditText) findViewById(R.id.editTextTextPersonName);
                        EditText et2 = (EditText) findViewById(R.id.editTextTextPersonName2);
                        Button sb = (Button) findViewById(R.id.button3);

                        et.setVisibility(GONE);
                        et2.setVisibility(GONE);
                        sb.setVisibility(GONE);
                        TextView tv = (TextView) findViewById(R.id.textView3);
                        tv.setVisibility(View.VISIBLE);

                        tv.setText(response.body().getMessage().getBody().getLyrics().getLyrics_body());
                    }

                    @Override
                    public void onFailure(Call<TopTrackModel> call, Throwable t) {
                        System.out.println(t);
                    }
                });
            }
        });
    }
}
