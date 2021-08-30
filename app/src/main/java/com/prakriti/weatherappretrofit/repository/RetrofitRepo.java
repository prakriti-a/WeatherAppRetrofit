package com.prakriti.weatherappretrofit.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.prakriti.weatherappretrofit.network.ApiCaller;
import com.prakriti.weatherappretrofit.network.RetrofitClient;
import com.prakriti.weatherappretrofit.pojo.WeatherInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitRepo {

    private final static String TAG = "Repository";
    private final static String apiKey = "66f3cfea2d52f0f35c01a1b9b39d2ff5";
    private final static String units = "metric";

    private static RetrofitRepo retrofitRepo;

    private MutableLiveData<WeatherInfo> weatherInfoMutableLiveData = new MutableLiveData<>();
    private ApiCaller apiCaller = RetrofitClient.getClient().create(ApiCaller.class);

    public static RetrofitRepo getInstance() {
        if(retrofitRepo == null) {
            retrofitRepo = new RetrofitRepo();
        }
        return retrofitRepo;
    }

    public MutableLiveData<WeatherInfo> getWeatherInfo(String location) {
        Call<WeatherInfo> weatherData = apiCaller.getResponse(location, units, apiKey);
        // Call is an interface that sends request to server & gets a response
        weatherData.enqueue(new Callback<WeatherInfo>() { // using enqueue() executes calls asynchronously
            @Override
            public void onResponse(Call<WeatherInfo> call, Response<WeatherInfo> response) {
                if(response.isSuccessful()) {
                    // pass info to MainActivity
                    weatherInfoMutableLiveData.postValue(response.body()); // setValue() when setting from Main thread
                    Log.i(TAG, "SUCCESS: " + response.body().getCityName());
                }
            }
            @Override
            public void onFailure(Call<WeatherInfo> call, Throwable t) {
                Log.e(TAG, "FAILURE: "+ t.getMessage());
            }
        });
        return weatherInfoMutableLiveData;
    }
}
