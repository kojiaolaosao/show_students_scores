package com.showscores;

import com.showscores.service.GradeRecordService;
import com.showscores.utils.ExcelReadUtil;
import com.showscores.vo.AllScoreVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShowscoresApplicationTests {


    @Autowired
    GradeRecordService gradeRecordService;

    @Test
    void contextLoads() throws Exception {
        List<List<Object>> lists = ExcelReadUtil.getBankListByExcel();
//        System.out.println("======"+lists.size());
    }


    @Test
    void addScoresList() throws Exception {
        AllScoreVO allScore = gradeRecordService.getAllScore(20L);
        System.out.println(allScore);
    }
}
