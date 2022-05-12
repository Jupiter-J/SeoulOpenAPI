package com.example.air.infrastructure.api;

import com.example.air.infrastructure.api.busan.BusanAirQualityApiDto;
import com.example.air.interfaces.api.dto.AirQualityDto;

import java.util.List;

public interface BusanApiInterface {

    AirQualityDto.GetAirQualityInfo getAirQuality();
    AirQualityDto.GetAirQualityInfo covert(BusanAirQualityApiDto.GetAirQualityResponse response);
    List<AirQualityDto.GuAirQualityInfo> convert(List<BusanAirQualityApiDto.Item> items);
}
