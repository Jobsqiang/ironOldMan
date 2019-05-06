package com.qiangjiang.ironOldMan.study.thread.thread01;

public class MyThread02 extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("MyThread02 go ......");
    }

    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public MyThread02(String name, int num) {
        super(name);
        this.num = num;
    }
}
