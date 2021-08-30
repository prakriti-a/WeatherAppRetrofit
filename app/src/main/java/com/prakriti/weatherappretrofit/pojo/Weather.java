package com.prakriti.weatherappretrofit.pojo;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



/*

{
  "coord": {
    "lon": 77.2167,
    "lat": 28.6667
  },
  "weather": [
    {
      "id": 721,
      "main": "Haze",
      "description": "haze",
      "icon": "50n"
    }
  ],
  "base": "stations",
  "main": {
    "temp": 30.05,
    "feels_like": 35.16,
    "temp_min": 30.05,
    "temp_max": 30.05,
    "pressure": 1002,
    "humidity": 70
  },
  "visibility": 3000,
  "wind": {
    "speed": 4.12,
    "deg": 90
  },
  "clouds": {
    "all": 40
  },
  "dt": 1624037033,
  "sys": {
    "type": 1,
    "id": 9165,
    "country": "IN",
    "sunrise": 1623973994,
    "sunset": 1624024276
  },
  "timezone": 19800,
  "id": 1273294,
  "name": "Delhi",
  "cod": 200
}

 */