package com.denysque.testdemo.ui;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.denysque.testdemo.core.models.Forecast;

import java.util.List;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface MainView extends MvpView {

    @StateStrategyType(AddToEndStrategy.class)
    void showForecast(Forecast forecasts);

    @StateStrategyType(AddToEndStrategy.class)
    void showForecasts(List<Forecast> forecastList);

    void openDetailedView(long cityId);

    void showSearchDialog();

    void showMessage(String message);

    @StateStrategyType(AddToEndStrategy.class)
    void removeItem(int position);

    void showProgressBar();

    void hideProgressBar();
}
