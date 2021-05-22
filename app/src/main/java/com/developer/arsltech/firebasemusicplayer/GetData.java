package com.developer.arsltech.firebasemusicplayer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetData {
    @GET("chart.tracks.get?apikey=f141ed965b8f97393f387009770795b8&chart_name=top&page=1&page_size=20&country=in&f_has_lyrics=1")
    Call<TopTrackModel> getData();

    @GET("matcher.lyrics.get")
    Call<TopTrackModel> getLyrics(@Query("apikey") String key, @Query("q_track") String trackname, @Query("q_artist") String artist);
}
