package com.gzxant.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gzxant.constant.Setting;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/portals")
public class PortalsWebController {

    /**
     * 公司信息展示
     */
//    @Autowired
//    private PortalsCompanyInformationService pc;

    @ApiOperation(value = "进入公司官网展示公司信息", notes = "进入公司官网展示公司信息")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list(Model model) {
//        PortalsCompanyInformation portalsCompanyInformation = pc.selectById(1L);
//        model.addAttribute("portalsCompanyInformation",portalsCompanyInformation);
    	System.out.println("====123===================================");
    	System.out.println(Setting.SCAN_MAPPER_PATH);
        return "/portals/index";
    }

}
