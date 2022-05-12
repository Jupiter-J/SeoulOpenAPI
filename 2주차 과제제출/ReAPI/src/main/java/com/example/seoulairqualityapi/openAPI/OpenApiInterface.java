package com.example.seoulairqualityapi.openAPI;

import retrofit2.Call;
import retrofit2.http.GET;

//외부에서 데이터를 가져오기 위한 레트로핏 서비스
// 가져올 API : 서울시 실시간 대기환경 평균 현황
public interface OpenApiInterface {

    //인증키
    String serviceKey = "536c58687267757531334b46554b41";
                                    //파라미터자체를 넣으면 에러 -> 기본url 그대로 가져오니까 해결되었다
    @GET(serviceKey + "/json/ListAvgOfSeoulAirQualityService/1/5")


    Call<OpenApiDto> getAirQuality();

}
