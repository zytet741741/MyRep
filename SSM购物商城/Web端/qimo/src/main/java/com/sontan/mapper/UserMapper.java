package com.sontan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sontan.entity.User;

public interface UserMapper {
	//用户登录验证
	public User loginUser(User user); 
	
	//注册
	public int addRegister(@Param("account") String account, 
						@Param("password")String password, 
						@Param("username")String username, 
						@Param("sex")String sex, 
						@Param("phone")String phone, 
						@Param("address")String address,
						@Param("user_type_id")int user_type_id);
	
	//商家登录验证
	public User ShangJialoginUser(User user); 
	
	//商家注册
	public int ShangJiaAddRegister(@Param("account") String account, 
			@Param("password")String password, 
			@Param("username")String username, 
			@Param("sex")String sex, 
			@Param("phone")String phone, 
			@Param("address")String address,
			@Param("user_type_id")int user_type_id);
	
	
	/*------------------------zyt------------------------*/
	//查询个人信息
	public User queryUserInfoByAccount(@Param("account")String account);
	
	//修改个人信息
	public void updateUserInfo(@Param("account") String account, 
			@Param("password")String password, 
			@Param("username")String username, 
			@Param("sex")String sex, 
			@Param("phone")String phone, 
			@Param("address")String address);
	
	
	/*------------------------zyt------------------------*/
	
	/*------------------------hht------------------------*/
	//查询商家信息
	public User queryShangJiaInfoByAccount(@Param("account")String account);
	
	//修改商家信息
	public void updateShangJiaInfo(@Param("account") String account, 
			@Param("password")String password, 
			@Param("username")String username, 
			@Param("sex")String sex, 
			@Param("phone")String phone, 
			@Param("address")String address);
	
	
	/*------------------------hht------------------------*/
	
}
