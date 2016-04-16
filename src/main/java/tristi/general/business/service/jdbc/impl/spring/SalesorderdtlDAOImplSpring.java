/*
 * Created on 10 Dec 2015
 *
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Salesorderdtl;
import tristi.general.business.service.SalesorderdtlService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Salesorderdtl DAO implementation 
 * 
 *
 */
@Repository
public class SalesorderdtlDAOImplSpring extends GenericDAO<Salesorderdtl> implements SalesorderdtlService {

	private final static String SQL_SELECT_ALL_PAGING = 
		"select salesorderdtlid, salesorderid, detailexpiredid, userid, productuomid, salesorderdtlqty, salesorderdtlremainingqty, salesorderdtlprice, salesorderdtlbaseprice, salesorderdtldiscount, salesorderdtlstatus, salesorderdtlmoddate from salesorderdtl limit ? offset ?";

        private final static String SQL_SELECT_ALL = 
		"select salesorderdtlid, salesorderid, detailexpiredid, userid, productuomid, salesorderdtlqty, salesorderdtlremainingqty, salesorderdtlprice, salesorderdtlbaseprice, salesorderdtldiscount, salesorderdtlstatus, salesorderdtlmoddate from salesorderdtl";

        private final static String SQL_SELECT_PAGING = 
		"select salesorderdtlid, salesorderid, detailexpiredid, userid, productuomid, salesorderdtlqty, salesorderdtlremainingqty, salesorderdtlprice, salesorderdtlbaseprice, salesorderdtldiscount, salesorderdtlstatus, salesorderdtlmoddate from salesorderdtl where salesorderdtlid = ? limit ? offset ?";

        private final static String SQL_SELECT = 
		"select salesorderdtlid, salesorderid, detailexpiredid, userid, productuomid, salesorderdtlqty, salesorderdtlremainingqty, salesorderdtlprice, salesorderdtlbaseprice, salesorderdtldiscount, salesorderdtlstatus, salesorderdtlmoddate from salesorderdtl where salesorderdtlid = ?";


	private final static String SQL_INSERT = 
		"insert into salesorderdtl ( salesorderid, detailexpiredid, userid, productuomid, salesorderdtlqty, salesorderdtlremainingqty, salesorderdtlprice, salesorderdtlbaseprice, salesorderdtldiscount, salesorderdtlstatus, salesorderdtlmoddate ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update salesorderdtl set salesorderid = ?, detailexpiredid = ?, userid = ?, productuomid = ?, salesorderdtlqty = ?, salesorderdtlremainingqty = ?, salesorderdtlprice = ?, salesorderdtlbaseprice = ?, salesorderdtldiscount = ?, salesorderdtlstatus = ?, salesorderdtlmoddate = ? where salesorderdtlid = ?";

	private final static String SQL_DELETE = 
		"delete from salesorderdtl where salesorderdtlid = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from salesorderdtl";

