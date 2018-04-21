package com.gzxant.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.gzxant.dao.FsInformationDao;
import com.gzxant.entity.FsInformation;
import com.gzxant.service.IFsInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import com.gzxant.base.controller.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 文章内容 前端控制器
 * </p>
 *
 * @author xiaoyc
 * @since 2018-04-19
 */
@Controller
@RequestMapping(value = "/fs/content")
public class FsInformationController {

    @Autowired
    private IFsInformationService iFsInformationService;

    /**
     * 进入咨询页面

     */
    @RequestMapping(value = "/index")
    public String insertSysFsInfromation() {
        System.out.print("这是测试");
        return "fs/datelist";
    }
//    /**
//     * 用户插入数据
//     */
//    @GetMapping(value = "/testControllerinsert")
//    @ResponseBody
//    public void insertSysFsInfromation(){
//        try{
//            FsInformation sysFsInformation=new FsInformation();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            Date date = sdf.parse(sdf.format(new Date()));
//            sysFsInformation.setCreateDate(date);
//            sysFsInformation.setUpdateDate(date);
//            sysFsInformation.setAuthor("莫进生");
//            sysFsInformation.setContent("食品检测");
//            sysFsInformation.setDelFlag("Y");
//            sysFsInformation.setTitle("标题文字");
//            sysFsInformation.setStatus(1);
//            iFsInformationService.insert(sysFsInformation);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    /**
//     * 更新数据
//     */
//    @GetMapping("/testControllerupdate")
//    @ResponseBody
//    public void updateFsinfromation(){
//        try{
//            FsInformation sysFsInformation=new FsInformation();
//            sysFsInformation.setAuthor("莫老板");
//            sysFsInformation.setStatus(5);
//            sysFsInformation.setType("5");
//            sysFsInformation.setTitle("小蚂蚁公司");
//            sysFsInformation.setId(Long.parseLong("1"));
//            sysFsInformation.updateById();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    /**
//     * 删除数据
//     */
//    @GetMapping("/testControllerdelet")
//    @ResponseBody
//    public void deletSysFsInfromation(){
//        try{
//
//            iFsInformationService.deleteById(Long.parseLong("1"));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    @GetMapping("/testControllerselect")
//    @ResponseBody
//    public void selectSysFsInfromation(){
//        try{
//
//            FsInformation sysFsInformation1= iFsInformationService.selectById(Long.parseLong("2"));
//            System.out.println(sysFsInformation1.getAuthor()+"==================");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    @GetMapping("/testControllerselectALL")
//    @ResponseBody
//    public void selectSysFsInfromationALL(){
//        try{
//
//            List<FsInformation> sysFsInformation1= iFsInformationService.selectList(new EntityWrapper<FsInformation>().
//                            eq("id","2"));
//            System.out.println(sysFsInformation1.get(3).getAuthor()+"==================");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
