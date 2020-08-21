package com.login;

import com.annotation.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:11411
 * @date: 2020/8/21 17:16
 **/
@RestController
public class LogController {

    @RequestMapping(method = RequestMethod.GET,value = "/logTest")
    @Log("这是log")
    public void logTest(){

    }
}
