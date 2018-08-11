package com.denysque.testdemo.ui.detailed_screen;

import com.arellomobile.mvp.MvpPresenter;
import com.denysque.testdemo.core.pojo.CityForecast;
import com.denysque.testdemo.core.repository.ForecastRepository;

import java.util.List;

public class DetailedPresenter extends MvpPresenter<DetailedView> {
    private final ForecastRepository repository;

    public DetailedPresenter(ForecastRepository forecastRepository) {
        this.repository = forecastRepository;
        display();
    }

    private void display() {
        repository.loadCityForecastFromRepo(new ForecastRepository.LoadCityForecastCallback() {
            @Override
            public void loadCityForecast(List<CityForecast> forecast) {
                getViewState().displayForecast(forecast);
            }
        });
    }

}
