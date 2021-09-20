package com.exchangeratecalculation.business.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class webController {

    @GetMapping("/hello")
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");

        return mv;
    }
}
