package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Date:2021/7/6
 * Author:ybc
 * Description:
 */
@Controller
public class TestController {

    private String buildView(String viewName, HttpServletRequest request, Model model) {
        model.addAttribute("path", request.getRequestURI());
        return viewName;
    }

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model){
        return buildView("index", request, model);
    }

    @RequestMapping("/param")
    public String param(HttpServletRequest request, Model model){
        return buildView("test_param", request, model);
    }

}
