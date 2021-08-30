package com.prakriti.weatherappretrofit.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherInfo {

    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;
    @SerializedName("name")
    private String cityName;
    @SerializedName("dt")
    private Long updateAt;
    @SerializedName("main")
    private MainInfo mainInfo;
    @SerializedName("sys")
    private SysInfo sysInfo;


    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public MainInfo getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }

    public SysInfo getSysInfo() {
        return sysInfo;
    }

    public void setSysInfo(SysInfo sysInfo) {
        this.sysInfo = sysInfo;
    }
}
