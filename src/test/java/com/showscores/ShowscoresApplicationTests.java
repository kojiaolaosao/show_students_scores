package com.showscores;

import com.showscores.utils.ExcelReadUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShowscoresApplicationTests {

    @Test
    void contextLoads() throws Exception {
        List<List<Object>> lists = ExcelReadUtil.getBankListByExcel();
//        System.out.println("======"+lists.size());
    }

}
