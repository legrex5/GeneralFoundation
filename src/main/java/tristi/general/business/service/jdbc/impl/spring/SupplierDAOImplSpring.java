/*
 * Created on 10 Dec 2015
 *
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Supplier;
import tristi.general.business.service.SupplierService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Supplier DAO implementation 
 * 
 *
 */
@Repository
public class SupplierDAOImplSpring extends GenericDAO<Supplier> implements SupplierService {

	private final static String SQL_SELECT_ALL_PAGING = 
		"select supplierid, supplier_userid, suppliercode, suppliername, supplieraddres, suppliercity, supplierphone1, supplierphone2, supplierfax1, supplierfax2, supplierisactive, suppliermoddate from supplier limit ? offset ?";

        private final static String SQL_SELECT_ALL = 
		"select supplierid, supplier_userid, suppliercode, suppliername, supplieraddres, suppliercity, supplierphone1, supplierphone2, supplierfax1, supplierfax2, supplierisactive, suppliermoddate from supplier";

        private final static String SQL_SELECT_PAGING = 
		"select supplierid, supplier_userid, suppliercode, suppliername, supplieraddres, suppliercity, supplierphone1, supplierphone2, supplierfax1, supplierfax2, supplierisactive, suppliermoddate from supplier where supplierid = ? limit ? offset ?";

        private final static String SQL_SELECT = 
		"select supplierid, supplier_userid, suppliercode, suppliername, supplieraddres, suppliercity, supplierphone1, supplierphone2, supplierfax1, supplierfax2, supplierisactive, suppliermoddate from supplier where supplierid = ?";


	private final static String SQL_INSERT = 
		"insert into supplier ( supplier_userid, suppliercode, suppliername, supplieraddres, suppliercity, supplierphone1, supplierphone2, supplierfax1, supplierfax2, supplierisactive, suppliermoddate ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update supplier set supplier_userid = ?, suppliercode = ?, suppliername = ?, supplieraddres = ?, suppliercity = ?, supplierphone1 = ?, supplierphone2 = ?, supplierfax1 = ?, supplierfax2 = ?, supplierisactive = ?, suppliermoddate = ? where supplierid = ?";

	private final static String SQL_DELETE = 
		"delete from supplier where supplierid = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from supplier";

