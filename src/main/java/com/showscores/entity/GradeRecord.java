package com.showscores.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import sun.reflect.generics.tree.ReturnType;

import java.lang.reflect.Field;
import java.util.List;

@Data
@TableName("score_records")
public class GradeRecord extends BaseEntity {
    //    姓名	总分	语文	数学	英语	附加	物理	地理	历史	政治	化学	生物	名次
    private Long studentId;
    private Long recordId;

    private Long studentCode;
    private String name;

    private Integer totalScore;

    private Integer languages;
    private Integer maths;
    private Integer englishes;
    private Integer addition;
    private Integer physicals;//物理
    private Integer history;//历史

    private Integer geography;//地理
    private Integer geographyReal;
    private Integer politics;//政治
    private Integer politicsReal;//政治
    private Integer chemicals;//化学
    private Integer chemicalsReal;//化学
    private Integer biological;//生物
    private Integer biologicalReal;//生物

    private Integer classRank;
    private Integer gradeRank;

    public void addFieldToList(@NotNull List<Object> list, @NotNull Field field){
        try {
            list.add(field.get(this));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
