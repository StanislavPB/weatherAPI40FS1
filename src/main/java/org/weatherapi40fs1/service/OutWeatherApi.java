package org.weatherapi40fs1.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.weatherapi40fs1.dto.WeatherDataResponseDto;
import org.weatherapi40fs1.dto.weatherJsonDataModel.WeatherJSON;
import org.weatherapi40fs1.service.postExample.RequestObj;
import org.weatherapi40fs1.service.postExample.ResponseObj;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;

@Service
@AllArgsConstructor
public class OutWeatherApi {

    private static Logger log = LoggerFactory.getLogger(OutWeatherApi.class);
    private final RestTemplate restTemplate;

    public WeatherDataResponseDto receivedFromWeatherApi(String lat, String lon) throws MalformedURLException, URISyntaxException {

        String urlRequest = createUrl(lat,lon);

        URL url = new URL(urlRequest);

        log.info("Sending request to {}", url);
        ResponseEntity<WeatherJSON> weatherJSON = restTemplate.getForEntity(url.toURI(), WeatherJSON.class);
        log.info("Received response {}", weatherJSON);

        if (weatherJSON.getBody() != null) {
            String tempFromResponse = "" + weatherJSON.getBody().getData().getFirst().getTemp();
            return new WeatherDataResponseDto(lat,lon,tempFromResponse);
        } else {
            throw new IllegalArgumentException("Response body not found");
        }

    }

    private String createUrl(String lat, String lon) {
        //https://api.weatherbit.io/v2.0/current?lat=35.7796&lon=-78.6382&key=API_KEY

        //String url =  "https://api.weatherbit.io/v2.0/current?" + "lat=" + lat + "&lon=" + lon + "&key=" + key;

        return UriComponentsBuilder.fromHttpUrl("https://api.weatherbit.io/v2.0/current")
                .queryParam("lat",lat)
                .queryParam("lon",lon)
                .queryParam("key","37195ad08f4d48b98708b260b3747f6e")
                .build()
                .toString();
    }

    private void sendPostRequest() throws MalformedURLException {

        String urlRequest ="http://mysite.com/api/resorce";
        URL url = new URL(urlRequest);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        RequestObj requestObj = new RequestObj("str1","str2");

        HttpEntity<RequestObj> entity = new HttpEntity<>(requestObj, headers);

//        try {
//            ResponseEntity<ResponseObj> response = restTemplate.postForEntity(url.toURI(), entity, ResponseObj.class);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }

        try {
            ResponseEntity<ResponseObj> response = restTemplate.exchange(urlRequest, HttpMethod.POST, entity, ResponseObj.class);
            log.info("Received response: {}", response);

            if (response.getBody() != null) {
                log.info("Success! Response body: {}", response.getBody());
                // что делаем с этим ответом
            } else {
                log.warn("No content in response body");
            }
        } catch (HttpClientErrorException exception){
            log.error("Error response from API: {}", exception.getResponseBodyAsString());
        }

    }
}
