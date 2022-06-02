package com.lc.MySpringBootTemplate;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(value = "com.lc.myController")
@ComponentScan(value = "com.lc.myException")
public class MySpringBootTemplateApplication {

	public static void main(String[] args) {
		// 隐掉初始写法
		// SpringApplication.run(MySpringBootTemplateApplication.class, args);

		// 获取context
		ConfigurableApplicationContext context = SpringApplication.run(MySpringBootTemplateApplication.class, args);
		Environment environment = context.getBean(Environment.class);
		// 获取端口
		// System.out.println("访问链接：http://localhost:" + environment.getProperty("server.port") + environment.getProperty("server.servlet.context-path"));
		String thisPort = environment.getProperty("server.port");
		Console.log("{},在端口{},服务程序正在运行... 测试链接 => {}", DateUtil.now(), thisPort, "http://localhost:" + thisPort + "/api" + "/ping");
	}

}
