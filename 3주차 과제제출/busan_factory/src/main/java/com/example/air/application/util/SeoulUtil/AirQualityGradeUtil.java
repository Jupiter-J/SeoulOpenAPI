package com.example.air.application.util.SeoulUtil;

import static com.example.air.application.util.SeoulUtil.AirQualityGrade.*;

public class AirQualityGradeUtil {
    private AirQualityGradeUtil() {
    }
    //static 공유 메모리에 담아서 타입을 동일하게 넣어서 반환
    //메서드 하나에 enum 부분을 정리해서 코드가 깔끔해짐..

                        //반환타입   //메서드명   //실행하기 위한 매개변수
    public static AirQualityGrade getPm25Grade(Double pm25) {
        if (pm25 <= 15) {
                    //enum
            return 좋음;
        }
        if (pm25 <= 35) {
            return 보통;
        }
        if (pm25 <= 75) {
            return 나쁨;
        }
        return 매우나쁨;
    }

    public static AirQualityGrade getPm10Grade(Double pm10) {
        if (pm10 <= 30) {
            return 좋음;
        }
        if (pm10 <= 80) {
            return 보통;
        }
        if (pm10 <= 150) {
            return 나쁨;
        }
        return 매우나쁨;
    }

    public static AirQualityGrade getO3Grade(Double o3) {
        if (o3 <= 0.030) {
            return 좋음;
        }
        if (o3 <= 0.090) {
            return 보통;
        }
        if (o3 <= 0.150) {
            return 나쁨;
        }
        return 매우나쁨;
    }

    public static AirQualityGrade getNo2Grade(Double no2) {
        if (no2 <= 0.030) {
            return 좋음;
        }
        if (no2 <= 0.060) {
            return 보통;
        }
        if (no2 <= 0.200) {
            return 나쁨;
        }
        return 매우나쁨;
    }

    public static AirQualityGrade getCoGrade(Double co) {
        if (co <= 2) {
            return 좋음;
        }
        if (co <= 9) {
            return 보통;
        }
        if (co <= 15) {
            return 나쁨;
        }
        return 매우나쁨;
    }

    public static AirQualityGrade getSo2Grade(Double so2) {
        if (so2 <= 0.020) {
            return 좋음;
        }
        if (so2 <= 0.050) {
            return 보통;
        }
        if (so2 <= 0.150) {
            return 나쁨;
        }
        return 매우나쁨;
    }
}
