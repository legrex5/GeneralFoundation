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

import tristi.general.bean.Uom;
import tristi.general.business.service.UomService;
import tristi.general.web.listitem.UomListItem;

/**
 * Spring MVC controller for 'Uom' management.
 */
@Controller
public class UomRestController {

	@Resource
	private UomService uomService;
	
	@RequestMapping( value="/items/uom",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<UomListItem> findAllAsListItems() {
		List<Uom> list = uomService.findAll();
		List<UomListItem> items = new LinkedList<UomListItem>();
		for ( Uom uom : list ) {
			items.add(new UomListItem( uom ) );
		}
		return items;
	}
	
	@RequestMapping( value="/uom",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Uom> findAll() {
		return uomService.findAll();
	}

	@RequestMapping( value="/uom/{uomid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Uom findOne(@PathVariable("uomid") String uomid) {
		return uomService.findById(uomid);
	}
	
	@RequestMapping( value="/uom",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Uom create(@RequestBody Uom uom) {
		return uomService.create(uom);
	}

	@RequestMapping( value="/uom/{uomid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Uom update(@PathVariable("uomid") String uomid, @RequestBody Uom uom) {
		return uomService.update(uom);
	}

	@RequestMapping( value="/uom/{uomid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("uomid") String uomid) {
		uomService.delete(uomid);
	}
	
}
