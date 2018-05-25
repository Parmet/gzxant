package com.gzxant.controller.qualification;

import com.gzxant.annotation.SLog;
import com.gzxant.base.controller.BaseController;
import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.entity.qualification.Qualification;
import com.gzxant.service.qualification.IQualificationService;
import com.gzxant.util.PathUtils;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 资格认证 前端控制器
 * </p>
 *
 * @author zt
 * @since 2018-05-18
 */
@Controller
@RequestMapping("/qualification")
public class QualificationController extends BaseController {
	@Autowired
	private IQualificationService qualificationService;

	@ApiOperation(value = "进入资格认证列表界面", notes = "进入资格认证列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/qualification/manage/list";
	}

	@ApiOperation(value = "进入资格认证编辑界面", notes = "进入资格认证编辑界面")
	@GetMapping(value = {"/{action}/{id}", "/{action}"})
	public String detail(@PathVariable(name = "action") String action,
						 @PathVariable(name = "id", required = false) String id, Model model) {
		if (!PathUtils.checkDetailPath(action, id)) {
			model.addAttribute("msg", "未识别参数");
			return "/qualification/manage/list";
		}

		Qualification qualification = null;
		if (StringUtils.isNumeric(id)) {
			qualification = qualificationService.selectById(id);
		}
		model.addAttribute("qualification", qualification);
		model.addAttribute("action", action);
		return "/qualification/manage/detail";
	}

	@ApiOperation(value = "获取资格认证列表数据", notes = "获取资格认证列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<Qualification> list(@RequestBody DataTable<Qualification> dt) {
		if (dt == null
				|| dt.getPageNumber() < 0
				|| dt.getPageSize() < 0) {
			dt = new DataTable<>();
		}
		
		return qualificationService.pageSearch(dt);
	}

	@ApiOperation(value = "添加资格认证", notes = "添加资格认证")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(Qualification param) {
		//非空判断  姓名,身份证号,邮箱,电话不能空
		if (param == null
				|| StringUtils.isBlank(param.getName())
				|| StringUtils.isBlank(param.getCard())
				|| StringUtils.isBlank(param.getEmail())
				|| StringUtils.isBlank(param.getPhone())) {
			return ReturnDTOUtil.paramError();
		}
		qualificationService.insert(param);
		return ReturnDTOUtil.success();
	}



	//=================资格 认证  生成一个随机数,字母加数字,并保存到code中========================


	@ApiOperation(value = "授权资格认证通过", notes = "授权资格认证通过")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(Qualification param) {
		//非空判断
		if (param == null || param.getId() == null) {
			return ReturnDTOUtil.paramError();
		}
		//1 为通过  0 为不通过
		param.setState("Y");
		param.setVerifyDate(new Date());
		qualificationService.qualification(param);
		return ReturnDTOUtil.success();
	}


	@ApiOperation(value = "授权资格认证不通过", notes = "授权资格认证不通过")
	@PostMapping(value = "/not")
	@ResponseBody
	public ReturnDTO not(Qualification param) {
		//非空判断
		if (param == null || param.getId() == null) {
			return ReturnDTOUtil.paramError();
		}
		//1 为通过  0 为不通过
		param.setState("N");
		param.setVerifyDate(new Date());
		qualificationService.updateById(param);
		return ReturnDTOUtil.success();
	}

	@SLog("批量删除资格认证")
	@ApiOperation(value = "批量删除资格认证", notes = "批量删除资格认证")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return ReturnDTOUtil.paramError();
		}
		List<Qualification> datas = qualificationService.selectBatchIds(ids);
		for (Qualification data : datas) {
			data.setDelFlag("N");
		}
		
		if (qualificationService.updateAllColumnBatchById(datas)) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
