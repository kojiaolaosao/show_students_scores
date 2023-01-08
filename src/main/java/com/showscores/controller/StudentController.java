package com.showscores.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.showscores.common.lang.Result;
import com.showscores.entity.Student;
import com.showscores.service.StudentService;
import com.showscores.vo.GradeRecordVO;
import com.showscores.vo.PageVO;
import com.showscores.vo.RecordVO;
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

    @PostMapping("/getPage")
    public Result<Page<Student>> getPage(@RequestBody PageVO pageVO){
        return Result.succ(studentService.getPage(pageVO));
    }
}
