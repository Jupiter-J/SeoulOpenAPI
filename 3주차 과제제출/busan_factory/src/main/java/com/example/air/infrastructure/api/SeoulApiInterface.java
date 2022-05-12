package com.example.air.infrastructure.api;

import com.example.air.infrastructure.api.seoul.SeoulAirQualityApiDto;
import com.example.air.interfaces.api.dto.AirQualityDto;

import java.util.List;

public interface SeoulApiInterface {

    AirQualityDto.GetAirQualityInfo getAirQuality();
    AirQualityDto.GetAirQualityInfo convert(SeoulAirQualityApiDto.GetAirQualityResponse response);
    List<AirQualityDto.GuAirQualityInfo> convert(List<SeoulAirQualityApiDto.Row> rows);
    Double averagePm10(List<SeoulAirQualityApiDto.Row> rows);


}
