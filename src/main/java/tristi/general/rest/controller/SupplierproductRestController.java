/*
 * Created on 6 Dec 2015 ( Time 04:13:35 )
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

import tristi.general.bean.Supplierproduct;
import tristi.general.business.service.SupplierproductService;
import tristi.general.web.listitem.SupplierproductListItem;

/**
 * Spring MVC controller for 'Supplierproduct' management.
 */
@Controller
public class SupplierproductRestController {

	@Resource
	private SupplierproductService supplierproductService;
	
	@RequestMapping( value="/items/supplierproduct",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<SupplierproductListItem> findAllAsListItems() {
		List<Supplierproduct> list = supplierproductService.findAll();
		List<SupplierproductListItem> items = new LinkedList<SupplierproductListItem>();
		for ( Supplierproduct supplierproduct : list ) {
			items.add(new SupplierproductListItem( supplierproduct ) );
		}
		return items;
	}
	
	@RequestMapping( value="/supplierproduct",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Supplierproduct> findAll() {
		return supplierproductService.findAll();
	}

	@RequestMapping( value="/supplierproduct/{supplierproductid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Supplierproduct findOne(@PathVariable("supplierproductid") String supplierproductid) {
		return supplierproductService.findById(supplierproductid);
	}
	
	@RequestMapping( value="/supplierproduct",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Supplierproduct create(@RequestBody Supplierproduct supplierproduct) {
		return supplierproductService.create(supplierproduct);
	}

	@RequestMapping( value="/supplierproduct/{supplierproductid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Supplierproduct update(@PathVariable("supplierproductid") String supplierproductid, @RequestBody Supplierproduct supplierproduct) {
		return supplierproductService.update(supplierproduct);
	}

	@RequestMapping( value="/supplierproduct/{supplierproductid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("supplierproductid") String supplierproductid) {
		supplierproductService.delete(supplierproductid);
	}
	
}