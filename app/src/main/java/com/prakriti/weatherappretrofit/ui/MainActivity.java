package com.prakriti.weatherappretrofit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.prakriti.weatherappretrofit.R;
import com.prakriti.weatherappretrofit.pojo.WeatherInfo;
import com.prakriti.weatherappretrofit.viewmodel.MyViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private MyViewModel myViewModel;

    private TextView txtForecast, txtTemp, txtCity, txtTime, txtCountry, txtHumidity, txtMinTemp, txtMaxTemp, txtSunrise, txtSunset;
    private EditText edtLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        edtLocation = findViewById(R.id.edtLocation);

        txtForecast = findViewById(R.id.txtForecast);
        txtTemp = findViewById(R.id.txtTemp);
        txtTime = findViewById(R.id.txtTime);
        txtCity = findViewById(R.id.txtCity);
        txtCountry = findViewById(R.id.txtCountry);
        txtHumidity = findViewById(R.id.txtHumidity);
        txtMinTemp = findViewById(R.id.txtMinTemp);
        txtMaxTemp = findViewById(R.id.txtMaxTemp);
        txtSunrise = findViewById(R.id.txtSunrise);
        txtSunset = findViewById(R.id.txtSunset);

        Button btnGetWeather = findViewById(R.id.btnGetWeather);
        Button btnClear = findViewById(R.id.btnClear);
        btnGetWeather.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        myViewModel.getWeatherLiveData().observe(this, new Observer<WeatherInfo>() {
            @Override
            public void onChanged(WeatherInfo weatherInfo) {
                String cityName = weatherInfo.getCityName();
                Long time = weatherInfo.getUpdateAt();
                String updatedAt = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(time * 1000));

                String temperature = weatherInfo.getMainInfo().getTemperature() + " °C";
                String temp_max = weatherInfo.getMainInfo().getMaxTemp();
                String temp_min = weatherInfo.getMainInfo().getMinTemp();
                String humidity = weatherInfo.getMainInfo().getHumidity();

                String forecast = weatherInfo.getWeather().get(0).getDescription();

                String countryName = weatherInfo.getSysInfo().getCountry();
                Long rise = weatherInfo.getSysInfo().getSunrise();
                String sunrise = new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(rise * 1000));
                Long set = weatherInfo.getSysInfo().getSunset();
                String sunset = new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(set * 1000));

                Log.i(TAG, "onChanged: value " + cityName);

                txtCity.setText(cityName);
                Log.i(TAG, "onChanged: textview " + txtCity.getText().toString());

                txtCountry.setText(countryName);
                txtTime.setText(updatedAt);
                txtTemp.setText(temperature);
                txtForecast.setText(forecast);
                txtHumidity.setText(humidity);
                txtMinTemp.setText(temp_min);
                txtMaxTemp.setText(temp_max);
                txtSunrise.setText(sunrise);
                txtSunset.setText(sunset);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGetWeather:
                if(edtLocation.getText().toString().trim().equals("")) {
                    edtLocation.setError("This field cannot be empty");
                    return;
                }
                String inputCity = edtLocation.getText().toString().trim();
                fetchData(inputCity);
                break;

            case R.id.btnClear:
                edtLocation.setText("");
                txtForecast.setText("");
                txtTemp.setText("");
                txtTime.setText("");
                txtCity.setText("");
                txtCountry.setText("");
                txtHumidity.setText("");
                txtMinTemp.setText("");
                txtMaxTemp.setText("");
                txtSunrise.setText("");
                txtSunset.setText("");
                break;
        }
    }

    private void fetchData(String inputCity) {
        myViewModel.makeApiCall(inputCity);
    }
}