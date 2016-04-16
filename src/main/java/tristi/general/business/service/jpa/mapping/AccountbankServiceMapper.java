/*
 * Created on 6 Dec 2015 ( Time 04:08:58 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service.jpa.mapping;

import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import tristi.general.bean.Accountbank;
import tristi.general.bean.jpa.AccountbankEntity;
import tristi.general.bean.jpa.SalesorderEntity;
import tristi.general.bean.jpa.UseraccessEntity;
import tristi.general.bean.jpa.BankEntity;
import tristi.general.bean.jpa.SupplierEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class AccountbankServiceMapper extends AbstractServiceMapper {

	/**
	 * ModelMapper : bean to bean mapping library.
	 */
	private ModelMapper modelMapper;
	
	/**
	 * Constructor.
	 */
	public AccountbankServiceMapper() {
		modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * Mapping from 'AccountbankEntity' to 'Accountbank'
	 * @param accountbankEntity
         * @return Accountbank
	 */
	public Accountbank mapAccountbankEntityToAccountbank(AccountbankEntity accountbankEntity) {
		if(accountbankEntity == null) {
			return null;
		}

		//--- Generic mapping 
		Accountbank accountbank = map(accountbankEntity, Accountbank.class);

		//--- Link mapping ( link to Salesorder )
		if(accountbankEntity.getSalesorder() != null) {
			accountbank.setAccountbankSalesorderid(accountbankEntity.getSalesorder().getSalesorderid().toString());
		}
		//--- Link mapping ( link to Useraccess )
		if(accountbankEntity.getUseraccess() != null) {
			accountbank.setAccountbankUserid(accountbankEntity.getUseraccess().getUserid().toString());
		}
		//--- Link mapping ( link to Bank )
		if(accountbankEntity.getBank() != null) {
			accountbank.setAccountbankBankid(accountbankEntity.getBank().getBankid().toString());
		}
		//--- Link mapping ( link to Supplier )
		if(accountbankEntity.getSupplier() != null) {
			accountbank.setAccountbankSupplierid(accountbankEntity.getSupplier().getSupplierid().toString());
		}
		return accountbank;
	}
	
	/**
	 * Mapping from 'Accountbank' to 'AccountbankEntity'
	 * @param accountbank
	 * @param accountbankEntity
	 */
	public void mapAccountbankToAccountbankEntity(Accountbank accountbank, AccountbankEntity accountbankEntity) {
		if(accountbank == null) {
			return;
		}

		//--- Generic mapping 
		map(accountbank, accountbankEntity);

		//--- Link mapping ( link : accountbank )
		if( hasLinkToSalesorder(accountbank) ) {
			SalesorderEntity salesorder1 = new SalesorderEntity();
			salesorder1.setSalesorderid( UUID.fromString(accountbank.getAccountbankSalesorderid()));
			accountbankEntity.setSalesorder( salesorder1 );
		} else {
			accountbankEntity.setSalesorder( null );
		}

		//--- Link mapping ( link : accountbank )
		if( hasLinkToUseraccess(accountbank) ) {
			UseraccessEntity useraccess2 = new UseraccessEntity();
			useraccess2.setUserid( UUID.fromString(accountbank.getAccountbankUserid()));
			accountbankEntity.setUseraccess( useraccess2 );
		} else {
			accountbankEntity.setUseraccess( null );
		}

		//--- Link mapping ( link : accountbank )
		if( hasLinkToBank(accountbank) ) {
			BankEntity bank3 = new BankEntity();
			bank3.setBankid( UUID.fromString(accountbank.getAccountbankBankid()));
			accountbankEntity.setBank( bank3 );
		} else {
			accountbankEntity.setBank( null );
		}

		//--- Link mapping ( link : accountbank )
		if( hasLinkToSupplier(accountbank) ) {
			SupplierEntity supplier4 = new SupplierEntity();
			supplier4.setSupplierid( UUID.fromString(accountbank.getAccountbankSupplierid()));
			accountbankEntity.setSupplier( supplier4 );
		} else {
			accountbankEntity.setSupplier( null );
		}

	}
	
	/**
	 * Verify that Salesorder id is valid.
	 * @param Salesorder Salesorder
	 * @return boolean
	 */
	private boolean hasLinkToSalesorder(Accountbank accountbank) {
		return accountbank.getAccountbankSalesorderid() != null;
	}

	/**
	 * Verify that Useraccess id is valid.
	 * @param Useraccess Useraccess
	 * @return boolean
	 */
	private boolean hasLinkToUseraccess(Accountbank accountbank) {
		return accountbank.getAccountbankUserid() != null;
	}

	/**
	 * Verify that Bank id is valid.
	 * @param Bank Bank
	 * @return boolean
	 */
	private boolean hasLinkToBank(Accountbank accountbank) {
		return accountbank.getAccountbankBankid() != null;
	}

	/**
	 * Verify that Supplier id is valid.
	 * @param Supplier Supplier
	 * @return boolean
	 */
	private boolean hasLinkToSupplier(Accountbank accountbank) {
		return accountbank.getAccountbankSupplierid() != null;
	}

	/**
	 * {@inheritDoc}
         * @return ModelMapper
	 */
	@Override
	protected ModelMapper getModelMapper() {
		return modelMapper;
	}

	protected void setModelMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

}