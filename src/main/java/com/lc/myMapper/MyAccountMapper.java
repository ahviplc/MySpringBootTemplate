package com.lc.myMapper;



import com.lc.mapper.AccountMapper;
import com.lc.myEntity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyAccountMapper extends AccountMapper {

	Account selectByName(@Param("name") String name);

	@Select("select * from tb_account where id = #{id}")
	Account selectById(@Param("id") Long id);
}
