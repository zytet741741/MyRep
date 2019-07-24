package com.sontan.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sontan.entity.Good;
import com.sontan.entity.Goods;
import com.sontan.entity.Shop;
/*import com.sontan.entity.OrderType;*/
import com.sontan.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	public GoodsService goodsService;

	// test
	@RequestMapping("/test")
	@ResponseBody
	private String test() {
		return "[{\"id\":\"1\",\"name\":\"AAAAA\"},\r\n" + "{\"id\":\"2\",\"name\":\"BBBBB\"},\r\n"
				+ "{\"id\":\"3\",\"name\":\"CCCCC\"},\r\n" + "{\"id\":\"4\",\"name\":\"DDDDD\"},\r\n"
				+ "{\"id\":\"5\",\"name\":\"EEEEE\"},\r\n" + "{\"id\":\"6\",\"name\":\"FFFFF\"},\r\n"
				+ "{\"id\":\"7\",\"name\":\"GGGGG\"},\r\n" + "{\"id\":\"8\",\"name\":\"HHHHH\"},\r\n"
				+ "{\"id\":\"9\",\"name\":\"IIIII\"},\r\n" + "{\"id\":\"10\",\"name\":\"JJJJJ\"},\r\n"
				+ "{\"id\":\"11\",\"name\":\"KKKKK\"},\r\n" + "{\"id\":\"12\",\"name\":\"LLLLL\"},\r\n"
				+ "{\"id\":\"13\",\"name\":\"MMMMM\"}\r\n]";
	}

	// 查询所有订单

	@RequestMapping("/allSale")
	private String allSale(String user_account, HttpServletRequest request) {
		request.setAttribute("allSale", goodsService.selectAllSale(user_account));
		List<Good> list = goodsService.selectAllSale(user_account);
		for (Good good : list) {
			System.out.println(good.toString());
		}
		return "allSale";
	}

	// 安卓实现所有订单查询
	@RequestMapping("/allSaleJSON")
	@ResponseBody
	private Object allSaleJSON(String user_account, HttpServletRequest request) {
		request.setAttribute("allSale", goodsService.selectAllSale(user_account));
		List<Good> list = goodsService.selectAllSale(user_account);
		for (Good good : list) {
			System.out.println(good.toString());
		}
		return list;
	}

	// 查询待付款订单
	@RequestMapping("/Unpay")
	private String Unpay(String user_account, HttpServletRequest request) {
		request.setAttribute("Unpay", goodsService.selectUnpay(user_account));
		List<Good> list = goodsService.selectUnpay(user_account);
		for (Good good : list) {
			System.out.println(good.toString());
		}
		return "Unpay";
	}

	// 安卓实现查询待付款订单
	@RequestMapping("/UnpayJSON")
	@ResponseBody
	private Object UnpayJSON(String user_account, HttpServletRequest request) {
		request.setAttribute("Unpay", goodsService.selectUnpay(user_account));
		List<Good> list = goodsService.selectUnpay(user_account);
		for (Good good : list) {
			System.out.println(good.toString());
		}
		return list;
	}

	// 查询待发货
	@RequestMapping("/Unshiped")
	private String Unshiped(String user_account, HttpServletRequest request) {
		request.setAttribute("Unshiped", goodsService.selectUnshiped(user_account));
		List<Good> list = goodsService.selectUnshiped(user_account);
		for (Good good : list) {
			System.out.println(good.toString());
		}
		return "Unshiped";
	}

	// 安卓实现查询待发货订单
	@RequestMapping("/UnshipedJSON")
	@ResponseBody
	private Object UnshipedJSON(String user_account, HttpServletRequest request) {
		request.setAttribute("Unshiped", goodsService.selectUnshiped(user_account));
		List<Good> list = goodsService.selectUnshiped(user_account);
		for (Good good : list) {
			System.out.println(good.toString());
		}
		return list;
	}

	// 查询待收货
	@RequestMapping("/Received")
	@ResponseBody
	private String Received(String user_account, HttpServletRequest request) {
		request.setAttribute("Received", goodsService.selectReceived(user_account));
		List<Good> list = goodsService.selectReceived(user_account);
		for (Good good : list) {
			System.out.println(good.toString());
		}
		return "Received";
	}

	// 安卓实现待收货
	@RequestMapping("/ReceivedJSON")
	@ResponseBody
	private Object ReceivedJSON(String user_account, HttpServletRequest request) {
		request.setAttribute("Received", goodsService.selectReceived(user_account));
		List<Good> list = goodsService.selectReceived(user_account);
		for (Good good : list) {
			System.out.println(good.toString());
		}
		return list;
	}

	// 查询待评价
	@RequestMapping("/Evaluated")
	private Object Evaluated(String user_account, HttpServletRequest request) {
		request.setAttribute("Evaluated", goodsService.selectEvaluated(user_account));
		List<Good> list = goodsService.selectEvaluated(user_account);
		for (Good good : list) {
			System.out.println(good.toString());
		}
		return "Evaluated";
	}

	// 安卓实现查询待评价订单

	@RequestMapping("/EvaluatedJSON")
	@ResponseBody
	private Object EvaluatedJSON(String user_account, HttpServletRequest request) {
		request.setAttribute("Evaluated", goodsService.selectEvaluated(user_account));
		List<Good> list = goodsService.selectEvaluated(user_account);
		for (Good good : list) {
			System.out.println(good.toString());
		}
		return list;
	}

	// 立即付款操作
	@RequestMapping("/ToPay")
	@ResponseBody
	private Object updataToPay(Integer orderId) {
		System.out.println(orderId);
		goodsService.toPay(orderId);
		return "success";
	}

	// 确认收货
	@RequestMapping("/ToReceived")
	@ResponseBody
	private Object updataToReceived(Integer orderId) {
		System.out.println(orderId);
		goodsService.toReceived(orderId);
		return "success";
	}

	// 去立即评价界面
	@RequestMapping("/ToEvaluated")
	private String selectEvaluatedById(Integer orderId, String user_account, HttpServletRequest request) {
		request.setAttribute("AddEvaluated", goodsService.selectEvaluatedById(orderId, user_account));
		List<Good> list = goodsService.selectEvaluatedById(orderId, user_account);
		for (Good good : list) {
			System.out.println(good.toString());
		}
		return "AddEvaluated";
	}

	// 安卓实现去立即评价界面
	@RequestMapping("/ToEvaluatedJSON")
	@ResponseBody
	private Object selectEvaluatedByIdJSON(Integer orderId, String user_account, HttpServletRequest request) {
		request.setAttribute("AddEvaluated", goodsService.selectEvaluatedById(orderId, user_account));
		List<Good> list = goodsService.selectEvaluatedById(orderId, user_account);
		for (Good good : list) {
			System.out.println(good.toString());
		}
		return list;
	}

	// 立即评价
	@RequestMapping("/AddEvaluated")
	@ResponseBody
	private Object addEvaluated(String orderId, String evaluated, HttpServletRequest request) {
		int a = goodsService.addEvaluated(orderId, evaluated);
		System.out.println("orderId" + orderId);
		if (a != 0) {
			return "success";
		} else {
			return false;
		}

	}

	/* -----------------------------zyt------------------------------- */
	// 查询所有商品
	@RequestMapping("/allGood")
	private String allGoodJson(HttpServletRequest request) {
		request.setAttribute("allGood", goodsService.selectAllGood());
		List<Good> goodlist = goodsService.selectAllGood();
		for (Good good : goodlist) {
			System.out.println(good.toString());
		}
		return "GoodView";

	}

	// 安卓查询所有商品
	@RequestMapping("/allGoodJSON")
	@ResponseBody
	private Object allGoodJSON(HttpServletRequest request) {
		request.setAttribute("allGood", goodsService.selectAllGood());
		List<Good> goodlist = goodsService.selectAllGood();
		for (Good good : goodlist) {
			System.out.println(good.toString());
		}
		return goodlist;
	}

	// 查询商品信息

	@RequestMapping("/queryGoodInfo")
	private String queryGoodInfoByName(@RequestParam(value = "good_name", required = false) String good_name,
			Model model) {
		Good good = goodsService.queryGoodInfoByName(good_name);
		model.addAttribute("good", good);
		return "GoodInfo";
	}

	// 安卓查询商品信息
	@RequestMapping("/queryGoodInfoJSON")
	@ResponseBody
	private Object queryGoodInfoJSON(@RequestParam(value = "good_name", required = false) String good_name,
			Model model) {
		Good good = goodsService.queryGoodInfoByName(good_name);
		model.addAttribute("good", good);
		return good;
	}

	// 查询购物车信息
	@RequestMapping("/shopCar")
	private String ShopCar(HttpServletRequest request) {
		request.setAttribute("shopCar", goodsService.selectShopCar());
		List<Shop> shoplist = goodsService.selectShopCar();
		for (Shop Shop : shoplist) {
			System.out.println(Shop.toString());
		}
		return "ShopCar";
	}

	// 安卓查询购物车信息
	@RequestMapping("/shopCarJSON")
	@ResponseBody
	private Object shopCarJSON(String user_account,HttpServletRequest request) {
		request.setAttribute("shopCar", goodsService.selectShopCar2(user_account));
		List<Shop> shoplist = goodsService.selectShopCar2(user_account);
		for (Shop Shop : shoplist) {
			System.out.println(Shop.toString());
		}
		return shoplist;
	}


	
	// 添加购物车商品
	@RequestMapping("/addInCar")
	public String addInCar(String good_name, String good_price, String good_content, String good_image,
			String user_account, Integer number, HttpServletRequest request) {
		goodsService.addInCar(good_name, good_price, good_content, good_image, user_account, number);
		request.setAttribute("shopCar", goodsService.selectShopCar());
		List<Shop> shoplist = goodsService.selectShopCar();
		for (Shop Shop : shoplist) {
			System.out.println(Shop.toString());
		}
		return "ShopCar";
	}

	// 安卓添加购物车商品
	@RequestMapping("/addInCarJSON")
	@ResponseBody
	private Object addInCarJSON(String good_name, String good_price, String good_content, String good_image,
			String user_account, Integer number, HttpServletRequest request) {
		goodsService.addInCar(good_name, good_price, good_content, good_image, user_account, number);
		request.setAttribute("shopCar", goodsService.selectShopCar());
		List<Shop> shoplist = goodsService.selectShopCar();
		for (Shop Shop : shoplist) {
			System.out.println(Shop.toString());
		}
		return shoplist;
	}

	// 删除购物车商品
	@RequestMapping("/delCarGood")
	
	private String delCarGoodJSON(String good_name, HttpServletRequest request) {
		goodsService.delCarGood(good_name);
		request.setAttribute("shopCar", goodsService.selectShopCar());
		List<Shop> shoplist = goodsService.selectShopCar();
		for (Shop Shop : shoplist) {
			System.out.println(Shop.toString());
		}
		return "ShopCar";
	}

	// 安卓删除购物车商品
	@RequestMapping("/delCarGoodJSON")
	@ResponseBody
	public String delCarGood(String good_name, HttpServletRequest request) {
		System.out.println("删除购物车商品");
		goodsService.delCarGood(good_name);
		System.out.println("成功删除");
		return "success";
	}
	
	// 添加商品到订单
	@RequestMapping("/addInOrder")
	public Object addInOrder(String good_name, String good_price, String good_image, String user_account,
			Integer number, Integer good_total_price, Integer order_type_id, HttpServletRequest request) {
		goodsService.addInOrder(good_name, good_price, good_image, user_account, number, good_total_price,
				order_type_id);
		request.setAttribute("allSale", goodsService.selectAllSale(user_account));
		List<Good> list = goodsService.selectAllSale(user_account);
		for (Good good : list) {
			System.out.println(good.toString());
		}
		return "allSale";
	}

	// 安卓添加商品到订单
	@RequestMapping("/addInOrderJSON")
	@ResponseBody
	private Object addInOrderJSON(String good_name, String good_price, String good_image, String user_account,
			Integer number, Integer good_total_price, Integer order_type_id, HttpServletRequest request) {
		goodsService.addInOrder(good_name, good_price, good_image, user_account, number, good_total_price,
				order_type_id);
		
		return "success";
	}
			
	
