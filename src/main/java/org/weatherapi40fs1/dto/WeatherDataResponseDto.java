package org.weatherapi40fs1.dto;

import lombok.Data;

@Data
public class WeatherDataResponseDto {
    private String latitude;
    private String longitude;
    private String temperature;
}
