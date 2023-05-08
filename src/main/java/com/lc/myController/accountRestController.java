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
    public ResultBody selectName(@PathVariable("name") String name) {
        return ResultBody.success(myAccountMapper.selectByName(name));
    }

    @SysLog(value = "我是account接口通过id查询单个实体切面日志-自定义mapper")
    @GetMapping("/account/byId/{id}")
    public ResultBody selectId(@PathVariable("id") Long id) {
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
    public ResultBody all() {
        return ResultBody.success(accountMapper.selectAll());
    }

    @SysLog(value = "我是account接口分页查询切面日志")
    @GetMapping("/account/page")
    public ResultBody paginate(@RequestParam(defaultValue = "1") int pageNumber, @RequestParam(defaultValue = "10") int pageSize) {
        return ResultBody.success(accountMapper.paginate(pageNumber, pageSize, QueryWrapper.create()));
    }

    // test
    // 各种测试
    @SysLog(value = "我是account接口t1测试切面日志")
    @GetMapping("/account/t1")
    public ResultBody t1() {
        //构造 QueryWrapper
        QueryWrapper query = new QueryWrapper();
        query.where(ACCOUNT.ID.ge(2));
        return ResultBody.success(accountMapper.selectListByQuery(query));
    }

    @SysLog(value = "我是account接口t2测试切面日志")
    @GetMapping("/account/t2")
    public ResultBody t2() {
        //构造 QueryWrapper
        QueryWrapper query = new QueryWrapper();
        query.select(ACCOUNT.ID, ACCOUNT.USER_NAME).from(ACCOUNT);
        return ResultBody.success(accountMapper.selectListByQuery(query));
    }

    @SysLog(value = "我是account接口t3测试切面日志")
    @GetMapping("/account/t3")
    public ResultBody t3() {
        //构造 QueryWrapper
        QueryWrapper query = new QueryWrapper().select(ACCOUNT.ID.as("accountId"), ACCOUNT.USER_NAME).from(ACCOUNT.as("a"));
        return ResultBody.success(accountMapper.selectListByQuery(query));
    }

    @SysLog(value = "我是account接口t4测试切面日志")
    @GetMapping("/account/t4")
    public ResultBody t4() {
        //构造 QueryWrapper
        QueryWrapper query = new QueryWrapper().select(ACCOUNT.ID.as("accountId"), ACCOUNT.USER_NAME).from(ACCOUNT.as("a"));
        return ResultBody.success(accountMapper.selectListByQuery(query));
    }

    @SysLog(value = "我是account接口t5测试切面日志")
    @GetMapping("/account/t5")
    public ResultBody t5() {
        //构造 QueryWrapper
        QueryWrapper query = new QueryWrapper().select(ACCOUNT.ID, ACCOUNT.USER_NAME.as("user_name"), max(ACCOUNT.BIRTHDAY), avg(ACCOUNT.AGE).as("age_avg")).from(ACCOUNT).groupBy(ACCOUNT.ID, ACCOUNT.USER_NAME);
        // todo 待解决 【SELECT "id", "user_name" AS "user_name", MAX("birthday"), AVG("age") AS age_avg FROM "tb_account"】
        // 有报错 Cause: org.postgresql.util.PSQLException: ERROR: column "tb_account.id" must appear in the GROUP BY clause or be used in an aggregate function
        // 无报错 解决sql 【SELECT "id", "user_name" AS "user_name", MAX("birthday"), AVG("age") AS age_avg FROM "tb_account" GROUP BY "id", "user_name"】
        return ResultBody.success(accountMapper.selectListByQuery(query));
    }

    @SysLog(value = "我是account接口t6测试切面日志")
    @GetMapping("/account/t6")
    public ResultBody t6() {
        //构造 QueryWrapper
        QueryWrapper queryWrapper = QueryWrapper.create().select().from(ACCOUNT).where(ACCOUNT.ID.ge(1)).and(ACCOUNT.USER_NAME.like("haha"));
        return ResultBody.success(accountMapper.selectListByQuery(queryWrapper));
    }

    @SysLog(value = "我是account接口t7测试切面日志")
    @GetMapping("/account/t7")
    public ResultBody t7() {
        // https://mybatis-flex.com/zh/base/querywrapper.html#where-%E5%8A%A8%E6%80%81%E6%9D%A1%E4%BB%B6-1
        // where 动态条件 1
        // 构造 QueryWrapper
        boolean flag = false;
        QueryWrapper queryWrapper = QueryWrapper.create().select().from(ACCOUNT).where(flag ? ACCOUNT.ID.ge(2) : noCondition()).and(ACCOUNT.USER_NAME.like("haha"));
        return ResultBody.success(accountMapper.selectListByQuery(queryWrapper));
    }

    @SysLog(value = "我是account接口t8测试切面日志")
    @GetMapping("/account/t8")
    public ResultBody t8() {
        // https://mybatis-flex.com/zh/base/querywrapper.html#where-%E5%8A%A8%E6%80%81%E6%9D%A1%E4%BB%B6-2
        // where 动态条件 2
        // 构造 QueryWrapper
        boolean flag = true;
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select().from(ACCOUNT)
                .where(ACCOUNT.ID.ge(2).when(flag)) // when....
                .and(ACCOUNT.USER_NAME.like("haha"));
        return ResultBody.success(accountMapper.selectListByQuery(queryWrapper));
    }

    @SysLog(value = "我是account接口t9测试切面日志")
    @GetMapping("/account/t9")
    public ResultBody t9() {
        // 构造 QueryWrapper
        //【SELECT "id", "user_name", "age", "birthday" FROM "tb_account" WHERE "id" >=  100  AND ("age" =  1  OR "age" =  2 ) OR ("age" IN (18,19,20) AND "user_name" LIKE  '%haha%' )】
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .from(ACCOUNT)
                .where(ACCOUNT.ID.ge(100))
                .and(ACCOUNT.AGE.eq(1).or(ACCOUNT.AGE.eq(2)))
                .or(ACCOUNT.AGE.in(18, 19, 20).and(ACCOUNT.USER_NAME.like("haha")));
        return ResultBody.success(accountMapper.selectListByQuery(queryWrapper));
    }

    @SysLog(value = "我是account接口t10测试切面日志")
    @GetMapping("/account/t10")
    public ResultBody t10() {
        // 构造 QueryWrapper | group by
        //【SELECT "id", MAX("age") AS age FROM "tb_account" GROUP BY "id"】
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select(ACCOUNT.ID, max(ACCOUNT.AGE).as("age"))
                .from(ACCOUNT)
                .groupBy(ACCOUNT.ID);
        return ResultBody.success(accountMapper.selectListByQuery(queryWrapper));
    }

    @SysLog(value = "我是account接口t11测试切面日志")
    @GetMapping("/account/t11")
    public ResultBody t11() {
        // 构造 QueryWrapper | having
        //【SELECT "id", "user_name", "age", "birthday" FROM "tb_account" GROUP BY "id", "user_name", "age", "birthday" HAVING "age" BETWEEN  50 AND 100 】
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .from(ACCOUNT)
                .groupBy(ACCOUNT.ALL_COLUMNS)
                .having(ACCOUNT.AGE.between(1, 100));
        return ResultBody.success(accountMapper.selectListByQuery(queryWrapper));
    }

    @SysLog(value = "我是account接口t12测试切面日志")
    @GetMapping("/account/t12")
    public ResultBody t12() {
        // 构造 QueryWrapper | orderBy
        //【SELECT "id", "user_name", "age", "birthday" FROM "tb_account" ORDER BY "age" ASC, "user_name" DESC NULLS LAST】
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .from(ACCOUNT)
                .orderBy(ACCOUNT.AGE.asc(), ACCOUNT.USER_NAME.desc().nullsLast());
        return ResultBody.success(accountMapper.selectListByQuery(queryWrapper));
    }

    @SysLog(value = "我是account接口t13测试切面日志")
    @GetMapping("/account/t13")
    public ResultBody t13() {
        // 构造 QueryWrapper | limit... offset
        // 在 "limit... offset" 的示例中，Mybatis-Flex 能够自动识别当前数据库
        // PostgreSQL 中的 limit 子句用于限制 SELECT 语句中查询的数据的数量
        //【SELECT "id", "user_name", "age", "birthday" FROM "tb_account" ORDER BY "id" DESC LIMIT 3 OFFSET 2】
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select()
                .from(ACCOUNT)
                .orderBy(ACCOUNT.ID.desc())
                .limit(3) // 查询三条数据数量
                .offset(2); // 从第三位开始提取 3 个记录
        return ResultBody.success(accountMapper.selectListByQuery(queryWrapper));
    }

    @SysLog(value = "我是account接口t14测试切面日志")
    @GetMapping("/account/t14")
    public ResultBody t14() {
        // 构造 QueryWrapper | 注意事项
        //【https://mybatis-flex.com/zh/base/querywrapper.html#特别注意事项】
        // 在 QueryWrapper 的条件构建中，如果传入 null 值，则自动忽略该条件，这有许多的好处，不需要额外的通过 when() 方法判断。但是也带来一些额外的知识记忆点， 因此，正对这一点需要特别注意一下。
        // 在以上的 query1 和 query2 中，它们构建出来的 SQL 条件是完全一致的，因为 Mybatis-Flex 会自动忽略 null 值的条件。
        //【SELECT "id", "user_name", "age", "birthday" FROM "tb_account" WHERE "age" >=  18 】
        String userName = null;
        Integer id = null;
        QueryWrapper query1 = QueryWrapper.create()
                .where(ACCOUNT.AGE.ge(18))
                .and(ACCOUNT.USER_NAME.like(userName))
                .and(ACCOUNT.ID.ge(id));

        QueryWrapper query2 = QueryWrapper.create()
                .where(ACCOUNT.AGE.ge(18));
        accountMapper.selectListByQuery(query1);
        return ResultBody.success(accountMapper.selectListByQuery(query2));
    }

    @SysLog(value = "我是account接口t15测试切面日志")
    @GetMapping("/account/t15")
    public ResultBody t15() {
        // 构造 QueryWrapper | orderBy 正确使用
        //【SELECT tb_account.user_name, SUM(tb_account.age) FROM tb_account GROUP BY tb_account.user_name】
        // 下面拼接出来的sql【SELECT "user_name", SUM("age") AS age FROM "tb_account" GROUP BY "user_name"】
        QueryWrapper queryWrapper = QueryWrapper.create()
                .select(ACCOUNT.USER_NAME, sum(ACCOUNT.AGE).as("age"))
                .from(ACCOUNT)
                .groupBy(ACCOUNT.USER_NAME);
        return ResultBody.success(accountMapper.selectListByQuery(queryWrapper));
    }

    // todo
    // go on
}

