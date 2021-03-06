/*
 * Created on 6 Dec 2015 ( Time 04:13:34 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.rest.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import tristi.general.bean.Product;
import tristi.general.business.service.ProductService;
import tristi.general.web.listitem.ProductListItem;

/**
 * Spring MVC controller for 'Product' management.
 */
@Controller
public class ProductRestController {

	@Resource
	private ProductService productService;
	
	@RequestMapping( value="/items/product",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<ProductListItem> findAllAsListItems() {
		List<Product> list = productService.findAll();
		List<ProductListItem> items = new LinkedList<ProductListItem>();
		for ( Product product : list ) {
			items.add(new ProductListItem( product ) );
		}
		return items;
	}
	
	@RequestMapping( value="/product",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Product> findAll() {
		return productService.findAll();
	}

	@RequestMapping( value="/product/{productid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Product findOne(@PathVariable("productid") String productid) {
		return productService.findById(productid);
	}
	
	@RequestMapping( value="/product",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Product create(@RequestBody Product product) {
		return productService.create(product);
	}

	@RequestMapping( value="/product/{productid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Product update(@PathVariable("productid") String productid, @RequestBody Product product) {
		return productService.update(product);
	}

	@RequestMapping( value="/product/{productid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("productid") String productid) {
		productService.delete(productid);
	}
	
}
