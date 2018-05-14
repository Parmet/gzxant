package com.gzxant.controller.portals.column;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.portals.column.PortalsColumn;
import com.gzxant.service.portals.column.IPortalsColumnService;
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
 * 栏目管理 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-05-12
 */
@Controller
@RequestMapping("/column")
public class PortalsColumnController extends BaseController {
	@Autowired
	private IPortalsColumnService portalsColumnService;

	@ApiOperation(value = "进入栏目管理列表界面", notes = "进入栏目管理列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/portals/column/list";
	}

	@ApiOperation(value = "进入栏目管理编辑界面", notes = "进入栏目管理编辑界面")
	@GetMapping(value = {"/{action}/{id}", "/{action}"})
	public String detail(@PathVariable(name = "action") String action,
						 @PathVariable(name = "id", required = false) String id, Model model) {
		if (!PathUtils.checkDetailPath(action, id)) {
			model.addAttribute("msg", "未识别参数");
			return "/portals/column/list";
		}
		PortalsColumn portalsArticle = null;
		if (StringUtils.isNumeric(id)) {
			portalsArticle = portalsColumnService.selectById(id);
		}
		model.addAttribute("portalsArticle", portalsArticle);
		model.addAttribute("action", action);
		return "/portals/column/detail";
	}

	@ApiOperation(value = "获取栏目管理列表数据", notes = "获取栏目管理列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<PortalsColumn> list(@RequestBody DataTable<PortalsColumn> dt) {
		if (dt == null
				|| dt.getPageNumber() < 0
				|| dt.getPageSize() < 0) {
			dt = new DataTable<>();
		}
		return portalsColumnService.pageSearch(dt);
	}

	@ApiOperation(value = "添加栏目管理", notes = "添加栏目管理")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(PortalsColumn param) {
		//非空判断  栏目名栏目路径
		if (param == null
				|| StringUtils.isBlank(param.getColumnName())
				|| StringUtils.isBlank(param.getColumnPath())) {
			return ReturnDTOUtil.paramError();
		}
		portalsColumnService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑栏目管理", notes = "编辑栏目管理")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(PortalsColumn param) {
		//非空判断
		if (param == null || param.getId() == null
				|| param.getId().intValue() < 0) {
			return ReturnDTOUtil.paramError();
		}
		portalsColumnService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除栏目管理")
	@ApiOperation(value = "批量删除栏目管理", notes = "批量删除栏目管理")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return ReturnDTOUtil.paramError();
		}
		boolean success = portalsColumnService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
