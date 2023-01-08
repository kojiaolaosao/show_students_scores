package com.showscores.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.showscores.entity.GradeRecord;
import com.showscores.entity.Student;
import com.showscores.mapper.GradeRecordMapper;
import com.showscores.mapper.StudentMapper;
import com.showscores.service.StudentService;
import com.showscores.vo.PageVO;
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

    @Override
    public Page<Student> getPage(PageVO pageVO) {
        Page<Student> page = pageVO.getPage();
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper=pageVO.getWrapper(wrapper);
        wrapper.and(w->w.like("name",pageVO.getSearch()));
        return page(page,wrapper);
    }


}
