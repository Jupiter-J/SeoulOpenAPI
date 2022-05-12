package com.example.air.application;

import com.example.air.interfaces.api.dto.AirQualityDto;

//caller를 감싸서 캡슐화를 한것(?)
public interface KoreaAirQualityService {

    Sido getSido();
    AirQualityDto.GetAirQualityInfo getAirQualityInfo(); //캐시 적용
}
