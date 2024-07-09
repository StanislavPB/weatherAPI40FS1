package org.weatherapi40fs1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.weatherapi40fs1.dto.WeatherDataResponseDto;
import org.weatherapi40fs1.entity.WeatherDataEntity;
import org.weatherapi40fs1.repository.WeatherRepository;

import java.time.Duration;
import java.time.LocalDateTime;
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
     */

    private final WeatherRepository repository;
    private final Converter converter;
    private final OutWeatherApi outWeatherApi;

    @Override
    public WeatherDataResponseDto getWeather(String lat, String lon) {

//        Optional<WeatherDataEntity> optEntity = getFromDatabase(lat,lon);
//
//        if (optEntity.isPresent()){
//            WeatherDataEntity weatherDataEntity = optEntity.get();
//            LocalDateTime createdTime = weatherDataEntity.getTimeCreate();
//
//            long duration = Duration.between(LocalDateTime.now(), createdTime).toMinutes();
//
//            if (duration < 10) {
//                return converter.fromEntityToDto(weatherDataEntity);
//            }
//        }
//
//        WeatherDataResponseDto response = getFromApi(lat,lon);
//        repository.save(converter.fromDtoToEntity(response));
//
//        return response;

        return getFromDatabase(lat,lon)
                .filter(entity -> Duration.between(LocalDateTime.now(), entity.getTimeCreate()).toMinutes() < 10)
                .map(converter::fromEntityToDto)
                .orElseGet(() -> {
                    WeatherDataResponseDto response = getFromApi(lat,lon);
                    repository.save(converter.fromDtoToEntity(response));
                    return response;
                });

    }

    private Optional<WeatherDataEntity> getFromDatabase(String lat, String lon){
        return repository.findByLatitudeAndLongitude(lat,lon);
    }


    private WeatherDataResponseDto getFromApi(String lat, String lon){
        return outWeatherApi.receivedFromWeatherApi(lat,lon);
    }


}
