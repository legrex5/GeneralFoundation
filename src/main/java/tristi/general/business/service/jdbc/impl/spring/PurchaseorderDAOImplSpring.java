/*
 * Created on 10 Dec 2015
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Purchaseorder;
import tristi.general.business.service.PurchaseorderService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Purchaseorder DAO implementation 
 * 
 * 
 *
 */
@Repository
public class PurchaseorderDAOImplSpring extends GenericDAO<Purchaseorder> implements PurchaseorderService {

	private final static String SQL_SELECT_ALL_PAGING = 
		"select purchaseorderid, purchaseorder_supplierid, purchaseorder_accountbankid, purchaseorder_userid, purchaseorder_paymentformid, purchaseordercode, purchaseorderrefnumber, purchaseorderdate, puchaseorderamount, purchaserorderdiscount, purchaseorderdeliverydate, purchaseorderstatus, purchaseorderincludetax, purchaseordermoddate from purchaseorder limit ? offset ?";

        private final static String SQL_SELECT_ALL = 
		"select purchaseorderid, purchaseorder_supplierid, purchaseorder_accountbankid, purchaseorder_userid, purchaseorder_paymentformid, purchaseordercode, purchaseorderrefnumber, purchaseorderdate, puchaseorderamount, purchaserorderdiscount, purchaseorderdeliverydate, purchaseorderstatus, purchaseorderincludetax, purchaseordermoddate from purchaseorder";

        private final static String SQL_SELECT_PAGING = 
		"select purchaseorderid, purchaseorder_supplierid, purchaseorder_accountbankid, purchaseorder_userid, purchaseorder_paymentformid, purchaseordercode, purchaseorderrefnumber, purchaseorderdate, puchaseorderamount, purchaserorderdiscount, purchaseorderdeliverydate, purchaseorderstatus, purchaseorderincludetax, purchaseordermoddate from purchaseorder where purchaseorderid = ? limit ? offset ?";

        private final static String SQL_SELECT = 
		"select purchaseorderid, purchaseorder_supplierid, purchaseorder_accountbankid, purchaseorder_userid, purchaseorder_paymentformid, purchaseordercode, purchaseorderrefnumber, purchaseorderdate, puchaseorderamount, purchaserorderdiscount, purchaseorderdeliverydate, purchaseorderstatus, purchaseorderincludetax, purchaseordermoddate from purchaseorder where purchaseorderid = ?";

	private final static String SQL_INSERT = 
		"insert into purchaseorder ( purchaseorder_supplierid, purchaseorder_accountbankid, purchaseorder_userid, purchaseorder_paymentformid, purchaseordercode, purchaseorderrefnumber, purchaseorderdate, puchaseorderamount, purchaserorderdiscount, purchaseorderdeliverydate, purchaseorderstatus, purchaseorderincludetax, purchaseordermoddate ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update purchaseorder set purchaseorder_supplierid = ?, purchaseorder_accountbankid = ?, purchaseorder_userid = ?, purchaseorder_paymentformid = ?, purchaseordercode = ?, purchaseorderrefnumber = ?, purchaseorderdate = ?, puchaseorderamount = ?, purchaserorderdiscount = ?, purchaseorderdeliverydate = ?, purchaseorderstatus = ?, purchaseorderincludetax = ?, purchaseordermoddate = ? where purchaseorderid = ?";

	private final static String SQL_DELETE = 
		"delete from purchaseorder where purchaseorderid = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from purchaseorder";

