package com.gzxant.controller;

import com.gzxant.base.controller.BaseController;
import com.gzxant.entity.portals.company.information.PortalsCompanyInformation;
import com.gzxant.service.portals.company.information.IPortalsCompanyInformationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/indeex")
public class PortalsWebController extends BaseController {

    @Autowired
    private IPortalsCompanyInformationService portalsCompanyInformationService;


    @ApiOperation(value = "进入联系我们编辑界面", notes = "进入联系我们编辑界面")
    @GetMapping(value = {"/{action}/{id}", "/{action}"})
    public String detail(@PathVariable(name = "action") String action,
                         @PathVariable(name = "id", required = false) String id, Model model) {


        PortalsCompanyInformation portals = portalsCompanyInformationService.selectById(1L);

        model.addAttribute("action", action);
        model.addAttribute("portals", portals);

        return "/portals/web/index";
    }


}
