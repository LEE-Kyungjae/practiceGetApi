package com.lkj.getapi.controller;

import com.lkj.getapi.mosquito.MosquitoStatusResponse;
import com.lkj.getapi.mosquito.Row;
import com.lkj.getapi.util.MosquitoAPI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/mos")
@RequiredArgsConstructor
public class MosquitoController {

    private final MosquitoAPI mosquitoAPI;

    @GetMapping
    public String showMosquitoForecast(Model model) {
        try {
            MosquitoStatusResponse mosquitoStatusResponse = mosquitoAPI.getMosquitoForecast();
            if (mosquitoStatusResponse != null) {
                model.addAttribute("mosquitoForecast", mosquitoStatusResponse);
                Row firstRow = mosquitoStatusResponse.getRows().get(0);
                //log.warn("Mosquito Value Water: {}", firstRow.getMosquitoValueWater());
            } else {
                model.addAttribute("error", "API 응답이 없습니다.");
            }
        } catch (IOException e) {
            model.addAttribute("error", "API 요청에 실패했습니다.");
        }
        return "mosquito_forecast";
    }
}
