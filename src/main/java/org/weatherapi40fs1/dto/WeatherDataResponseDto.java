package org.weatherapi40fs1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDataResponseDto {
    private String latitude;
    private String longitude;
    private String temperature;
}
