package com.gzxant.service.equipment.standard;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.equipment.standard.EquipmentStandardDao;
import com.gzxant.entity.equipment.standard.EquipmentStandard;
import com.gzxant.util.FileUtils;
import com.gzxant.util.StringUtils;

/**
 * <p>
 * 标准表 服务实现类
 * </p>
 *
 * @author ycxiao
 * @since 2018-05-17
 */
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EquipmentStandardService extends BaseService<EquipmentStandardDao, EquipmentStandard> implements IEquipmentStandardService {
	
	@Override
	public Map<String, Object> parse(String txtPath) {
		Map<String, Object> map = new HashMap<>();
		
		// 读取txtpath下所有txt文件
		List<File> files = FileUtils.getFiles(txtPath);
		for (int i = 0; i < files.size(); i++) {
			File file = files.get(i);
			// 保存基本信息到map
			// 读取首页的名称、编号、发布时间、实施时间
			if (i == 0 && file.getName().contains(String.valueOf(i))) {
				map.putAll(parseHome(file));
				continue;
			}
			
			// 读取第二页的原版本编号、原版本名称
			if (i == 1 && file.getName().contains(String.valueOf(i))) {
				map.putAll(parseSecond(file));
				continue;
			}
			
			// 循环读取剩余页面的鉴别试验、测定实验的设备、耗材
			map.putAll(parseItem(file));
		}
		
		// 识别耗材设备，查找父级
		// 保存鉴别试验、测定实验到map
		// 保存设备、耗材到map
		
		return null;
	}
	
	private Map<String, Object> parseHome(File file) {
		Map<String, Object> map = new HashMap<>();
		List<String> txts = FileUtils.getFileTxt(file);
		String txt = "";
		for (int i = 0; i < txts.size(); i++) {
			txt = txts.get(i);
			if (txt.trim().contains("GB")) {
				map.put("number", txt.trim());
				String firstCategory = txts.get(i + 1).trim();
				if (StringUtils.isNotBlank(firstCategory)
					&& firstCategory.endsWith("国家标准")) {
					map.put("firstCategory", firstCategory);
					map.put("secondCategory", txts.get(i + 2).trim());
					map.put("name", txts.get(i + 3).trim());
				}
			}
			
			if (txt.contains("-") && txt.contains("发布")) {
				map.put("publishDate", txt.trim().substring(0, 10));
			}
			
			if (txt.contains("-") && txt.contains("实施")) {
				map.put("implementDate", txt.trim().substring(0, 10));
			}
		}
		
		return map;
	}
	
	private Map<String, Object> parseSecond(File file) {
		Map<String, Object> map = new HashMap<>();
		List<String> txts = FileUtils.getFileTxt(file);
		String txt = "";
		for (int i = 0; i < txts.size(); i++) {
			txt = txts.get(i);
			if (txt.contains("代替") && txt.contains("GB")) {
				txt = txt.substring(txt.indexOf("GB"), txt.length());
				String oldNumber = txt.substring(0, txt.indexOf("《"));
				String oldName = txt.substring(txt.indexOf("《"), txt.length());
				map.put("oldNumber", oldNumber);
				map.put("oldName", oldName);
				return map;
			}
		}
		
		return map;
	}
	
	private Map<String, Object> parseItem(File file) {
		Map<String, Object> map = new HashMap<>();
		List<String> txts = FileUtils.getFileTxt(file);
		String txt = "";
		for (int i = 0; i < txts.size(); i++) {
			txt = txts.get(i);
			if () {
				
			}
		}
		
		return map;
	}
	
	public static void main(String[] args) {
		String txt = "本标准代替GB6782-2009《食品添加剂柠檬酸钠》";
		txt = txt.substring(txt.indexOf("GB"), txt.length());
		String oldNumber = txt.substring(0, txt.indexOf("《"));
		String oldName = txt.substring(txt.indexOf("《") + 1, txt.indexOf("》"));
		System.out.println(oldNumber);
		System.out.println(oldName);
	}
}
