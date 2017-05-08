package com.dfrz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dfrz.bean.TUser;
import com.dfrz.util.BaseDataBase;

public class UserDao extends BaseDataBase implements IUserDao {
	Connection conn=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
	@Override
	public List<TUser> getAllUser(TUser parm) {
		List<TUser> ret_list=new ArrayList<TUser>();
		conn=super.getCon();
		String sql="select * from tb_user a where 1=1 ";
		//拼接查询条件
		if (parm!=null) {
			if (parm.getLogin_name() != null) {
				sql+=" and a.login_name ='"+parm.getLogin_name()+"'";
			}
			if (parm.getReal_name() != null) {
				sql+=" and a.real_name like'%"+parm.getReal_name()+"%'";
			}
		}
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String login_name=rs.getString("login_name");
				String login_password=rs.getString("login_password");
				String real_name=rs.getString("real_name");
				String mobile=rs.getString("mobile");
				TUser user=new TUser(id, login_name, login_password, real_name, mobile);
				ret_list.add(user);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			super.closeAll(conn, pstmt, rs);
		}
		
		return ret_list;
	}
	@Override
	public TUser checkuser(String username) {
		conn=super.getCon();
		TUser tuser=null;
		try {
			String sql="select * from tb_user where login_name="+"'"+username+"'";
			stmt=conn.createStatement();
			
			System.out.println(sql);
			rs=stmt.executeQuery(sql);
		while(rs.next()){
			tuser=new TUser();
			tuser.setId(rs.getInt("id"));
			tuser.setLogin_name(rs.getString("login_name"));
			tuser.setLogin_password(rs.getString("login_password"));
			tuser.setMobile(rs.getString("mobile"));
			tuser.setReal_name(rs.getString("real_name"));
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tuser;
	}

}
