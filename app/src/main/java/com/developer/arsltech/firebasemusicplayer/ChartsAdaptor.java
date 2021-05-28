package com.developer.firebasemusicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChartsAdaptor extends RecyclerView.Adapter {
    List<track> trackList;
    Context context;

    public ChartsAdaptor(List<track> trackList, Context context) {
        this.trackList = trackList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.top_chart_item, parent, false);
        return new ChartsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ChartsViewHolder) holder).bindData(trackList.get(position));
    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }
}

class ChartsViewHolder extends RecyclerView.ViewHolder {
    TextView textView;
    public ChartsViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.textView);
    }

    public void bindData(final track tr){
        textView.setText(tr.getTrack().getTrack_name());
    }
}
