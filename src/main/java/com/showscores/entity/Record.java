package com.showscores.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("record")
public class Record extends BaseEntity{
    private Integer grade;
    private Integer clazz;
    private String title;
    private String info;
}
