package com.example.air.infrastructure.api.busan;

import com.example.air.application.util.SeoulUtil.Sido;
import com.example.air.infrastructure.api.BusanApiInterface;
import com.example.air.interfaces.api.dto.AirQualityDto;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class BusanAirQualityApiCaller implements BusanApiInterface {
    private final BusanAirQualityApi busanAirQualityApi;

    public BusanAirQualityApiCaller(@Value("${api.busan.base-url}") String baseUrl) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();

        this.busanAirQualityApi = retrofit.create(BusanAirQualityApi.class);
    }

    public AirQualityDto.GetAirQualityInfo getAirQuality() {
        try {
            var call = busanAirQualityApi.getAirQuality();
            var response = call.execute().body();

            if (response == null || response.getResponse() == null) {
                throw new RuntimeException("[busan] getAirQuality 응답값이 존재하지 않습니다.");
            }

            if (response.getResponse().isSuccess()) {
                log.info(response.toString());
                return covert(response);
            }

            throw new RuntimeException("[busan] getAirQuality 응답이 올바르지 않습니다. header=" + response.getResponse().getHeader());

        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("[busan] getAirQuality API error 발생! errorMessage=" + e.getMessage());
        }
    }

        public AirQualityDto.GetAirQualityInfo covert(BusanAirQualityApiDto.GetAirQualityResponse response){
            var items = response.getResponse().getItems();
            var guList = convert(items);

            return AirQualityDto.GetAirQualityInfo.builder()
                    .sido(Sido.busan.getDescription())
                    .guList(guList)
                    .build();
        }

        public List<AirQualityDto.GuAirQualityInfo> convert(List<BusanAirQualityApiDto.Item> items){
            return items.stream()
                    .map(item -> new AirQualityDto.GuAirQualityInfo(
                    item.getSite(),
                    Integer.parseInt(item.getPm10()),
                    Integer.parseInt(item.getPm25()),
                    Double.parseDouble(item.getO3()),
                    Double.parseDouble(item.getNo2()),
                    Double.parseDouble(item.getCo()),
                    Double.parseDouble(item.getSo2())
                            )
                    )
                    .collect(Collectors.toList());

        }




}
