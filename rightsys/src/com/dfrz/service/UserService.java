package com.dfrz.service;

import java.util.List;

import com.dfrz.bean.TUser;
import com.dfrz.dao.IUserDao;
import com.dfrz.dao.UserDao;

public class UserService implements IUserService {
	private IUserDao userDao;
	public UserService(){
		userDao=new UserDao();
	}
	@Override
	public List<TUser> getAllUser(TUser parm) {
		// TODO Auto-generated method stub
		return userDao.getAllUser(parm);
	}
	@Override
	public boolean checkuser(String username, String password) {
		TUser tuser=userDao.checkuser(username);
		if(password.equals(tuser.getLogin_password())){
			return true;
		}
		return false;
	}
	
}
