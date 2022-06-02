package com.lc.myHandler;

import cn.hutool.log.StaticLog;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 此对捕获的异常进行简单的二次处理，返回异常的信息，虽然这种能够让我们知道异常的原因，但是在很多的情况下来说，
 * 可能还是不够人性化，不符合我们的要求。那么我们这里可以通过自定义的异常类以及枚举类来实现我们想要的那种数据吧
 * 详细见 com/lc/myException/GlobalExceptionHandler.java
 */
@ControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public String exceptionHandler(Exception e) {
		// System.out.println("未知异常！原因是:" + e);
		StaticLog.info("未知异常！原因是:{}", e);
		return e.getMessage();
	}
}
