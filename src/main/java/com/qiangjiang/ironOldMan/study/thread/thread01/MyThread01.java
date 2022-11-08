package com.qiangjiang.ironOldMan.study.thread.thread01;

public class MyThread01 extends Thread{

    private int num = 1000;
    @Override
    public void run() {
        while (true){
            if(num>=0){
                num--;
                System.out.println(currentThread().getName()+"----"+num);
            }
        }

    }

}

