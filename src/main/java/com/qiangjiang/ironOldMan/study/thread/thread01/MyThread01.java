package com.qiangjiang.ironOldMan.study.thread.thread01;

public class MyThread01 extends Thread{

    private int num = 1000;
    @Override
    public void run() {

        while(num > 0){
            System.out.println(getName()+"go ......"+num);
            num--;
        }

    }

    public MyThread01() {

    }

    public MyThread01(String name) {
        super(name);
    }
}

