package com.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.IProductDAO;
import com.model.Product;
import com.model.ProductDAO;

@Controller
public class ProductController {
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home() {
		
		ModelAndView view = new ModelAndView("product");
		view.addObject("HeaderName", "Welcome to Products Page");
		return view;
	}
	
	@RequestMapping(value="/success", method=RequestMethod.GET)
	public ModelAndView productSuccess(@ModelAttribute("product1")Product product) throws Exception
	{
/*		String exceptionOccured = "ARITHMETIC_EXCEPTION";
		if(exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			throw new NullPointerException("Null Pointer Exception");
		}
		else if(exceptionOccured.equalsIgnoreCase("IO_EXCEPTION")) {
			throw new IOException("IO Exception");
		}
		else if(exceptionOccured.equalsIgnoreCase("ARITHMETIC_EXCEPTION")) {
			throw new ArithmeticException("Arithmetic Exception");
		}*/
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("productName",product.getpName());
		
		IProductDAO pd = new ProductDAO();
		pd.insertProduct(product);
		
		return mv;
	}
	
	@RequestMapping(value="/getproducts", method = RequestMethod.GET)
	public ModelAndView getProductList(Principal p) {
		
		ProductDAO pd = new ProductDAO();
		List<Product> al = pd.getProducts();
		ModelAndView mv = new ModelAndView("listproducts");
		mv.addObject("lp",al);
		mv.addObject("un",p.getName());
		return mv;		
	}
	
	@ResponseBody
	@RequestMapping(value="/getjsonproducts", method=RequestMethod.POST)
	public List<Product> getJsonProductList(){
		ProductDAO pd = new ProductDAO();
		List<Product> al = pd.getProducts();
		return al;
	}
	
	@RequestMapping(value="/privatePage", method=RequestMethod.GET)
	public String getPrivatePage() {
		
		return "privatepage";
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
