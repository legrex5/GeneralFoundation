/*
 * Created on 10 Dec 2015
 *
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Salesorder;
import tristi.general.business.service.SalesorderService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Salesorder DAO implementation 
 * 
 *
 */
@Repository
public class SalesorderDAOImplSpring extends GenericDAO<Salesorder> implements SalesorderService {

	private final static String SQL_SELECT_ALL_PAGING = 
		"select salesorderid, paymentformid, salesordercorrection_id, salesorder_userid, salesordercode, salesorderdate, salesorderdeliverydate, salesorderstatus, salesorderdiscount, salesorderbilling, salesorderpaying, salesorderincludetax, salesordermoddate from salesorder limit ? offset ?";

        private final static String SQL_SELECT_ALL = 
		"select salesorderid, paymentformid, salesordercorrection_id, salesorder_userid, salesordercode, salesorderdate, salesorderdeliverydate, salesorderstatus, salesorderdiscount, salesorderbilling, salesorderpaying, salesorderincludetax, salesordermoddate from salesorder";

        private final static String SQL_SELECT_PAGING = 
		"select salesorderid, paymentformid, salesordercorrection_id, salesorder_userid, salesordercode, salesorderdate, salesorderdeliverydate, salesorderstatus, salesorderdiscount, salesorderbilling, salesorderpaying, salesorderincludetax, salesordermoddate from salesorder where salesorderid = ? limit ? offset ?";

        private final static String SQL_SELECT = 
		"select salesorderid, paymentformid, salesordercorrection_id, salesorder_userid, salesordercode, salesorderdate, salesorderdeliverydate, salesorderstatus, salesorderdiscount, salesorderbilling, salesorderpaying, salesorderincludetax, salesordermoddate from salesorder where salesorderid = ?";


	private final static String SQL_INSERT = 
		"insert into salesorder ( paymentformid, salesordercorrection_id, salesorder_userid, salesordercode, salesorderdate, salesorderdeliverydate, salesorderstatus, salesorderdiscount, salesorderbilling, salesorderpaying, salesorderincludetax, salesordermoddate ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update salesorder set paymentformid = ?, salesordercorrection_id = ?, salesorder_userid = ?, salesordercode = ?, salesorderdate = ?, salesorderdeliverydate = ?, salesorderstatus = ?, salesorderdiscount = ?, salesorderbilling = ?, salesorderpaying = ?, salesorderincludetax = ?, salesordermoddate = ? where salesorderid = ?";

	private final static String SQL_DELETE = 
		"delete from salesorder where salesorderid = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from salesorder";

