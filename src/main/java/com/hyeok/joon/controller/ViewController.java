package com.hyeok.joon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hyeok.joon.service.NewsServiceImpl;
@Controller
public class ViewController {
    @Autowired
    NewsServiceImpl mainNewsService;
    @RequestMapping("/")
    public String index(Model model) {
    	model.addAttribute("workList",mainNewsService.getHomeWorkList());
        return "index";
    }
    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("newsData",mainNewsService.getNews());
        return "about";
    }
}
