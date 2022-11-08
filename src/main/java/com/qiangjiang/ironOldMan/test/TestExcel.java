package com.qiangjiang.ironOldMan.test;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jq on 8/6/21
 */
public class TestExcel {

    public static void main(String[] args) {
        //创建HSSFWorkbook工作薄对象
        HSSFWorkbook workbook=new HSSFWorkbook();
        //创建HSSFSheet对象
        HSSFSheet sheet=workbook.createSheet("sheet1");
        //创建行的单元格，从0开始
        HSSFRow row = sheet.createRow(0);
        //创建单元格,从0开始
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("a");
        //一下为简写
        row.createCell(1).setCellValue("aa");
        row.createCell(2).setCellValue("aaa");
        row.createCell(3).setCellValue("aaaa");

        //创建文档信息
        workbook.createInformationProperties();
        //获取DocumentSummaryInformation对象
        DocumentSummaryInformation documentSummaryInformation = workbook.getDocumentSummaryInformation();
        documentSummaryInformation.setCategory("类别:Excel文件");//类别
        documentSummaryInformation.setManager("管理者:王军");//管理者
        documentSummaryInformation.setCompany("公司:Action");//公司
        try {
            //文档输出
            FileOutputStream out = new FileOutputStream("/Users/jiangqiang/work/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() +".xls");
            workbook.write(out);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