	private final static String SQL_COUNT = 
		"select count(*) from salesorder where salesorderid = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public SalesorderDAOImplSpring() {
		super();
	}

	@Override
	public boolean exists( String salesorderid ) {
		Object[] primaryKey = new Object[] { salesorderid };
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
	protected Object[] getValuesForInsert(Salesorder salesorder)  {
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//			salesorder.getSalesorderid() , // "salesorderid" : java.lang.String
			salesorder.getPaymentformid()==null?salesorder.getPaymentformid():UUID.fromString(salesorder.getPaymentformid()) , // "paymentformid" : java.lang.String
			salesorder.getSalesordercorrectionId()==null?salesorder.getSalesordercorrectionId():UUID.fromString(salesorder.getSalesordercorrectionId()) , // "salesordercorrection_id" : java.lang.String
			salesorder.getSalesorderUserid()==null?salesorder.getSalesorderUserid():UUID.fromString(salesorder.getSalesorderUserid()) , // "salesorder_userid" : java.lang.String
			salesorder.getSalesordercode() , // "salesordercode" : java.lang.String
			salesorder.getSalesorderdate() , // "salesorderdate" : java.util.Date
			salesorder.getSalesorderdeliverydate() , // "salesorderdeliverydate" : java.util.Date
			salesorder.getSalesorderstatus() , // "salesorderstatus" : java.lang.String
			salesorder.getSalesorderdiscount() , // "salesorderdiscount" : java.lang.Double
			salesorder.getSalesorderbilling() , // "salesorderbilling" : java.lang.Double
			salesorder.getSalesorderpaying() , // "salesorderpaying" : java.lang.Double
			salesorder.getSalesorderincludetax() , // "salesorderincludetax" : java.lang.Boolean
			salesorder.getSalesordermoddate()  // "salesordermoddate" : java.util.Date
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Salesorder salesorder) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
			salesorder.getPaymentformid()==null?salesorder.getPaymentformid():UUID.fromString(salesorder.getPaymentformid()) , // "paymentformid" : java.lang.String
			salesorder.getSalesordercorrectionId()==null?salesorder.getSalesordercorrectionId():UUID.fromString(salesorder.getSalesordercorrectionId()) , // "salesordercorrection_id" : java.lang.String
			salesorder.getSalesorderUserid()==null?salesorder.getSalesorderUserid():UUID.fromString(salesorder.getSalesorderUserid()) , // "salesorder_userid" : java.lang.String
			salesorder.getSalesordercode(), // "salesordercode" : java.lang.String
			salesorder.getSalesorderdate(), // "salesorderdate" : java.util.Date
			salesorder.getSalesorderdeliverydate(), // "salesorderdeliverydate" : java.util.Date
			salesorder.getSalesorderstatus(), // "salesorderstatus" : java.lang.String
			salesorder.getSalesorderdiscount(), // "salesorderdiscount" : java.lang.Double
			salesorder.getSalesorderbilling(), // "salesorderbilling" : java.lang.Double
			salesorder.getSalesorderpaying(), // "salesorderpaying" : java.lang.Double
			salesorder.getSalesorderincludetax(), // "salesorderincludetax" : java.lang.Boolean
			salesorder.getSalesordermoddate(), // "salesordermoddate" : java.util.Date
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			UUID.fromString(salesorder.getSalesorderid())  // "salesorderid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Salesorder salesorder)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			salesorder.getSalesorderid()  // "salesorderid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Salesorder> getRowMapper(Salesorder o)  {
		//--- RowMapper to populate the given bean instance
		return new SalesorderRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Salesorder> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new SalesorderRowMapper() ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param salesorder
	 * @throws SQLException
	 */
	private Salesorder populateBean(ResultSet rs, Salesorder salesorder) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		salesorder.setSalesorderid(rs.getString("salesorderid")); // java.lang.String
		salesorder.setPaymentformid(rs.getString("paymentformid")); // java.lang.String
		salesorder.setSalesordercorrectionId(rs.getString("salesordercorrection_id")); // java.lang.String
		salesorder.setSalesorderUserid(rs.getString("salesorder_userid")); // java.lang.String
		salesorder.setSalesordercode(rs.getString("salesordercode")); // java.lang.String
		salesorder.setSalesorderdate(rs.getDate("salesorderdate")); // java.util.Date
		salesorder.setSalesorderdeliverydate(rs.getDate("salesorderdeliverydate")); // java.util.Date
		salesorder.setSalesorderstatus(rs.getString("salesorderstatus")); // java.lang.String
		salesorder.setSalesorderdiscount(rs.getDouble("salesorderdiscount")); // java.lang.Double
		if ( rs.wasNull() ) { salesorder.setSalesorderdiscount(null); }; // not primitive number => keep null value if any
		salesorder.setSalesorderbilling(rs.getDouble("salesorderbilling")); // java.lang.Double
		if ( rs.wasNull() ) { salesorder.setSalesorderbilling(null); }; // not primitive number => keep null value if any
		salesorder.setSalesorderpaying(rs.getDouble("salesorderpaying")); // java.lang.Double
		if ( rs.wasNull() ) { salesorder.setSalesorderpaying(null); }; // not primitive number => keep null value if any
		salesorder.setSalesorderincludetax(rs.getBoolean("salesorderincludetax")); // java.lang.Boolean
		salesorder.setSalesordermoddate(rs.getDate("salesordermoddate")); // java.util.Date
                return salesorder;
	}
        
    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param salesorder
	 * @throws SQLException
	 */
	private Salesorder populateBean(ResultSet rs) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
            Salesorder salesorder = new Salesorder();
		salesorder.setSalesorderid(rs.getString("salesorderid")); // java.lang.String
		salesorder.setPaymentformid(rs.getString("paymentformid")); // java.lang.String
		salesorder.setSalesordercorrectionId(rs.getString("salesordercorrection_id")); // java.lang.String
		salesorder.setSalesorderUserid(rs.getString("salesorder_userid")); // java.lang.String
		salesorder.setSalesordercode(rs.getString("salesordercode")); // java.lang.String
		salesorder.setSalesorderdate(rs.getDate("salesorderdate")); // java.util.Date
		salesorder.setSalesorderdeliverydate(rs.getDate("salesorderdeliverydate")); // java.util.Date
		salesorder.setSalesorderstatus(rs.getString("salesorderstatus")); // java.lang.String
		salesorder.setSalesorderdiscount(rs.getDouble("salesorderdiscount")); // java.lang.Double
		if ( rs.wasNull() ) { salesorder.setSalesorderdiscount(null); }; // not primitive number => keep null value if any
		salesorder.setSalesorderbilling(rs.getDouble("salesorderbilling")); // java.lang.Double
		if ( rs.wasNull() ) { salesorder.setSalesorderbilling(null); }; // not primitive number => keep null value if any
		salesorder.setSalesorderpaying(rs.getDouble("salesorderpaying")); // java.lang.Double
		if ( rs.wasNull() ) { salesorder.setSalesorderpaying(null); }; // not primitive number => keep null value if any
		salesorder.setSalesorderincludetax(rs.getBoolean("salesorderincludetax")); // java.lang.Boolean
		salesorder.setSalesordermoddate(rs.getDate("salesordermoddate")); // java.util.Date
                return salesorder;
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class SalesorderRowMapper implements RowMapper<Salesorder> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private Salesorder bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		SalesorderRowMapper(Salesorder bean) {
			this.bean = bean ;
		}
		
		public SalesorderRowMapper() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public Salesorder mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
		}
	}

	@Override
	public Salesorder findById(String salesorderid) {
		Object[] primaryKey = new Object[] { UUID.fromString(salesorderid) };
		return super.doSelect(primaryKey);
	}

	@Override
	public List<Salesorder> findAll() {
		return super.doSelectAll();
	}

	@Override
	public Salesorder save(Salesorder entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Salesorder update(Salesorder entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Salesorder create(Salesorder entity) {
		super.doInsert(entity);
		return entity;
	}

	@Override
	public void delete(String salesorderid) {
		Object[] primaryKey = new Object[] { salesorderid };
		super.doDelete(primaryKey);		
	}
}
