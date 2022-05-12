package com.example.seoulairqualityapi.openAPI;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

public class OpenApiDto {

    @JsonProperty("ListAvgOfSeoulAirQualityService")
    private OpenApiDto.ListavgofseoulairqualityserviceEntity listavgofseoulairqualityservice;

    public OpenApiDto.ListavgofseoulairqualityserviceEntity getListavgofseoulairqualityservice() {
        return listavgofseoulairqualityservice;
    }

    public void setListavgofseoulairqualityservice(OpenApiDto.ListavgofseoulairqualityserviceEntity listavgofseoulairqualityservice) {
        this.listavgofseoulairqualityservice = listavgofseoulairqualityservice;
    }

    public static class ListavgofseoulairqualityserviceEntity {
        @JsonProperty("row")
        private List<OpenApiDto.RowEntity> row;
        @JsonProperty("RESULT")
        private OpenApiDto.ResultEntity result;
        @JsonProperty("list_total_count")
        private int listTotalCount;

        public List<OpenApiDto.RowEntity> getRow() {
            return row;
        }

        public void setRow(List<OpenApiDto.RowEntity> row) {
            this.row = row;
        }

        public OpenApiDto.ResultEntity getResult() {
            return result;
        }

        public void setResult(OpenApiDto.ResultEntity result) {
            this.result = result;
        }

        public int getListTotalCount() {
            return listTotalCount;
        }

        public void setListTotalCount(int listTotalCount) {
            this.listTotalCount = listTotalCount;
        }
    }

    public static class RowEntity {
        @JsonProperty("PM25")
        private int pm25;
        @JsonProperty("PM10")
        private int pm10;
        @JsonProperty("SULFUROUS")
        private double sulfurous;
        @JsonProperty("CARBON")
        private double carbon;
        @JsonProperty("OZONE")
        private double ozone;
        @JsonProperty("NITROGEN")
        private double nitrogen;
        @JsonProperty("POLLUTANT")
        private String pollutant;
        @JsonProperty("IDEX_MVL")
        private String idexMvl;
        @JsonProperty("GRADE")
        private String grade;

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
            this.pm10 = pm10;
        }

        public double getSulfurous() {
            return sulfurous;
        }

        public void setSulfurous(double sulfurous) {
            this.sulfurous = sulfurous;
        }

        public double getCarbon() {
            return carbon;
        }

        public void setCarbon(double carbon) {
            this.carbon = carbon;
        }

        public double getOzone() {
            return ozone;
        }

        public void setOzone(double ozone) {
            this.ozone = ozone;
        }

        public double getNitrogen() {
            return nitrogen;
        }

        public void setNitrogen(double nitrogen) {
            this.nitrogen = nitrogen;
        }

        public String getPollutant() {
            return pollutant;
        }

        public void setPollutant(String pollutant) {
            this.pollutant = pollutant;
        }

        public String getIdexMvl() {
            return idexMvl;
        }

        public void setIdexMvl(String idexMvl) {
            this.idexMvl = idexMvl;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    public static class ResultEntity {
        @JsonProperty("MESSAGE")
        private String message;
        @JsonProperty("CODE")
        private String code;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

}
