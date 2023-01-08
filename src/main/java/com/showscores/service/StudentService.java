package com.showscores.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.showscores.entity.Student;
import com.showscores.vo.PageVO;

public interface StudentService extends IService<Student> {
    Student existStudent(Student student);

    Page<Student> getPage(PageVO pageVO);
}
