package com.rawtype.service;

import com.rawtype.entity.BaseEntity;

/**
 * @author: ls
 * @date: 2020/5/8 0008 16:31
 */
public interface BaseEntityService {

    <T extends BaseEntity> T queryEntity(T entity);
}
