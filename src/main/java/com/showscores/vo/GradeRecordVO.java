package com.showscores.vo;

import com.showscores.entity.BaseEntity;
import com.showscores.entity.GradeRecord;
import lombok.Data;

@Data
public class GradeRecordVO extends BaseEntity {
    //    姓名	总分	语文	数学	英语	附加	物理	地理	历史	政治	化学	生物	名次
    private  Long 学号;
    private String 姓名;
    private Integer 语文;
    private Integer 数学;
    private  Integer 附加;
    private Integer 英语;
    private Integer 物理;
    private Integer 历史;
    private Integer 化学;
    private Integer 化赋;
    private Integer 政治;
    private Integer 政赋;
    private Integer 地理;
    private Integer 地赋;

    private Integer 生物;
    private Integer 生赋;
    private Integer 总分;
    private Integer 班级名次;
    private Integer 年级排名;

    public GradeRecord VOtoEntity(){
        GradeRecord gradeRecord = new GradeRecord();

        gradeRecord.setName(姓名);
        gradeRecord.setStudentCode(学号);

        gradeRecord.setTotalScore(总分);

        gradeRecord.setLanguages(语文);
        gradeRecord.setMaths(数学);
        gradeRecord.setEnglishes(英语);

        gradeRecord.setAddition(附加);

        gradeRecord.setPhysicals(物理);
        gradeRecord.setHistory(历史);

        gradeRecord.setGeography(地理);
        gradeRecord.setGeographyReal(地赋);
        gradeRecord.setPolitics(政治);
        gradeRecord.setPoliticsReal(政赋);
        gradeRecord.setChemicals(化学);
        gradeRecord.setChemicalsReal(化赋);
        gradeRecord.setBiological(生物);
        gradeRecord.setBiologicalReal(生赋);

        gradeRecord.setClassRank(班级名次);
        gradeRecord.setGradeRank(年级排名);

        return gradeRecord;
    }
}
