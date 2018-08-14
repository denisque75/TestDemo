package com.denysque.testdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.denysque.testdemo.App;
import com.denysque.testdemo.R;
import com.denysque.testdemo.core.models.Forecast;
import com.denysque.testdemo.core.repository.DatabaseRepository;
import com.denysque.testdemo.core.repository.LoadForecastRepository;
import com.denysque.testdemo.core.repository.RoomDBRepository;
import com.denysque.testdemo.core.retrofit.WeatherAPI;
import com.denysque.testdemo.core.retrofit.WeatherApiRetrofit;
import com.denysque.testdemo.ui.detailed_screen.DetailedActivity;
import com.denysque.testdemo.ui.detailed_screen.DetailedView;
import com.denysque.testdemo.ui.recyclerView.ForecastAdapter;
import com.denysque.testdemo.ui.search_city.SearchCityCallback;
import com.denysque.testdemo.ui.search_city.SearchDialogFragment;
import com.denysque.testdemo.utils.RetrofitCreator;

import java.util.List;

public class MainActivity extends MvpAppCompatActivity implements MainView, SearchCityCallback {
    @InjectPresenter
    Presenter mainPresenter;
    private ForecastAdapter adapter;

    @ProvidePresenter
    public Presenter provideMainPresenter() {
        WeatherApiRetrofit weatherApiRetrofit = new WeatherApiRetrofit(RetrofitCreator.createRetrofit());
        WeatherAPI weatherApi = weatherApiRetrofit.create(WeatherAPI.class);
        DatabaseRepository dbRepository = new RoomDBRepository(((App) getApplication()).getDatabase());
        mainPresenter = new Presenter(new LoadForecastRepository(weatherApi), dbRepository);
        return mainPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainPresenter.createSearchDialog();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.main_screen__recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ForecastAdapter(new OnItemClickListener<Forecast>() {
            @Override
            public void onClicked(Forecast data) {
                mainPresenter.onItemClicked(data);
            }
        });
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void openDetailedView(long cityId) {
        Intent intent = new Intent(this, DetailedActivity.class);
        intent.putExtra(DetailedView.CITY_ID, cityId);
        startActivity(intent);
    }

    @Override
    public void showForecast(Forecast forecasts) {
        adapter.addItem(forecasts);
    }

    @Override
    public void showForecasts(List<Forecast> forecastList) {
        adapter.setItems(forecastList);
    }

    @Override
    public void showSearchDialog() {
        new SearchDialogFragment().show(getSupportFragmentManager(), "SEARCH_CITY");
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cityWeather(String city) {
        mainPresenter.searchForecast(city);
    }
}
