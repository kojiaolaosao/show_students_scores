package com.showscores.vo;

import com.showscores.entity.BaseEntity;
import com.showscores.entity.Record;
import com.showscores.entity.Student;
import lombok.Data;

@Data
public class AllScoreVO extends BaseEntity {
    private Student student;
    private String recordIds;

    private String totalScore;
    private String languages;
    private String maths;
    private String englishes;
    private String addition;
    private String physicals;
    private String history;
    private String geography;
    private String geographyReal;
    private String politics;
    private String politicsReal;
    private String chemicals;
    private String chemicalsReal;
    private String biological;
    private String biologicalReal;
    private String classRank;
    private String gradeRank;

    private String createdTimes;
    private String updatedTimes;

}
