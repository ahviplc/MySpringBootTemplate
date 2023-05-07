package com.lc.MySpringBootTemplate;

import cn.hutool.core.date.DateUtil;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.lc.myInterface.MyMessageReporter;
import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.audit.ConsoleMessageCollector;
import com.mybatisflex.core.audit.MessageCollector;
import com.mybatisflex.core.audit.MessageReporter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.lc.myController",
        "com.lc.myService",
        "com.lc.myException",
        "com.lc.myAspect"})
@MapperScan("com.lc.myMapper")
public class MySpringBootTemplateApplication implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {

    public static void main(String[] args) {
        // 隐掉初始写法
        // SpringApplication.run(MySpringBootTemplateApplication.class, args);

        // 获取context
        ConfigurableApplicationContext context = SpringApplication.run(MySpringBootTemplateApplication.class, args);
        Environment environment = context.getBean(Environment.class);
        // 获取端口
        // System.out.println("访问链接：http://localhost:" + environment.getProperty("server.port") + environment.getProperty("server.servlet.context-path"));
        String thisPort = environment.getProperty("server.port");
        // Console.log("{},在端口{},服务程序正在运行... 首页链接 => {} | {}", DateUtil.now(), thisPort, "http://localhost:" + thisPort, "http://127.0.0.1:" + thisPort);
        // Console.log("{},在端口{},服务程序正在运行... 测试链接 => {} | {}", DateUtil.now(), thisPort, "http://localhost:" + thisPort + "/api" + "/ping", "http://127.0.0.1:" + thisPort + "/api" + "/ping");
        StaticLog.info("{},在端口{},服务程序正在运行... 首页链接 => {} | {}", DateUtil.now(), thisPort, "http://localhost:" + thisPort, "http://127.0.0.1:" + thisPort);
        StaticLog.info("{},在端口{},服务程序正在运行... 测试链接 => {} | {}", DateUtil.now(), thisPort, "http://localhost:" + thisPort + "/api" + "/ping", "http://127.0.0.1:" + thisPort + "/api" + "/ping");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("run....");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("onApplicationEvent");
        //开启审计功能
        AuditManager.setAuditEnable(true);

        //【MessageCollector】和【MessageReporter】只能二选一
        // 设置 SQL 审计收集器
        // 控制台输出
        // collector = new ConsoleMessageCollector();
        // AuditManager.setMessageCollector(collector);

        // 设置自己的 自定义 MessageReporter
        // 输出到log文件中【MySpringBootTemplate\logs】
        MessageReporter reporter = new MyMessageReporter();
        AuditManager.setMessageReporter(reporter);
    }
}
