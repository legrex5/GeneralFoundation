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

import tristi.general.bean.Paymentform;
import tristi.general.bean.jpa.PaymentformEntity;
import tristi.general.business.service.PaymentformService;
import tristi.general.business.service.jpa.mapping.PaymentformServiceMapper;
import tristi.general.data.repository.jpa.PaymentformJpaRepository;

/**
 * Implementation of PaymentformService
 */
@Component
@Transactional
public class PaymentformServiceImpl implements PaymentformService {

	@Resource
	private PaymentformJpaRepository paymentformJpaRepository;

	@Resource
	private PaymentformServiceMapper paymentformServiceMapper;
	
	@Override
	public Paymentform findById(String paymentformid) {
		PaymentformEntity paymentformEntity = paymentformJpaRepository.findOne(paymentformid);
		return paymentformServiceMapper.mapPaymentformEntityToPaymentform(paymentformEntity);
	}

	@Override
	public List<Paymentform> findAll() {
		Iterable<PaymentformEntity> entities = paymentformJpaRepository.findAll();
		List<Paymentform> beans = new ArrayList<Paymentform>();
		for(PaymentformEntity paymentformEntity : entities) {
			beans.add(paymentformServiceMapper.mapPaymentformEntityToPaymentform(paymentformEntity));
		}
		return beans;
	}

	@Override
	public Paymentform save(Paymentform paymentform) {
		return update(paymentform) ;
	}

	@Override
	public Paymentform create(Paymentform paymentform) {
		PaymentformEntity paymentformEntity = paymentformJpaRepository.findOne(paymentform.getPaymentformid());
		if( paymentformEntity != null ) {
			throw new IllegalStateException("already.exists");
		}
		paymentformEntity = new PaymentformEntity();
		paymentformServiceMapper.mapPaymentformToPaymentformEntity(paymentform, paymentformEntity);
		PaymentformEntity paymentformEntitySaved = paymentformJpaRepository.save(paymentformEntity);
		return paymentformServiceMapper.mapPaymentformEntityToPaymentform(paymentformEntitySaved);
	}

	@Override
	public Paymentform update(Paymentform paymentform) {
		PaymentformEntity paymentformEntity = paymentformJpaRepository.findOne(paymentform.getPaymentformid());
		paymentformServiceMapper.mapPaymentformToPaymentformEntity(paymentform, paymentformEntity);
		PaymentformEntity paymentformEntitySaved = paymentformJpaRepository.save(paymentformEntity);
		return paymentformServiceMapper.mapPaymentformEntityToPaymentform(paymentformEntitySaved);
	}

	@Override
	public void delete(String paymentformid) {
		paymentformJpaRepository.delete(paymentformid);
	}

	public PaymentformJpaRepository getPaymentformJpaRepository() {
		return paymentformJpaRepository;
	}

	public void setPaymentformJpaRepository(PaymentformJpaRepository paymentformJpaRepository) {
		this.paymentformJpaRepository = paymentformJpaRepository;
	}

	public PaymentformServiceMapper getPaymentformServiceMapper() {
		return paymentformServiceMapper;
	}

	public void setPaymentformServiceMapper(PaymentformServiceMapper paymentformServiceMapper) {
		this.paymentformServiceMapper = paymentformServiceMapper;
	}

	@Override
	public boolean exists(String paymentformid) {
		return paymentformJpaRepository.exists(paymentformid);
	}

	@Override
	public long count() {
		return paymentformJpaRepository.count();
	}

}
