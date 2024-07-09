package org.weatherapi40fs1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.weatherapi40fs1.dto.WeatherDataResponseDto;
import org.weatherapi40fs1.entity.WeatherDataEntity;
import org.weatherapi40fs1.repository.WeatherRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class WeatherDataService implements WeatherDataServiceInterface{

    /**
     * WeatherDataResponseDto getWeather(String lat, String lon)
     *
     * WeatherDataResponseDto getFromApi(String lat, String lon)
     *
     * Optional<WeatherDataEntity> getFromDatabase(String lat, String lon)
     *
     * WeatherDataEntity saveNewWeather(WeatherJSON request)
     */

    private final WeatherRepository repository;
    private final Converter converter;
    private final OutWeatherApi outWeatherApi;

    @Override
    public WeatherDataResponseDto getWeather(String lat, String lon) {
        return null;
    }

    private Optional<WeatherDataEntity> getFromDatabase(String lat, String lon){
        return repository.findByLatitudeAndLongitude(lat,lon);
    }


    private WeatherDataResponseDto getFromApi(String lat, String lon){
        return outWeatherApi.receivedFromWeatherApi(lat,lon);
    }


}
