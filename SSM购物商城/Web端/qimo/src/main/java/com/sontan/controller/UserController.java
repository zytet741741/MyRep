package com.sontan.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sontan.entity.User;
import com.sontan.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//去用户界面
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	//用户登录验证
	@RequestMapping("/login")
	public String login(User user, HttpSession session) {	
		user = userService.doLoginUser(user);
		if (user != null) {
			session.setAttribute("user", user);
			return "index";
		} else {
			return "login";
		}
	}
	
	//用户安卓实现登录
	@RequestMapping("/loginJson")
	@ResponseBody
	public Object loginJson(User user) {
		User users = userService.doLoginUser(user);
		if (users != null) {
			return users;
		} else {
			return "false";
		}
	}	
		
	//去注册界面
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "Register";
	}
	
	//用户注册
	@RequestMapping("/addRegister")
	public String addRegister(String account,String password,String username,String sex,String phone,String address,int user_type_id) {
		userService.addRegister(account, password, username, sex, phone, address, user_type_id);
		return "login";
	}
	
	//用户注册
		@RequestMapping("/addRegisterJSON")
		@ResponseBody
		public Object addRegisterJSON(String account,String password,String username,String sex,String phone,String address,int user_type_id) {
			int a = userService.addRegister(account, password, username, sex, phone, address, user_type_id);
			System.out.println(a); 
			if(a!=0) {
				return "SUCCESS";
			}else {
				return "FALSE";
			}
		}
	
	
	//去商家界面
	@RequestMapping("/toShangJia")
	public String toShangJia() {
		return "ShangJiaLogin";
		}
		
	//商家登录验证
	@RequestMapping("/ShangJialogin")
		public String ShangJialogin(User user, HttpSession session) {	
		user = userService.ShangJialoginUser(user);
			if (user != null) {
				session.setAttribute("user", user);
				return "ShangJiaindex";
			} else {
				return "ShangJiaLogin";
				}
		}
	
	
	//安卓实现商家登录
	@RequestMapping("/ShangJialoginJSON")
	@ResponseBody
	public Object ShangJialoginJSON(User user, HttpSession session) {	
	User users = userService.ShangJialoginUser(user);
		if (users != null) {
			return users;
		} else {
			return "false";
			}
	}
	
	
	//去商家注册界面
	@RequestMapping("/ShangJiaToRegister")
	public String ShangJiaToRegister() {
		return "ShangJiaRegister";
	}
	//商家注册
	@RequestMapping("/ShangJiaAddRegister")
	public String ShangJiaAddRegister(String account,String password,String username,String sex,String phone,String address,int user_type_id) {
		userService.ShangJiaAddRegister(account, password, username, sex, phone, address, user_type_id);
		return "ShangJiaLogin";
	}
	
	/*------------------------------zyt------------------------------*/
	// 查询个人信息
	@RequestMapping("/userInfo")
	private String queryUserInfoByAccount(@RequestParam(value = "account", required = false) String account,
			Model model) {
		User user = userService.queryUserInfoByAccount(account);
		model.addAttribute("user", user);
		return "UserInfo";
	}

	// 安卓查询个人信息
	@RequestMapping("/userInfoJSON")
	@ResponseBody
	private Object userInfoJSON(@RequestParam(value = "account", required = false) String account,
			Model model) {
		User user = userService.queryUserInfoByAccount(account);
		model.addAttribute("user", user);
		return user;
	}

	// 修改个人信息
	@RequestMapping("/toUpdate")
	public String toUpdate() {
		return "UpdateUserInfo";
	}

	@RequestMapping("/updateUserInfo")
	public String updateUserInfo(String account, String password, String username, String sex, String phone,
			String address, Model model) {
		userService.updateUserInfo(account, password, username, sex, phone, address);
		User user = userService.queryUserInfoByAccount(account);
		model.addAttribute("user", user);
		return "UserInfo";
	}
	
	// 安卓修改个人信息
	@RequestMapping("/updateUserInfoJSON")
	@ResponseBody
	private Object updateUserInfoJSON(String account, String password, String username, String sex, String phone,
			String address, Model model) {
		userService.updateUserInfo(account, password, username, sex, phone, address);
		User user = userService.queryUserInfoByAccount(account);
		model.addAttribute("user", user);
		return user;
	}
	/*------------------------------zyt------------------------------*/
	
	/*------------------------------hht------------------------------*/
	
	
	
	// 查询商家个人信息
	@RequestMapping("/shangJiaInfo")
	private String queryShangJiaInfoByAccount(@RequestParam(value = "account", required = false) String account,
			Model model) {
		User user = userService.queryShangJiaInfoByAccount(account);
		model.addAttribute("user", user);
		return "ShangJiaInfo";
	}
	
	
	// 安卓端查询商家个人信息
		@RequestMapping("/shangJiaInfoJSON")
		@ResponseBody
		private Object queryShangJiaInfoByAccountJSON(@RequestParam(value = "account", required = false) String account,
				Model model) {
			User user = userService.queryShangJiaInfoByAccount(account);
			model.addAttribute("user", user);
			return user;
		}
	
	
	
	// 修改商家个人信息
	@RequestMapping("/toUpdateShangJia")
	public String toUpdateShangJia() {return "UpdateShangJiaInfo";}
	@RequestMapping("/updateShangJiaInfo")
	public String updateShangJiaInfo(String account, String password, String username, String sex, String phone,
			String address,Model model) {
		userService.updateShangJiaInfo(account,password,username,sex,phone,address);
		User user = userService.queryShangJiaInfoByAccount(account);
		model.addAttribute("user", user);
		return "ShangJiaInfo";
	}
	
	// 安卓端修改商家个人信息
	@RequestMapping("/updateShangJiaInfoJSON")
	@ResponseBody
	public String updateShangJiaInfoJSON(String account, String password, String username, String sex, String phone,
			String address,Model model) {
		userService.updateShangJiaInfo(account,password,username,sex,phone,address);
		User user = userService.queryShangJiaInfoByAccount(account);
		model.addAttribute("user", user);
		return "success";
	}
	/*------------------------------hht------------------------------*/
	
}