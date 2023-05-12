package com.lc.myController;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.lc.myAspect.annotation.SysLog;
import com.lc.myEntity.User;
import com.lc.myException.BizException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller 控制层
 * <p>
 * 用户
 */
@RestController
@RequestMapping(value = "/api")
public class UserRestController {

	@SysLog(value = "新增用户User接口切面日志")
	@PostMapping("/user")
	public boolean insert(@RequestBody User user) {
		// System.out.println("开始新增...");
		// 如果姓名为空就手动抛出一个自定义的异常！
		if (user.getName() == null) {
			throw new BizException("-1", "用户姓名不能为空！");
		}
		return true;
	}

	@SysLog(value = "更新用户User接口切面日志")
	@PutMapping("/user")
	public boolean update(@RequestBody User user) {
		// System.out.println("开始更新...");
		// 这里故意造成一个空指针的异常，并且不进行处理
		String str = null;
		str.equals("111");
		return true;
	}

	@SysLog(value = "删除用户User接口切面日志")
	@DeleteMapping("/user")
	public boolean delete(@RequestBody User user) {
		// System.out.println("开始删除...");
		// 这里故意造成一个异常，并且不进行处理
		Integer.parseInt("abc123");
		return true;
	}

	@SysLog(value = "查询用户User接口切面日志")
	@GetMapping("/user")
	public List<User> findByUser(@RequestBody User user) {
		// System.out.println("开始查询...");
		List<User> userList = new ArrayList<>();
		User user2 = new User();
		user2.setId("1");
		user2.setName("LC");
		user2.setAge(18);
		userList.add(user2);
		return userList;
	}

	// Sa-Token测试接口
	// 测试登录，浏览器访问： http://localhost:9527/api/user/doLogin?username=zhang&password=123456
	@RequestMapping("user/doLogin")
	public SaResult doLogin(String username, String password) {
		// 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
		if ("zhang".equals(username) && "123456".equals(password)) {
			StpUtil.login(10001);
			return SaResult.ok("登录成功");
		}
		return SaResult.error("登录失败");
	}

	// Sa-Token测试接口
	// 查询登录状态，浏览器访问： http://localhost:9527/api/user/isLogin
	@RequestMapping("user/isLogin")
	public SaResult isLogin() {
		// 获取当前会话是否已经登录，返回true=已登录，false=未登录
		boolean loginFlag = StpUtil.isLogin();
		// 检验当前会话是否已经登录, 如果未登录，则抛出异常：`NotLoginException`
		// 可将此异常定义在【com/lc/myException/GlobalExceptionHandler.java】 将其接管 优雅抛出返回异常json串
		// StpUtil.checkLogin();
		if (loginFlag) {
			SaSession sessionByLoginId = StpUtil.getSessionByLoginId(10001);
			// 获取当前匿名 Token-Session （可在未登录情况下使用的Token-Session）
			SaSession sessionByLoginId2 = StpUtil.getAnonTokenSession();
			SaSession sessionByLoginId3 = StpUtil.getTokenSession();

			// 获取当前会话账号id, 如果未登录，则返回null
			Object thisLoginId = StpUtil.getLoginIdDefaultNull();
			Object thisToken = StpUtil.getTokenValue();
			String thisToken2 = StpUtil.getTokenValueByLoginId(10001);
			SaSession sessionByLoginI4 = StpUtil.getTokenSessionByToken(thisToken.toString());
			SaSession sessionByLoginI5 = StpUtil.getTokenSessionByToken(thisToken2);
			System.out.println("");
		}
		return SaResult.ok("当前会话是否登录：" + loginFlag);
	}

	// Sa-Token测试接口
	// 查询 Token 信息  ---- http://localhost:9527/api/user/tokenInfo
	@RequestMapping("user/tokenInfo")
	public SaResult tokenInfo() {
		return SaResult.data(StpUtil.getTokenInfo());
	}

	// Sa-Token测试接口
	// 测试注销  ---- http://localhost:9527/api/user/logout
	@RequestMapping("user/logout")
	public SaResult logout() {
		// 当前会话注销登录
		StpUtil.logout();
		return SaResult.ok();
	}
}

