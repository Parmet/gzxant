package com.gzxant.controller.web;

import com.gzxant.entity.portals.company.information.PortalsCompanyInformation;
import com.gzxant.service.portals.company.information.PortalsCompanyInformationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web/index")
public class PortalsWebController {

    /**
     * 公司信息展示
     */
    @Autowired
    private PortalsCompanyInformationService pc;

    @ApiOperation(value = "进入公司官网展示公司信息", notes = "进入公司官网展示公司信息")
    @GetMapping(value = "")
    public String list(Model model) {
        PortalsCompanyInformation portalsCompanyInformation = pc.selectById(1L);
        model.addAttribute("portalsCompanyInformation",portalsCompanyInformation);
        return "/portals/web/index";
    }


}
