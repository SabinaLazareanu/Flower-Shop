package com.flowerShop.flowershop;

import com.flowerShop.flowershop.controller.ProductController;
import com.flowerShop.flowershop.model.Product;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Product p1= new Product("rose", "pink", 10.3f, 10);
		ProductController c1= new ProductController();
		c1.addProduct(p1);

	}

}
