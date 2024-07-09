package org.weatherapi40fs1.service;

import org.springframework.stereotype.Component;
import org.weatherapi40fs1.dto.WeatherDataResponseDto;
import org.weatherapi40fs1.entity.WeatherDataEntity;

import java.time.LocalDateTime;

@Component
public class Converter {

    WeatherDataResponseDto fromEntityToDto(WeatherDataEntity entity){
        WeatherDataResponseDto response = new WeatherDataResponseDto();
        response.setLatitude(entity.getLatitude());
        response.setLongitude(entity.getLongitude());
        response.setTemperature(entity.getTemperature());
        return response;
    }

    WeatherDataEntity fromDtoToEntity(WeatherDataResponseDto dto){
        WeatherDataEntity entity = new WeatherDataEntity();
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setTemperature(dto.getTemperature());
        entity.setTimeCreate(LocalDateTime.now());

        return entity;
    }
}
