package com.showscores.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("student")
public class Student  extends BaseEntity{
    private String name;
    private sex sex;
}
enum sex{
    男,女
}