//package com.qiangjiang.ironOldMan.test;
//
//import lombok.Data;
//import org.junit.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by jq on 2020-03-27
// */
//public class TestMap {
//
//    @Test
//    public void testMap() {
//        Map<String, Object> result = new HashMap<>();
//        Object t1 = instance();
//        result.put("111", t1);
//        Object t2 = result.getOrDefault("111", instance());
//
////        Object t2 = result.computeIfAbsent("111", (key) -> instance());
//
//    }
//
//    private Object instance() {
//        System.out.println("instance");
//        return new TestC();
//    }
//
//    @Data
//    public static class TestC {
//        private String name;
//    }
//
//
//    @Test
//    public void testStr(){
//        String str = "mock-0123456";
//        boolean contains = str.contains("mock-0123456");
//        System.out.println(contains);
//
//    }
//}
