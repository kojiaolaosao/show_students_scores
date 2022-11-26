package com.showscores.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("student")
public class Student {
    private String name;
    private Boolean sex;
    private Integer score;
}
