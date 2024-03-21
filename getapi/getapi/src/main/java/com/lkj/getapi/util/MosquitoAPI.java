package com.lkj.getapi.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lkj.getapi.mosquito.MosquitoStatusResponse;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class MosquitoAPI {

    public MosquitoStatusResponse getMosquitoForecast() throws IOException {
        Dotenv config = Dotenv.configure().load();
        String TOKEN = config.get("TOKEN");
        String apiUrl = "http://openapi.seoul.go.kr:8088/"+TOKEN+"/json/MosquitoStatus/1/5/2020-04-12";

        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        int responseCode = conn.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("API 요청에 실패했습니다. 응답 코드: " + responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        System.out.println("API 응답 JSON: " + response.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        MosquitoStatusResponse mosquitoStatusResponse = objectMapper.readValue(response.toString(), MosquitoStatusResponse.class);
    return mosquitoStatusResponse;
    }
    //모기예보 API를 요청한다.
    //API는 json으로 반환된다.
    //json을 object로 받아서 반환한다.

}
