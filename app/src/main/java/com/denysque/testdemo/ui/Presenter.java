package com.denysque.testdemo.ui;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.denysque.testdemo.core.pojo.Forecast;
import com.denysque.testdemo.core.repository.ForecastRepository;

import java.util.List;

@InjectViewState
public class Presenter extends MvpPresenter<MainView> {
    private final ForecastRepository repository;

    public Presenter(ForecastRepository repository) {
        this.repository = repository;
        display();
    }

    private void display() {
        repository.loadForecastFromRepo(new ForecastRepository.LoadForecastCallback() {
            @Override
            public void loadForecast(List<Forecast> forecasts) {
                getViewState().showForecast(forecasts);
            }
        });

    }

}
