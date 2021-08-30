package com.prakriti.weatherappretrofit.pojo;

import com.google.gson.annotations.SerializedName;

public class MainInfo {

    @SerializedName("temp")
    private String temperature;

    @SerializedName("temp_min")
    private String minTemp;

    @SerializedName("temp_max")
    private String maxTemp;

    @SerializedName("humidity")
    private String humidity;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}


