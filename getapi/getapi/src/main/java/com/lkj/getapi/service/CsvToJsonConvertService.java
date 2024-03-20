package com.lkj.getapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class CsvToJsonConvertService {

    public void convert() {

        //endpoint url
        String apiUrl = "https://example.com/api/data";
        // csvFile
        String csvFilePath = "data.csv";
        //converted json file path
        String jsonFilePath = "output.json";

        //API 요청을 해서 CSV파일 받아오기
        try {
            downloadCsvFromApi(apiUrl,csvFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void downloadCsvFromApi(String apiUrl, String csvFilePath) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        byte[] response = restTemplate.getForObject(apiUrl, byte[].class);

        // 받은 데이터를 파일로 저장
        try (FileOutputStream fos = new FileOutputStream(csvFilePath)) {
            fos.write(response);
        }
    }

}
