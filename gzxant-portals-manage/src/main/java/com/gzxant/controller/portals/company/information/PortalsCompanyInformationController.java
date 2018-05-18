package com.gzxant.controller.portals.company.information;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.portals.company.information.PortalsCompanyInformation;
import com.gzxant.service.portals.company.information.IPortalsCompanyInformationService;
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
 * 公司信息 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-05-10
 */
@Controller
@RequestMapping("/company/information")
public class PortalsCompanyInformationController extends BaseController {
	@Autowired
	private IPortalsCompanyInformationService portalsCompanyInformationService;

	@ApiOperation(value = "进入公司信息列表界面", notes = "进入公司信息列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/portals/company/information/list";
	}

	@ApiOperation(value = "进入公司信息详情界面", notes = "进入公司信息编辑界面")
	@GetMapping(value = {"/{action}/{id}", "/{action}"})
	public String detail(@PathVariable(name = "action") String action,
						 @PathVariable(name = "id", required = false) String id, Model model) {
		if (!PathUtils.checkDetailPath(action, id)) {
			model.addAttribute("msg", "未识别参数");
			return "/portals/company/information/list";
		}

		PortalsCompanyInformation portalsCompanyInformation = null;
		if (StringUtils.isNumeric(id)) {
			portalsCompanyInformation = portalsCompanyInformationService.selectById(id);
		}

		model.addAttribute("portalsCompanyInformation", portalsCompanyInformation);
		model.addAttribute("action", action);

		return "/portals/company/information/detail";
	}

	@ApiOperation(value = "获取公司信息列表数据", notes = "获取公司信息列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<PortalsCompanyInformation> list(@RequestBody DataTable<PortalsCompanyInformation> dt) {
		if (dt == null
				|| dt.getPageNumber() < 0
				|| dt.getPageSize() < 0) {
			dt = new DataTable<>();
		}
		return portalsCompanyInformationService.pageSearch(dt);
	}

	@ApiOperation(value = "添加公司信息", notes = "添加公司信息")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(PortalsCompanyInformation param) {

		//非空判断  公司名称和公司地理位置不为空
		if (param == null
				|| StringUtils.isBlank(param.getName())
				|| StringUtils.isBlank(param.getAddress())) {
			return ReturnDTOUtil.paramError();
		}
		portalsCompanyInformationService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑公司信息", notes = "编辑公司信息")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(PortalsCompanyInformation param) {
		//非空判断  Logo和Email不能为空
		if (param == null
				|| StringUtils.isBlank(param.getLogo())
				|| StringUtils.isBlank(param.getAddress())) {
			return ReturnDTOUtil.paramError();
		}
		portalsCompanyInformationService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除公司信息")
	@ApiOperation(value = "批量删除公司信息", notes = "批量删除公司信息")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return ReturnDTOUtil.paramError();
		}
		boolean success = portalsCompanyInformationService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
