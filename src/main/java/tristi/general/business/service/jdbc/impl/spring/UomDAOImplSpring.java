/*
 * Created on 10 Dec 2015 ( Time 04:32:01 )
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Uom;
import tristi.general.business.service.UomService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Uom DAO implementation 
 * 
 *
 */
@Repository
public class UomDAOImplSpring extends GenericDAO<Uom> implements UomService {

	private final static String SQL_SELECT_ALL_PAGING = 
		"select uomid, uom_userid, uomcode, uomdescription, uomisactive, uommoddate from uom limit ? offset ?";
        
        private final static String SQL_SELECT_ALL = 
		"select uomid, uom_userid, uomcode, uomdescription, uomisactive, uommoddate from uom";
        
        private final static String SQL_SELECT_PAGING = 
		"select uomid, uom_userid, uomcode, uomdescription, uomisactive, uommoddate from uom where uomid = ? limit ? offset ?";
        
        private final static String SQL_SELECT = 
		"select uomid, uom_userid, uomcode, uomdescription, uomisactive, uommoddate from uom where uomid = ?";

	private final static String SQL_INSERT = 
		"insert into uom ( uom_userid, uomcode, uomdescription, uomisactive, uommoddate ) values ( ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update uom set uom_userid = ?, uomcode = ?, uomdescription = ?, uomisactive = ?, uommoddate = ? where uomid = ?";

	private final static String SQL_DELETE = 
		"delete from uom where uomid = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from uom";

	private final static String SQL_COUNT = 
		"select count(*) from uom where uomid = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public UomDAOImplSpring() {
		super();
	}

	@Override
	public boolean exists( String uomid ) {
		Object[] primaryKey = new Object[] { uomid };
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
	protected Object[] getValuesForInsert(Uom uom)  {
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//			uom.getUomid() , // "uomid" : java.lang.String
				uom.getUomUserid()==null?uom.getUomUserid():UUID.fromString(uom.getUomUserid()), // "uom_userid" : java.lang.String
			uom.getUomcode() , // "uomcode" : java.lang.String
			uom.getUomdescription() , // "uomdescription" : java.lang.String
			uom.getUomisactive() , // "uomisactive" : java.lang.Boolean
			uom.getUommoddate()  // "uommoddate" : java.util.Date
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Uom uom) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
			uom.getUomUserid()==null?uom.getUomUserid():UUID.fromString(uom.getUomUserid()), // "uom_userid" : java.lang.String
			uom.getUomcode(), // "uomcode" : java.lang.String
			uom.getUomdescription(), // "uomdescription" : java.lang.String
			uom.getUomisactive(), // "uomisactive" : java.lang.Boolean
			uom.getUommoddate(), // "uommoddate" : java.util.Date
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			UUID.fromString(uom.getUomid())  // "uomid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Uom uom)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			uom.getUomid()  // "uomid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Uom> getRowMapper(Uom o)  {
		//--- RowMapper to populate the given bean instance
		return new UomRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Uom> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new UomRowMapper() ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param uom
	 * @throws SQLException
	 */
	private Uom populateBean(ResultSet rs, Uom uom) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		uom.setUomid(rs.getString("uomid")); // java.lang.String
		uom.setUomUserid(rs.getString("uom_userid")); // java.lang.String
		uom.setUomcode(rs.getString("uomcode")); // java.lang.String
		uom.setUomdescription(rs.getString("uomdescription")); // java.lang.String
		uom.setUomisactive(rs.getBoolean("uomisactive")); // java.lang.Boolean
		uom.setUommoddate(rs.getDate("uommoddate")); // java.util.Date
                return uom;
	}
        
    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param uom
	 * @throws SQLException
	 */
	private Uom populateBean(ResultSet rs) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
            Uom uom = new Uom();
		uom.setUomid(rs.getString("uomid")); // java.lang.String
		uom.setUomUserid(rs.getString("uom_userid")); // java.lang.String
		uom.setUomcode(rs.getString("uomcode")); // java.lang.String
		uom.setUomdescription(rs.getString("uomdescription")); // java.lang.String
		uom.setUomisactive(rs.getBoolean("uomisactive")); // java.lang.Boolean
		uom.setUommoddate(rs.getDate("uommoddate")); // java.util.Date
                return uom;
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class UomRowMapper implements RowMapper<Uom> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private Uom bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		UomRowMapper(Uom bean) {
			this.bean = bean ;
		}
		
		public UomRowMapper() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public Uom mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
		}
	}

	@Override
	public Uom findById(String uomid) {
		Object[] primaryKey = new Object[] { UUID.fromString(uomid) };
		return super.doSelect(primaryKey);
	}

	@Override
	public List<Uom> findAll() {
		return super.doSelectAll();
	}

	@Override
	public Uom save(Uom entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Uom update(Uom entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Uom create(Uom entity) {
		super.doInsert(entity);
		return entity;
	}

	@Override
	public void delete(String uomid) {
		Object[] primaryKey = new Object[] { uomid };
		super.doDelete(primaryKey);
	}
}
