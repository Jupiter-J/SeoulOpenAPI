package com.example.air.infrastructure.api;

import com.example.air.application.util.SeoulUtil.Sido;
import com.example.air.infrastructure.api.busan.BusanAirQualityApi;
import com.example.air.infrastructure.api.busan.BusanAirQualityApiCaller;
import com.example.air.infrastructure.api.seoul.SeoulAirQualityApiCaller;
import com.example.air.interfaces.api.dto.AirQualityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component //새로정의하고 싶은 클래스
@RequiredArgsConstructor
public class Factory {
    private final SeoulApiInterface seoulApiInterface;
    private final BusanApiInterface busanApiInterface;
    //        1. Factory에서 생성해야하는 인스턴스가 존재해야 하나요 아니면 여기선 없어도 되나요 ?
    //        2. 만약에 생성해야하는 인스턴스가 존재한다면 무엇이 되어야 하나요 ?


    public AirQualityDto.GetAirQualityInfo seoulGetAirQuality(Sido sido) {
        if (sido.equals(Sido.seoul)) {
            return seoulApiInterface.getAirQuality();
        }
        throw new RuntimeException(sido + " 대기질 정보는 아직 준비중입니다.");
    }

    public AirQualityDto.GetAirQualityInfo busanGetAirQuality(Sido sido) {
        if (sido.equals(Sido.busan)) {
            return busanApiInterface.getAirQuality();
        }
        throw new RuntimeException(sido + " 대기질 정보는 아직 준비중입니다.");
    }

}
