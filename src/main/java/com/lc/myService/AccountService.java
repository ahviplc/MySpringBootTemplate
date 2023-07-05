package com.lc.myService;


import com.lc.myEntity.TbAccount;
import com.lc.mapper.TbAccountMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Component
public class AccountService {


	@Resource
	TbAccountMapper accountMapper;


	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void update2(Long id) {
		TbAccount account = new TbAccount();
		account.setId(id);
		account.setUserName("haha" + String.valueOf(id));
		accountMapper.update(account);
	}
}
