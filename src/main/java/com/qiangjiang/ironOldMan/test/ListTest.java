package com.qiangjiang.ironOldMan.test;


public class ListTest {

    public static void main(String[] args) {
        if(true){
            byte[] placeHolder = new byte[64 * 1024 * 1024];
            System.out.println(placeHolder.length / 1024);
        }
        System.gc();
    }
}
