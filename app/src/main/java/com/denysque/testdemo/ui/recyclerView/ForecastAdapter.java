package com.denysque.testdemo.ui.recyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.denysque.testdemo.BuildConfig;
import com.denysque.testdemo.R;
import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.models.Weather;
import com.denysque.testdemo.core.repository.photo.PhotoRepository;
import com.denysque.testdemo.ui.OnItemClickListener;
import com.denysque.testdemo.utils.TemperatureUtils;
import com.denysque.testdemo.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {
    private final List<Forecast> forecasts;
    private final OnItemClickListener<Forecast> clickListener;
    private final PhotoRepository photoRepository;

    public ForecastAdapter(OnItemClickListener<Forecast> clickListener, PhotoRepository photoRepository) {
        forecasts = new ArrayList<>();
        this.clickListener = clickListener;
        this.photoRepository = photoRepository;
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

    public void addItem(Forecast forecast) {
        if (!this.forecasts.contains(forecast)) {
            this.forecasts.add(forecast);
            notifyItemChanged(forecasts.size() - 1);
        }
    }

    public void removeItem(int position) {
        forecasts.remove(position);
        notifyItemRemoved(position);
    }

    public Forecast getItemByPosition(int position) {
        return forecasts.get(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView positionTextView;
        private TextView updateTimeTextView;
        private TextView degreeTextView;
        private TextView minDegreeTextView;
        private TextView maxDegreeTextView;
        private ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.main_screen__forecast_image);
            positionTextView = itemView.findViewById(R.id.main_screen__position);
            updateTimeTextView = itemView.findViewById(R.id.main_screen_update_time);
            degreeTextView = itemView.findViewById(R.id.main_screen__degrees);
            minDegreeTextView = itemView.findViewById(R.id.main_screen__min_degree);
            maxDegreeTextView = itemView.findViewById(R.id.main_screen__max_degree);
        }

        void bind(final Forecast forecast) {
            positionTextView.setText(forecast.getCity());
            updateTimeTextView.setText(TimeUtils.convertTimeFromLong(forecast.getUpdatedTime()));
            Weather topWeather = forecast.getWeatherList().get(0);
            degreeTextView.setText(TemperatureUtils.convertToString(topWeather.getTemp()));
            maxDegreeTextView.setText(TemperatureUtils.convertToString(topWeather.getMaxTemp()));
            minDegreeTextView.setText(TemperatureUtils.convertToString(topWeather.getMinTemp()));

            photoRepository.loadImage(BuildConfig.PIC_URL + topWeather.getIcon() + BuildConfig.PIC_EXCT, imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onClicked(forecast);
                }
            });
        }
    }
}
