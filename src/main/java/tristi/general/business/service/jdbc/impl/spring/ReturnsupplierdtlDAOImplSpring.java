/*
 * Created on 10 Dec 2015
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Returnsupplierdtl;
import tristi.general.business.service.ReturnsupplierdtlService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Returnsupplierdtl DAO implementation 
 * 
 * @author Telosys Tools
 *
 */
@Repository
public class ReturnsupplierdtlDAOImplSpring extends GenericDAO<Returnsupplierdtl> implements ReturnsupplierdtlService {

	private final static String SQL_SELECT_ALL_PAGING = 
		"select returndtlid, returndtl_returnsupplierid, returndtl_productuomid, returndtl_userid, returndtl_detailexpiredid, returndtlqty, returndtlprice, returnrdtlmoddate from returnsupplierdtl limit ? offset ?";

        private final static String SQL_SELECT_ALL = 
		"select returndtlid, returndtl_returnsupplierid, returndtl_productuomid, returndtl_userid, returndtl_detailexpiredid, returndtlqty, returndtlprice, returnrdtlmoddate from returnsupplierdtl";

        private final static String SQL_SELECT_PAGING = 
		"select returndtlid, returndtl_returnsupplierid, returndtl_productuomid, returndtl_userid, returndtl_detailexpiredid, returndtlqty, returndtlprice, returnrdtlmoddate from returnsupplierdtl where returndtlid = ? limit ? offset ?";

        private final static String SQL_SELECT = 
		"select returndtlid, returndtl_returnsupplierid, returndtl_productuomid, returndtl_userid, returndtl_detailexpiredid, returndtlqty, returndtlprice, returnrdtlmoddate from returnsupplierdtl where returndtlid = ?";

	private final static String SQL_INSERT = 
		"insert into returnsupplierdtl ( returndtl_returnsupplierid, returndtl_productuomid, returndtl_userid, returndtl_detailexpiredid, returndtlqty, returndtlprice, returnrdtlmoddate ) values ( ?, ?, ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update returnsupplierdtl set returndtl_returnsupplierid = ?, returndtl_productuomid = ?, returndtl_userid = ?, returndtl_detailexpiredid = ?, returndtlqty = ?, returndtlprice = ?, returnrdtlmoddate = ? where returndtlid = ?";

	private final static String SQL_DELETE = 
		"delete from returnsupplierdtl where returndtlid = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from returnsupplierdtl";

