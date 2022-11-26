package com.showscores.controller;

import com.showscores.common.lang.Result;
import com.showscores.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/update")
    public Result test() {
        return Result.succ(studentService.list());
    }
}
