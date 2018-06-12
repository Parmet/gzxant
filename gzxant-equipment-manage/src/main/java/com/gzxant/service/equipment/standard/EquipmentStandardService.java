package com.gzxant.service.equipment.standard;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.Condition;
import com.gzxant.base.service.impl.BaseService;
import com.gzxant.dao.equipment.standard.EquipmentStandardDao;
import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;
import com.gzxant.entity.equipment.standard.EquipmentStandard;
import com.gzxant.entity.equipment.standard.item.EquipmentStandardItem;
import com.gzxant.entity.equipment.standard.item.product.EquipmentStandardItemProduct;
import com.gzxant.service.equipment.shop.product.IEquipmentShopProductService;
import com.gzxant.service.equipment.standard.item.IEquipmentStandardItemService;
import com.gzxant.service.equipment.standard.item.product.IEquipmentStandardItemProductService;
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
	
	@Autowired
	private IEquipmentStandardItemService itemService;
	@Autowired
	private IEquipmentShopProductService productService;
	@Autowired
	private IEquipmentStandardItemProductService itemProductService;
	
	@Override
	public Map<String, Object> parse(String txtPath) {
		// 读取txtpath下所有txt文件
		List<File> files = FileUtils.getFiles(txtPath);
		
		EquipmentStandard info = new EquipmentStandard();
		List<String> txts = new ArrayList<>();
		Map<String, ArrayList<String>> items = new HashMap<>();
		for (int i = 0; i < files.size(); i++) {
			File file = files.get(i);
			// 读取首页的名称、编号、发布时间、实施时间
			if (i == 0 && file.getName().contains(String.valueOf(i))) {
				info = parseInfo(file, files.get(i + 1));
				continue;
			}
			
			List<String> curTxts = FileUtils.readFileTxt(file);
			// 删除第一行的编号
			if (curTxts.get(0).startsWith("GB")) {
				curTxts.remove(0);
				txts.addAll(curTxts);
			}
		}
		
		items = parseItem(txts);
		return null;
	}
	
	private EquipmentStandard parseInfo(File homePage, File secondPage) {
		EquipmentStandard stand = new EquipmentStandard();
		// 读取第一个文件
		List<String> txts = FileUtils.readFileTxt(homePage);
		txts.addAll(FileUtils.readFileTxt(secondPage));
		String txt = "";
		for (int i = 0; i < txts.size(); i++) {
			txt = txts.get(i);
			// 读取编号、名字
			if (txt.trim().contains("GB")) {
				stand.setNumber(txt.trim());
				String firstCategory = txts.get(i + 1).trim();
				if (StringUtils.isNotBlank(firstCategory)
					&& firstCategory.contains("国家标准")) { 
					String secondCategory = txts.get(i + 2).trim();
					
					stand.setCategory(firstCategory);
					stand.setType(secondCategory);
					stand.setName(firstCategory 
							+ secondCategory 
							+ txts.get(i + 3).trim());
				}
			}
			
			// 读取发布时间
			if (txt.contains("-") && txt.contains("发布")) {
				stand.setPublishDate(txt.trim().substring(0, 10));
			}
			
			// 读取实施时间
			if (txt.contains("-") && txt.contains("实施")) {
				stand.setImplementDate(txt.trim().substring(0, 10));
			}
			
			// 读取就标准编号
			if (txt.contains("代替") && txt.contains("GB")) {
				txt = txt.substring(txt.indexOf("GB"), txt.length());
				String oldNumber = txt.substring(0, txt.indexOf("《"));
				//String oldName = txt.substring(txt.indexOf("《"), txt.length());
				stand.setReplaceStandard(oldNumber);
			}
		}
		
		return stand;
	}
	
	private Map<String, ArrayList<String>> parseItem(List<String> txts) {
		Map<String, ArrayList<String>> map = new HashMap<>();
		String txt = "";
		// 识别耗材设备，查找父级
		// 保存鉴别试验、测定实验到map
		// 保存设备、耗材到map
		for (int i = 0; i < txts.size(); i++) {
			txt = txts.get(i);
		}
		
		return map;
	}

	@Override
	public Map<EquipmentStandard, Map<EquipmentStandardItem, List<EquipmentShopProduct>>> getDataMapById(
			String id) {
		Map<EquipmentStandard, Map<EquipmentStandardItem, List<EquipmentShopProduct>>> map = new HashMap<>();
		if (StringUtils.isBlank(id)) {
			return null;
		}
		
		// 标准信息
		EquipmentStandard standard = selectById(id);
		if (standard == null || standard.getId() == null) {
			return null;
		}
		
		// 检验项信息
		List<EquipmentStandardItem> items = itemService.selectList(Condition.create().eq("standard_id", id));
		Map<Long, EquipmentStandardItem> itemMap = new HashMap<>();
		for (EquipmentStandardItem item : items) {
			itemMap.put(item.getId(), item);
		}
		
		// 检验项和耗材设备关联信息
		Set<Long> itemIds = itemMap.keySet();
		List<EquipmentStandardItemProduct> itemProducts = itemProductService.selectList(Condition.create().in("item_id", itemIds));
		
		// 耗材设备信息
		List<Long> productIds = new ArrayList<>();
		for (EquipmentStandardItemProduct itemProduct : itemProducts) {
			productIds.add(itemProduct.getProductId());
		}
		List<EquipmentShopProduct> products = productService.selectBatchIds(productIds);
		Map<Long, EquipmentShopProduct> productMap = new HashMap<>();
		for (EquipmentShopProduct product : products) {
			productMap.put(product.getId(), product);
		}
		
		// 检验项和耗材设备关联信息
		Map<EquipmentStandardItem, List<EquipmentShopProduct>> itemProductMap = new HashMap<>();
		for (EquipmentStandardItemProduct itemProduct : itemProducts) {
			EquipmentStandardItem key = itemMap.get(itemProduct.getItemId());
			List<EquipmentShopProduct> curItemProducts = null;
			if (itemProductMap.containsKey(key)) {
				curItemProducts = itemProductMap.get(key);
			} else {
				curItemProducts = new ArrayList<>();
			}
			
			EquipmentShopProduct product = productMap.get(itemProduct.getProductId());
			product.setRemark(itemProduct.getRemark());
			curItemProducts.add(product);
			itemProductMap.put(key, curItemProducts);
		}
		
		map.put(standard, itemProductMap);
		return map;
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteItemsById(Long id) {
		if (id == null || id.longValue() <= 0L) {
			return ;
		}
		
		List<EquipmentStandardItem> oldItems = itemService.selectList(Condition.create().eq("standard_id", id));
		List<Long> itemIds = new ArrayList<>();
		for (EquipmentStandardItem item : oldItems) {
			itemIds.add(item.getId());
		}
		
		itemProductService.delete(Condition.create().in("item_id", itemIds));
		itemService.deleteBatchIds(itemIds);		
	}
}
