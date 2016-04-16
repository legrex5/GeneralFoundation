/*
 * Created on 10 Dec 2015
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Returnsupplier;
import tristi.general.business.service.ReturnsupplierService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Returnsupplier DAO implementation 
 * 
 *
 */
@Repository
public class ReturnsupplierDAOImplSpring extends GenericDAO<Returnsupplier> implements ReturnsupplierService {

	private final static String SQL_SELECT_ALL_PAGING = 
		"select returnsupplierid, returnsupplier_userid, returnsupplier_supplierid, returnsuppliercode, returnsupplierdate, returnsupplieramount, returnsupplierstatus, returnsuppliermoddate from returnsupplier limit ? offset ?";

        private final static String SQL_SELECT_ALL = 
		"select returnsupplierid, returnsupplier_userid, returnsupplier_supplierid, returnsuppliercode, returnsupplierdate, returnsupplieramount, returnsupplierstatus, returnsuppliermoddate from returnsupplier";

        private final static String SQL_SELECT_PAGING = 
		"select returnsupplierid, returnsupplier_userid, returnsupplier_supplierid, returnsuppliercode, returnsupplierdate, returnsupplieramount, returnsupplierstatus, returnsuppliermoddate from returnsupplier where returnsupplierid = ? limit ? offset ?";

        private final static String SQL_SELECT = 
		"select returnsupplierid, returnsupplier_userid, returnsupplier_supplierid, returnsuppliercode, returnsupplierdate, returnsupplieramount, returnsupplierstatus, returnsuppliermoddate from returnsupplier where returnsupplierid = ?";


	private final static String SQL_INSERT = 
		"insert into returnsupplier ( returnsupplier_userid, returnsupplier_supplierid, returnsuppliercode, returnsupplierdate, returnsupplieramount, returnsupplierstatus, returnsuppliermoddate ) values ( ?, ?, ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update returnsupplier set returnsupplier_userid = ?, returnsupplier_supplierid = ?, returnsuppliercode = ?, returnsupplierdate = ?, returnsupplieramount = ?, returnsupplierstatus = ?, returnsuppliermoddate = ? where returnsupplierid = ?";

	private final static String SQL_DELETE = 
		"delete from returnsupplier where returnsupplierid = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from returnsupplier";

