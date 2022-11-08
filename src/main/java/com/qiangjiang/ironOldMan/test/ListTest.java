package com.qiangjiang.ironOldMan.test;


//import cn.hutool.core.collection.CollUtil;
//import cn.hutool.poi.excel.ExcelUtil;
//import cn.hutool.poi.excel.ExcelWriter;


import java.util.List;

public class ListTest {

    public static void main(String[] args) {

//        List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
//        List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
//        List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
//        List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
//        List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");
//
//        List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);
//
//        //通过工具类创建writer
////        ExcelWriter writer = ExcelUtil.getWriter("/Users/jiangqiang/test.xlsx");
//        //通过构造方法创建writer
//        ExcelWriter writer = new ExcelWriter("/Users/jiangqiang/test.xlsx");
//        //跳过当前行，既第一行，非必须，在此演示用
//        writer.passCurrentRow();
//
//        //合并单元格后的标题行，使用默认标题样式
//        writer.merge(row1.size() - 1, "测试标题");
//        //一次性写出内容，强制输出标题
//        writer.write(rows, true);
//        //关闭writer，释放内存
//        writer.close();


        boolean b = Float.parseFloat("0.00") <= 0;
        boolean c = Float.parseFloat("0.0") <= 0;
        boolean d = Float.parseFloat("0") <= 0;
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }



    public void test(){
        if(true){
            byte[] placeHolder = new byte[64 * 1024 * 1024];
            System.out.println(placeHolder.length / 1024);
        }
        System.gc();
    }


    public void testBuy(){

        while (true){

        }

    }

}
