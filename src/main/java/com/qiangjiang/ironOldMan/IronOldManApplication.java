package com.qiangjiang.ironOldMan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableEurekaServer
@SpringBootApplication
@EnableSwagger2
public class IronOldManApplication {
	private static Logger logger = LoggerFactory.getLogger(IronOldManApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(IronOldManApplication.class, args);
		logger.info("服务干起来...");

	}

}
