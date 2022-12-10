package com.showscores.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("score_records")
public class GradeRecord extends BaseEntity {
    //    姓名	总分	语文	数学	英语	附加	物理	地理	历史	政治	化学	生物	名次
    private String name;
    private Integer total_score;
    private Integer languages;
    private Integer maths;
    private Integer englishes;
    private Integer addition;
    private Integer physicals;
    private Integer geography;
    private Integer history;
    private Integer politics;
    private Integer chemicals;
    private Integer biological;
    private Integer student_id;
}
