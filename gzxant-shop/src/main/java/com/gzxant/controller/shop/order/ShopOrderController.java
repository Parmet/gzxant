package com.gzxant.controller.shop.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.shop.order.ShopOrder;
import com.gzxant.service.shop.order.IShopOrderService;
import com.gzxant.service.shop.order.goods.IShopOrderGoodsService;
import com.gzxant.service.shop.order.pay.IShopOrderPayService;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.vo.shop.order.ShopOrderVo;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 商城-订单表 前端控制器
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-21
 */
@Controller
@RequestMapping("/shop/order")
public class ShopOrderController extends BaseController {
	@Autowired
	private IShopOrderService orderService;
	@Autowired
	private IShopOrderGoodsService orderGoodsService;
	@Autowired
	private IShopOrderPayService orderPayService;

	@ApiOperation(value = "进入商城-订单表列表界面", notes = "进入商城-订单表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/shop/order/list";
	}

	@ApiOperation(value = "进入商城-订单表编辑界面", notes = "进入商城-订单表编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/shop/order/detail";
	}

	@ApiOperation(value = "获取商城-订单表列表数据", notes = "获取商城-订单表列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<ShopOrder> list(@RequestBody DataTable<ShopOrder> dt) {
		return orderService.pageSearch(dt);
	}

	@ApiOperation(value = "添加商城-订单表", notes = "添加商城-订单表")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(ShopOrderVo param) {
		orderService.insert(param);
		orderGoodsService.insert(param);
		orderPayService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑商城-订单表", notes = "编辑商城-订单表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(ShopOrder param) {
		orderService.updateById(param);
		return ReturnDTOUtil.success();
	}

}
