package com.juaracoding.cucumber.utils;


/*
IntelliJ IDEA 2024.3.1.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author wirawanriorenaldi a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 20/04/25 00.26
@Last Modified 20/04/25 00.26
Version 1.0
*/


import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import org.apache.poi.ss.usermodel.DateUtil;



public class ExcelReaderPro {

    private static Workbook workbook;

    public static void loadExcel(String path) {
        try {
            FileInputStream file = new FileInputStream(new File(path));
            workbook = WorkbookFactory.create(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<String, String> getRowData(String sheetName, int rowNum) {
        Map<String, String> data = new HashMap<>();
        Sheet sheet = workbook.getSheet(sheetName);
        Row header = sheet.getRow(0);
        Row row = sheet.getRow(rowNum);

        for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
            data.put(header.getCell(i).getStringCellValue(), row.getCell(i).getStringCellValue());
        }
        return data;
    }

    public static List<Map<String, String>> getAllData(String sheetName) {
        List<Map<String, String>> allData = new ArrayList<>();
        Sheet sheet = workbook.getSheet(sheetName);
        Row header = sheet.getRow(0);

        int lastRowNum = sheet.getLastRowNum();
        for (int i = 1; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue; // skip empty rows

            Map<String, String> data = new HashMap<>();
            for (int j = 0; j < header.getPhysicalNumberOfCells(); j++) {
                Cell cell = row.getCell(j);

                String cellValue = "";
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            cellValue = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                cellValue = cell.getDateCellValue().toString(); // Kalau date
                            } else {
                                cellValue = String.valueOf((long) cell.getNumericCellValue()); // Kalau angka biasa
                            }
                            break;
                        case BOOLEAN:
                            cellValue = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            cellValue = cell.getCellFormula();
                            break;
                        case BLANK:
                            cellValue = "";
                            break;
                        default:
                            cellValue = "";
                    }
                }
                data.put(header.getCell(j).getStringCellValue(), cellValue);
            }

            allData.add(data);
        }
        return allData;
    }

}