	private final static String SQL_COUNT = 
		"select count(*) from returnsupplier where returnsupplierid = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public ReturnsupplierDAOImplSpring() {
		super();
	}

	@Override
	public boolean exists( String returnsupplierid ) {
		Object[] primaryKey = new Object[] { returnsupplierid };
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
	protected Object[] getValuesForInsert(Returnsupplier returnsupplier)  {
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//			returnsupplier.getReturnsupplierid() , // "returnsupplierid" : java.lang.String
			returnsupplier.getReturnsupplierUserid()==null?returnsupplier.getReturnsupplierUserid():UUID.fromString(returnsupplier.getReturnsupplierUserid()) , // "returnsupplier_userid" : java.lang.String
			returnsupplier.getReturnsupplierSupplierid()==null?returnsupplier.getReturnsupplierSupplierid():UUID.fromString(returnsupplier.getReturnsupplierSupplierid()) , // "returnsupplier_supplierid" : java.lang.String
			returnsupplier.getReturnsuppliercode() , // "returnsuppliercode" : java.lang.String
			returnsupplier.getReturnsupplierdate() , // "returnsupplierdate" : java.util.Date
			returnsupplier.getReturnsupplieramount() , // "returnsupplieramount" : java.lang.Double
			returnsupplier.getReturnsupplierstatus() , // "returnsupplierstatus" : java.lang.String
			returnsupplier.getReturnsuppliermoddate()  // "returnsuppliermoddate" : java.util.Date
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Returnsupplier returnsupplier) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
			returnsupplier.getReturnsupplierUserid()==null?returnsupplier.getReturnsupplierUserid():UUID.fromString(returnsupplier.getReturnsupplierUserid()) , // "returnsupplier_userid" : java.lang.String
			returnsupplier.getReturnsupplierSupplierid()==null?returnsupplier.getReturnsupplierSupplierid():UUID.fromString(returnsupplier.getReturnsupplierSupplierid()) , // "returnsupplier_supplierid" : java.lang.String
			returnsupplier.getReturnsuppliercode(), // "returnsuppliercode" : java.lang.String
			returnsupplier.getReturnsupplierdate(), // "returnsupplierdate" : java.util.Date
			returnsupplier.getReturnsupplieramount(), // "returnsupplieramount" : java.lang.Double
			returnsupplier.getReturnsupplierstatus(), // "returnsupplierstatus" : java.lang.String
			returnsupplier.getReturnsuppliermoddate(), // "returnsuppliermoddate" : java.util.Date
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			UUID.fromString(returnsupplier.getReturnsupplierid())  // "returnsupplierid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Returnsupplier returnsupplier)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			returnsupplier.getReturnsupplierid()  // "returnsupplierid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Returnsupplier> getRowMapper(Returnsupplier o)  {
		//--- RowMapper to populate the given bean instance
		return new ReturnsupplierRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Returnsupplier> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new ReturnsupplierRowMapper() ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param returnsupplier
	 * @throws SQLException
	 */
	private Returnsupplier populateBean(ResultSet rs, Returnsupplier returnsupplier) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		returnsupplier.setReturnsupplierid(rs.getString("returnsupplierid")); // java.lang.String
		returnsupplier.setReturnsupplierUserid(rs.getString("returnsupplier_userid")); // java.lang.String
		returnsupplier.setReturnsupplierSupplierid(rs.getString("returnsupplier_supplierid")); // java.lang.String
		returnsupplier.setReturnsuppliercode(rs.getString("returnsuppliercode")); // java.lang.String
		returnsupplier.setReturnsupplierdate(rs.getDate("returnsupplierdate")); // java.util.Date
		returnsupplier.setReturnsupplieramount(rs.getDouble("returnsupplieramount")); // java.lang.Double
		if ( rs.wasNull() ) { returnsupplier.setReturnsupplieramount(null); }; // not primitive number => keep null value if any
		returnsupplier.setReturnsupplierstatus(rs.getString("returnsupplierstatus")); // java.lang.String
		returnsupplier.setReturnsuppliermoddate(rs.getDate("returnsuppliermoddate")); // java.util.Date
                return returnsupplier;
	}
        
        //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param returnsupplier
	 * @throws SQLException
	 */
	private Returnsupplier populateBean(ResultSet rs) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
        Returnsupplier returnsupplier = new Returnsupplier();
		returnsupplier.setReturnsupplierid(rs.getString("returnsupplierid")); // java.lang.String
		returnsupplier.setReturnsupplierUserid(rs.getString("returnsupplier_userid")); // java.lang.String
		returnsupplier.setReturnsupplierSupplierid(rs.getString("returnsupplier_supplierid")); // java.lang.String
		returnsupplier.setReturnsuppliercode(rs.getString("returnsuppliercode")); // java.lang.String
		returnsupplier.setReturnsupplierdate(rs.getDate("returnsupplierdate")); // java.util.Date
		returnsupplier.setReturnsupplieramount(rs.getDouble("returnsupplieramount")); // java.lang.Double
		if ( rs.wasNull() ) { returnsupplier.setReturnsupplieramount(null); }; // not primitive number => keep null value if any
		returnsupplier.setReturnsupplierstatus(rs.getString("returnsupplierstatus")); // java.lang.String
		returnsupplier.setReturnsuppliermoddate(rs.getDate("returnsuppliermoddate")); // java.util.Date
                return returnsupplier;
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class ReturnsupplierRowMapper implements RowMapper<Returnsupplier> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private Returnsupplier bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		ReturnsupplierRowMapper(Returnsupplier bean) {
			this.bean = bean ;
		}
		
		public ReturnsupplierRowMapper() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public Returnsupplier mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
		}
	}

	@Override
	public Returnsupplier findById(String returnsupplierid) {
		Object[] primaryKey = new Object[] { UUID.fromString(returnsupplierid) };
		return super.doSelect(primaryKey);
	}

	@Override
	public List<Returnsupplier> findAll() {
		return super.doSelectAll();
	}

	@Override
	public Returnsupplier save(Returnsupplier entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Returnsupplier update(Returnsupplier entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Returnsupplier create(Returnsupplier entity) {
		super.doInsert(entity);
		return entity;
	}

	@Override
	public void delete(String returnsupplierid) {
		Object[] primaryKey = new Object[] { returnsupplierid };
		super.doDelete(primaryKey);	
	}
}
