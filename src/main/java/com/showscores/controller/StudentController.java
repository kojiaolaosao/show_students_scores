package com.showscores.controller;

import com.showscores.common.lang.Result;
import com.showscores.entity.Student;
import com.showscores.service.StudentService;
import com.showscores.vo.GradeRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/update")
    public Result<List<Student>> test() {
        return Result.succ(studentService.list());
    }

    @PostMapping("/addScoresList")
    public Result addScoresList(@RequestBody List<GradeRecordVO> gradeRecordVOs){
        System.out.println(gradeRecordVOs);
        return null;
    }
}
