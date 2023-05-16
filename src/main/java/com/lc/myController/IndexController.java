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

	/**
	 * status页
	 *
	 * @return
	 */
	@RequestMapping("/")
	public String index() {
		return "status";
	}

	/**
	 * index页
	 *
	 * @return
	 */
	@RequestMapping("/index")
	public String index2() {
		return "index";
	}

	/**
	 * index2页
	 *
	 * @return
	 */
	@RequestMapping("/index2")
	public String index3() {
		return "index-vue2.7";
	}

	/**
	 * index3页
	 *
	 * @return
	 */
	@RequestMapping("/index3")
	public String index4() {
		return "index-vue3";
	}

	/**
	 * layui-vue-index页
	 *
	 * @return
	 */
	@RequestMapping("/layuiVueIndex")
	public String layuiVueIndex() {
		return "layui-vue-index";
	}
}
