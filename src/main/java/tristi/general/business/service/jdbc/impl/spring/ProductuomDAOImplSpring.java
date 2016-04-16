/*
 * Created on 10 Dec 2015
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Productuom;
import tristi.general.business.service.ProductuomService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Productuom DAO implementation 
 * 
 * @author Telosys Tools
 *
 */
@Repository
public class ProductuomDAOImplSpring extends GenericDAO<Productuom> implements ProductuomService {

	private final static String SQL_SELECT_ALL_PAGING = 
		"select productuomid, userid, productid, uomid, productuomvalue, productuomissalesunit, productuomisstockunit, productuomisbaseunit, productuomsequence, productuomisactive, productuommoddate from productuom limit ? offset ?";

        private final static String SQL_SELECT_ALL = 
		"select productuomid, userid, productid, uomid, productuomvalue, productuomissalesunit, productuomisstockunit, productuomisbaseunit, productuomsequence, productuomisactive, productuommoddate from productuom";

        private final static String SQL_SELECT_PAGING = 
		"select productuomid, userid, productid, uomid, productuomvalue, productuomissalesunit, productuomisstockunit, productuomisbaseunit, productuomsequence, productuomisactive, productuommoddate from productuom where productuomid = ? limit ? offset ?";

        private final static String SQL_SELECT = 
		"select productuomid, userid, productid, uomid, productuomvalue, productuomissalesunit, productuomisstockunit, productuomisbaseunit, productuomsequence, productuomisactive, productuommoddate from productuom where productuomid = ?";

	private final static String SQL_INSERT = 
		"insert into productuom ( userid, productid, uomid, productuomvalue, productuomissalesunit, productuomisstockunit, productuomisbaseunit, productuomsequence, productuomisactive, productuommoddate ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update productuom set userid = ?, productid = ?, uomid = ?, productuomvalue = ?, productuomissalesunit = ?, productuomisstockunit = ?, productuomisbaseunit = ?, productuomsequence = ?, productuomisactive = ?, productuommoddate = ? where productuomid = ?";

	private final static String SQL_DELETE = 
		"delete from productuom where productuomid = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from productuom";

