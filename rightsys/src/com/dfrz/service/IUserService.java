package com.dfrz.service;

import java.util.List;

import com.dfrz.bean.TUser;

public interface IUserService {
	/**
	 * 查询条件
	 * @param parm
	 * @return
	 */
	public List<TUser> getAllUser(TUser parm);
	public boolean checkuser(String name,String pass);
}
