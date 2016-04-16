/*
 * Created on 6 Dec 2015
 * 
 */
package tristi.general.business.service.jpa.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import tristi.general.bean.Accountbank;
import tristi.general.bean.jpa.AccountbankEntity;
import tristi.general.business.service.AccountbankService;
import tristi.general.business.service.jpa.mapping.AccountbankServiceMapper;
import tristi.general.data.repository.jpa.AccountbankJpaRepository;

/**
 * Implementation of AccountbankService
 */
@Component
@Transactional
public class AccountbankServiceImpl implements AccountbankService {

	@Resource
	private AccountbankJpaRepository accountbankJpaRepository;

	@Resource
	private AccountbankServiceMapper accountbankServiceMapper;
	
	@Override
	public Accountbank findById(String accountbankid) {
		AccountbankEntity accountbankEntity = accountbankJpaRepository.findOne(accountbankid);
		return accountbankServiceMapper.mapAccountbankEntityToAccountbank(accountbankEntity);
	}

	@Override
	public List<Accountbank> findAll() {
		Iterable<AccountbankEntity> entities = accountbankJpaRepository.findAll();
		List<Accountbank> beans = new ArrayList<Accountbank>();
		for(AccountbankEntity accountbankEntity : entities) {
			beans.add(accountbankServiceMapper.mapAccountbankEntityToAccountbank(accountbankEntity));
		}
		return beans;
	}

	@Override
	public Accountbank save(Accountbank accountbank) {
		return update(accountbank) ;
	}

	@Override
	public Accountbank create(Accountbank accountbank) {
		AccountbankEntity accountbankEntity = accountbankJpaRepository.findOne(accountbank.getAccountbankid());
		if( accountbankEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		accountbankEntity = new AccountbankEntity();
		accountbankServiceMapper.mapAccountbankToAccountbankEntity(accountbank, accountbankEntity);
		AccountbankEntity accountbankEntitySaved = accountbankJpaRepository.save(accountbankEntity);
		return accountbankServiceMapper.mapAccountbankEntityToAccountbank(accountbankEntitySaved);
	}

	@Override
	public Accountbank update(Accountbank accountbank) {
		AccountbankEntity accountbankEntity = accountbankJpaRepository.findOne(accountbank.getAccountbankid());
		accountbankServiceMapper.mapAccountbankToAccountbankEntity(accountbank, accountbankEntity);
		AccountbankEntity accountbankEntitySaved = accountbankJpaRepository.save(accountbankEntity);
		return accountbankServiceMapper.mapAccountbankEntityToAccountbank(accountbankEntitySaved);
	}

	@Override
	public void delete(String accountbankid) {
		accountbankJpaRepository.delete(accountbankid);
	}

	public AccountbankJpaRepository getAccountbankJpaRepository() {
		return accountbankJpaRepository;
	}

	public void setAccountbankJpaRepository(AccountbankJpaRepository accountbankJpaRepository) {
		this.accountbankJpaRepository = accountbankJpaRepository;
	}

	public AccountbankServiceMapper getAccountbankServiceMapper() {
		return accountbankServiceMapper;
	}

	public void setAccountbankServiceMapper(AccountbankServiceMapper accountbankServiceMapper) {
		this.accountbankServiceMapper = accountbankServiceMapper;
	}

	@Override
	public boolean exists(String accountbankid) {
		return accountbankJpaRepository.exists(accountbankid);
	}

	@Override
	public long count() {
		return accountbankJpaRepository.count();
	}

}
