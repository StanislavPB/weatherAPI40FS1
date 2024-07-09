package org.weatherapi40fs1.service;

import org.weatherapi40fs1.dto.WeatherDataResponseDto;

public interface WeatherDataServiceInterface {

    WeatherDataResponseDto getWeather(String lat, String lon);

}
