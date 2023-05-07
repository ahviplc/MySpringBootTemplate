package com.lc.myService;
;
import com.lc.mapper.AccountMapper;
import com.lc.myEntity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
public class AccountService {


	@Resource
	AccountMapper accountMapper;


	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void update2( Long id) {
		Account account = new Account();
		account.setId(id);
		account.setUserName("haha" + String.valueOf(id));
		accountMapper.update(account);
	}
}