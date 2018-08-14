package com.denysque.testdemo.ui.detailed_screen;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.repository.DatabaseRepository;

@InjectViewState
public class DetailedPresenter extends MvpPresenter<DetailedView> {
    private final DatabaseRepository repository;
    private final long cityId;

    public DetailedPresenter(long cityId, DatabaseRepository repository) {
        this.cityId = cityId;
        this.repository = repository;
        display();
    }

    private void display() {
        Forecast forecast = repository.getForecastById(cityId);
        getViewState().displayForecast(forecast);
    }


}
