package com.showscores.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.showscores.entity.GradeRecord;
import com.showscores.entity.Student;
import com.showscores.mapper.GradeRecordMapper;
import com.showscores.mapper.StudentMapper;
import com.showscores.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    GradeRecordMapper gradeRecordMapper;

    @Override
    public Student existStudent(Student student) {
        return getOne(new QueryWrapper<Student>()
                .eq("name",student.getName())
                .eq("grade",student.getGrade())
                .eq("clazz",student.getClazz())
        );
    }




}
