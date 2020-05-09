package com.rawtype.impl;

import com.rawtype.entity.BaseEntity;
import com.rawtype.service.BaseEntityService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

/**
 * @author: ls
 * @date: 2020/5/8 0008 16:33
 */
@Service
public class BaseEntityServiceImpl implements BaseEntityService {
    @Override
    public <T extends BaseEntity> T queryEntity(T entity) {
//        String clazz = entity.getClass().getSimpleName();
        Class clazz = entity.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getType() + ":" + f.getName());
        }
        Class superClazz = entity.getClass().getSuperclass();
        Field[] superfields = superClazz.getDeclaredFields();
        for (Field f : superfields) {
            System.out.println(f.getType() + "-" + f.getName());
        }
//        System.out.println(clazz);
//        String hql = "from ? where id = ?";
        return null;
    }
}
