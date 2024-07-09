package org.weatherapi40fs1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.weatherapi40fs1.dto.WeatherDataResponseDto;
import org.weatherapi40fs1.service.WeatherDataServiceInterface;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class GetWeatherController {

    private final WeatherDataServiceInterface service;


    @GetMapping("/weather")
    public WeatherDataResponseDto getWeather(@RequestParam String lat, @RequestParam String lon){
        return service.getWeather(lat,lon);
    }


}
