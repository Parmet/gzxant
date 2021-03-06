package com.gzxant.controller;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.base.vo.DataTable;
import com.gzxant.enums.HttpCodeEnum;
import com.gzxant.exception.SlifeException;
import com.gzxant.service.ProcessService;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.vo.ProcessVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author: felix.
 * @createTime: 2017/12/11.
 */
@Controller
@RequestMapping("/process")
@Api(description = "流程实例的前端控制器")
public class ProcessController {

	@Autowired
	ProcessService processService;

	@ApiOperation(value = "进入流程管理页面", notes = "进入流程管理页面")
	@GetMapping(value = "")
	public String list(org.springframework.ui.Model model, HttpServletRequest request) {
		model.addAttribute("url", request.getContextPath()+"/process/");
		return "process/list";
	}

    @ApiOperation(value = "获取流程列表数据", notes = "获取流程列表数据:使用约定的DataTable")
    @PostMapping(value = "/list")
    @ResponseBody
    public DataTable<ProcessVO> list(@RequestBody DataTable dt) {
        if (null == dt) {
            return null;
        }
        return processService.getProcessByPage(dt);
    }

    @ApiOperation(value = "读取xml/image资源", notes = "resType为xml或者image")
    @GetMapping(value = "/resource")
    public void resourceRead(String procDefId, String proInsId, String resType, HttpServletResponse response) {
        if ("xml".equals(resType)) {
            response.setContentType("application/xml");
        } else {
            response.setContentType("image/png");
        }

        try {
            InputStream resourceAsStream = processService.resourceRead(procDefId, proInsId, resType);
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
                response.getOutputStream().write(b, 0, len);
            }
        } catch (Exception e) {
            throw new SlifeException(HttpCodeEnum.FAIL);
        }
    }

    @ApiOperation(value = "激活/挂起", notes = "active为激活，suspend为挂起")
    @PostMapping("/status")
    @ResponseBody
    public ReturnDTO updateState(@RequestParam String status, @RequestParam String procDefId) {
        processService.updateStatus(status, procDefId);
        return ReturnDTOUtil.success();
    }
}
