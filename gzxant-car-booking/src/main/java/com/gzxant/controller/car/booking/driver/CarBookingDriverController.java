package com.gzxant.controller.car.booking.driver;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.gzxant.service.car.booking.driver.ICarBookingDriverService;
import com.gzxant.entity.car.booking.driver.CarBookingDriver;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 司机信息 前端控制器
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-10
 */
@Controller
@RequestMapping("/driver")
public class CarBookingDriverController extends BaseController {
	@Autowired
	private ICarBookingDriverService carBookingDriverService;

	@ApiOperation(value = "进入司机信息列表界面", notes = "进入司机信息列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/car/booking/driver/list";
	}

	@ApiOperation(value = "进入司机信息编辑界面", notes = "进入司机信息编辑界面")
	@GetMapping(value = {"/{action}/{id}", "/{action}"})
	public String detail(@PathVariable("action") String action, 
			@PathVariable(value = "id", required = false) String id, Model model) {
		if (StringUtils.isNumeric(id)) {
			CarBookingDriver driver = carBookingDriverService.selectById(id);
			model.addAttribute("driver", driver);
		}
		
		model.addAttribute("action", action);
		return "/car/booking/driver/detail";
	}

	@ApiOperation(value = "获取司机信息列表数据", notes = "获取司机信息列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<CarBookingDriver> list(@RequestBody DataTable<CarBookingDriver> dt) {
		return carBookingDriverService.pageSearch(dt);
	}

	@ApiOperation(value = "添加司机信息", notes = "添加司机信息")
	@PostMapping(value = "/create")
	@ResponseBody
	public ReturnDTO create(CarBookingDriver param) {
		carBookingDriverService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑司机信息", notes = "编辑司机信息")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(CarBookingDriver param) {
		carBookingDriverService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除司机信息")
	@ApiOperation(value = "批量删除司机信息", notes = "批量删除司机信息")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = carBookingDriverService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
