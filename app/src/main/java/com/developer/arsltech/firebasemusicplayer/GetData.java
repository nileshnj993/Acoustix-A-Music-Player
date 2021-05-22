package com.developer.arsltech.firebasemusicplayer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetData {
    @GET("chart.tracks.get?apikey=f141ed965b8f97393f387009770795b8&chart_name=top&page=1&page_size=20&country=in&f_has_lyrics=1")
    Call<TopTrackModel> getData();

}
