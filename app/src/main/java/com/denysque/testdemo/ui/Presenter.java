package com.denysque.testdemo.ui;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.repository.DatabaseRepository;
import com.denysque.testdemo.core.repository.ForecastRepository;

import java.util.List;

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
        getViewState().showForecasts(dbRepository.getAllForecasts());
        updateCities();
    }

    private void updateCities() {
        updateDefaultCities();
        List<Long> citiesId = dbRepository.getAllCitiesID();
        for (Long id : citiesId) {
            searchForecast(id);
        }
    }

    private void updateDefaultCities() {
        for (String city : AppConstants.DEFAULT_CITIES) {
            searchForecast(city);
        }
    }

    public void searchForecast(String city) {
        repository.loadForecastsFromRepo(city, new ForecastRepository.LoadForecastCallback() {
            @Override
            public void forecastResult(Forecast forecasts) {
                if (forecasts != null) {
                    dbRepository.saveForecast(forecasts);
                    getViewState().showForecast(forecasts);
                } else {
                    getViewState().showMessage("Something went wrong!");
                }
            }
        });
    }

    public void searchForecast(long cityId) {
        repository.loadForecastsFromRepo(cityId, new ForecastRepository.LoadForecastCallback() {
            @Override
            public void forecastResult(Forecast forecasts) {
                if (forecasts != null) {
                    dbRepository.saveForecast(forecasts);
                    getViewState().showForecast(forecasts);
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
            getViewState().openDetailedView(forecast.getId());
        }
    }

}
