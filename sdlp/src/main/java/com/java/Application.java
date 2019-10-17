package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@MapperScan({"com.java"})
//包扫描：扫描controller:service
//@SpringBootApplication(scanBasePackages = {"com.java"})
//开启sprinngboot的默认配置
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.java"})
@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	/*外置tomcat使用*/
	/*@Override protected SpringApplicationBuilder configure(SpringApplicationBuilder application) { 
		return application.sources(Application.class);
	}*/

    
    public static void main(String[] args) {
        // 内置了tomcat，因此springboot可以不用发布在外部的tomcat服务器中
        // spring就是简化了ssm框架的搭建,类似于不用书写ssm的所有配置文件
        SpringApplication.run(Application.class, args);
    }
    
}
