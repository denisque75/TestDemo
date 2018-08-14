package com.denysque.testdemo.ui.search_city;

import com.arellomobile.mvp.MvpView;

public interface SearchCityView extends MvpView {

    void searchCity(String city, SearchCityCallback callback);
}
