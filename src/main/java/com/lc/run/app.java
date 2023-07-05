package com.lc.run;

import com.mybatisflex.codegen.Generator;
import com.mybatisflex.codegen.config.ColumnConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * mybatis-flex 代码生成器
 * <p>
 * https://mybatis-flex.com/zh/others/codegen.html
 */
public class app {
	public static void main(String[] args) {
		//配置数据源
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl("jdbc:postgresql://192.168.192.193:5432/postgres");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres");

		//创建配置内容
		GlobalConfig globalConfig = new GlobalConfig();

		// 设置作者
		globalConfig.setAuthor("LC");

		//设置只生成哪些表 可多写【("aaa","bbb")】
//		globalConfig.setGenerateTable("flmeter_info");
		globalConfig.setGenerateTable("tb_account");

		//设置 entity 的包名
		globalConfig.setEntityPackage("com.lc.myEntity");

		//设置表前缀
		//globalConfig.setTablePrefix("tb_");
		globalConfig.setTablePrefix(null);

		globalConfig.setTableDefGenerateEnable(false);

		//设置 entity 是否使用 Lombok
		globalConfig.setEntityWithLombok(true);


		//是否生成 mapper 类，默认为 false
		//【注意：由于 MyBatis-Flex 的 APT 功能会自动帮我们生成了 Mapper 的 Java 类，如果我们在代码生成器中选择生成 Mapper，
		// 则建议把 APT 的 Mapper 生成功能给关闭掉，否则系统中会存在两份一样功能的 Mapper。】
		globalConfig.setMapperGenerateEnable(true);
		globalConfig.setMapperClassPrefix("");

		//设置 mapper 类的包名
		globalConfig.setMapperPackage("com.lc.mapper");

		//可以单独配置某个列
//        ColumnConfig columnConfig = new ColumnConfig();
//        columnConfig.setColumnName("tenant_id");
//        columnConfig.setLarge(true);
//        columnConfig.setVersion(true);
//        globalConfig.addColumnConfig("account", columnConfig);

		//可以单独配置某个列
		ColumnConfig columnConfig2 = new ColumnConfig();
		columnConfig2.setColumnName("tenant_id");
		columnConfig2.setLarge(true);
		columnConfig2.setVersion(true);
		globalConfig.setColumnConfig("aaa", columnConfig2);

		//通过 datasource 和 globalConfig 创建代码生成器
		Generator generator = new Generator(dataSource, globalConfig);

		//生成代码
		generator.generate();
	}
}