	private final static String SQL_COUNT = 
		"select count(*) from productuom where productuomid = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public ProductuomDAOImplSpring() {
		super();
	}

	@Override
	public boolean exists( String productuomid ) {
		Object[] primaryKey = new Object[] { productuomid };
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
	protected Object[] getValuesForInsert(Productuom productuom)  {
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//			productuom.getProductuomid() , // "productuomid" : java.lang.String
			productuom.getUserid()==null?productuom.getUserid():UUID.fromString(productuom.getUserid()) , // "userid" : java.lang.String
			productuom.getProductid()==null?productuom.getProductid():UUID.fromString(productuom.getProductid()) , // "productid" : java.lang.String
			productuom.getUomid()==null?productuom.getUomid():UUID.fromString(productuom.getUomid()) , // "uomid" : java.lang.String
			productuom.getProductuomvalue() , // "productuomvalue" : java.lang.Double
			productuom.getProductuomissalesunit() , // "productuomissalesunit" : java.lang.Double
			productuom.getProductuomisstockunit() , // "productuomisstockunit" : java.lang.Double
			productuom.getProductuomisbaseunit() , // "productuomisbaseunit" : java.lang.Double
			productuom.getProductuomsequence() , // "productuomsequence" : java.lang.Integer
			productuom.getProductuomisactive() , // "productuomisactive" : java.lang.Boolean
			productuom.getProductuommoddate()  // "productuommoddate" : java.util.Date
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Productuom productuom) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
			productuom.getUserid()==null?productuom.getUserid():UUID.fromString(productuom.getUserid()) , // "userid" : java.lang.String
			productuom.getProductid()==null?productuom.getProductid():UUID.fromString(productuom.getProductid()) , // "productid" : java.lang.String
			productuom.getUomid()==null?productuom.getUomid():UUID.fromString(productuom.getUomid()) , // "uomid" : java.lang.String
			productuom.getProductuomvalue(), // "productuomvalue" : java.lang.Double
			productuom.getProductuomissalesunit(), // "productuomissalesunit" : java.lang.Double
			productuom.getProductuomisstockunit(), // "productuomisstockunit" : java.lang.Double
			productuom.getProductuomisbaseunit(), // "productuomisbaseunit" : java.lang.Double
			productuom.getProductuomsequence(), // "productuomsequence" : java.lang.Integer
			productuom.getProductuomisactive(), // "productuomisactive" : java.lang.Boolean
			productuom.getProductuommoddate(), // "productuommoddate" : java.util.Date
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			UUID.fromString(productuom.getProductuomid())  // "productuomid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Productuom productuom)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			productuom.getProductuomid()  // "productuomid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Productuom> getRowMapper(Productuom o)  {
		//--- RowMapper to populate the given bean instance
		return new ProductuomRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Productuom> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new ProductuomRowMapper() ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param productuom
	 * @throws SQLException
	 */
	private Productuom populateBean(ResultSet rs, Productuom productuom) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		productuom.setProductuomid(rs.getString("productuomid")); // java.lang.String
		productuom.setUserid(rs.getString("userid")); // java.lang.String
		productuom.setProductid(rs.getString("productid")); // java.lang.String
		productuom.setUomid(rs.getString("uomid")); // java.lang.String
		productuom.setProductuomvalue(rs.getDouble("productuomvalue")); // java.lang.Double
		if ( rs.wasNull() ) { productuom.setProductuomvalue(null); }; // not primitive number => keep null value if any
		productuom.setProductuomissalesunit(rs.getDouble("productuomissalesunit")); // java.lang.Double
		if ( rs.wasNull() ) { productuom.setProductuomissalesunit(null); }; // not primitive number => keep null value if any
		productuom.setProductuomisstockunit(rs.getDouble("productuomisstockunit")); // java.lang.Double
		if ( rs.wasNull() ) { productuom.setProductuomisstockunit(null); }; // not primitive number => keep null value if any
		productuom.setProductuomisbaseunit(rs.getDouble("productuomisbaseunit")); // java.lang.Double
		if ( rs.wasNull() ) { productuom.setProductuomisbaseunit(null); }; // not primitive number => keep null value if any
		productuom.setProductuomsequence(rs.getInt("productuomsequence")); // java.lang.Integer
		if ( rs.wasNull() ) { productuom.setProductuomsequence(null); }; // not primitive number => keep null value if any
		productuom.setProductuomisactive(rs.getBoolean("productuomisactive")); // java.lang.Boolean
		productuom.setProductuommoddate(rs.getDate("productuommoddate")); // java.util.Date
                return productuom;
	}
        
        //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param productuom
	 * @throws SQLException
	 */
	private Productuom populateBean(ResultSet rs) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
            Productuom productuom = new Productuom();
		productuom.setProductuomid(rs.getString("productuomid")); // java.lang.String
		productuom.setUserid(rs.getString("userid")); // java.lang.String
		productuom.setProductid(rs.getString("productid")); // java.lang.String
		productuom.setUomid(rs.getString("uomid")); // java.lang.String
		productuom.setProductuomvalue(rs.getDouble("productuomvalue")); // java.lang.Double
		if ( rs.wasNull() ) { productuom.setProductuomvalue(null); }; // not primitive number => keep null value if any
		productuom.setProductuomissalesunit(rs.getDouble("productuomissalesunit")); // java.lang.Double
		if ( rs.wasNull() ) { productuom.setProductuomissalesunit(null); }; // not primitive number => keep null value if any
		productuom.setProductuomisstockunit(rs.getDouble("productuomisstockunit")); // java.lang.Double
		if ( rs.wasNull() ) { productuom.setProductuomisstockunit(null); }; // not primitive number => keep null value if any
		productuom.setProductuomisbaseunit(rs.getDouble("productuomisbaseunit")); // java.lang.Double
		if ( rs.wasNull() ) { productuom.setProductuomisbaseunit(null); }; // not primitive number => keep null value if any
		productuom.setProductuomsequence(rs.getInt("productuomsequence")); // java.lang.Integer
		if ( rs.wasNull() ) { productuom.setProductuomsequence(null); }; // not primitive number => keep null value if any
		productuom.setProductuomisactive(rs.getBoolean("productuomisactive")); // java.lang.Boolean
		productuom.setProductuommoddate(rs.getDate("productuommoddate")); // java.util.Date
                return productuom;
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class ProductuomRowMapper implements RowMapper<Productuom> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private Productuom bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		ProductuomRowMapper(Productuom bean) {
			this.bean = bean ;
		}
		
		public ProductuomRowMapper() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public Productuom mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
		}
	}

	@Override
	public Productuom findById(String productuomid) {
		Object[] primaryKey = new Object[] { UUID.fromString(productuomid) };
		return super.doSelect(primaryKey);
	}

	@Override
	public List<Productuom> findAll() {
		return super.doSelectAll();
	}

	@Override
	public Productuom save(Productuom entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Productuom update(Productuom entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Productuom create(Productuom entity) {
		super.doInsert(entity);
		return entity;
	}

	@Override
	public void delete(String productuomid) {
		Object[] primaryKey = new Object[] { productuomid };
		super.doDelete(primaryKey);	
	}
}