//		--------------------------hht-----------------------------------------
	// 查询所有商品
		@RequestMapping("/findGood")
		private String findGoodJson(HttpServletRequest request) {
			request.setAttribute("findGood", goodsService.findAllGoods());
			List<Good> goodlist = goodsService.findAllGoods();
			for (Good good : goodlist) {
				System.out.println(good.toString());
			}
			return "FindAllGoods";

		}
		
		
		//安卓实现查询所有商品
				@RequestMapping("/findGoodJSON")
				@ResponseBody
				private Object findGoodJSON(String user_account,HttpServletRequest request) {
					request.setAttribute("findGood", goodsService.findAllGoods());
					List<Good> goodlist = goodsService.findAllGoods();
					for (Good good : goodlist) {
						System.out.println(good.toString());
					}
					return goodlist;	
				}
		

		// 通过名字查询商品信息
		@RequestMapping("/findGoodInfo")
		private String findGoodInfoByName(@RequestParam(value = "good_name", required = false) String good_name,
				Model model) {
			Good good = goodsService.findGoodInfoByName(good_name);
			model.addAttribute("good", good);
			return "GoodChange";
		}
		
		// 安卓通过名字查询商品信息
		@RequestMapping("/findGoodInfoJSON")
		@ResponseBody
		private Object findGoodInfoByNameJSON(@RequestParam(value = "good_name", required = false) String good_name,
				Model model) {
			Good good = goodsService.findGoodInfoByName(good_name);
			model.addAttribute("good", good);
			return good;
		}
		
		// 修改商品信息
			@RequestMapping("/toUpdateGoods")
			public String toUpdateGoods(@RequestParam(value = "good_name", required = false) String good_name,
					Model model) {
				Good good = goodsService.findGoodInfoByName(good_name);
				model.addAttribute("good", good);
				return "UpdateGoodsInfo";
			}
			@RequestMapping("/updateGoodsInfo")
			public String updateGoodsInfo(String good_content, String good_price, String good_name,Model model) {
				goodsService.updateGoodsInfo(good_content, good_price, good_name);
				Good good = goodsService.findGoodInfoByName(good_name);
				model.addAttribute("good", good);
				return "GoodChange";
			}
			
			// 安卓端修改商品信息
			@RequestMapping("/updateGoodsInfoJSON")
			@ResponseBody
			public String updateGoodsInfoJSON(String good_content, String good_price, String good_name,Model model) {
				goodsService.updateGoodsInfo(good_content, good_price, good_name);
				Good good = goodsService.findGoodInfoByName(good_name);
				model.addAttribute("good", good);
				return "success";
			}
			
		
		//删除商品
			@RequestMapping("/delGood")
			public String delGood(String good_name,HttpServletRequest request) {
				System.out.println("删除前");
				goodsService.delGood(good_name);
				System.out.println("删除后");
				request.setAttribute("findGood", goodsService.findAllGoods());
				List<Good> goodlist = goodsService.findAllGoods();
				for (Good good : goodlist) {
					System.out.println(good.toString());
				}
				return "FindAllGoods";

			}
			
			//安卓端删除商品
			@RequestMapping("/delGoodJSON")
			@ResponseBody
			public String delGoodJSON(String good_name,HttpServletRequest request) {
				System.out.println("删除前");
				goodsService.delGood(good_name);
				System.out.println("删除后");
			/*
			 * request.setAttribute("findGood", goodsService.findAllGoods()); List<Good>
			 * goodlist = goodsService.findAllGoods(); for (Good good : goodlist) {
			 * System.out.println(good.toString()); }
			 */
				return "success";

			}
			
			//增加商品
			@RequestMapping("/toAddGood")
			public String toAddGood() {
				return "AddGood";
			}
			@RequestMapping("/addGood")
			public String addGood(int good_type_id, String good_name, String good_content, String good_price, String good_image,
					HttpServletRequest request) {
				goodsService.addGood(good_type_id, good_name, good_content, good_price, good_image);
				request.setAttribute("findGood", goodsService.findAllGoods());
				List<Good> goodlist = goodsService.findAllGoods();
				for (Good good : goodlist) {
					System.out.println(good.toString());
				}
				return "FindAllGoods";
			}
			
			
			
			//安卓端增加商品
			@RequestMapping("/addGoodJSON")
			@ResponseBody
			public String addGoodJSON(int good_type_id, String good_name, String good_content, String good_price, String good_image,
					HttpServletRequest request) {
				goodsService.addGood(good_type_id, good_name, good_content, good_price, good_image);
			 /*	request.setAttribute("findGood", goodsService.findAllGoods());
			  *
			 * List<Good> goodlist = goodsService.findAllGoods(); for (Good good : goodlist)
			 * { System.out.println(good.toString()); }
			 */
				return "success";
			}
			
			
			
	
	
}
