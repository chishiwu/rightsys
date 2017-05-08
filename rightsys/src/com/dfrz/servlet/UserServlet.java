package com.dfrz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.dfrz.bean.TUser;
import com.dfrz.service.IUserService;
import com.dfrz.service.UserService;
import com.google.gson.Gson;

public class UserServlet extends HttpServlet {
	private IUserService userService;
	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
		super();
		userService=new UserService();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		//获取查询条件
		String login_name= request.getParameter("login_name");
		String real_name= request.getParameter("real_name");
		TUser parm=new TUser(0, login_name, null, real_name, null);
		//调用业务，取数据
		List<TUser> ulist=userService.getAllUser(parm);
		//列表转成JSON   GSON (对象 和JSON)
		Gson gson=new Gson();
		String json=gson.toJson(ulist);
		System.out.println(json);
		out.print(json);
		

		
		//放入request域
		//request.setAttribute("ulist", ulist);
		//request.getRequestDispatcher("userList.jsp");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
