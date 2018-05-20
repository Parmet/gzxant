package com.gzxant.controller.qualification;

import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.entity.qualification.Qualification;
import com.gzxant.service.qualification.IQualificationService;
import com.gzxant.util.ReturnDTOUtil;
import com.gzxant.util.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/code")
public class Web {

    @Autowired
    private IQualificationService qualificationService;

    @ApiOperation(value = "进入资格认证列表界面", notes = "进入资格认证列表界面")
    @GetMapping(value = "")
    public String list(Model model) {


        return "/qualification/index";
    }
    @ApiOperation(value = "进入word", notes = "进入word")
    @GetMapping(value = "/select")
    public String select(Model model) {


        return "/qualification/word";
    }
    @ApiOperation(value = "进入查询列表界面", notes = "进入查询列表界面")
    @GetMapping(value = "/select")
    public String worde(Model model) {


        return "/qualification/code";
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


    @ApiOperation(value = "授权编码查询", notes = "授权编码查询")
    @PostMapping(value = "/select/save")
    @ResponseBody
    public String save(String param) {
        //非空判断  授权编码不能为空
        if (param == null
                || StringUtils.isBlank(param)) {
            return "没有该授权编码";
        }
        qualificationService.selectByCode(param);


        return param;
    }

}
