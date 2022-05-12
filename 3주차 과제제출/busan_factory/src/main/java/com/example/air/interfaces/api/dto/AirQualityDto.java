package com.example.air.interfaces.api.dto;

import com.example.air.application.util.SeoulUtil.AirQualityGrade;
import com.example.air.application.util.SeoulUtil.AirQualityGradeUtil;
import lombok.Builder;
import lombok.Getter;

import java.util.Collections;
import java.util.List;

public class AirQualityDto {

    @Getter
    @Builder
    //가져오고 싶은 API DTO 형태
    public static class GetAirQualityInfo {
        private String sido;
        private Double sidoPm10Avg;
        private AirQualityGrade sidoPm10AvgGrade;
        private List<GuAirQualityInfo> guList;  //list를 담을거다 선언만 한 상태

        public GetAirQualityInfo searchByGu(String gu) {
            if (gu == null) {
                return this;
            }
            //지역변수로만 사용가능 <익명 클래스>
            //모든것을 담을 수 있는 변수 타입이다
            //null 초기화 불가능, 배열을 넣을때는 명시적으로 타입을 넣어야 한다.
            var searchedGuInfo = searchGuAirQualityInfo(gu);
            guList = Collections.singletonList(searchedGuInfo);
            return this;
        }

        //GuAirQualityInfo를 반환하는 메서드 (메서드를 실행하기 위한 조건 gu)
        private GuAirQualityInfo searchGuAirQualityInfo(String gu) {

            return guList.stream()
                    //filter 찾는 조건                 //infogu데이터와 String gu가 같으면
                    .filter(guAirQualityInfo -> guAirQualityInfo.getGu().equals(gu))
                    //찾아진 첫번째 값을 불러온다
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(gu + "에 해당하는 자치구가 존재하지 않습니다."));

        }
    }

    @Getter
    public static class GuAirQualityInfo {
        private final String gu;
        private final Integer pm10;
        private final Integer pm25;
        private final Double o3;
        private final Double no2;
        private final Double co;
        private final Double so2;
                        //변수타입    //변수
        private final AirQualityGrade pm10Grade;
        private final AirQualityGrade pm25Grade;
        private final AirQualityGrade o3Grade;
        private final AirQualityGrade no2Grade;
        private final AirQualityGrade coGrade;
        private final AirQualityGrade so2Grade;

        public GuAirQualityInfo(String gu, Integer pm10, Integer pm25, Double o3, Double no2, Double co, Double so2) {
            this.gu = gu;
            this.pm10 = pm10;
            this.pm25 = pm25;
            this.o3 = o3;
            this.no2 = no2;
            this.co = co;
            this.so2 = so2;
                                                            //실수 형태로 데이터가 저장
            this.pm10Grade = AirQualityGradeUtil.getPm10Grade(Double.valueOf(pm10));
            this.pm25Grade = AirQualityGradeUtil.getPm25Grade(Double.valueOf(pm25));
            this.o3Grade = AirQualityGradeUtil.getO3Grade(o3);
            this.no2Grade = AirQualityGradeUtil.getNo2Grade(no2);
            this.coGrade = AirQualityGradeUtil.getCoGrade(co);
            this.so2Grade = AirQualityGradeUtil.getSo2Grade(so2);
        }
    }
}
