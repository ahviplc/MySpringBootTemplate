# MySpringBootTemplate

```markdown
SpringBoot的全局异常处理的优雅方法_Java糖糖的博客-CSDN博客_springboot 优雅异常处理
https://blog.csdn.net/m0_49496327/article/details/124500571

springboot 获取当前项目的端口号 ip_m0_54852350的博客-CSDN博客_springboot获取ip和端口
https://blog.csdn.net/m0_54852350/article/details/124035448

springboot启动时如何获取端口和项目名_Java_软件编程 - 编程客栈
http://www.cppcns.com/ruanjian/java/439383.html

Springboot与Controller目录不在同一级，导致controller的方法404 - 灰信网（软件开发博客聚合）
https://www.freesion.com/article/70711195172/

Hutool — 🍬A set of tools that keep Java sweet.
https://hutool.cn/

hutool: 🍬小而全的Java工具类库，使Java拥有函数式语言般的优雅，让Java语言也可以“甜甜的”。
https://gitee.com/dromara/hutool

GitHub - oshi/oshi: Native Operating System and Hardware Information
https://github.com/oshi/oshi

Oshi封装-OshiUtil
https://www.hutool.cn/docs/#/system/Oshi￥ﾰﾁ￨ﾣﾅ-OshiUtil
```

# 其他说明

```markdown
SpringBoot的项目已经对有一定的异常处理了，但是对于我们开发者而言可能就不太合适了， 因此我们需要对这些异常进行统一的捕获并处理。 SpringBoot中有一个 ControllerAdvice
的注解，使用该注解表示开启了全局异常的捕获， 我们只需在自定义一个方法使用 ExceptionHandler 注解 然后定义捕获异常的类型即可对这些捕获的异常进行统一的处理.
```

## 注意点

```markdown
*
* 注意点
* com/lc/MySpringBootTemplate/myController/UserRestController.java
* 要和
* com/lc/MySpringBootTemplate/MySpringBootTemplateApplication.java
* 在同一层目录或【com/lc/MySpringBootTemplate】其子目录下
* 也就是说
* controller目录 要和 启动类 在 同一级目录下 或 其同一级目录下的子目录下
* 若在其他位置 【com/lc/myController/UserRestController.java】
* 需使用下面注解【在 com/lc/MySpringBootTemplate/MySpringBootTemplateApplication.java 文件添加】
* 【@ComponentScan(value = "com.lc.myController")】
*
* 已在 com/lc/MySpringBootTemplate/MySpringBootTemplateApplication.java:12 添加
```

```markdown
* com/lc/myException/GlobalExceptionHandler.java 也需要添加进 组件扫描 注解
  *【@ComponentScan(value = "com.lc.myException")】
*
* 已在 com/lc/MySpringBootTemplate/MySpringBootTemplateApplication.java:13 添加
```

## git提交的一些说明

```markdown
提交信息书写模板指南:

注意前面有个空格
> ### 代表是具体的文字描述

*
* 做杂务 零工 杂事的时候
* chore: ###
*
* 修复bug的时候
* fix: ###
*
* 有功绩 有重大功能添加的时候
* feat: ###
*
* 性能提升的时候
* perf: ####
*
```

# Docker相关

```markdown
将 target/MySpringBootTemplate-0.0.1-SNAPSHOT.jar 
和
Dockerfile
一起传到服务器端(已安装Docker环境) 放在同级目录

然后执行指令 根据此 Dockerfile 创建 Docker 镜像 此镜像命名必须都是小写字母

docker build -t getyourmachineinfo:v1.0.0 .

然后执行 创建 Docker 容器

docker run -di -p 9527:9527 --name myGetYourMachineInfo getyourmachineinfo:v1.0.0

登录守护式容器
docker exec -it myGetYourMachineInfo /bin/bash

查看日志
docker logs -f --tail=30 myGetYourMachineInfo
```

# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.0/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.0/reference/htmlsingle/#web)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

