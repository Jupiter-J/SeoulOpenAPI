package com.example.seoulairqualityapi.API;


import com.example.seoulairqualityapi.API.dto.SeoulApiDto;
import com.example.seoulairqualityapi.openAPI.OpenApiDto;
import com.example.seoulairqualityapi.openAPI.RetrofitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeoulApiService  {
                    //retrofitConfig 연결
    private final RetrofitConfig retrofitConfig;

    public SeoulApiService(
            @Autowired RetrofitConfig retrofitConfig
    ){
        this.retrofitConfig = retrofitConfig;
    }


    public SeoulApiDto getAirQuality() {

        //response라는 변수에 가져온 값을 넣는다
        //한번호출해서 데이터를 담아두고 저걸 활용해서 만든다  (서버로부터 openApi형식으로 들어온 상태)
        OpenApiDto response = retrofitConfig.getAirQuality();

        //원하는 형태로 만들기 위해서
        SeoulApiDto seoulApiDto = new SeoulApiDto();
        seoulApiDto.setSido("서울");          //필요한 데이터만 다시 뽑아서 하나의 객체로 만들었다.
        seoulApiDto.setSidoPm10Avg(response.getListavgofseoulairqualityservice().getRow().get(0).getPm10());

        String grade;
        double pm10Value = seoulApiDto.getSidoPm10Avg();
        if (pm10Value <= 15) {
            grade = "좋음";
        } else if (pm10Value <= 35) {
            grade = "보통";
        } else if (pm10Value <= 75) {
            grade = "나쁨";
        } else {
            grade = "매우나쁨";
        }
        seoulApiDto.setSidoPm10AvgGrade(grade);

        return seoulApiDto;
    }


}
