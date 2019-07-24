package com.sontan.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sontan.entity.Good;
import com.sontan.entity.Goods;
//import com.sontan.entity.OrderType;
import com.sontan.entity.Shop;

public interface GoodsService {

	// 查询所有订单
	public List<Good> selectAllSale(String user_account);

	// 查询待付款订单
	public List<Good> selectUnpay(String user_account);

	// 查询待发货订单
	public List<Good> selectUnshiped(String user_account);

	// 查询待收货订单
	public List<Good> selectReceived(String user_account);

	// 查询待评价订单
	public List<Good> selectEvaluated(String user_account);

	// 立即付款
	public Integer toPay(Integer orderId);

	// 确认收货
	public Integer toReceived(Integer orderId);

	// 去评价界面
	public List<Good> selectEvaluatedById(Integer orderId, String user_account);

	// 发表评价
	public int addEvaluated(@Param("orderId") String orderId, @Param("evaluated") String evaluated);

	// 查询所有商品
	public List<Good> selectAllGood();

	// 查询商品信息
	Good queryGoodInfoByName(String good_name);

	// 查询购物车
	public List<Shop> selectShopCar();
	public List<Shop> selectShopCar2(String user_account);

	// 添加购物车商品
	public int addInCar(@Param("good_name") String good_name, @Param("good_price") String good_price,
			@Param("good_content") String good_content, @Param("good_image") String good_image,
			@Param("user_account") String user_account, @Param("number") Integer number);

	// 删除购物车商品
	public void delCarGood(@Param("good_name") String good_name);

	// 添加订单商品
	public int addInOrder(@Param("good_name") String good_name, @Param("good_price") String good_price,
			@Param("good_image") String good_image, @Param("user_account") String user_account,
			@Param("number") Integer number, @Param("good_total_price") Integer good_total_price,
			@Param("order_type_id") Integer order_type_id);

	/*------------------------hht------------------------*/
	//查询所有商品
	public List<Good> findAllGoods();
	//查询商品信息
	public Good findGoodInfoByName(String good_name);
	//修改商品信息
	 public void updateGoodsInfo(@Param("good_content") String good_content, 
			@Param("good_price")String good_price,@Param("good_name")String good_name);
	//删除购物车商品
	public void delGood(@Param("good_name")String good_name);
	//增加商品
			public int addGood(
					@Param("good_type_id") int good_type_id,
					@Param("good_name")String good_name,
					@Param("good_content") String good_content, 
					@Param("good_price")String good_price,
					@Param("good_image")String good_image);
	
	/*------------------------hht------------------------*/
	
}
