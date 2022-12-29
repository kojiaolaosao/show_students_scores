package com.showscores.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @program: graduation_project
 * @description: 数据库字段自动填充
 * @author: Mr.qi
 * @create: 2022-03-10 17:31
 **/
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createdTime",LocalDateTime.now(),metaObject);
        this.setFieldValByName("updatedTime",LocalDateTime.now(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updatedTime",LocalDateTime.now(),metaObject);
    }
}
