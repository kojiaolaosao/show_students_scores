package com.showscores.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("student")
public class Student  extends BaseEntity{
    private String name;
    private Integer grade;
    private Integer clazz;
//    private String student_code;
}
