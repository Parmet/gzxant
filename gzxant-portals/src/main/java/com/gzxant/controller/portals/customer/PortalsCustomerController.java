package com.gzxant.controller.portals.customer;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.portals.customer.PortalsCustomer;
import com.gzxant.service.portals.customer.IPortalsCustomerService;
import com.gzxant.util.PathUtils;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 客户管理 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
@Controller
@RequestMapping("/customer")
public class PortalsCustomerController extends BaseController {
	@Autowired
	private IPortalsCustomerService portalsCustomerService;

	@ApiOperation(value = "进入客户管理列表界面", notes = "进入客户管理列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/portals/customer/list";
	}

	@ApiOperation(value = "进入客户管理编辑界面", notes = "进入客户管理编辑界面")
	@GetMapping(value = {"/{action}/{id}", "/{action}"})
	public String detail(@PathVariable(name = "action") String action,
						 @PathVariable(name = "id", required = false) String id, Model model) {
		if (!PathUtils.checkDetailPath(action, id)) {
			model.addAttribute("msg", "未识别参数");
			return "/portals/customer/list";
		}
		PortalsCustomer portalsCustomer = null;
		if (StringUtils.isNumeric(id)) {
			portalsCustomer = portalsCustomerService.selectById(id);
		}
		model.addAttribute("portalsCustomer", portalsCustomer);
		model.addAttribute("action", action);
		return "/portals/customer/detail";
	}

	@ApiOperation(value = "获取客户管理列表数据", notes = "获取客户管理列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<PortalsCustomer> list(@RequestBody DataTable<PortalsCustomer> dt) {
		if (dt == null
				|| dt.getPageNumber() < 0
				|| dt.getPageSize() < 0) {
			dt = new DataTable<>();
		}
			return portalsCustomerService.pageSearch(dt);
	}

	@ApiOperation(value = "添加客户管理", notes = "添加客户管理")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(PortalsCustomer param) {
		//客户名字 客户logo
		if (param == null
				|| StringUtils.isBlank(param.getCustomerName())
				|| StringUtils.isBlank(param.getCustomerLogo())) {
			return ReturnDTOUtil.paramError();
		}
		portalsCustomerService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑客户管理", notes = "编辑客户管理")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(PortalsCustomer param) {
		//非空判断
		if (param == null || param.getId() == null
				|| param.getId().intValue() < 0) {
			return ReturnDTOUtil.paramError();
		}
		portalsCustomerService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除客户管理")
	@ApiOperation(value = "批量删除客户管理", notes = "批量删除客户管理")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return ReturnDTOUtil.paramError();
		}
		boolean success = portalsCustomerService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
