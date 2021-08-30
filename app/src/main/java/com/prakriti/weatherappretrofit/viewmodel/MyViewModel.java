package com.prakriti.weatherappretrofit.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.prakriti.weatherappretrofit.pojo.WeatherInfo;
import com.prakriti.weatherappretrofit.repository.RetrofitRepo;

public class MyViewModel extends ViewModel {

    private static final String TAG = "ViewModel";
    // the data that is fetched asynchronously
    private MutableLiveData<WeatherInfo> weatherInformation = new MutableLiveData<>();

    // call this method to get live data
    public LiveData<WeatherInfo> getWeatherLiveData() {
//        if (weatherInformation == null) {
//            weatherInformation = new MutableLiveData<>();
//        }
        return weatherInformation;
    }

    // load it asynchronously from server in this method
    // this method will make the Retrofit call to get JSON data from URL
    public void makeApiCall(String location) {
        weatherInformation = RetrofitRepo.getInstance().getWeatherInfo(location);
        Log.i(TAG, "makeApiCall");
    }

}

/*
LiveData -> will return data to MainActivity if u want data to be observed
    aka. can use passed list for recycler adapter, or for other UI Controller operations
    list/coll of data can be accessed from onChanged() method after posting to observer

    Event injection -> when tasks are delegated to background thread, initial response may be null as main & bg thread finish tasks at different times
    so we need a listener to listen for the changes - involves creating interface, overriding methods etc, which is eliminated in viewModel
    that is called event injection
 */