//package com.qiangjiang.ironOldMan;
//
//import cn.smallbun.screw.core.Configuration;
//import cn.smallbun.screw.core.engine.EngineConfig;
//import cn.smallbun.screw.core.engine.EngineFileType;
//import cn.smallbun.screw.core.engine.EngineTemplateType;
//import cn.smallbun.screw.core.execute.DocumentationExecute;
//import cn.smallbun.screw.core.process.ProcessConfig;
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.junit.Test;
//
//import javax.sql.DataSource;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Created by jq on 2020-08-28
// */
//public class TestScrew {
//
//
//    public static void main(String[] args) {
//        test();
//    }
//
//    public static void test() {
////        DataSource dataSourceMysql = applicationContext.getBean(DataSource.class);
//
//
//// 数据源
//        HikariConfig hikariConfig = new HikariConfig();
//        hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@10.100.22.80:1521:orcl");
//        hikariConfig.setUsername("BPMDEV");
//        hikariConfig.setPassword("BPMDEV");
////        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
////        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/db_ironOldMan");
////        hikariConfig.setUsername("root");
////        hikariConfig.setPassword("jiangqiang");
//        // 设置可以获取tables remarks信息
//        hikariConfig.addDataSourceProperty("useInformationSchema", "true");
//        hikariConfig.setMinimumIdle(2);
//        hikariConfig.setMaximumPoolSize(5);
//        DataSource dataSourceMysql = new HikariDataSource(hikariConfig);
//
//        // 生成文件配置
//        EngineConfig engineConfig = EngineConfig.builder()
//                // 生成文件路径，自己mac本地的地址，这里需要自己更换下路径
//                .fileOutputDir("/Users/jiangqiang/")
//                // 打开目录
//                .openOutputDir(false)
//                // 文件类型
//                .fileType(EngineFileType.WORD)
//                // 生成模板实现
//                .produceType(EngineTemplateType.freemarker).build();
//        // 生成文档配置（包含以下自定义版本号、描述等配置连接）
//        Configuration config = Configuration.builder()
//                .version("1.0.3")
//                .description("生成文档信息描述")
//                .dataSource(dataSourceMysql)
//                .engineConfig(engineConfig)
//                .produceConfig(getProcessConfig())
//                .build();
//        // 执行生成
//        new DocumentationExecute(config).execute();
//    }
//
//    /**
//     * 配置想要生成的表+ 配置想要忽略的表
//     *
//     * @return 生成表配置
//     */
//    public static ProcessConfig getProcessConfig() {
//        // 忽略表名
//        List<String> ignoreTableName = Arrays.asList("a", "test_group");
//        // 忽略表前缀，如忽略a开头的数据库表
//        List<String> ignorePrefix = Arrays.asList("a", "t");
//        // 忽略表后缀
//        List<String> ignoreSuffix = Arrays.asList("_test", "czb_");
//        return ProcessConfig.builder()
//                //根据名称指定表生成
//                .designatedTableName(Arrays.asList("fire_user"))
//                //根据表前缀生成
//                .designatedTablePrefix(new ArrayList<>())
//                //根据表后缀生成
//                .designatedTableSuffix(new ArrayList<>())
//                //忽略表名
//                .ignoreTableName(ignoreTableName)
//                //忽略表前缀
//                .ignoreTablePrefix(ignorePrefix)
//                //忽略表后缀
//                .ignoreTableSuffix(ignoreSuffix).build();
//    }
//
//}
