package com.rovaind.academy.Utils.exoplayerview.extension;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.rovaind.academy.R;
import com.rovaind.academy.Utils.exoplayerview.media.ExoMediaSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mo on 18-2-8.
 * 剑气纵横三万里 一剑光寒十九洲
 */

public class MultiQualitySelectorAdapter extends RecyclerView.Adapter<MultiQualitySelectorAdapter.MultiQualitySelectorViewHolder> {

    public interface MultiQualitySelectorNavigator {

        /***
         * @return interrupted if true
         * */
        boolean onQualitySelected(ExoMediaSource.Quality quality);
    }


    public interface VisibilityCallback {
        void shouldChangeVisibility(int visibility);
    }

    private List<ExoMediaSource.Quality> qualities = new ArrayList<>();
    private MultiQualitySelectorNavigator navigator;


    public MultiQualitySelectorAdapter(List<ExoMediaSource.Quality> qualities, MultiQualitySelectorNavigator navigator) {
        this.qualities.addAll(qualities);
        this.navigator = navigator;
    }

    @NonNull
    @Override
    public MultiQualitySelectorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quality, parent, false);
        return new MultiQualitySelectorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MultiQualitySelectorViewHolder holder, int position) {
        holder.rootView.setOnClickListener(view -> navigator.onQualitySelected(qualities.get(position)));
        holder.qualityDes.setText(qualities.get(position).getDisplayName());
    }

    @Override
    public int getItemCount() {
        return qualities.size();
    }

    class MultiQualitySelectorViewHolder extends RecyclerView.ViewHolder {
        View rootView;
        TextView qualityDes;

        MultiQualitySelectorViewHolder(View itemView) {
            super(itemView);
            rootView = itemView;
            qualityDes = itemView.findViewById(R.id.qualityDes);
        }
    }

}