	private final static String SQL_COUNT = 
		"select count(*) from salesorderdtl where salesorderdtlid = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public SalesorderdtlDAOImplSpring() {
		super();
	}

	@Override
	public boolean exists( String salesorderdtlid ) {
		Object[] primaryKey = new Object[] { salesorderdtlid };
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
	protected Object[] getValuesForInsert(Salesorderdtl salesorderdtl)  {
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//			salesorderdtl.getSalesorderdtlid() , // "salesorderdtlid" : java.lang.String
			salesorderdtl.getSalesorderid()==null?salesorderdtl.getSalesorderid():UUID.fromString(salesorderdtl.getSalesorderid()) , // "salesorderid" : java.lang.String
			salesorderdtl.getDetailexpiredid()==null?salesorderdtl.getDetailexpiredid():UUID.fromString(salesorderdtl.getDetailexpiredid()) , // "detailexpiredid" : java.lang.String
			salesorderdtl.getUserid()==null?salesorderdtl.getUserid():UUID.fromString(salesorderdtl.getUserid()) , // "userid" : java.lang.String
			salesorderdtl.getProductuomid()==null?salesorderdtl.getProductuomid():UUID.fromString(salesorderdtl.getProductuomid()) , // "productuomid" : java.lang.String
			salesorderdtl.getSalesorderdtlqty() , // "salesorderdtlqty" : java.lang.Integer
			salesorderdtl.getSalesorderdtlremainingqty() , // "salesorderdtlremainingqty" : java.lang.Integer
			salesorderdtl.getSalesorderdtlprice() , // "salesorderdtlprice" : java.lang.Double
			salesorderdtl.getSalesorderdtlbaseprice() , // "salesorderdtlbaseprice" : java.lang.Double
			salesorderdtl.getSalesorderdtldiscount() , // "salesorderdtldiscount" : java.lang.Double
			salesorderdtl.getSalesorderdtlstatus() , // "salesorderdtlstatus" : java.lang.String
			salesorderdtl.getSalesorderdtlmoddate()  // "salesorderdtlmoddate" : java.util.Date
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Salesorderdtl salesorderdtl) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
			salesorderdtl.getSalesorderid()==null?salesorderdtl.getSalesorderid():UUID.fromString(salesorderdtl.getSalesorderid()) , // "salesorderid" : java.lang.String
			salesorderdtl.getDetailexpiredid()==null?salesorderdtl.getDetailexpiredid():UUID.fromString(salesorderdtl.getDetailexpiredid()) , // "detailexpiredid" : java.lang.String
			salesorderdtl.getUserid()==null?salesorderdtl.getUserid():UUID.fromString(salesorderdtl.getUserid()) , // "userid" : java.lang.String
			salesorderdtl.getProductuomid()==null?salesorderdtl.getProductuomid():UUID.fromString(salesorderdtl.getProductuomid()) , // "productuomid" : java.lang.String
			salesorderdtl.getSalesorderdtlqty(), // "salesorderdtlqty" : java.lang.Integer
			salesorderdtl.getSalesorderdtlremainingqty(), // "salesorderdtlremainingqty" : java.lang.Integer
			salesorderdtl.getSalesorderdtlprice(), // "salesorderdtlprice" : java.lang.Double
			salesorderdtl.getSalesorderdtlbaseprice(), // "salesorderdtlbaseprice" : java.lang.Double
			salesorderdtl.getSalesorderdtldiscount(), // "salesorderdtldiscount" : java.lang.Double
			salesorderdtl.getSalesorderdtlstatus(), // "salesorderdtlstatus" : java.lang.String
			salesorderdtl.getSalesorderdtlmoddate(), // "salesorderdtlmoddate" : java.util.Date
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			UUID.fromString(salesorderdtl.getSalesorderdtlid())  // "salesorderdtlid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Salesorderdtl salesorderdtl)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			salesorderdtl.getSalesorderdtlid()  // "salesorderdtlid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Salesorderdtl> getRowMapper(Salesorderdtl o)  {
		//--- RowMapper to populate the given bean instance
		return new SalesorderdtlRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Salesorderdtl> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new SalesorderdtlRowMapper() ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param salesorderdtl
	 * @throws SQLException
	 */
	private Salesorderdtl populateBean(ResultSet rs, Salesorderdtl salesorderdtl) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		salesorderdtl.setSalesorderdtlid(rs.getString("salesorderdtlid")); // java.lang.String
		salesorderdtl.setSalesorderid(rs.getString("salesorderid")); // java.lang.String
		salesorderdtl.setDetailexpiredid(rs.getString("detailexpiredid")); // java.lang.String
		salesorderdtl.setUserid(rs.getString("userid")); // java.lang.String
		salesorderdtl.setProductuomid(rs.getString("productuomid")); // java.lang.String
		salesorderdtl.setSalesorderdtlqty(rs.getInt("salesorderdtlqty")); // java.lang.Integer
		if ( rs.wasNull() ) { salesorderdtl.setSalesorderdtlqty(null); }; // not primitive number => keep null value if any
		salesorderdtl.setSalesorderdtlremainingqty(rs.getInt("salesorderdtlremainingqty")); // java.lang.Integer
		if ( rs.wasNull() ) { salesorderdtl.setSalesorderdtlremainingqty(null); }; // not primitive number => keep null value if any
		salesorderdtl.setSalesorderdtlprice(rs.getDouble("salesorderdtlprice")); // java.lang.Double
		if ( rs.wasNull() ) { salesorderdtl.setSalesorderdtlprice(null); }; // not primitive number => keep null value if any
		salesorderdtl.setSalesorderdtlbaseprice(rs.getDouble("salesorderdtlbaseprice")); // java.lang.Double
		if ( rs.wasNull() ) { salesorderdtl.setSalesorderdtlbaseprice(null); }; // not primitive number => keep null value if any
		salesorderdtl.setSalesorderdtldiscount(rs.getDouble("salesorderdtldiscount")); // java.lang.Double
		if ( rs.wasNull() ) { salesorderdtl.setSalesorderdtldiscount(null); }; // not primitive number => keep null value if any
		salesorderdtl.setSalesorderdtlstatus(rs.getString("salesorderdtlstatus")); // java.lang.String
		salesorderdtl.setSalesorderdtlmoddate(rs.getDate("salesorderdtlmoddate")); // java.util.Date
                return salesorderdtl;
	}
        
    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param salesorderdtl
	 * @throws SQLException
	 */
	private Salesorderdtl populateBean(ResultSet rs) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
            Salesorderdtl salesorderdtl = new Salesorderdtl();
		salesorderdtl.setSalesorderdtlid(rs.getString("salesorderdtlid")); // java.lang.String
		salesorderdtl.setSalesorderid(rs.getString("salesorderid")); // java.lang.String
		salesorderdtl.setDetailexpiredid(rs.getString("detailexpiredid")); // java.lang.String
		salesorderdtl.setUserid(rs.getString("userid")); // java.lang.String
		salesorderdtl.setProductuomid(rs.getString("productuomid")); // java.lang.String
		salesorderdtl.setSalesorderdtlqty(rs.getInt("salesorderdtlqty")); // java.lang.Integer
		if ( rs.wasNull() ) { salesorderdtl.setSalesorderdtlqty(null); }; // not primitive number => keep null value if any
		salesorderdtl.setSalesorderdtlremainingqty(rs.getInt("salesorderdtlremainingqty")); // java.lang.Integer
		if ( rs.wasNull() ) { salesorderdtl.setSalesorderdtlremainingqty(null); }; // not primitive number => keep null value if any
		salesorderdtl.setSalesorderdtlprice(rs.getDouble("salesorderdtlprice")); // java.lang.Double
		if ( rs.wasNull() ) { salesorderdtl.setSalesorderdtlprice(null); }; // not primitive number => keep null value if any
		salesorderdtl.setSalesorderdtlbaseprice(rs.getDouble("salesorderdtlbaseprice")); // java.lang.Double
		if ( rs.wasNull() ) { salesorderdtl.setSalesorderdtlbaseprice(null); }; // not primitive number => keep null value if any
		salesorderdtl.setSalesorderdtldiscount(rs.getDouble("salesorderdtldiscount")); // java.lang.Double
		if ( rs.wasNull() ) { salesorderdtl.setSalesorderdtldiscount(null); }; // not primitive number => keep null value if any
		salesorderdtl.setSalesorderdtlstatus(rs.getString("salesorderdtlstatus")); // java.lang.String
		salesorderdtl.setSalesorderdtlmoddate(rs.getDate("salesorderdtlmoddate")); // java.util.Date
                return salesorderdtl;
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class SalesorderdtlRowMapper implements RowMapper<Salesorderdtl> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private Salesorderdtl bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		SalesorderdtlRowMapper(Salesorderdtl bean) {
			this.bean = bean ;
		}
		
		SalesorderdtlRowMapper() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public Salesorderdtl mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
		}
	}

	@Override
	public Salesorderdtl findById(String salesorderdtlid) {
		Object[] primaryKey = new Object[] { UUID.fromString(salesorderdtlid) };
		return super.doSelect(primaryKey);	
	}

	@Override
	public List<Salesorderdtl> findAll() {
		return super.doSelectAll();
	}

	@Override
	public Salesorderdtl save(Salesorderdtl entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Salesorderdtl update(Salesorderdtl entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Salesorderdtl create(Salesorderdtl entity) {
		super.doInsert(entity);
		return entity;
	}

	@Override
	public void delete(String salesorderdtlid) {
		Object[] primaryKey = new Object[] { salesorderdtlid };
		super.doDelete(primaryKey);	
	}
}
