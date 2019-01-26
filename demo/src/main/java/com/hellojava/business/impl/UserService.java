package com.hellojava.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hellojava.business.IUserService;
import com.hellojava.dao.IUserDao;
import com.hellojava.entity.UserView;
@Service("userService")
public class UserService implements IUserService {
	@Autowired
	private IUserDao userDao;
	public boolean query(UserView userView) {
		boolean bool=false;
		UserView user=userDao.query(userView);
		if(user!=null) {
			bool=true;
		}
		return bool;
	}

}
