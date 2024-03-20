package com.lkj.getapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lkj.getapi.mosquito.MosquitoStatusResponse;
import com.lkj.getapi.mosquito.Row;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Component
public class AppRunner implements CommandLineRunner {

    @Value("${mosquito.token}")
    private String mosquitoToken;

    public String apiurl() {
        System.out.println("apiurl");
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        String apiUrl = "http://openapi.seoul.go.kr:8088/" + mosquitoToken + "/json/MosquitoStatus/1/5/" + formattedDate;
        return apiUrl;
    }

    public String getApi() throws IOException {
        System.out.println("getApi");
        URL url = new URL(apiurl());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json;charset=UTF-8");
        System.out.println("Response code: " + conn.getResponseCode()); /* 연결 자체에 대한 확인이 필요하므로 추가합니다.*/
        BufferedReader rd;
        // 서비스코드가 정상이면 200~300사이의 숫자가 나옵니다.
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("run");
        String jsonString = getApi();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            MosquitoStatusResponse response = objectMapper.readValue(jsonString, MosquitoStatusResponse.class);
            Row row = (Row) response.getRow();
            System.out.println(row.getMosquitoValuePark());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
