package com.developer.arsltech.firebasemusicplayer;

import java.util.List;

public class TopTrackModel {
    MessageModel message;

    public TopTrackModel(MessageModel message) {
        this.message = message;
    }

    public MessageModel getMessage() {
        return message;
    }

    public void setMessage(MessageModel message) {
        this.message = message;
    }
}
class MessageModel {
    headerModel header;
    bodyModel body;

    public MessageModel(headerModel header, bodyModel body) {
        this.header = header;
        this.body = body;
    }

    public headerModel getHeader() {
        return header;
    }

    public void setHeader(headerModel header) {
        this.header = header;
    }

    public bodyModel getBody() {
        return body;
    }

    public void setBody(bodyModel body) {
        this.body = body;
    }
}

class headerModel {
    int status_code;
    double execute_time;
    int available;

    public headerModel(int status_code, long execute_time, int available) {
        this.status_code = status_code;
        this.execute_time = execute_time;
        this.available = available;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public double getExecute_time() {
        return execute_time;
    }

    public void setExecute_time(long execute_time) {
        this.execute_time = execute_time;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }
}

class bodyModel {
    List<track> track_list;
    LyricsModel lyrics;

    public bodyModel(LyricsModel lyrics) {
        this.lyrics = lyrics;
    }

    public LyricsModel getLyrics() {
        return lyrics;
    }

    public void setLyrics(LyricsModel lyrics) {
        this.lyrics = lyrics;
    }

    public List<track> getTrack_list() {
        return track_list;
    }

    public void setTrack_list(List<track> track_list) {
        this.track_list = track_list;
    }

    public bodyModel(List<track> track_list) {
        this.track_list = track_list;
    }

}

class track {
    trackModel track;

    public track(trackModel track) {
        this.track = track;
    }

    public trackModel getTrack() {
        return track;
    }

    public void setTrack(trackModel track) {
        this.track = track;
    }
}

class trackModel {
    String track_name;

    public trackModel(String track) {
        this.track_name = track;
    }

    public String getTrack_name() {
        return track_name;
    }

    public void setTrack_name(String track_name) {
        this.track_name = track_name;
    }
}

class LyricsModel {
    String lyrics_body;

    public String getLyrics_body() {
        return lyrics_body;
    }

    public void setLyrics_body(String lyrics_body) {
        this.lyrics_body = lyrics_body;
    }

    public LyricsModel(String lyrics_body) {
        this.lyrics_body = lyrics_body;
    }
}