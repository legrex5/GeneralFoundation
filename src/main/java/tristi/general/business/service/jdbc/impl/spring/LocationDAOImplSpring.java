/*
 * Created on 10 Dec 2015
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Location;
import tristi.general.business.service.LocationService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Location DAO implementation 
 * 
 * @author Telosys Tools
 *
 */
@Repository
public class LocationDAOImplSpring extends GenericDAO<Location> implements LocationService {

	private final static String SQL_SELECT_ALL_PAGING = 
		"select locationid, location_userid, locationcode, locationname, locationismain, locationisactive, locationmoddate from location limit ? offset ?";

        private final static String SQL_SELECT_ALL = 
		"select locationid, location_userid, locationcode, locationname, locationismain, locationisactive, locationmoddate from location";

        private final static String SQL_SELECT_PAGING = 
		"select locationid, location_userid, locationcode, locationname, locationismain, locationisactive, locationmoddate from location where locationid = ? limit ? offset ?";

        private final static String SQL_SELECT = 
		"select locationid, location_userid, locationcode, locationname, locationismain, locationisactive, locationmoddate from location where locationid = ?";

	private final static String SQL_INSERT = 
		"insert into location ( location_userid, locationcode, locationname, locationismain, locationisactive, locationmoddate ) values ( ?, ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update location set location_userid = ?, locationcode = ?, locationname = ?, locationismain = ?, locationisactive = ?, locationmoddate = ? where locationid = ?";

	private final static String SQL_DELETE = 
		"delete from location where locationid = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from location";

	private final static String SQL_COUNT = 
		"select count(*) from location where locationid = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public LocationDAOImplSpring() {
		super();
	}

	@Override
	public boolean exists( String locationid ) {
		Object[] primaryKey = new Object[] { locationid };
		return super.doExists(primaryKey);
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * DAO interface implementation
	 */
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
	protected Object[] getValuesForInsert(Location location)  {
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//			location.getLocationid() , // "locationid" : java.lang.String
			location.getLocationUserid()==null?location.getLocationUserid():UUID.fromString(location.getLocationUserid()) , // "location_userid" : java.lang.String
			location.getLocationcode() , // "locationcode" : java.lang.String
			location.getLocationname() , // "locationname" : java.lang.String
			location.getLocationismain() , // "locationismain" : java.lang.Boolean
			location.getLocationisactive() , // "locationisactive" : java.lang.Boolean
			location.getLocationmoddate()  // "locationmoddate" : java.util.Date
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Location location) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
			location.getLocationUserid()==null?location.getLocationUserid():UUID.fromString(location.getLocationUserid()) , // "location_userid" : java.lang.String
			location.getLocationcode(), // "locationcode" : java.lang.String
			location.getLocationname(), // "locationname" : java.lang.String
			location.getLocationismain(), // "locationismain" : java.lang.Boolean
			location.getLocationisactive(), // "locationisactive" : java.lang.Boolean
			location.getLocationmoddate(), // "locationmoddate" : java.util.Date
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			UUID.fromString(location.getLocationid())  // "locationid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Location location)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			location.getLocationid()  // "locationid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Location> getRowMapper(Location o)  {
		//--- RowMapper to populate the given bean instance
		return new LocationRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Location> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new LocationRowMapper() ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param location
	 * @throws SQLException
	 */
	private Location populateBean(ResultSet rs, Location location) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		location.setLocationid(rs.getString("locationid")); // java.lang.String
		location.setLocationUserid(rs.getString("location_userid")); // java.lang.String
		location.setLocationcode(rs.getString("locationcode")); // java.lang.String
		location.setLocationname(rs.getString("locationname")); // java.lang.String
		location.setLocationismain(rs.getBoolean("locationismain")); // java.lang.Boolean
		location.setLocationisactive(rs.getBoolean("locationisactive")); // java.lang.Boolean
		location.setLocationmoddate(rs.getDate("locationmoddate")); // java.util.Date
                return location;
	}
        
        //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param location
	 * @throws SQLException
	 */
	private Location populateBean(ResultSet rs) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
            Location location = new Location();
		location.setLocationid(rs.getString("locationid")); // java.lang.String
		location.setLocationUserid(rs.getString("location_userid")); // java.lang.String
		location.setLocationcode(rs.getString("locationcode")); // java.lang.String
		location.setLocationname(rs.getString("locationname")); // java.lang.String
		location.setLocationismain(rs.getBoolean("locationismain")); // java.lang.Boolean
		location.setLocationisactive(rs.getBoolean("locationisactive")); // java.lang.Boolean
		location.setLocationmoddate(rs.getDate("locationmoddate")); // java.util.Date
                return location;
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class LocationRowMapper implements RowMapper<Location> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private Location bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		LocationRowMapper(Location bean) {
			this.bean = bean ;
		}
		
		public LocationRowMapper() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
		}
	}

	@Override
	public Location findById(String locationid) {
		Object[] primaryKey = new Object[] { UUID.fromString(locationid) };
		return super.doSelect(primaryKey);
	}

	@Override
	public List<Location> findAll() {
		return super.doSelectAll();
	}

	@Override
	public Location save(Location entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Location update(Location entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Location create(Location entity) {
		super.doInsert(entity);
		return entity;
	}

	@Override
	public void delete(String locationid) {
		Object[] primaryKey = new Object[] { locationid };
		super.doDelete(primaryKey);	
	}
}
