package com.gzxant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzxant.base.entity.ReturnDTO;
import com.gzxant.util.ReturnDTOUtil;

@Controller
@RequestMapping("/food/safety/test")
public class FoodSafetyTestController {

	@RequestMapping("get")
	@ResponseBody
	public ReturnDTO get() {
		System.out.println("get success!");
		return ReturnDTOUtil.success();
	}
}
