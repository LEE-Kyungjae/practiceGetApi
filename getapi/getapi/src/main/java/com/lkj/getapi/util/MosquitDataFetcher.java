package com.lkj.getapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lkj.getapi.mosquito.MosquitoStatusResponse;
import com.lkj.getapi.repository.MosquitoRepository;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MosquitDataFetcher {

    private MosquitoStatusResponse mosquitoStatusResponse;
    private MosquitoRepository mosquitoRepository;

    @Scheduled(cron = "0 5 4 * * *")
    public void getMosquitoForecast() throws IOException {

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        Dotenv config = Dotenv.configure().load();
        String TOKEN = config.get("TOKEN");
        String apiUrl = "http://openapi.seoul.go.kr:8088/" + TOKEN + "/json/MosquitoStatus/1/5/" + formattedDate;

        RestTemplate restTemplate = new RestTemplate();
            MosquitoStatusResponse mosquitoStatusResponse = restTemplate.getForObject(apiUrl, MosquitoStatusResponse.class);
            if (mosquitoStatusResponse != null) {
                mosquitoRepository.save(mosquitoStatusResponse);
                System.out.println("데이터를 성공적으로 저장했습니다.");
            } else {
                System.out.println("데이터를 가져오는 데 문제가 발생했습니다.");
            }
    }
    public void addalldata(){
        ArrayList<String> tasks = alldate();


    }

    public ArrayList<String> alldate() {
        ArrayList<String> tasks = new ArrayList<>();
        LocalDate startDate = LocalDate.of(2023, 1, 1); // 시작 날짜 설정
        LocalDate currentDate = LocalDate.now();

        while (currentDate == startDate) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = startDate.format(formatter);
            tasks.add(formattedDate);
            startDate.plusDays(1);
        }
        return tasks;
    }
}