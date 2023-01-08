package com.showscores.vo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

@Data
public class PageVO {
    private Integer current;
    private Integer size;

    private Integer total;

    private String search;

    private Integer grade;
    private Integer clazz;

    public <T> Page<T> getPage(){
        return new Page<>(current, size);
    }

    public <T> QueryWrapper<T> getWrapper(QueryWrapper<T> wrapper){
        if (grade!=null){
            wrapper.eq("grade",grade);
        }
        if (clazz!=null){
            wrapper.eq("clazz",clazz);
        }
        return wrapper;
    }
}
