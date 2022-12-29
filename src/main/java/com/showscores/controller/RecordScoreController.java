package com.showscores.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.showscores.common.lang.Result;
import com.showscores.entity.Record;
import com.showscores.service.GradeRecordService;
import com.showscores.service.RecordService;
import com.showscores.vo.PageVO;
import com.showscores.vo.RecordVO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/score")
public class RecordScoreController {

    @Autowired
    GradeRecordService gradeRecordService;

    @Autowired
    RecordService recordService;

    @PostMapping("/addScoresList")
    public Result<Boolean> addScoresList(@RequestBody RecordVO recordVO){
        return Result.succ(gradeRecordService.addScoresList(recordVO));
    }


    @GetMapping("getScores")
    public Result<RecordVO> getScoresListDefault(){
        return Result.succ(gradeRecordService.getScoresListDefault());
    }

    @GetMapping("AllRecord")
    public Result<List<Record>> getAllRecord(){
        return Result.succ(recordService.list());
    }

    @PostMapping("getPage")
    public Result<Page<Record>> getPage(@RequestBody PageVO pageVO){
        return Result.succ(recordService.getPage(pageVO));
    }

    @PostMapping("getPageOrderByTime")
    public Result<Page<Record>> getPageOrderByTime(@RequestBody PageVO pageVO){
        return Result.succ(recordService.getPageOrderByTime(pageVO));
    }

    @PostMapping("updateRecord")
    public Result<Boolean> updateRecord(@RequestBody Record record){
        return Result.succ(recordService.updateById(record));
    }

    @PostMapping("delRecord/{id}")
    public Result<Boolean> delRecordById(@PathVariable Long id){
        return Result.succ(recordService.del(id));
    }
}
