package org.weatherapi40fs1.dto.weatherJsonDataModel;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;


@Data

public class Weather {

    public String icon;
    public int code;
    public String description;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


}
