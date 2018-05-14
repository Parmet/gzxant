package com.gzxant.controller.portals.about.me;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.portals.about.me.PortalsAboutMe;
import com.gzxant.service.portals.about.me.IPortalsAboutMeService;
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
 * 关于我们 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
@Controller
@RequestMapping("/about/me")
public class PortalsAboutMeController extends BaseController {
	@Autowired
	private IPortalsAboutMeService portalsAboutMeService;

	@ApiOperation(value = "进入关于我们列表界面", notes = "进入关于我们列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/portals/about/me/list";
	}

	@ApiOperation(value = "进入关于我们编辑界面", notes = "进入关于我们编辑界面")
	@GetMapping(value = {"/{action}/{id}", "/{action}"})
	public String detail(@PathVariable(name = "action") String action,
						 @PathVariable(name = "id", required = false) String id, Model model) {
		if (!PathUtils.checkDetailPath(action, id)) {
			model.addAttribute("msg", "未识别参数");
			return "/portals/about/me/list";
		}
		PortalsAboutMe portalsAboutMe = null;
		if (StringUtils.isNumeric(id)) {
			portalsAboutMe = portalsAboutMeService.selectById(id);
		}
		model.addAttribute("portalsAboutMe", portalsAboutMe);
		model.addAttribute("action", action);
		return "/portals/about/me/detail";
	}

	@ApiOperation(value = "获取关于我们列表数据", notes = "获取关于我们列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<PortalsAboutMe> list(@RequestBody DataTable<PortalsAboutMe> dt) {
		if (dt == null
				|| dt.getPageNumber() < 0
				|| dt.getPageSize() < 0) {
			dt = new DataTable<>();
		}
		return portalsAboutMeService.pageSearch(dt);
	}

	@ApiOperation(value = "添加关于我们", notes = "添加关于我们")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(PortalsAboutMe param) {
		//非空判断  标题内容
		if (param == null
				|| StringUtils.isBlank(param.getAboutMeTitle())
				|| StringUtils.isBlank(param.getAboutMeContent())) {
			return ReturnDTOUtil.paramError();
		}
		portalsAboutMeService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑关于我们", notes = "编辑关于我们")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(PortalsAboutMe param) {
		//非空判断
		if (param == null || param.getId() == null
				|| param.getId().intValue() < 0) {
			return ReturnDTOUtil.paramError();
		}
		portalsAboutMeService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除关于我们")
	@ApiOperation(value = "批量删除关于我们", notes = "批量删除关于我们")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return ReturnDTOUtil.paramError();
		}
		boolean success = portalsAboutMeService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
