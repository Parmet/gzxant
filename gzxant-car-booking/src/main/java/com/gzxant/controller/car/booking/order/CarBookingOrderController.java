package com.gzxant.controller.car.booking.order;

import java.util.List;
import java.util.Map;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;
import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.constant.car.booking.Global;
import com.gzxant.entity.SysDict;
import com.gzxant.entity.car.booking.order.CarBookingOrder;
import com.gzxant.service.ISysDictService;
import com.gzxant.service.car.booking.order.ICarBookingOrderService;
import com.gzxant.util.ReturnDTOUtil;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 车辆预定订单 前端控制器
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-10
 */
@Controller
@RequestMapping("/order")
public class CarBookingOrderController extends BaseController {
	@Autowired
	private ICarBookingOrderService carBookingOrderService;
	@Autowired
	private ISysDictService dictService;

	@ApiOperation(value = "进入车辆预定订单列表界面", notes = "进入车辆预定订单列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		List<SysDict> orderStates = dictService.getSub(Global.KEY_ORDER_STATE);
		model.addAttribute("orderStates", orderStates);
		return "/car/booking/order/list";
	}

	@ApiOperation(value = "进入车辆预定订单编辑界面", notes = "进入车辆预定订单编辑界面")
	@GetMapping(value = "/detail/{action}")
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/car/booking/order/detail";
	}

	@ApiOperation(value = "获取车辆预定订单列表数据", notes = "获取车辆预定订单列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CarBookingOrder> list(@RequestBody DataTable<CarBookingOrder> dt) {
		dt = carBookingOrderService.pageSearch(dt);
		dt = dealData(dt);
		return dt;
	}

	@ApiOperation(value = "添加车辆预定订单", notes = "添加车辆预定订单")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(CarBookingOrder param) {
		carBookingOrderService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑车辆预定订单", notes = "编辑车辆预定订单")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(CarBookingOrder param) {
		carBookingOrderService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除车辆预定订单")
	@ApiOperation(value = "批量删除车辆预定订单", notes = "批量删除车辆预定订单")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = carBookingOrderService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
	
	/**
	 * 处理返回数据
	 * 
	 * @param dt
	 * @return
	 */
	private DataTable<CarBookingOrder> dealData(DataTable<CarBookingOrder> dt) {
		List<CarBookingOrder> datas = dt.getRows();
		Map<String, String> map = getDictMap();
		for (CarBookingOrder data : datas) {
			data.setOrderType(map.get(data.getOrderType()));
			data.setProductType(map.get(data.getProductType()));
			data.setCarType(map.get(data.getCarType()));
			data.setOrderState(map.get(data.getOrderState()));
			data.setPayState(map.get(data.getPayState()));
		}
		
		return dt;
	}

	/**
	 * 获取订单需要的字典
	 * 
	 * @param dt
	 * @return
	 */
	private Map<String, String> getDictMap() {
		Map<String, String> map = Maps.newHashMap();
		List<SysDict> all = Lists.newArrayList();
		all.addAll(dictService.getSub(Global.KEY_ORDER_TYPE));
		all.addAll(dictService.getSub(Global.KEY_PRODUCT_TYPE));
		all.addAll(dictService.getSub(Global.KEY_CAR_TYPE));
		all.addAll(dictService.getSub(Global.KEY_ORDER_STATE));
		all.addAll(dictService.getSub(Global.KEY_PAY_STATE));
		for (SysDict dict : all) {
			map.put(dict.getJkey(), dict.getJvalue());
		}
		
		return map;
	}
}
