package com.showscores.vo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

@Data
public class PageVO {
    private Integer current;
    private Integer size;

    private Integer total;

    public <T> Page<T> getPage(){
        return new Page<>(current, size);
    }
}
