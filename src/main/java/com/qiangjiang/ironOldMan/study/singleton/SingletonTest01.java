package com.qiangjiang.ironOldMan.study.singleton;

/**
 * Created by jq on 2020-03-02
 */
public class SingletonTest01 {

    //私有构造函数
    private SingletonTest01(){

        System.out.println("singleton is create");
    }

    private static SingletonTest01 singletonTest01 = new SingletonTest01();

    private static SingletonTest01 getSingleton(){
        return singletonTest01;
    }

    public void createString(){
        System.out.println("string is create");
    }

    public static void main(String[] args) {
        SingletonTest01.getSingleton();
    }

}
