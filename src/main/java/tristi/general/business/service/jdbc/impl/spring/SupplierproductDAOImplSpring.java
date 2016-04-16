/*
 * Created on 10 Dec 2015
 *
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Supplierproduct;
import tristi.general.business.service.SupplierproductService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Supplierproduct DAO implementation 
 * 
 *
 */
@Repository
public class SupplierproductDAOImplSpring extends GenericDAO<Supplierproduct> implements SupplierproductService {

	private final static String SQL_SELECT_ALL_PAGING = 
		"select supplierproductid, supplierproduct_productid, supplierproduct_userid, supplierproduct_supplierid, supplierproductisactive, supplierproductmoddate from supplierproduct limit ? offset ?";

        private final static String SQL_SELECT_ALL = 
		"select supplierproductid, supplierproduct_productid, supplierproduct_userid, supplierproduct_supplierid, supplierproductisactive, supplierproductmoddate from supplierproduct";

        private final static String SQL_SELECT_PAGING = 
		"select supplierproductid, supplierproduct_productid, supplierproduct_userid, supplierproduct_supplierid, supplierproductisactive, supplierproductmoddate from supplierproduct where supplierproductid = ? limit ? offset ?";

        private final static String SQL_SELECT = 
		"select supplierproductid, supplierproduct_productid, supplierproduct_userid, supplierproduct_supplierid, supplierproductisactive, supplierproductmoddate from supplierproduct where supplierproductid = ?";

	private final static String SQL_INSERT = 
		"insert into supplierproduct ( supplierproduct_productid, supplierproduct_userid, supplierproduct_supplierid, supplierproductisactive, supplierproductmoddate ) values ( ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update supplierproduct set supplierproduct_productid = ?, supplierproduct_userid = ?, supplierproduct_supplierid = ?, supplierproductisactive = ?, supplierproductmoddate = ? where supplierproductid = ?";

	private final static String SQL_DELETE = 
		"delete from supplierproduct where supplierproductid = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from supplierproduct";

	private final static String SQL_COUNT = 
		"select count(*) from supplierproduct where supplierproductid = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public SupplierproductDAOImplSpring() {
		super();
	}

	@Override
	public boolean exists( String supplierproductid ) {
		Object[] primaryKey = new Object[] { supplierproductid };
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
	protected Object[] getValuesForInsert(Supplierproduct supplierproduct)  {
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//			supplierproduct.getSupplierproductid() , // "supplierproductid" : java.lang.String
			supplierproduct.getSupplierproductProductid()==null?supplierproduct.getSupplierproductProductid():UUID.fromString(supplierproduct.getSupplierproductProductid()) , // "supplierproduct_productid" : java.lang.String
			supplierproduct.getSupplierproductUserid()==null?supplierproduct.getSupplierproductUserid():UUID.fromString(supplierproduct.getSupplierproductUserid()) , // "supplierproduct_userid" : java.lang.String
			supplierproduct.getSupplierproductSupplierid()==null?supplierproduct.getSupplierproductSupplierid():UUID.fromString(supplierproduct.getSupplierproductSupplierid()) , // "supplierproduct_supplierid" : java.lang.String
			supplierproduct.getSupplierproductisactive() , // "supplierproductisactive" : java.lang.Boolean
			supplierproduct.getSupplierproductmoddate()  // "supplierproductmoddate" : java.util.Date
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Supplierproduct supplierproduct) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
			supplierproduct.getSupplierproductProductid()==null?supplierproduct.getSupplierproductProductid():UUID.fromString(supplierproduct.getSupplierproductProductid()) , // "supplierproduct_productid" : java.lang.String
			supplierproduct.getSupplierproductUserid()==null?supplierproduct.getSupplierproductUserid():UUID.fromString(supplierproduct.getSupplierproductUserid()) , // "supplierproduct_userid" : java.lang.String
			supplierproduct.getSupplierproductSupplierid()==null?supplierproduct.getSupplierproductSupplierid():UUID.fromString(supplierproduct.getSupplierproductSupplierid()) , // "supplierproduct_supplierid" : java.lang.String
			supplierproduct.getSupplierproductisactive(), // "supplierproductisactive" : java.lang.Boolean
			supplierproduct.getSupplierproductmoddate(), // "supplierproductmoddate" : java.util.Date
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			UUID.fromString(supplierproduct.getSupplierproductid())  // "supplierproductid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Supplierproduct supplierproduct)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			supplierproduct.getSupplierproductid()  // "supplierproductid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Supplierproduct> getRowMapper(Supplierproduct o)  {
		//--- RowMapper to populate the given bean instance
		return new SupplierproductRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Supplierproduct> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new SupplierproductRowMapper() ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param supplierproduct
	 * @throws SQLException
	 */
	private Supplierproduct populateBean(ResultSet rs, Supplierproduct supplierproduct) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		supplierproduct.setSupplierproductid(rs.getString("supplierproductid")); // java.lang.String
		supplierproduct.setSupplierproductProductid(rs.getString("supplierproduct_productid")); // java.lang.String
		supplierproduct.setSupplierproductUserid(rs.getString("supplierproduct_userid")); // java.lang.String
		supplierproduct.setSupplierproductSupplierid(rs.getString("supplierproduct_supplierid")); // java.lang.String
		supplierproduct.setSupplierproductisactive(rs.getBoolean("supplierproductisactive")); // java.lang.Boolean
		supplierproduct.setSupplierproductmoddate(rs.getDate("supplierproductmoddate")); // java.util.Date
                return supplierproduct;
	}
        
        //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param supplierproduct
	 * @throws SQLException
	 */
	private Supplierproduct populateBean(ResultSet rs) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
            Supplierproduct supplierproduct = new Supplierproduct();
		supplierproduct.setSupplierproductid(rs.getString("supplierproductid")); // java.lang.String
		supplierproduct.setSupplierproductProductid(rs.getString("supplierproduct_productid")); // java.lang.String
		supplierproduct.setSupplierproductUserid(rs.getString("supplierproduct_userid")); // java.lang.String
		supplierproduct.setSupplierproductSupplierid(rs.getString("supplierproduct_supplierid")); // java.lang.String
		supplierproduct.setSupplierproductisactive(rs.getBoolean("supplierproductisactive")); // java.lang.Boolean
		supplierproduct.setSupplierproductmoddate(rs.getDate("supplierproductmoddate")); // java.util.Date
                return supplierproduct;
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class SupplierproductRowMapper implements RowMapper<Supplierproduct> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private Supplierproduct bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		SupplierproductRowMapper(Supplierproduct bean) {
			this.bean = bean ;
		}
		
		public SupplierproductRowMapper() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public Supplierproduct mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
		}
	}

	@Override
	public Supplierproduct findById(String supplierproductid) {
		Object[] primaryKey = new Object[] { UUID.fromString(supplierproductid) };
		return super.doSelect(primaryKey);
	}

	@Override
	public List<Supplierproduct> findAll() {
		return super.doSelectAll();
	}

	@Override
	public Supplierproduct save(Supplierproduct entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Supplierproduct update(Supplierproduct entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Supplierproduct create(Supplierproduct entity) {
		super.doInsert(entity);
		return entity;
	}

	@Override
	public void delete(String supplierproductid) {
		Object[] primaryKey = new Object[] { supplierproductid };
		super.doDelete(primaryKey);	
	}
}
