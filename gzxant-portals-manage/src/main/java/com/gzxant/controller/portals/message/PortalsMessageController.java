package com.gzxant.controller.portals.message;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.portals.message.PortalsMessage;
import com.gzxant.service.portals.message.IPortalsMessageService;
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
 * 联系我们 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-05-10
 */
@Controller
@RequestMapping("/message")
public class PortalsMessageController extends BaseController {
	@Autowired
	private IPortalsMessageService portalsMessageService;

	@ApiOperation(value = "进入联系我们列表界面", notes = "进入联系我们列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/portals/message/list";
	}

	@ApiOperation(value = "进入联系我们编辑界面", notes = "进入联系我们编辑界面")
	@GetMapping(value = {"/{action}/{id}", "/{action}"})
	public String detail(@PathVariable(name = "action") String action,
						 @PathVariable(name = "id", required = false) String id, Model model) {
		if (!PathUtils.checkDetailPath(action, id)) {
		model.addAttribute("action", action);
			return "/portals/message/list";
		}
		PortalsMessage portalsMessage = null;
		if (StringUtils.isNumeric(id)) {
			portalsMessage = portalsMessageService.selectById(id);
		}

		model.addAttribute("portalsMessage", portalsMessage);
		model.addAttribute("action", action);

		return "/portals/message/detail";
	}

	@ApiOperation(value = "获取联系我们列表数据", notes = "获取联系我们列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<PortalsMessage> list(@RequestBody DataTable<PortalsMessage> dt) {
		if (dt == null
				|| dt.getPageNumber() < 0
				|| dt.getPageSize() < 0) {
			dt = new DataTable<>();
		}
		return portalsMessageService.pageSearch(dt);
	}

	@ApiOperation(value = "添加联系我们", notes = "添加联系我们")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(PortalsMessage param) {
		//非空判断  标题和内容不能为空
		if (param == null
				|| StringUtils.isBlank(param.getName())
				|| StringUtils.isBlank(param.getEmail())
				|| StringUtils.isBlank(param.getPhone())) {
			return ReturnDTOUtil.paramError();
		}
		portalsMessageService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑联系我们", notes = "编辑联系我们")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(PortalsMessage param) {
		//非空判断
		if (param == null || param.getId() == null
				|| param.getId().intValue() < 0) {
			return ReturnDTOUtil.paramError();
		}
		portalsMessageService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除联系我们")
	@ApiOperation(value = "批量删除联系我们", notes = "批量删除联系我们")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return ReturnDTOUtil.paramError();
		}
		boolean success = portalsMessageService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
