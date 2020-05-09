package com.rawtype.controller;

import com.rawtype.entity.BaseEntity;
import com.rawtype.entity.MyEntity1;
import com.rawtype.service.BaseEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ls
 * @date: 2020/5/8 0008 17:00
 */
@RestController
@RequestMapping("/baseEntity")
public class BaseEntityController {

    @Autowired
    private BaseEntityService baseEntityService;

    @RequestMapping(value = "/one")
    public <T extends BaseEntity> String queryEntity(T entity){
        baseEntityService.queryEntity(new MyEntity1());
        return "hello";
    }

}
