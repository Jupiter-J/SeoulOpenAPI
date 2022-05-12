package com.example.air.interfaces.api;

import com.example.air.application.util.SeoulUtil.AirQualityService;
import com.example.air.application.util.SeoulUtil.Sido;
import com.example.air.interfaces.api.dto.AirQualityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/air-quality")
public class AirQualityApiController {
    private final AirQualityService airQualityService;

    @GetMapping("/{sidoCode}")
            //반환타입                                        //메서드를 실행하기위한 매개변수
    public AirQualityDto.GetAirQualityInfo getAirQualityInfo(@PathVariable("sidoCode") Sido sidoCode,
                                                             @RequestParam(required = false) String gu) {
                                                                    //default=true지만 선택이기 때문에 false로 한다

        return airQualityService.getAirQualityInfo(sidoCode, gu);
    }
}
