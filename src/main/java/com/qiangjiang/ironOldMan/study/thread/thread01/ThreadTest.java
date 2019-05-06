package com.qiangjiang.ironOldMan.study.thread.thread01;

public class ThreadTest {



    public static void main(String[] args) {
        MyThread01  myThread01 = new MyThread01();
//        MyThread01  myThread02 = new MyThread01("myThread02");
//        MyThread01  myThread03 = new MyThread01("myThread03");
//        MyThread01  myThread04 = new MyThread01("myThread04");
        myThread01.start();
        myThread01.start();
        myThread01.start();
        myThread01.start();
    }
}
