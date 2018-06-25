package com.gzxant.controller.equipment.member.user;

import java.util.List;

import com.gzxant.entity.SysUser;
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
import com.gzxant.service.equipment.member.user.IEquipmentMemberUserService;
import com.gzxant.entity.equipment.member.user.EquipmentMemberUser;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.base.controller.BaseController;

import io.swagger.annotations.ApiOperation;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员用户表 前端控制器
 * </p>
 *
 * @author mojinsheng
 * @since 2018-06-23
 */
@Controller
@RequestMapping("/memberuser")
public class EquipmentMemberUserController extends BaseController {
	@Autowired
	private IEquipmentMemberUserService equipmentMemberUserService;

	@ApiOperation(value = "进入会员用户表列表界面", notes = "进入会员用户表列表界面")
	@GetMapping(value = "")
	public String list(Model model) {
		return "/equipment/user/list";
	}

//	@ApiOperation(value = "进入会员用户表编辑界面", notes = "进入会员用户表编辑界面")
//	@GetMapping(value = "/detail/{action}")
//	public String detail(@PathVariable("action") String action, Model model) {
//		model.addAttribute("action", action);
//		return "/equipment/member/user/detail";
//	}
	/**
	 * 查看用户详情界面
	 *
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/{action}/{id}")
	public String detail(@PathVariable("action") String action,@PathVariable("id") Long id, Model model, HttpServletRequest request) {
		EquipmentMemberUser equipmentMemberUser = equipmentMemberUserService.selectById(id);
		model.addAttribute("action", action);
		model.addAttribute("equipmentMemberUser", equipmentMemberUser);
		return "/equipment/user/detail";
	}
	/**
	 * 进入创建用户界面
	 *
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/insert")
	public String create(Model model, HttpServletRequest request) {
		model.addAttribute("action", "insert");
		EquipmentMemberUser equipmentMemberUser = new EquipmentMemberUser();
		equipmentMemberUser.setId(0L);
		equipmentMemberUser.setLoginName("");
		equipmentMemberUser.setPassword("");
		model.addAttribute("equipmentMemberUser", equipmentMemberUser);
		return "/equipment/user/insert";
	}
	@ApiOperation(value = "获取会员用户表列表数据", notes = "获取会员用户表列表数据:使用约定的DataTable")
	@PostMapping(value = "/list")
	@ResponseBody
	public DataTable<EquipmentMemberUser> list(@RequestBody DataTable<EquipmentMemberUser> dt) {
		return equipmentMemberUserService.pageSearch(dt);
	}
	@ApiOperation(value = "添加会员用户表", notes = "添加会员用户表")
	@PostMapping(value = "/insert")
	@ResponseBody
	public ReturnDTO create(EquipmentMemberUser param) {
		equipmentMemberUserService.insert(param);
		return ReturnDTOUtil.success();
	}

	@ApiOperation(value = "编辑会员用户表", notes = "编辑会员用户表")
	@PostMapping(value = "/update")
	@ResponseBody
	public ReturnDTO update(EquipmentMemberUser param) {
		if (param == null) {
			return ReturnDTOUtil.paramError();
		}
		boolean op=equipmentMemberUserService.updateById(param);
		return ReturnDTOUtil.success();
	}
	/**
	 * 检查用户名是否存在
	 *
	 * @param loginName
	 * @return
	 */
	@GetMapping(value = "check/{id}")
	@ResponseBody
	public Boolean check(@PathVariable("id") Long id, @RequestParam("loginName") String loginName) {
		return equipmentMemberUserService.checkLoginName(loginName, id);
	}
	@SLog("批量删除会员用户表")
	@ApiOperation(value = "批量删除会员用户表", notes = "批量删除会员用户表")
	@PostMapping(value = "/delete")
	@ResponseBody
	public ReturnDTO delete(@RequestParam("ids") List<Long> ids) {
		boolean success = equipmentMemberUserService.deleteBatchIds(ids);
		if (success) {
			return ReturnDTOUtil.success();
		}
		return ReturnDTOUtil.fail();
	}
}
