package com.dfrz.test;

import java.util.ArrayList;
import java.util.List;

import com.dfrz.bean.TUser;
import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) {
		
		List<TUser> list=new ArrayList<TUser>();
		list.add(new TUser(1, "zhangsan", "1111", "张三", "158799003334"));
		list.add(new TUser(2, "lisi", "1111", "李四", "158799003334"));
		list.add(new TUser(3, "wangwu", "1111", "王五", "158799003334"));
		list.add(new TUser(4, "zhaoliu", "1111", "赵六", "158799003334"));
		Gson gson=new Gson();
		String json=gson.toJson(list);
		System.out.println(json);

	}

}
