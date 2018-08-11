package com.denysque.testdemo.ui.recyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.denysque.testdemo.R;
import com.denysque.testdemo.core.pojo.Forecast;

import java.util.ArrayList;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    private final List<Forecast> forecasts;

    public ForecastAdapter() {
        forecasts = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(forecasts.get(position));
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    public void setItems(List<Forecast> forecasts) {
        this.forecasts.clear();
        this.forecasts.addAll(forecasts);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView positionTextView;
        private TextView accuratePositionTextView;
        private TextView updateTimeTextView;
        private TextView degreeTextView;
        private TextView minDegreeTextView;
        private TextView maxDegreeTextView;

        ViewHolder(View itemView) {
            super(itemView);
            positionTextView = itemView.findViewById(R.id.main_screen__position);
            accuratePositionTextView = itemView.findViewById(R.id.main_screen__accurate_position);
            updateTimeTextView = itemView.findViewById(R.id.main_screen_update_time);
            degreeTextView = itemView.findViewById(R.id.main_screen__degrees);
            minDegreeTextView = itemView.findViewById(R.id.main_screen__min_degree);
            maxDegreeTextView = itemView.findViewById(R.id.main_screen__max_degree);
        }

        void bind(Forecast forecast) {
            positionTextView.setText(forecast.getPosition());
            accuratePositionTextView.setText(forecast.getAccuratePosition());
            updateTimeTextView.setText(forecast.getTimeOfUpdate());
            degreeTextView.setText(String.valueOf(forecast.getDegree()));
            maxDegreeTextView.setText(String.valueOf(forecast.getMaxDegree()));
            minDegreeTextView.setText(String.valueOf(forecast.getMinDegree()));
        }
    }
}
