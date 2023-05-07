package com.lc.myController;


import com.lc.mapper.AccountMapper;
import com.lc.myAspect.annotation.SysLog;
//import com.lc.myEntity.Account;
import com.lc.myEntity.ResultBody;
import com.lc.myMapper.MyAccountMapper;
import com.lc.myService.AccountService;
//import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.row.Db;
import com.mybatisflex.core.row.Row;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static com.lc.myEntity.table.Tables.ACCOUNT;
import static com.mybatisflex.core.query.QueryMethods.*;

/**
 * Controller 控制层 for account
 * <p>
 * 用户
 */
@RestController
@RequestMapping(value = "/api")
public class accountRestController {
    @Resource
    AccountMapper accountMapper;


    @Resource
    MyAccountMapper myAccountMapper;

    @Resource
    AccountService accountService;

    @SysLog(value = "我是account接口通过name查询单个实体切面日志-自定义mapper")
    @GetMapping("/account/byName/{name}")
    ResultBody selectName(@PathVariable("name") String name) {
        return ResultBody.success(myAccountMapper.selectByName(name));
    }

    @SysLog(value = "我是account接口通过id查询单个实体切面日志-自定义mapper")
    @GetMapping("/account/byId/{id}")
    ResultBody selectId(@PathVariable("id") Long id) {
        return ResultBody.success(myAccountMapper.selectById(id));
    }

    @SysLog(value = "我是account接口通过id查询单个实体切面日志")
    @GetMapping("/account/{id}")
    @Transactional
    public ResultBody selectOne(@PathVariable("id") Long id) {

        Row row1 = Db.selectOneById("tb_account", "id", 1);
        System.out.println(">>>>>>> row1: " + row1);

        Row row2 = Db.selectOneById("tb_account", "id", 2);
        System.out.println(">>>>>>> row2: " + row2);

        return ResultBody.success(accountMapper.selectOneById(id));
    }

    @SysLog(value = "我是account接口更新切面日志")
    @GetMapping("/account/update/{id}")
    @Transactional
    public ResultBody updateOne(@PathVariable("id") Long id) {

        Row row1 = Db.selectOneById("tb_account", "id", 1);
        System.out.println(">>>>>>> row1: " + row1);

        Row row2 = Db.selectOneById("tb_account", "id", 2);
        System.out.println(">>>>>>> row2: " + row2);

        accountService.update2(id);

        return ResultBody.success(accountMapper.selectOneById(id));
    }

    @SysLog(value = "我是account接口查询全部切面日志")
    @GetMapping("/account/all")
    ResultBody all() {
        return ResultBody.success(accountMapper.selectAll());
    }

    @SysLog(value = "我是account接口分页查询切面日志")
    @GetMapping("/account/page")
    ResultBody paginate(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "10") int pageSize) {
        return ResultBody.success(accountMapper.paginate(pageNumber, pageSize, QueryWrapper.create()));
    }

    // test
    // 各种测试
    @SysLog(value = "我是account接口t1测试切面日志")
    @GetMapping("/account/t1")
    ResultBody t1() {
        //构造 QueryWrapper
        QueryWrapper query = new QueryWrapper();
        query.where(ACCOUNT.ID.ge(2));
        return ResultBody.success(accountMapper.selectListByQuery(query));
    }

    @SysLog(value = "我是account接口t2测试切面日志")
    @GetMapping("/account/t2")
    ResultBody t2() {
        //构造 QueryWrapper
        QueryWrapper query = new QueryWrapper();
        query.select(ACCOUNT.ID, ACCOUNT.USER_NAME).from(ACCOUNT);
        return ResultBody.success(accountMapper.selectListByQuery(query));
    }

    @SysLog(value = "我是account接口t3测试切面日志")
    @GetMapping("/account/t3")
    ResultBody t3() {
        //构造 QueryWrapper
        QueryWrapper query = new QueryWrapper().select(ACCOUNT.ID.as("accountId"), ACCOUNT.USER_NAME).from(ACCOUNT.as("a"));
        return ResultBody.success(accountMapper.selectListByQuery(query));
    }

    @SysLog(value = "我是account接口t4测试切面日志")
    @GetMapping("/account/t4")
    ResultBody t4() {
        //构造 QueryWrapper
        QueryWrapper query = new QueryWrapper().select(ACCOUNT.ID.as("accountId"), ACCOUNT.USER_NAME).from(ACCOUNT.as("a"));
        return ResultBody.success(accountMapper.selectListByQuery(query));
    }

    @SysLog(value = "我是account接口t5测试切面日志")
    @GetMapping("/account/t5")
    ResultBody t5() {
        //构造 QueryWrapper
        QueryWrapper query = new QueryWrapper().select(ACCOUNT.ID, ACCOUNT.USER_NAME.as("user_name"), max(ACCOUNT.BIRTHDAY), avg(ACCOUNT.AGE).as("age_avg")).from(ACCOUNT);
        // todo 待解决 【SELECT "id", "user_name" AS "user_name", MAX("birthday"), AVG("age") AS age_avg FROM "tb_account"】
        // 有报错 Cause: org.postgresql.util.PSQLException: ERROR: column "tb_account.id" must appear in the GROUP BY clause or be used in an aggregate function
        return ResultBody.success(accountMapper.selectListByQuery(query));
    }

    @SysLog(value = "我是account接口t6测试切面日志")
    @GetMapping("/account/t6")
    ResultBody t6() {
        //构造 QueryWrapper
        QueryWrapper queryWrapper = QueryWrapper.create().select().from(ACCOUNT).where(ACCOUNT.ID.ge(1)).and(ACCOUNT.USER_NAME.like("haha"));
        return ResultBody.success(accountMapper.selectListByQuery(queryWrapper));
    }

    @SysLog(value = "我是account接口t7测试切面日志")
    @GetMapping("/account/t7")
    ResultBody t7() {
        // https://mybatis-flex.com/zh/base/querywrapper.html#where-%E5%8A%A8%E6%80%81%E6%9D%A1%E4%BB%B6-1
        // where 动态条件 1
        // 构造 QueryWrapper
        boolean flag = false;
        QueryWrapper queryWrapper = QueryWrapper.create().select().from(ACCOUNT).where(flag ? ACCOUNT.ID.ge(2) : noCondition()).and(ACCOUNT.USER_NAME.like("haha"));
        return ResultBody.success(accountMapper.selectListByQuery(queryWrapper));
    }

    // todo
    // go on
}

