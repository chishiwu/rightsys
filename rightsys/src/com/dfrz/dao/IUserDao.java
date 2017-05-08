package com.dfrz.dao;

import java.util.List;

import com.dfrz.bean.TUser;

public interface IUserDao {
	/**
	 * 查询条件
	 * @param parm
	 * @return
	 */
	public List<TUser> getAllUser(TUser parm);
	public TUser checkuser(String username);
}
