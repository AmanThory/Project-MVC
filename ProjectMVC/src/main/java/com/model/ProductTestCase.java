package com.model;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {
		private static AnnotationConfigApplicationContext context;
	 private static IProductDAO pd;
		private Product product;
	//	private ProductDAO pd;
		@BeforeClass
		public static void init() {
			context = new AnnotationConfigApplicationContext();
			context.scan("com.model");
			context.refresh();
			pd = (IProductDAO)context.getBean("productDAO");
		}
		
		@Test
		public void testInsertProduct() {
			product = new Product();
			product.setpName("Keys");
			product.setpCost(400);
			assertEquals("Successfully inserted a single product to the table",true,pd.insertProduct(product));
		}
		
		@Test
		public void testUpdateProduct() {
			product = pd.getProduct(36);
			product.setpName("SpringMVC");
			assertEquals("Successfully Updated",true, pd.updateProduct(product));
		}
		
		@Test
		public void testDeleteProduct() {
			product = pd.getProduct(2);
			assertEquals("Successfully Deleted",true,pd.deleteProduct(product));
		}
		
		@Test
		public void testGetProduct() {
			product = pd.getProduct(35);
			assertEquals("Successfully reterived","Ring",product.getpName());
		}
		
}