	private final static String SQL_COUNT = 
		"select count(*) from supplier where supplierid = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public SupplierDAOImplSpring() {
		super();
	}

	@Override
	public boolean exists( String supplierid ) {
		Object[] primaryKey = new Object[] { supplierid };
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
	protected Object[] getValuesForInsert(Supplier supplier)  {
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//			supplier.getSupplierid() , // "supplierid" : java.lang.String
			supplier.getSupplierUserid()==null?supplier.getSupplierUserid():UUID.fromString(supplier.getSupplierUserid()) , // "supplier_userid" : java.lang.String
			supplier.getSuppliercode() , // "suppliercode" : java.lang.String
			supplier.getSuppliername() , // "suppliername" : java.lang.String
			supplier.getSupplieraddres() , // "supplieraddres" : java.lang.String
			supplier.getSuppliercity() , // "suppliercity" : java.lang.String
			supplier.getSupplierphone1() , // "supplierphone1" : java.lang.String
			supplier.getSupplierphone2() , // "supplierphone2" : java.lang.String
			supplier.getSupplierfax1() , // "supplierfax1" : java.lang.String
			supplier.getSupplierfax2() , // "supplierfax2" : java.lang.String
			supplier.getSupplierisactive() , // "supplierisactive" : java.lang.Boolean
			supplier.getSuppliermoddate()  // "suppliermoddate" : java.util.Date
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Supplier supplier) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
			supplier.getSupplierUserid()==null?supplier.getSupplierUserid():UUID.fromString(supplier.getSupplierUserid()) , // "supplier_userid" : java.lang.String
			supplier.getSuppliercode(), // "suppliercode" : java.lang.String
			supplier.getSuppliername(), // "suppliername" : java.lang.String
			supplier.getSupplieraddres(), // "supplieraddres" : java.lang.String
			supplier.getSuppliercity(), // "suppliercity" : java.lang.String
			supplier.getSupplierphone1(), // "supplierphone1" : java.lang.String
			supplier.getSupplierphone2(), // "supplierphone2" : java.lang.String
			supplier.getSupplierfax1(), // "supplierfax1" : java.lang.String
			supplier.getSupplierfax2(), // "supplierfax2" : java.lang.String
			supplier.getSupplierisactive(), // "supplierisactive" : java.lang.Boolean
			supplier.getSuppliermoddate(), // "suppliermoddate" : java.util.Date
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			UUID.fromString(supplier.getSupplierid()) // "supplierid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Supplier supplier)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			supplier.getSupplierid()  // "supplierid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Supplier> getRowMapper(Supplier o)  {
		//--- RowMapper to populate the given bean instance
		return new SupplierRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Supplier> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new SupplierRowMapper() ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param supplier
	 * @throws SQLException
	 */
	private Supplier populateBean(ResultSet rs, Supplier supplier) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		supplier.setSupplierid(rs.getString("supplierid")); // java.lang.String
		supplier.setSupplierUserid(rs.getString("supplier_userid")); // java.lang.String
		supplier.setSuppliercode(rs.getString("suppliercode")); // java.lang.String
		supplier.setSuppliername(rs.getString("suppliername")); // java.lang.String
		supplier.setSupplieraddres(rs.getString("supplieraddres")); // java.lang.String
		supplier.setSuppliercity(rs.getString("suppliercity")); // java.lang.String
		supplier.setSupplierphone1(rs.getString("supplierphone1")); // java.lang.String
		supplier.setSupplierphone2(rs.getString("supplierphone2")); // java.lang.String
		supplier.setSupplierfax1(rs.getString("supplierfax1")); // java.lang.String
		supplier.setSupplierfax2(rs.getString("supplierfax2")); // java.lang.String
		supplier.setSupplierisactive(rs.getBoolean("supplierisactive")); // java.lang.Boolean
		supplier.setSuppliermoddate(rs.getDate("suppliermoddate")); // java.util.Date
		return supplier;
	}
	
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param supplier
	 * @throws SQLException
	 */
	private Supplier populateBean(ResultSet rs) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		Supplier supplier = new Supplier();
		supplier.setSupplierid(rs.getString("supplierid")); // java.lang.String
		supplier.setSupplierUserid(rs.getString("supplier_userid")); // java.lang.String
		supplier.setSuppliercode(rs.getString("suppliercode")); // java.lang.String
		supplier.setSuppliername(rs.getString("suppliername")); // java.lang.String
		supplier.setSupplieraddres(rs.getString("supplieraddres")); // java.lang.String
		supplier.setSuppliercity(rs.getString("suppliercity")); // java.lang.String
		supplier.setSupplierphone1(rs.getString("supplierphone1")); // java.lang.String
		supplier.setSupplierphone2(rs.getString("supplierphone2")); // java.lang.String
		supplier.setSupplierfax1(rs.getString("supplierfax1")); // java.lang.String
		supplier.setSupplierfax2(rs.getString("supplierfax2")); // java.lang.String
		supplier.setSupplierisactive(rs.getBoolean("supplierisactive")); // java.lang.Boolean
		supplier.setSuppliermoddate(rs.getDate("suppliermoddate")); // java.util.Date
		return supplier;
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class SupplierRowMapper implements RowMapper<Supplier> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private Supplier bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		SupplierRowMapper(Supplier bean) {
			this.bean = bean ;
		}
		
		public SupplierRowMapper() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public Supplier mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
		}
	}

	@Override
	public Supplier findById(String supplierid) {
		Object[] primaryKey = new Object[] { UUID.fromString(supplierid) };
		return super.doSelect(primaryKey);	
	}

	@Override
	public List<Supplier> findAll() {
		return super.doSelectAll();
	}

	@Override
	public Supplier save(Supplier entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Supplier update(Supplier entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Supplier create(Supplier entity) {
		super.doInsert(entity);
		return entity;
	}

	@Override
	public void delete(String supplierid) {
		Object[] primaryKey = new Object[] { supplierid };
		super.doDelete(primaryKey);
	}
}
