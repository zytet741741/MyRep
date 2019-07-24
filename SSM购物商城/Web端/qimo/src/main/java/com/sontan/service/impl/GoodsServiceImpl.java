package com.sontan.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sontan.entity.Good;
import com.sontan.entity.Goods;
import com.sontan.entity.Shop;
//import com.sontan.entity.OrderType;
import com.sontan.mapper.GoodsMapper;
import com.sontan.service.GoodsService;


@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	//查询所有订单
	@Override
	public List<Good> selectAllSale(String user_account) {
		// TODO Auto-generated method stub
		return goodsMapper.selectAllSale(user_account);
	}

	//查询待付款订单
	@Override
	public List<Good> selectUnpay(String user_account) {
		// TODO Auto-generated method stub
		return goodsMapper.selectUnpay(user_account);
	}
	
	//查询待发货
	@Override
	public List<Good> selectUnshiped(String user_account) {
		// TODO Auto-generated method stub
		return goodsMapper.selectUnshiped(user_account);
		}

	//查询待收货
	@Override
	public List<Good> selectReceived(String user_account) {
		// TODO Auto-generated method stub
		return goodsMapper.selectReceived(user_account);
		}
		
	//查询待评价
	@Override
	public List<Good> selectEvaluated(String user_account) {
		// TODO Auto-generated method stub
		return goodsMapper.selectEvaluated(user_account);
		}
	
	

	
	//立即付款
	@Override
	public Integer toPay(Integer orderId) {
		// TODO Auto-generated method stub
		return goodsMapper.toPay(orderId);
	}

	//确认收货
	@Override
	public Integer toReceived(Integer orderId) {
		// TODO Auto-generated method stub
		return goodsMapper.toReceived(orderId);
	}

	//去评价界面
	@Override
	public List<Good> selectEvaluatedById(Integer orderId, String user_account) {
		// TODO Auto-generated method stub
		return goodsMapper.selectEvaluatedById(orderId, user_account);
	}

	//发表评价
	@Override
	public int addEvaluated(String orderId, String evaluated) {
		// TODO Auto-generated method stub
		return goodsMapper.addEvaluated(orderId,evaluated);
	}
	
	
	/* zyt */
	// 查询所有商品
	@Override
	public List<Good> selectAllGood() {
		return goodsMapper.selectAllGood();

	}
	
	// 查询商品信息
		public Good queryGoodInfoByName(String good_name) {
			return goodsMapper.queryGoodInfoByName(good_name);
		}

		// 查询购物车
		@Override
		public List<Shop> selectShopCar() {
			return goodsMapper.selectShopCar();
		}
		@Override
		public List<Shop> selectShopCar2(String user_account) {
			// TODO Auto-generated method stub
			return goodsMapper.selectShopCar2(user_account);
		}

		// 添加购物车商品
		public int addInCar(String good_name,String good_price,String good_content,String good_image,String user_account,Integer number) {
			return goodsMapper.addInCar(good_name, good_price, good_content, good_image, user_account, number);
		}
		
		@Override
		public void delCarGood(String good_name) {
			// TODO Auto-generated method stub
			goodsMapper.delCarGood(good_name);
		}
		
		//添加订单商品
		public int addInOrder(String good_name,String good_price,String good_image,String user_account,Integer number,Integer good_total_price,Integer order_type_id) {
			return goodsMapper.addInOrder(good_name, good_price, good_image, user_account, number, good_total_price, order_type_id);
		}
		/* zyt */
	
		/*------------------------hht------------------------*/
		//查询所有商品
		@Override
		public List<Good> findAllGoods() {
			// TODO Auto-generated method stub
			return goodsMapper.findAllGoods();
		}
		//通过名字查找商品
		@Override
		public Good findGoodInfoByName(String good_name) {
			// TODO Auto-generated method stub
			return goodsMapper.findGoodInfoByName(good_name);
		}
		//删除商品
		@Override
		public void delGood(String good_name) {
			// TODO Auto-generated method stub
			goodsMapper.delGood(good_name);
		}
		//修改商品信息
		@Override
		public void updateGoodsInfo(String good_content, String good_price, String good_name) {
			// TODO Auto-generated method stub
			goodsMapper.updateGoodsInfo(good_content, good_price, good_name);
		}

		//增加商品
		@Override
		public int addGood(int good_type_id, String good_name, String good_content, String good_price, String good_image) {
			// TODO Auto-generated method stub
			return goodsMapper.addGood(good_type_id, good_name, good_content, good_price, good_image);
		}

		

		/*------------------------hht------------------------*/
		

}
