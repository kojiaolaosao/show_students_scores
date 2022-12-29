package com.showscores.vo;


import com.showscores.entity.BaseEntity;
import com.showscores.entity.GradeRecord;
import com.showscores.entity.Record;
import com.showscores.entity.Student;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class RecordVO extends BaseEntity {
    private List<GradeRecordVO> records;
    private List<GradeRecord> recordEntities;
    private String title;
    private String info;

    private Integer grade;
    private Integer clazz;

    public Record getRecord(){
        Record record = new Record();
        record.setGrade(grade);
        record.setClazz(clazz);
        record.setTitle(title);
        record.setInfo(info);
        return record;
    }

    public Student getStudent(String name){
        Student student = new Student();
        student.setName(name);
        student.setGrade(grade);
        student.setClazz(clazz);
        return student;
    }

    public RecordVO buildRecordVO(Record record,List<GradeRecord> gradeRecords){
        BeanUtils.copyProperties(record,this);
        recordEntities=gradeRecords;
        return this;
    }
}
