package com.showscores.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.showscores.entity.Student;
import com.showscores.mapper.StudentMapper;
import com.showscores.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
