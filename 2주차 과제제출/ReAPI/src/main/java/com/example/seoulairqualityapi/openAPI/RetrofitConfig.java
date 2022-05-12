package com.example.seoulairqualityapi.openAPI;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

@Slf4j    //logger
@Component  //상속을 받기위한 클래스(개발자가 직접 작성한 class를 빈으로 등록하기 위함)
public class RetrofitConfig {

      //기본세팅                        //호출할 도메인
    public Retrofit retrofit(){
        String baseUrl = "http://openAPI.seoul.go.kr:8088/";

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

    }
                    //dto의 결과 가져오기
    public OpenApiDto getAirQuality(){
        try{
            return retrofit().create(OpenApiInterface.class).getAirQuality().execute().body();
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }


}
