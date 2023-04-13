package com.codehows.mobul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/auth") // url에 /auth로 들어오는 요청을 이 AuthController가 처리하도록함
public class AuthController {
    @GetMapping(value="/signin")
    public String signIn(Model model){
        return "auth/signin"; //templates폴더를 기준으로 뷰의 위치와 이름을 반환
    }

    @GetMapping(value="/signup")
    public String signUp(Model model){
        return "auth/signup";
    }
}
