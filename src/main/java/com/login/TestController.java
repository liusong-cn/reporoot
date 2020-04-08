package com.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author: ls
 * @date: 2020/4/8 0008 11:36
 */
@Controller("teController")
@RequestMapping("/testController")
public class TestController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public String test(){
        return "hello";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET,value = "user")
    public String test1(){
        return "this is user";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/user/{id}")
    public String test2(@PathVariable("id")String id, HttpServletRequest request){
        System.out.println(id);
        //接收了表单格式的post参数，需前端设置header Content-Type: application/x-www-form-urlencoded
        //表单数据格式刑辱 name=liu&sex=male
        System.out.println(request.getParameter("name"));
        return "test id";
    }

    /**
     * 通过reqeustparm注解，绑定前端的参数name到后台的参数name，且必须有，否则异常，通过设置required=false可以避免
     * @param id
     * @param name
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/users/{id}")
    public String test3(@PathVariable("id")String id,@RequestParam("name")String name, HttpServletRequest request){
        String age = "3";
        System.out.println(id);
        System.out.println(name);
        return "test id";
    }

    /**
     * 后端以requestbody注解接收json格式参数，后台可以以String接收，则实际为json格式字符串
     * 或者后台以对象接收，name后端需要匹配json格式的对象，json的key匹配对象的field
     * @param id
     * @param m
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST,value = "/userss/{id}")
    public String test4(@PathVariable("id")String id, @RequestBody String m, HttpServletRequest request){
        String age = "3";
        System.out.println(id);
        System.out.println(m);
        return "test id";
    }

}
