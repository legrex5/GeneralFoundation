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

import tristi.general.bean.Bank;
import tristi.general.bean.jpa.BankEntity;
import tristi.general.business.service.BankService;
import tristi.general.business.service.jpa.mapping.BankServiceMapper;
import tristi.general.data.repository.jpa.BankJpaRepository;

/**
 * Implementation of BankService
 */
@Component
@Transactional
public class BankServiceImpl implements BankService {

	@Resource
	private BankJpaRepository bankJpaRepository;

	@Resource
	private BankServiceMapper bankServiceMapper;
	
	@Override
	public Bank findById(String bankid) {
		BankEntity bankEntity = bankJpaRepository.findOne(bankid);
		return bankServiceMapper.mapBankEntityToBank(bankEntity);
	}

	@Override
	public List<Bank> findAll() {
		Iterable<BankEntity> entities = bankJpaRepository.findAll();
		List<Bank> beans = new ArrayList<Bank>();
		for(BankEntity bankEntity : entities) {
			beans.add(bankServiceMapper.mapBankEntityToBank(bankEntity));
		}
		return beans;
	}

	@Override
	public Bank save(Bank bank) {
		return update(bank) ;
	}

	@Override
	public Bank create(Bank bank) {
		BankEntity bankEntity = bankJpaRepository.findOne(bank.getBankid());
		if( bankEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		bankEntity = new BankEntity();
		bankServiceMapper.mapBankToBankEntity(bank, bankEntity);
		BankEntity bankEntitySaved = bankJpaRepository.save(bankEntity);
		return bankServiceMapper.mapBankEntityToBank(bankEntitySaved);
	}

	@Override
	public Bank update(Bank bank) {
		BankEntity bankEntity = bankJpaRepository.findOne(bank.getBankid());
		bankServiceMapper.mapBankToBankEntity(bank, bankEntity);
		BankEntity bankEntitySaved = bankJpaRepository.save(bankEntity);
		return bankServiceMapper.mapBankEntityToBank(bankEntitySaved);
	}

	@Override
	public void delete(String bankid) {
		bankJpaRepository.delete(bankid);
	}

	public BankJpaRepository getBankJpaRepository() {
		return bankJpaRepository;
	}

	public void setBankJpaRepository(BankJpaRepository bankJpaRepository) {
		this.bankJpaRepository = bankJpaRepository;
	}

	public BankServiceMapper getBankServiceMapper() {
		return bankServiceMapper;
	}

	public void setBankServiceMapper(BankServiceMapper bankServiceMapper) {
		this.bankServiceMapper = bankServiceMapper;
	}

	@Override
	public boolean exists(String bankid) {
		return bankJpaRepository.exists(bankid);
	}

	@Override
	public long count() {
		return bankJpaRepository.count();
	}

}
