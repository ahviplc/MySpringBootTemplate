# MySpringBootTemplate

MySpringBootTemplate: 一个SpringBoot开发模板项目,内置了优雅的处理全局异常.
https://gitee.com/ahviplc/MySpringBootTemplate

Docker Hub for getyourmachineinfo
https://hub.docker.com/repository/docker/ahviplc/getyourmachineinfo

# 如何使用 Docker 部署我

> docker pull ahviplc/getyourmachineinfo:latest

> docker pull ahviplc/getyourmachineinfo:v1.0.0

执行上面 docker 指令 获取其镜像之后 之后 执行下面的指令 创建容器即可

具体版本 v1.0.0

```shell
docker run -di -p 9527:9527 \
--name myGetYourMachineInfo \
-e APP_NAME='Just Show Your Machine Info' \
-e WHO_AM_I='LC' \
getyourmachineinfo:v1.0.0
```

最新版本

```shell
docker run -di -p 9527:9527 \
--name myGetYourMachineInfo \
-e APP_NAME='Just Show Your Machine Info' \
-e WHO_AM_I='LC' \
getyourmachineinfo:latest
```

浏览器访问 测试接口

http://localhost:9527/api/ping

返回json串

```json
{
  "code": "200",
  "message": "成功!",
  "result": "pong"
}
```

即代表部署完成 访问 http://localhost:9527 即可到首页

一些其他接口说明 请看如下标题部分的内容

> 一些接口总览

Done.

# 一些链接

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

SpringBoot项目中如何访问HTML页面_java_脚本之家
https://www.jb51.net/article/230765.htm

Vue2 配置 Axios api 接口调用文件的方法_含有 vue2 页面
http://www.gimoo.net/t/1909/5d7dc5519c0e4.html

vue2的生命周期_旧梦ぷ如烟的博客-CSDN博客_vue2生命周期
https://blog.csdn.net/m0_69974492/article/details/124348644

spring boot profile配置和启动时no active profile set, falling back to default profiles: default的问题_beAwesomeToday的博客-CSDN博客
https://blog.csdn.net/benbenniaono1/article/details/105632264

解决js浮点数加法减法乘除法精度丢失问题 - 自处理或者使用开源js-CSDN博客
https://blog.csdn.net/InternetJava/article/details/109473812

decimal.JS 快速入门 - 简书
https://www.jianshu.com/p/429637a1c80e

Vue的生命周期_执手天涯@的博客-vue生命周期
https://blog.csdn.net/m0_37911124/article/details/123481146

js定时器_成神之路.java的博客-js 定时器
https://blog.csdn.net/qq_38135680/article/details/118157464

vue中使用定时器 - 简书
https://www.jianshu.com/p/2165d4a0ab26
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
将  
target/MySpringBootTemplate-0.0.1-SNAPSHOT.jar  
和    
Dockerfile  
一起传到服务器端(已安装Docker环境) 放在同级目录

然后执行指令 根据此 Dockerfile 创建 Docker 镜像 此镜像命名必须都是小写字母

docker build -t getyourmachineinfo:v1.0.0 .

然后执行 创建 Docker 容器

docker run -di -p 9527:9527 --name myGetYourMachineInfo getyourmachineinfo:v1.0.0

带环境变量的执行 创建 Docker 容器 可改变默认的自定义环境变量

这个端口环境变量容器弃用 端口指定 端口变更(内部端口必须是9527) 可通过 -p 9527:9527 或 -p 10001:9527

docker run -di -p 9527:9527 \
--name myGetYourMachineInfo \
-e APP_NAME='Just Show Your Machine Info' \
-e APP_PORT=9527 \
getyourmachineinfo:v1.0.0

这个指定了 WHO_AM_I 我是谁 使用下面这个

docker run -di -p 9527:9527 \
--name myGetYourMachineInfo \
-e APP_NAME='Just Show Your Machine Info' \
-e WHO_AM_I='LC' \
getyourmachineinfo:v1.0.0

登录守护式容器

docker exec -it myGetYourMachineInfo /bin/bash

查看日志

docker logs -f --tail=30 myGetYourMachineInfo
```

# 一些接口总览

> 测试接口 http://localhost:9527/api/ping

> 测试接口腾讯云 http://43.142.58.153:9527/api/ping

```markdown
所有机器信息
http://localhost:9527/api/all

cpu信息
http://localhost:9527/api/cpu

内存信息
http://localhost:9527/api/mem

硬盘信息
http://localhost:9527/api/disk

系统信息
http://localhost:9527/api/os

环境变量信息
http://localhost:9527/api/env
```

```markdown
首页(status 状态页)
Just Show Your Machine Status
http://localhost:9527/

Just Show Your Machine Info
http://localhost:9527/index
```

# ChangeLog

## v1.0.0 | 20220607

> 完成:核心功能接口和页面展示

> 待做:环形展示内存使用率和cpu使用率等

## v1.0.1 | 20220608

> 完成:环形展示内存使用率和cpu使用率等

TODO

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

