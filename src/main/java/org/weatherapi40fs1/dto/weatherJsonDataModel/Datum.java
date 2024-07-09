package org.weatherapi40fs1.dto.weatherJsonDataModel;


import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data

public class Datum {

    public String windCdir;
    public int rh;
    public String pod;
    public double lon;
    public double pres;
    public String timezone;
    public String obTime;
    public String countryCode;
    public int clouds;
    public int vis;
    public double windSpd;
    public int gust;
    public String windCdirFull;
    public double appTemp;
    public String stateCode;
    public int ts;
    public int hAngle;
    public double dewpt;
    public Weather weather;
    public int uv;
    public int aqi;
    public String station;
    public List<String> sources = null;
    public int windDir;
    public int elevAngle;
    public String datetime;
    public int precip;
    public double ghi;
    public int dni;
    public int dhi;
    public int solarRad;
    public String cityName;
    public String sunrise;
    public String sunset;
    public double temp;
    public double lat;
    public double slp;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
