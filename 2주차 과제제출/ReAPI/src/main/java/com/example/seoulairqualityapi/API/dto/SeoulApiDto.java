package com.example.seoulairqualityapi.API.dto;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class SeoulApiDto {
    private String sido;
    private double sidoPm10Avg;
    private String sidoPm10AvgGrade;

}
