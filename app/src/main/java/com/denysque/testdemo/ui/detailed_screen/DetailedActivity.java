package com.denysque.testdemo.ui.detailed_screen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.denysque.testdemo.R;
import com.denysque.testdemo.core.pojo.CityForecast;
import com.denysque.testdemo.core.repository.MainScreenRepositoryStub;
import com.denysque.testdemo.ui.detailed_screen.adapter.DetailedTemperatureAdapter;

import java.util.List;

public class DetailedActivity extends AppCompatActivity implements DetailedView {
    @InjectPresenter
    DetailedPresenter presenter;
    private DetailedTemperatureAdapter each3HourAdapter;
    private DetailedTemperatureAdapter dailyAdapter;

    @ProvidePresenter
    public DetailedPresenter provideDetailedPresenter() {
        presenter = new DetailedPresenter(new MainScreenRepositoryStub());
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        RecyclerView each3HourRecyclerView = findViewById(R.id.detailed__temp3hours_recyclerView);
        each3HourRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        each3HourAdapter = new DetailedTemperatureAdapter();
        each3HourRecyclerView.setAdapter(each3HourAdapter);

        RecyclerView dialyRecyclerView = findViewById(R.id.detailed__temp_daily_recyclerView);
        dialyRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        dailyAdapter = new DetailedTemperatureAdapter();
        dialyRecyclerView.setAdapter(dailyAdapter);
    }

    @Override
    public void displayForecast(List<CityForecast> forecast) {
        each3HourAdapter.setItems(forecast);
        dailyAdapter.setItems(forecast);
    }
}