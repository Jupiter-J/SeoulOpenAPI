package com.example.air.application.util.SeoulUtil;

import com.example.air.infrastructure.api.Factory;
import com.example.air.infrastructure.api.SeoulApiInterface;
import com.example.air.infrastructure.api.busan.BusanAirQualityApiCaller;
import com.example.air.infrastructure.api.seoul.SeoulAirQualityApiCaller;
import com.example.air.interfaces.api.dto.AirQualityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AirQualityService {
    private final Factory factory;

    public AirQualityDto.GetAirQualityInfo getAirQualityInfo(Sido sido, String gu) {
        if (sido == Sido.seoul) {
            AirQualityDto.GetAirQualityInfo airQualityInfo = factory.seoulGetAirQuality(sido);
            if (gu != null) {
                return airQualityInfo.searchByGu(gu);
            }
            return airQualityInfo;
        }

        if (sido == Sido.busan) {
            var airQualityInfo = factory.busanGetAirQuality(sido);
            if (gu != null) {
                return airQualityInfo.searchByGu(gu);
            }
            return airQualityInfo;
        }

        throw new RuntimeException(sido + " 대기질 정보는 아직 준비중입니다.");
    }
}
