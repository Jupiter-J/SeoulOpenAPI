package com.example.seoulairqualityapi.API;

import com.example.seoulairqualityapi.API.dto.SeoulApiDto;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/air-quality/")
public class SeoulApiController {
    private final SeoulApiService apiService;


    //@RequiredArgsConstructor - autowired 없이도 생성 가능
    public SeoulApiController(
            @Autowired SeoulApiService apiService
    ){
        this.apiService = apiService;
    }

    @GetMapping("{sidoCode}")
    public SeoulApiDto seoulApiDto(@PathVariable("sidoCode") String sido){

        return apiService.getAirQuality();
    }




}
