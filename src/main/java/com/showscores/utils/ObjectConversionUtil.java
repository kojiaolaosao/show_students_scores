package com.showscores.utils;

import org.springframework.cglib.beans.BeanMap;

import java.util.Map;

public class ObjectConversionUtil {
    public static <T> T mapToBean(Map<String,Object> map, Class<T> clazz) {
        T bean = null;
        try {
            bean = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }
}
