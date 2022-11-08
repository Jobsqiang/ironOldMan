package com.qiangjiang.ironOldMan.study.singleton;

/**
 * Created by jq on 2020-03-02
 */
public class SingletonTest02 {

    private SingletonTest02(){
        System.out.println("singleton is create");
    }

    private static SingletonTest02 singletonTest02 = null;

    public static synchronized SingletonTest02 getSingletonTest02(){
        if(singletonTest02 == null){
            singletonTest02 = new SingletonTest02();
        }
        return singletonTest02;
    }

}
