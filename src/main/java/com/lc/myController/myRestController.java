package com.lc.myController;

import cn.hutool.core.lang.Dict;
import cn.hutool.system.oshi.OshiUtil;
import com.lc.myEntity.ResultBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller 控制层
 * <p>
 * 一些共用的接口
 */
@RestController
@RequestMapping(value = "/api")
public class myRestController {
	/**
	 * ping pong 测试接口
	 *
	 * @return
	 */
	@RequestMapping(value = "/ping", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
	public ResultBody ping() {
		return ResultBody.success("pong");
	}

	/**
	 * ping pong 测试接口
	 *
	 * @return
	 */
	@RequestMapping(value = "/myMachineInfo", method = {RequestMethod.POST, RequestMethod.GET}, produces = "application/json;charset=utf-8")
	public ResultBody myMachineInfo() {
		return ResultBody.success(Dict.create()
				.set("cpu", OshiUtil.getCpuInfo())
				.set("mem", OshiUtil.getMemory())
				.set("disk", OshiUtil.getDiskStores())
		);
	}
}