	private final static String SQL_COUNT = 
		"select count(*) from purchaseorder where purchaseorderid = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public PurchaseorderDAOImplSpring() {
		super();
	}
	
	@Override
	public boolean exists( String purchaseorderid ) {
		Object[] primaryKey = new Object[] { purchaseorderid };
		return super.doExists(primaryKey);
	}

	@Override
	public long count() {
		return super.doCountAll();
	}

    //----------------------------------------------------------------------
	// Super class abstract methods implementation
    //----------------------------------------------------------------------
	@Override
	protected String getSqlSelectAll() {
		return SQL_SELECT_ALL ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlSelect() {
		return SQL_SELECT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlInsert() {
		return SQL_INSERT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlUpdate() {
		return SQL_UPDATE ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlDelete() {
		return SQL_DELETE ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlCount() {
		return SQL_COUNT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlCountAll() {
		return SQL_COUNT_ALL ;
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForInsert(Purchaseorder purchaseorder)  {
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//			purchaseorder.getPurchaseorderid() , // "purchaseorderid" : java.lang.String
			purchaseorder.getPurchaseorderSupplierid()==null?purchaseorder.getPurchaseorderSupplierid():UUID.fromString(purchaseorder.getPurchaseorderSupplierid()) , // "purchaseorder_supplierid" : java.lang.String
			purchaseorder.getPurchaseorderAccountbankid()==null?purchaseorder.getPurchaseorderAccountbankid():UUID.fromString(purchaseorder.getPurchaseorderAccountbankid()) , // "purchaseorder_accountbankid" : java.lang.String
			purchaseorder.getPurchaseorderUserid()==null?purchaseorder.getPurchaseorderUserid():UUID.fromString(purchaseorder.getPurchaseorderUserid()) , // "purchaseorder_userid" : java.lang.String
			purchaseorder.getPurchaseorderPaymentformid()==null?purchaseorder.getPurchaseorderPaymentformid():UUID.fromString(purchaseorder.getPurchaseorderPaymentformid()) , // "purchaseorder_paymentformid" : java.lang.String
			purchaseorder.getPurchaseordercode() , // "purchaseordercode" : java.lang.String
			purchaseorder.getPurchaseorderrefnumber() , // "purchaseorderrefnumber" : java.lang.String
			purchaseorder.getPurchaseorderdate() , // "purchaseorderdate" : java.util.Date
			purchaseorder.getPuchaseorderamount() , // "puchaseorderamount" : java.lang.Double
			purchaseorder.getPurchaserorderdiscount() , // "purchaserorderdiscount" : java.lang.Double
			purchaseorder.getPurchaseorderdeliverydate() , // "purchaseorderdeliverydate" : java.util.Date
			purchaseorder.getPurchaseorderstatus() , // "purchaseorderstatus" : java.lang.String
			purchaseorder.getPurchaseorderincludetax() , // "purchaseorderincludetax" : java.lang.Boolean
			purchaseorder.getPurchaseordermoddate()  // "purchaseordermoddate" : java.util.Date
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Purchaseorder purchaseorder) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
			purchaseorder.getPurchaseorderSupplierid()==null?purchaseorder.getPurchaseorderSupplierid():UUID.fromString(purchaseorder.getPurchaseorderSupplierid()) , // "purchaseorder_supplierid" : java.lang.String
			purchaseorder.getPurchaseorderAccountbankid()==null?purchaseorder.getPurchaseorderAccountbankid():UUID.fromString(purchaseorder.getPurchaseorderAccountbankid()) , // "purchaseorder_accountbankid" : java.lang.String
			purchaseorder.getPurchaseorderUserid()==null?purchaseorder.getPurchaseorderUserid():UUID.fromString(purchaseorder.getPurchaseorderUserid()) , // "purchaseorder_userid" : java.lang.String
			purchaseorder.getPurchaseorderPaymentformid()==null?purchaseorder.getPurchaseorderPaymentformid():UUID.fromString(purchaseorder.getPurchaseorderPaymentformid()) , // "purchaseorder_paymentformid" : java.lang.String
			purchaseorder.getPurchaseordercode(), // "purchaseordercode" : java.lang.String
			purchaseorder.getPurchaseorderrefnumber(), // "purchaseorderrefnumber" : java.lang.String
			purchaseorder.getPurchaseorderdate(), // "purchaseorderdate" : java.util.Date
			purchaseorder.getPuchaseorderamount(), // "puchaseorderamount" : java.lang.Double
			purchaseorder.getPurchaserorderdiscount(), // "purchaserorderdiscount" : java.lang.Double
			purchaseorder.getPurchaseorderdeliverydate(), // "purchaseorderdeliverydate" : java.util.Date
			purchaseorder.getPurchaseorderstatus(), // "purchaseorderstatus" : java.lang.String
			purchaseorder.getPurchaseorderincludetax(), // "purchaseorderincludetax" : java.lang.Boolean
			purchaseorder.getPurchaseordermoddate(), // "purchaseordermoddate" : java.util.Date
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			UUID.fromString(purchaseorder.getPurchaseorderid())  // "purchaseorderid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Purchaseorder purchaseorder)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			purchaseorder.getPurchaseorderid()  // "purchaseorderid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Purchaseorder> getRowMapper(Purchaseorder o)  {
		//--- RowMapper to populate the given bean instance
		return new PurchaseorderRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Purchaseorder> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new PurchaseorderRowMapper() ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param purchaseorder
	 * @throws SQLException
	 */
	private Purchaseorder populateBean(ResultSet rs, Purchaseorder purchaseorder) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		purchaseorder.setPurchaseorderid(rs.getString("purchaseorderid")); // java.lang.String
		purchaseorder.setPurchaseorderSupplierid(rs.getString("purchaseorder_supplierid")); // java.lang.String
		purchaseorder.setPurchaseorderAccountbankid(rs.getString("purchaseorder_accountbankid")); // java.lang.String
		purchaseorder.setPurchaseorderUserid(rs.getString("purchaseorder_userid")); // java.lang.String
		purchaseorder.setPurchaseorderPaymentformid(rs.getString("purchaseorder_paymentformid")); // java.lang.String
		purchaseorder.setPurchaseordercode(rs.getString("purchaseordercode")); // java.lang.String
		purchaseorder.setPurchaseorderrefnumber(rs.getString("purchaseorderrefnumber")); // java.lang.String
		purchaseorder.setPurchaseorderdate(rs.getDate("purchaseorderdate")); // java.util.Date
		purchaseorder.setPuchaseorderamount(rs.getDouble("puchaseorderamount")); // java.lang.Double
		if ( rs.wasNull() ) { purchaseorder.setPuchaseorderamount(null); }; // not primitive number => keep null value if any
		purchaseorder.setPurchaserorderdiscount(rs.getDouble("purchaserorderdiscount")); // java.lang.Double
		if ( rs.wasNull() ) { purchaseorder.setPurchaserorderdiscount(null); }; // not primitive number => keep null value if any
		purchaseorder.setPurchaseorderdeliverydate(rs.getDate("purchaseorderdeliverydate")); // java.util.Date
		purchaseorder.setPurchaseorderstatus(rs.getString("purchaseorderstatus")); // java.lang.String
		purchaseorder.setPurchaseorderincludetax(rs.getBoolean("purchaseorderincludetax")); // java.lang.Boolean
		purchaseorder.setPurchaseordermoddate(rs.getDate("purchaseordermoddate")); // java.util.Date
                return purchaseorder;
	}
        
        //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param purchaseorder
	 * @throws SQLException
	 */
	private Purchaseorder populateBean(ResultSet rs) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
            Purchaseorder purchaseorder = new Purchaseorder();
		purchaseorder.setPurchaseorderid(rs.getString("purchaseorderid")); // java.lang.String
		purchaseorder.setPurchaseorderSupplierid(rs.getString("purchaseorder_supplierid")); // java.lang.String
		purchaseorder.setPurchaseorderAccountbankid(rs.getString("purchaseorder_accountbankid")); // java.lang.String
		purchaseorder.setPurchaseorderUserid(rs.getString("purchaseorder_userid")); // java.lang.String
		purchaseorder.setPurchaseorderPaymentformid(rs.getString("purchaseorder_paymentformid")); // java.lang.String
		purchaseorder.setPurchaseordercode(rs.getString("purchaseordercode")); // java.lang.String
		purchaseorder.setPurchaseorderrefnumber(rs.getString("purchaseorderrefnumber")); // java.lang.String
		purchaseorder.setPurchaseorderdate(rs.getDate("purchaseorderdate")); // java.util.Date
		purchaseorder.setPuchaseorderamount(rs.getDouble("puchaseorderamount")); // java.lang.Double
		if ( rs.wasNull() ) { purchaseorder.setPuchaseorderamount(null); }; // not primitive number => keep null value if any
		purchaseorder.setPurchaserorderdiscount(rs.getDouble("purchaserorderdiscount")); // java.lang.Double
		if ( rs.wasNull() ) { purchaseorder.setPurchaserorderdiscount(null); }; // not primitive number => keep null value if any
		purchaseorder.setPurchaseorderdeliverydate(rs.getDate("purchaseorderdeliverydate")); // java.util.Date
		purchaseorder.setPurchaseorderstatus(rs.getString("purchaseorderstatus")); // java.lang.String
		purchaseorder.setPurchaseorderincludetax(rs.getBoolean("purchaseorderincludetax")); // java.lang.Boolean
		purchaseorder.setPurchaseordermoddate(rs.getDate("purchaseordermoddate")); // java.util.Date
                return purchaseorder;
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class PurchaseorderRowMapper implements RowMapper<Purchaseorder> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private Purchaseorder bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		PurchaseorderRowMapper(Purchaseorder bean) {
			this.bean = bean ;
		}
		
		public PurchaseorderRowMapper() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public Purchaseorder mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
		}
	}

	@Override
	public Purchaseorder findById(String purchaseorderid) {
		Object[] primaryKey = new Object[] { UUID.fromString(purchaseorderid) };
		return super.doSelect(primaryKey);
	}

	@Override
	public List<Purchaseorder> findAll() {
		return super.doSelectAll();
	}

	@Override
	public Purchaseorder save(Purchaseorder entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Purchaseorder update(Purchaseorder entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Purchaseorder create(Purchaseorder entity) {
		super.doInsert(entity);
		return entity;
	}

	@Override
	public void delete(String purchaseorderid) {
		Object[] primaryKey = new Object[] { purchaseorderid };
		super.doDelete(primaryKey);	
	}
}
