package com.denysque.testdemo.ui.detailed_screen;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.denysque.testdemo.App;
import com.denysque.testdemo.BuildConfig;
import com.denysque.testdemo.R;
import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.models.Weather;
import com.denysque.testdemo.core.repository.db.RoomDBRepository;
import com.denysque.testdemo.core.repository.db.callbacks.DatabaseRepository;
import com.denysque.testdemo.core.repository.photo.PhotoRepository;
import com.denysque.testdemo.core.repository.photo.PicassoRepository;
import com.denysque.testdemo.ui.detailed_screen.adapter.DetailedTemperatureAdapter;
import com.denysque.testdemo.utils.TemperatureUtils;
import com.denysque.testdemo.utils.TimeUtils;

public class DetailedActivity extends MvpAppCompatActivity implements DetailedView {
    @InjectPresenter
    DetailedPresenter presenter;
    private DetailedTemperatureAdapter each3HourAdapter;
    private PhotoRepository picassoRepository;

    @ProvidePresenter
    public DetailedPresenter provideDetailedPresenter() {
        long cityId = getIntent().getLongExtra(CITY_ID, 0L);
        DatabaseRepository dbRepository = new RoomDBRepository(((App) getApplication()).getDatabase());
        presenter = new DetailedPresenter(cityId, dbRepository);
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        RecyclerView each3HourRecyclerView = findViewById(R.id.detailed__temp3hours_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        each3HourRecyclerView.setLayoutManager(layoutManager);
        each3HourAdapter = new DetailedTemperatureAdapter();
        each3HourRecyclerView.setAdapter(each3HourAdapter);

        picassoRepository = new PicassoRepository();
    }

    @Override
    public void displayForecast(Forecast forecast) {
        TextView cityName = findViewById(R.id.detailed__position);
        cityName.setText(forecast.getCity());
        TextView time = findViewById(R.id.detailed__time);
        time.setText(TimeUtils.convertTimeFromLong(forecast.getUpdatedTime()));
        ImageView imageView = findViewById(R.id.detailed__main_image);

        Weather topWeather = forecast.getWeatherList().get(0);
        picassoRepository.loadImage(BuildConfig.PIC_URL + topWeather.getIcon() + BuildConfig.PIC_EXCT, imageView);
        TextView mainTemp = findViewById(R.id.detailed__main_temperature);
        mainTemp.setText(TemperatureUtils.convertToString(topWeather.getTemp()));
        TextView minTemp = findViewById(R.id.detailed__min_degree);
        minTemp.setText(TemperatureUtils.convertToString(topWeather.getMinTemp()));
        TextView maxTemp = findViewById(R.id.detailed__max_degree);
        maxTemp.setText(TemperatureUtils.convertToString(topWeather.getMaxTemp()));
        TextView humidity = findViewById(R.id.detailed__humidity);
        humidity.setText(TemperatureUtils.convertToHumidityString(topWeather.getHumidity()));

        each3HourAdapter.setItems(forecast.getWeatherList());
    }

}
