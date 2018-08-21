package com.denysque.testdemo.ui.detailed_screen.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.denysque.testdemo.R;
import com.denysque.testdemo.core.models.Weather;
import com.denysque.testdemo.utils.TemperatureUtils;
import com.denysque.testdemo.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

public class DetailedTemperatureAdapter extends RecyclerView.Adapter<DetailedTemperatureAdapter.ViewHolder> {
    private final List<Weather> forecasts;

    public DetailedTemperatureAdapter() {
        forecasts = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.temp_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(forecasts.get(position));
    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    public void setItems(List<Weather> forecasts) {
        this.forecasts.clear();
        this.forecasts.addAll(forecasts);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView minTemp;
        private TextView maxTemp;
        private TextView humidity;
        private TextView time;

        ViewHolder(View itemView) {
            super(itemView);
            minTemp = itemView.findViewById(R.id.temp__min_temp);
            maxTemp = itemView.findViewById(R.id.temp__max_temp);
            humidity = itemView.findViewById(R.id.temp__humidity);
            time = itemView.findViewById(R.id.temp__time);
        }

        void bind(Weather weather) {
            minTemp.setText(TemperatureUtils.convertToString(weather.getMinTemp()));
            maxTemp.setText(TemperatureUtils.convertToString(weather.getMaxTemp()));
            humidity.setText(TemperatureUtils.convertToHumidityString(weather.getHumidity()));
            time.setText(TimeUtils.convertTimeFromLong(weather.getTime()));
        }

    }
}
