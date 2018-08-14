package com.denysque.testdemo.ui.detailed_screen;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.repository.CityRepository;

@InjectViewState
public class DetailedPresenter extends MvpPresenter<DetailedView> {
    private final CityRepository repository;

    public DetailedPresenter(CityRepository forecastRepository) {
        this.repository = forecastRepository;
        display();
    }

    private void display() {
        repository.loadCityForecastFromRepo(new CityRepository.LoadCityForecastCallback() {
            @Override
            public void loadCityForecast(Forecast forecast) {
                getViewState().displayForecast(forecast);
            }
        });
    }


}
