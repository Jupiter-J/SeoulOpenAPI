package com.example.air.application;

import com.example.air.interfaces.api.dto.AirQualityDto;
import jdk.jfr.TransitionFrom;
import jdk.jfr.TransitionTo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AirQualityService {

    private final KoreaAirQualityServiceFactory koreaAirQualityServiceFactory;

    //캐시를 가져오는 메소드에 붙이는 어노테이션                            //null값 에러가 떠서 붙임
    @Cacheable(value="CacheKey.SIDOCODE", key = "#sido", condition = "#sido!=null", cacheManager = "firstCache")
    public AirQualityDto.GetAirQualityInfo getAirQualityInfo(Sido sido, String gu) {
        KoreaAirQualityService service = koreaAirQualityServiceFactory.getService(sido);

        //1시간 내에 각 부산, 서울시의 API 가 한번만 호출
        log.info("캐시 적용하기 getAirQualityInfo: {}", sido);

        var airQualityInfo = service.getAirQualityInfo();

        if (gu.equals("all") == false) {
                    //all == null
            return airQualityInfo.searchByGu(gu);
        }

        return airQualityInfo;
    }
}
