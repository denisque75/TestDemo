package com.denysque.testdemo.ui.detailed_screen;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.denysque.testdemo.core.repository.db.callbacks.DatabaseRepository;

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
        repository.getForecastById(cityId, forecast -> getViewState().displayForecast(forecast));
    }


}
