/*
 * Created on 6 Dec 2015 ( Time 04:13:33 )
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

import tristi.general.bean.Accountbank;
import tristi.general.business.service.AccountbankService;
import tristi.general.web.listitem.AccountbankListItem;


/**
 * Spring MVC controller for 'Accountbank' management.
 */
@Controller
public class AccountbankRestController {

	@Resource
	private AccountbankService accountbankService;
	
	@RequestMapping( value="/items/accountbank",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<AccountbankListItem> findAllAsListItems() {
		List<Accountbank> list = accountbankService.findAll();
		List<AccountbankListItem> items = new LinkedList<AccountbankListItem>();
		for ( Accountbank accountbank : list ) {
			items.add(new AccountbankListItem( accountbank ) );
		}
		return items;
	}
	
	@RequestMapping( value="/accountbank",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Accountbank> findAll() {
		return accountbankService.findAll();
	}

	@RequestMapping( value="/accountbank/{accountbankid}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Accountbank findOne(@PathVariable("accountbankid") String accountbankid) {
		return accountbankService.findById(accountbankid);
	}
	
	@RequestMapping( value="/accountbank",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Accountbank create(@RequestBody Accountbank accountbank) {
		return accountbankService.create(accountbank);
	}

	@RequestMapping( value="/accountbank/{accountbankid}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Accountbank update(@PathVariable("accountbankid") String accountbankid, @RequestBody Accountbank accountbank) {
		return accountbankService.update(accountbank);
	}

	@RequestMapping( value="/accountbank/{accountbankid}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("accountbankid") String accountbankid) {
		accountbankService.delete(accountbankid);
	}
	
}
