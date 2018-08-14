package com.denysque.testdemo.ui;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.repository.DatabaseRepository;
import com.denysque.testdemo.core.repository.ForecastRepository;

@InjectViewState
public class Presenter extends MvpPresenter<MainView> {
    private final ForecastRepository repository;
    private final DatabaseRepository dbRepository;

    public Presenter(ForecastRepository repository, DatabaseRepository dbRepository) {
        this.repository = repository;
        this.dbRepository = dbRepository;
        display();
    }

    private void display() {
        searchForecast("Lviv");

    }

    public void searchForecast(String city) {
        repository.loadForecastsFromRepo(city, new ForecastRepository.LoadForecastCallback() {
            @Override
            public void forecastResult(Forecast forecasts) {
                if (forecasts != null) {
                    getViewState().showForecast(forecasts);
                    dbRepository.saveForecast(forecasts);
                } else {
                    getViewState().showMessage("Something went wrong!");
                }
            }
        });
    }


    public void createSearchDialog() {
        getViewState().showSearchDialog();
    }

    public void onItemClicked(Forecast forecast) {
        if (forecast != null) {
            getViewState().openDetailedView(forecast);
        }
    }

}
