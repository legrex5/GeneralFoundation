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

import tristi.general.bean.Salesorderdtl;
import tristi.general.business.service.SalesorderdtlService;
import tristi.general.web.listitem.SalesorderdtlListItem;

/**
 * Spring MVC controller for 'Salesorderdtl' management.
 */
@Controller
public class SalesorderdtlRestController {

	@Resource
	private SalesorderdtlService salesorderdtlService;
	
	@RequestMapping( value="/items/salesorderdtl",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<SalesorderdtlListItem> findAllAsListItems() {
		List<Salesorderdtl> list = salesorderdtlService.findAll();
		List<SalesorderdtlListItem> items = new LinkedList<SalesorderdtlListItem>();
		for ( Salesorderdtl salesorderdtl : list ) {
			items.add(new SalesorderdtlListItem( salesorderdtl ) );
		}
		return items;
	}
	
	@RequestMapping( value="/salesorderdtl",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Salesorderdtl> findAll() {
		return salesorderdtlService.findAll();
	}

	@RequestMapping( value="/salesorderdtl/{salesorderdtlid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Salesorderdtl findOne(@PathVariable("salesorderdtlid") String salesorderdtlid) {
		return salesorderdtlService.findById(salesorderdtlid);
	}
	
	@RequestMapping( value="/salesorderdtl",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Salesorderdtl create(@RequestBody Salesorderdtl salesorderdtl) {
		return salesorderdtlService.create(salesorderdtl);
	}

	@RequestMapping( value="/salesorderdtl/{salesorderdtlid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Salesorderdtl update(@PathVariable("salesorderdtlid") String salesorderdtlid, @RequestBody Salesorderdtl salesorderdtl) {
		return salesorderdtlService.update(salesorderdtl);
	}

	@RequestMapping( value="/salesorderdtl/{salesorderdtlid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("salesorderdtlid") String salesorderdtlid) {
		salesorderdtlService.delete(salesorderdtlid);
	}
	
}