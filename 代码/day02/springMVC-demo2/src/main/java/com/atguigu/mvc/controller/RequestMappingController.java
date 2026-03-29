package com.atguigu.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Date:2021/7/6
 * Author:ybc
 * Description:
 */
@Controller
//@RequestMapping("/hello")
public class RequestMappingController {

    private String buildSuccessView(HttpServletRequest request, Model model) {
        model.addAttribute("path", request.getRequestURI());
        return "success";
    }

    @RequestMapping(
            value = {"/testRequestMapping", "/test"},
            method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String success(HttpServletRequest request, Model model) {
        return buildSuccessView(request, model);
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping(HttpServletRequest request, Model model){
        return buildSuccessView(request, model);
    }

    @RequestMapping(value = "/testPut", method = RequestMethod.PUT)
    public String testPut(HttpServletRequest request, Model model){
        return buildSuccessView(request, model);
    }

    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username","password!=123456"},
            headers = {"Host=localhost:8080"}
    )
    public String testParamsAndHeaders(HttpServletRequest request, Model model){
        return buildSuccessView(request, model);
    }

    //@RequestMapping("/a?a/testAnt")
    @RequestMapping("/a*a/testAnt")
    public String testAnt(HttpServletRequest request, Model model){
        return buildSuccessView(request, model);
    }

    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id")Integer id, @PathVariable("username") String username,
                           HttpServletRequest request, Model model){
        System.out.println("id:"+id+",username:"+username);
        return buildSuccessView(request, model);
    }

}
