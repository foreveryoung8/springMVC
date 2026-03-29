package com.atguigu.mvc.controller;

import com.atguigu.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * Date:2021/7/6
 * Author:ybc
 * Description:
 */
@Controller
public class ParamController {

    private String buildSuccessView(HttpServletRequest request, Model model) {
        model.addAttribute("path", request.getRequestURI());
        return "success";
    }

    @RequestMapping("/testServletAPI")
    //形参位置的request表示当前请求
    public String testServletAPI(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return buildSuccessView(request, model);
    }

    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam(value = "user_name", required = false, defaultValue = "hehe") String username,
            String password,
            String[] hobby,
            @RequestHeader(value = "sayHaha", required = true, defaultValue = "haha") String host,
            @CookieValue("JSESSIONID") String JSESSIONID,
            HttpServletRequest request,
            Model model){
        //若请求参数中出现多个同名的请求参数，可以再控制器方法的形参位置设置字符串类型或字符串数组接收此请求参数
        //若使用字符串类型的形参，最终结果为请求参数的每一个值之间使用逗号进行拼接
        System.out.println("username:"+username+",password:"+password+",hobby:"+ Arrays.toString(hobby));
        System.out.println("host:"+host);
        System.out.println("JSESSIONID:"+JSESSIONID);
        return buildSuccessView(request, model);
    }

    @RequestMapping("/testBean")
    public String testBean(User user, HttpServletRequest request, Model model){
        System.out.println(user);
        return buildSuccessView(request, model);
    }


}
