package com.gzxant.controller.web;

import com.gzxant.entity.portals.about.me.PortalsAboutMe;
import com.gzxant.entity.portals.article.PortalsArticle;
import com.gzxant.entity.portals.column.PortalsColumn;
import com.gzxant.entity.portals.company.information.PortalsCompanyInformation;
import com.gzxant.entity.portals.message.PortalsMessage;
import com.gzxant.service.portals.about.me.PortalsAboutMeService;
import com.gzxant.service.portals.article.PortalsArticleService;
import com.gzxant.service.portals.column.PortalsColumnService;
import com.gzxant.service.portals.company.information.PortalsCompanyInformationService;
import com.gzxant.service.portals.message.PortalsMessageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/portals")
public class PortalsWebController {

    /**
     * 公司信息展示
     */
     @Autowired
     private PortalsCompanyInformationService portalsCompanyInformationService;


    /**
     * 公司信息栏目
     */
     @Autowired
     private PortalsColumnService portalsColumnService;

    /**
     * 公司文章
     */
    @Autowired
    private PortalsArticleService portalsArticleService;



    /**
     * 公司联系方式
     */
    @Autowired
    private PortalsMessageService portalsMessageService;

    /**
     * 关于我们的信息
     */
    @Autowired
    private PortalsAboutMeService portalsAboutMeService;


    @ApiOperation(value = "进入公司官网展示公司信息", notes = "进入公司官网展示公司信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String list(Model model ) {
        //查询公司所有的信息
        PortalsCompanyInformation portalsCompanyInformation = portalsCompanyInformationService.selectAllPortals();

        //查询栏目
        PortalsColumn portalsColumn = portalsColumnService.selectAllColumns();

        //查询文章
        PortalsArticle portalsArticle = portalsArticleService.selectAllArticle();


        //公司的联系方式
        PortalsMessage portalsMessage =  portalsMessageService.selectAllMessage();

        //关于我们的信息
        PortalsAboutMe portalsAboutMe = portalsAboutMeService.selectAllAboutMe();



        //公司信息
        model.addAttribute("portalsCompanyInformation",portalsCompanyInformation);
       //公司栏目
        model.addAttribute("portalsColumn",portalsColumn);
        //公司文章
        model.addAttribute("portalsArticle",portalsArticle);
        //公司的联系方式
        model.addAttribute("portalsMessage",portalsMessage);
        //关于我们的信息
        model.addAttribute("portalsAboutMe",portalsAboutMe);
        return "/portals/index";
    }



}
