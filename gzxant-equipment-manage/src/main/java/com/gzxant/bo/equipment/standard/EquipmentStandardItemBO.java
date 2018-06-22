package com.gzxant.bo.equipment.standard;

import java.util.List;

import com.gzxant.entity.equipment.shop.product.EquipmentShopProduct;
import com.gzxant.entity.equipment.standard.item.EquipmentStandardItem;

public class EquipmentStandardItemBO {

	private EquipmentStandardItem item;
	private List<EquipmentShopProduct> products;

	public EquipmentStandardItem getItem() {
		return item;
	}

	public void setItem(EquipmentStandardItem item) {
		this.item = item;
	}

	public List<EquipmentShopProduct> getProducts() {
		return products;
	}

	public void setProducts(List<EquipmentShopProduct> products) {
		this.products = products;
	}
}
