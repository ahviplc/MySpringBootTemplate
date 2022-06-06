package com.lc.myController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 * <p>
 * 通过Controller控制器层跳转访问的资源
 *
 * @author LC
 **/
@Controller
public class IndexController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/index")
	public String index2() {
		return "index";
	}
}