	private final static String SQL_COUNT = 
		"select count(*) from returnsupplierdtl where returndtlid = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public ReturnsupplierdtlDAOImplSpring() {
		super();
	}

	@Override
	public boolean exists( String returndtlid ) {
		Object[] primaryKey = new Object[] { returndtlid };
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
	protected Object[] getValuesForInsert(Returnsupplierdtl returnsupplierdtl)  {
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//			returnsupplierdtl.getReturndtlid() , // "returndtlid" : java.lang.String
			returnsupplierdtl.getReturndtlReturnsupplierid()==null?returnsupplierdtl.getReturndtlReturnsupplierid():UUID.fromString(returnsupplierdtl.getReturndtlReturnsupplierid()) , // "returndtl_returnsupplierid" : java.lang.String
			returnsupplierdtl.getReturndtlProductuomid()==null?returnsupplierdtl.getReturndtlProductuomid():UUID.fromString(returnsupplierdtl.getReturndtlProductuomid()) , // "returndtl_productuomid" : java.lang.String
			returnsupplierdtl.getReturndtlUserid()==null?returnsupplierdtl.getReturndtlUserid():UUID.fromString(returnsupplierdtl.getReturndtlUserid()) , // "returndtl_userid" : java.lang.String
			returnsupplierdtl.getReturndtlDetailexpiredid()==null?returnsupplierdtl.getReturndtlDetailexpiredid():UUID.fromString(returnsupplierdtl.getReturndtlDetailexpiredid()) , // "returndtl_detailexpiredid" : java.lang.String
			returnsupplierdtl.getReturndtlqty() , // "returndtlqty" : java.lang.Integer
			returnsupplierdtl.getReturndtlprice() , // "returndtlprice" : java.lang.Double
			returnsupplierdtl.getReturnrdtlmoddate()  // "returnrdtlmoddate" : java.util.Date
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Returnsupplierdtl returnsupplierdtl) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
			returnsupplierdtl.getReturndtlReturnsupplierid()==null?returnsupplierdtl.getReturndtlReturnsupplierid():UUID.fromString(returnsupplierdtl.getReturndtlReturnsupplierid()) , // "returndtl_returnsupplierid" : java.lang.String
			returnsupplierdtl.getReturndtlProductuomid()==null?returnsupplierdtl.getReturndtlProductuomid():UUID.fromString(returnsupplierdtl.getReturndtlProductuomid()) , // "returndtl_productuomid" : java.lang.String
			returnsupplierdtl.getReturndtlUserid()==null?returnsupplierdtl.getReturndtlUserid():UUID.fromString(returnsupplierdtl.getReturndtlUserid()) , // "returndtl_userid" : java.lang.String
			returnsupplierdtl.getReturndtlDetailexpiredid()==null?returnsupplierdtl.getReturndtlDetailexpiredid():UUID.fromString(returnsupplierdtl.getReturndtlDetailexpiredid()) , // "returndtl_detailexpiredid" : java.lang.String
			returnsupplierdtl.getReturndtlqty(), // "returndtlqty" : java.lang.Integer
			returnsupplierdtl.getReturndtlprice(), // "returndtlprice" : java.lang.Double
			returnsupplierdtl.getReturnrdtlmoddate(), // "returnrdtlmoddate" : java.util.Date
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			UUID.fromString(returnsupplierdtl.getReturndtlid())  // "returndtlid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Returnsupplierdtl returnsupplierdtl)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			returnsupplierdtl.getReturndtlid()  // "returndtlid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Returnsupplierdtl> getRowMapper(Returnsupplierdtl o)  {
		//--- RowMapper to populate the given bean instance
		return new ReturnsupplierdtlRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Returnsupplierdtl> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new ReturnsupplierdtlRowMapper() ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param returnsupplierdtl
	 * @throws SQLException
	 */
	private Returnsupplierdtl populateBean(ResultSet rs, Returnsupplierdtl returnsupplierdtl) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		returnsupplierdtl.setReturndtlid(rs.getString("returndtlid")); // java.lang.String
		returnsupplierdtl.setReturndtlReturnsupplierid(rs.getString("returndtl_returnsupplierid")); // java.lang.String
		returnsupplierdtl.setReturndtlProductuomid(rs.getString("returndtl_productuomid")); // java.lang.String
		returnsupplierdtl.setReturndtlUserid(rs.getString("returndtl_userid")); // java.lang.String
		returnsupplierdtl.setReturndtlDetailexpiredid(rs.getString("returndtl_detailexpiredid")); // java.lang.String
		returnsupplierdtl.setReturndtlqty(rs.getInt("returndtlqty")); // java.lang.Integer
		if ( rs.wasNull() ) { returnsupplierdtl.setReturndtlqty(null); }; // not primitive number => keep null value if any
		returnsupplierdtl.setReturndtlprice(rs.getDouble("returndtlprice")); // java.lang.Double
		if ( rs.wasNull() ) { returnsupplierdtl.setReturndtlprice(null); }; // not primitive number => keep null value if any
		returnsupplierdtl.setReturnrdtlmoddate(rs.getDate("returnrdtlmoddate")); // java.util.Date
                return returnsupplierdtl;
	}
        
    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param returnsupplierdtl
	 * @throws SQLException
	 */
	private Returnsupplierdtl populateBean(ResultSet rs) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
            Returnsupplierdtl returnsupplierdtl = new Returnsupplierdtl();
		returnsupplierdtl.setReturndtlid(rs.getString("returndtlid")); // java.lang.String
		returnsupplierdtl.setReturndtlReturnsupplierid(rs.getString("returndtl_returnsupplierid")); // java.lang.String
		returnsupplierdtl.setReturndtlProductuomid(rs.getString("returndtl_productuomid")); // java.lang.String
		returnsupplierdtl.setReturndtlUserid(rs.getString("returndtl_userid")); // java.lang.String
		returnsupplierdtl.setReturndtlDetailexpiredid(rs.getString("returndtl_detailexpiredid")); // java.lang.String
		returnsupplierdtl.setReturndtlqty(rs.getInt("returndtlqty")); // java.lang.Integer
		if ( rs.wasNull() ) { returnsupplierdtl.setReturndtlqty(null); }; // not primitive number => keep null value if any
		returnsupplierdtl.setReturndtlprice(rs.getDouble("returndtlprice")); // java.lang.Double
		if ( rs.wasNull() ) { returnsupplierdtl.setReturndtlprice(null); }; // not primitive number => keep null value if any
		returnsupplierdtl.setReturnrdtlmoddate(rs.getDate("returnrdtlmoddate")); // java.util.Date
                return returnsupplierdtl;
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class ReturnsupplierdtlRowMapper implements RowMapper<Returnsupplierdtl> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private Returnsupplierdtl bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		ReturnsupplierdtlRowMapper(Returnsupplierdtl bean) {
			this.bean = bean ;
		}
		
		public ReturnsupplierdtlRowMapper() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public Returnsupplierdtl mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
		}
	}

	@Override
	public Returnsupplierdtl findById(String returndtlid) {
		Object[] primaryKey = new Object[] { UUID.fromString(returndtlid) };
		return super.doSelect(primaryKey);
	}

	@Override
	public List<Returnsupplierdtl> findAll() {
		return super.doSelectAll();
	}

	@Override
	public Returnsupplierdtl save(Returnsupplierdtl entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Returnsupplierdtl update(Returnsupplierdtl entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Returnsupplierdtl create(Returnsupplierdtl entity) {
		super.doInsert(entity);
		return entity;
	}

	@Override
	public void delete(String returndtlid) {
		Object[] primaryKey = new Object[] { returndtlid };
		super.doDelete(primaryKey);
	}
}
