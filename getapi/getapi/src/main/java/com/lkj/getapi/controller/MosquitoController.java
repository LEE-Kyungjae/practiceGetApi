package com.lkj.getapi.controller;

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

    @GetMapping
    public String showMosquitoForecast(Model model) {

        return "mosquito_forecast";
    }
}
