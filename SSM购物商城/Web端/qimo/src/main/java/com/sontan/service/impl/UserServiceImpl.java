package com.sontan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sontan.entity.User;
import com.sontan.mapper.UserMapper;
import com.sontan.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserMapper userMapper;
	//	登录验证
	@Override
	public User doLoginUser(User user) {
		return userMapper.loginUser(user);
	}

	//注册
	@Override
	public int addRegister(String account, String password, String username, String sex, String phone, String address,
			int user_type_id) {
		return userMapper.addRegister(account, password, username, sex, phone, address, user_type_id);
	}

	//商家登录验证
	@Override
	public User ShangJialoginUser(User user) {
		// TODO Auto-generated method stub
		return userMapper.ShangJialoginUser(user);
	}

	//商家注册
	@Override
	public int ShangJiaAddRegister(String account, String password, String username, String sex, String phone,
			String address, int user_type_id) {
		// TODO Auto-generated method stub
		return userMapper.ShangJiaAddRegister(account, password, username, sex, phone, address, user_type_id);
	}
	
	/*------------------------------zyt------------------------------*/	
	//查询个人信息
	@Override
	public User queryUserInfoByAccount(String account) {
		// TODO Auto-generated method stub
		return userMapper.queryUserInfoByAccount(account);
	}

	
	
	//修改个人信息
	@Override
	public void updateUserInfo(String account, String password, String username, String sex, String phone,
			String address) {
		// TODO Auto-generated method stub
		userMapper.updateUserInfo(account,password,username,sex,phone,address);
	}
	
	
	/*------------------------------zyt------------------------------*/	
	
	/*------------------------------hht------------------------------*/	
	//查询商家个人信息
	@Override
	public User queryShangJiaInfoByAccount(String account) {
		// TODO Auto-generated method stub
		return userMapper.queryUserInfoByAccount(account);
	}	
	//修改商家个人信息
	@Override
	public void updateShangJiaInfo(String account, String password, String username, String sex, String phone,
			String address) {
		// TODO Auto-generated method stub
		userMapper.updateUserInfo(account,password,username,sex,phone,address);
	}
	/*------------------------------hht------------------------------*/	

}
