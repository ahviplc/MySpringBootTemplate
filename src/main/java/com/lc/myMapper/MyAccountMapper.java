package com.lc.myMapper;


import com.lc.mapper.TbAccountMapper;
import com.lc.myEntity.TbAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyAccountMapper extends TbAccountMapper {

	TbAccount selectByName(@Param("name") String name);

	@Select("select * from tb_account where id = #{id}")
	TbAccount selectById(@Param("id") Long id);
}
