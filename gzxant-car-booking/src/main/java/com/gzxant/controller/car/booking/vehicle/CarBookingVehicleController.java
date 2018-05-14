package com.gzxant.controller.car.booking.vehicle;

import java.util.List;

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

import com.gzxant.annotation.SLog;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.service.car.booking.vehicle.ICarBookingVehicleService;
import com.gzxant.entity.car.booking.vehicle.CarBookingVehicle;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 车辆信息 前端控制器
 * </p>
 *
 * @author mojin
 * @since 2018-05-14
 */
@Controller
@RequestMapping("/car/booking/vehicle")
public class CarBookingVehicleController extends BaseController {
	@Autowired
	private ICarBookingVehicleService carBookingVehicleService;

	@ApiOperation(value = "进入车辆信息列表界面", notes = "进入车辆信息列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/car/booking/vehicle/list";
	}

	@ApiOperation(value = "进入车辆信息编辑界面", notes = "进入车辆信息编辑界面")
	@GetMapping(value = {"/{action}/{id}", "/{action}"})
	public String detail(@PathVariable("action") String action, Model model) {
		model.addAttribute("action", action);
		return "/car/booking/vehicle/detail";
	}

	@ApiOperation(value = "获取车辆信息列表数据", notes = "获取车辆信息列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CarBookingVehicle> list(@RequestBody DataTable<CarBookingVehicle> dt) {
		return carBookingVehicleService.pageSearch(dt);
	}

	@ApiOperation(value = "添加车辆信息", notes = "添加车辆信息")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(CarBookingVehicle param) {
		carBookingVehicleService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑车辆信息", notes = "编辑车辆信息")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(CarBookingVehicle param) {
		carBookingVehicleService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除车辆信息")
	@ApiOperation(value = "批量删除车辆信息", notes = "批量删除车辆信息")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = carBookingVehicleService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
