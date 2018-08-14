package com.denysque.testdemo.ui;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.denysque.testdemo.core.models.Forecast;

@StateStrategyType(OneExecutionStateStrategy.class)
public interface MainView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showForecast(Forecast forecasts);

    void openDetailedView(Forecast forecast);

    void showSearchDialog();

    void showMessage(String message);
}
