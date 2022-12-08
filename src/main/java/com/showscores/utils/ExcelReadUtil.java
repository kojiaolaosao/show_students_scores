package com.showscores.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


public class ExcelReadUtil {
    /**
     * 读取excel表
     *
     * @param
     * @param
     * @return     Workbook work = new XSSFWorkbook("D://GoolgeDownload//Summary.xlsx");
     * @throws Exception
     */
    public static List<List<Object>> getBankListByExcel() throws Exception {
        List<List<Object>> list = new ArrayList<List<Object>>();             // 读取的数据放入该集合中
        String filename="E://javaProject//IdeaProjects//showscores//student.xlsx";
        File file = new File(filename);

        if (!file.exists())
            System.out.println("no exists!");
        else
            System.out.println("exist!");

        FileInputStream fileInputStream = new FileInputStream(file);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            if (sheet==null) continue;

            for (int i1 = 0; i1 < sheet.getPhysicalNumberOfRows(); i1++) {
                Row row = sheet.getRow(i1);
                for (int j = 0; j <row.getLastCellNum() ; j++) {
                    System.out.print(row.getCell(j)+" ");
                }
                System.out.println();
            }
        }

        return list;
    }
}
