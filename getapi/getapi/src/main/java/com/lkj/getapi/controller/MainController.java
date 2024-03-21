package com.lkj.getapi.controller;

import com.lkj.getapi.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final SessionUtil sessionUtil;

    @GetMapping
    public String main (HttpSession session){
        if (!sessionUtil.getUser(session).isPresent()) {
            return "login";
        }
        return "index";
    }
    @GetMapping("/a")
    public String apireturn(){
        return "api";
    }
}
