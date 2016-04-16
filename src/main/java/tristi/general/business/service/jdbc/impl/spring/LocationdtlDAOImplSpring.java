/*
 * Created on 10 Dec 2015
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Locationdtl;
import tristi.general.business.service.LocationdtlService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Locationdtl DAO implementation
 *
 * @author Telosys Tools
 *
 */
@Repository
public class LocationdtlDAOImplSpring extends GenericDAO<Locationdtl> implements LocationdtlService {

    private final static String SQL_SELECT_ALL_PAGING
            = "select locationdtlid, locationdtl_locationid, locationdtl_userid, locationdtlname, locationdtlisactive, locationdtlmoddate from locationdtl limit ? offset ?";

    private final static String SQL_SELECT_ALL
            = "select locationdtlid, locationdtl_locationid, locationdtl_userid, locationdtlname, locationdtlisactive, locationdtlmoddate from locationdtl";

    private final static String SQL_SELECT_PAGING
            = "select locationdtlid, locationdtl_locationid, locationdtl_userid, locationdtlname, locationdtlisactive, locationdtlmoddate from locationdtl where locationdtlid = ? limit ? offset ?";

    private final static String SQL_SELECT
            = "select locationdtlid, locationdtl_locationid, locationdtl_userid, locationdtlname, locationdtlisactive, locationdtlmoddate from locationdtl where locationdtlid = ?";

    private final static String SQL_INSERT
            = "insert into locationdtl ( locationdtl_locationid, locationdtl_userid, locationdtlname, locationdtlisactive, locationdtlmoddate ) values ( ?, ?, ?, ?, ? )";

    private final static String SQL_UPDATE
            = "update locationdtl set locationdtl_locationid = ?, locationdtl_userid = ?, locationdtlname = ?, locationdtlisactive = ?, locationdtlmoddate = ? where locationdtlid = ?";

    private final static String SQL_DELETE
            = "delete from locationdtl where locationdtlid = ?";

    private final static String SQL_COUNT_ALL
            = "select count(*) from locationdtl";

    private final static String SQL_COUNT
            = "select count(*) from locationdtl where locationdtlid = ?";

    //----------------------------------------------------------------------
    /**
     * DAO constructor
     */
    public LocationdtlDAOImplSpring() {
        super();
    }

    @Override
    public boolean exists(String locationdtlid) {
        Object[] primaryKey = new Object[]{locationdtlid};
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
        return SQL_SELECT_ALL;
    }

    //----------------------------------------------------------------------

    @Override
    protected String getSqlSelect() {
        return SQL_SELECT;
    }

    //----------------------------------------------------------------------

    @Override
    protected String getSqlInsert() {
        return SQL_INSERT;
    }

    //----------------------------------------------------------------------

    @Override
    protected String getSqlUpdate() {
        return SQL_UPDATE;
    }

    //----------------------------------------------------------------------

    @Override
    protected String getSqlDelete() {
        return SQL_DELETE;
    }

    //----------------------------------------------------------------------

    @Override
    protected String getSqlCount() {
        return SQL_COUNT;
    }

    //----------------------------------------------------------------------

    @Override
    protected String getSqlCountAll() {
        return SQL_COUNT_ALL;
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForInsert(Locationdtl locationdtl) {
        return new Object[]{
            //--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//          locationdtl.getLocationdtlid(), // "locationdtlid" : java.lang.String
            locationdtl.getLocationdtlLocationid()==null?locationdtl.getLocationdtlLocationid():UUID.fromString(locationdtl.getLocationdtlLocationid()), // "locationdtl_locationid" : java.lang.String
            locationdtl.getLocationdtlUserid()==null?locationdtl.getLocationdtlUserid():UUID.fromString(locationdtl.getLocationdtlUserid()), // "locationdtl_userid" : java.lang.String
            locationdtl.getLocationdtlname(), // "locationdtlname" : java.lang.String
            locationdtl.getLocationdtlisactive(), // "locationdtlisactive" : java.lang.Boolean
            locationdtl.getLocationdtlmoddate() // "locationdtlmoddate" : java.util.Date
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForUpdate(Locationdtl locationdtl) {
        return new Object[]{
            //--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
        	locationdtl.getLocationdtlLocationid()==null?locationdtl.getLocationdtlLocationid():UUID.fromString(locationdtl.getLocationdtlLocationid()), // "locationdtl_locationid" : java.lang.String
        	locationdtl.getLocationdtlUserid()==null?locationdtl.getLocationdtlUserid():UUID.fromString(locationdtl.getLocationdtlUserid()), // "locationdtl_userid" : java.lang.String
        	locationdtl.getLocationdtlname(), // "locationdtlname" : java.lang.String
            locationdtl.getLocationdtlisactive(), // "locationdtlisactive" : java.lang.Boolean
            locationdtl.getLocationdtlmoddate(), // "locationdtlmoddate" : java.util.Date
            //--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
            UUID.fromString(locationdtl.getLocationdtlid()) // "locationdtlid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForPrimaryKey(Locationdtl locationdtl) {
        return new Object[]{
            //--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
            locationdtl.getLocationdtlid() // "locationdtlid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Locationdtl> getRowMapper(Locationdtl o) {
        //--- RowMapper to populate the given bean instance
        return new LocationdtlRowMapper(o);
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Locationdtl> getRowMapper() {
        //--- RowMapper to populate a new bean instance
        return new LocationdtlRowMapper();
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param locationdtl
     * @throws SQLException
     */
    private Locationdtl populateBean(ResultSet rs, Locationdtl locationdtl) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        locationdtl.setLocationdtlid(rs.getString("locationdtlid")); // java.lang.String
        locationdtl.setLocationdtlLocationid(rs.getString("locationdtl_locationid")); // java.lang.String
        locationdtl.setLocationdtlUserid(rs.getString("locationdtl_userid")); // java.lang.String
        locationdtl.setLocationdtlname(rs.getString("locationdtlname")); // java.lang.String
        locationdtl.setLocationdtlisactive(rs.getBoolean("locationdtlisactive")); // java.lang.Boolean
        locationdtl.setLocationdtlmoddate(rs.getDate("locationdtlmoddate")); // java.util.Date
        return locationdtl;
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param locationdtl
     * @throws SQLException
     */
    private Locationdtl populateBean(ResultSet rs) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        Locationdtl locationdtl = new Locationdtl();
        locationdtl.setLocationdtlid(rs.getString("locationdtlid")); // java.lang.String
        locationdtl.setLocationdtlLocationid(rs.getString("locationdtl_locationid")); // java.lang.String
        locationdtl.setLocationdtlUserid(rs.getString("locationdtl_userid")); // java.lang.String
        locationdtl.setLocationdtlname(rs.getString("locationdtlname")); // java.lang.String
        locationdtl.setLocationdtlisactive(rs.getBoolean("locationdtlisactive")); // java.lang.Boolean
        locationdtl.setLocationdtlmoddate(rs.getDate("locationdtlmoddate")); // java.util.Date
        return locationdtl;
    }

    //----------------------------------------------------------------------
    /**
     * Specific inner class for 'RowMapper' implementation
     */
    private class LocationdtlRowMapper implements RowMapper<Locationdtl> {

        /**
         * The bean instance that will be populated from the ResultSet
         */
        private Locationdtl bean;

        /**
         * Constructor
         *
         * @param bean the bean to be populated
         */
        LocationdtlRowMapper(Locationdtl bean) {
            this.bean = bean;
        }
        
        public LocationdtlRowMapper() {
			// TODO Auto-generated constructor stub
		}

        @Override
        public Locationdtl mapRow(ResultSet rs, int rowNum) throws SQLException {
        	if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
        }
    }

    @Override
    public Locationdtl findById(String locationdtlid) {
        Object[] primaryKey = new Object[]{UUID.fromString(locationdtlid)};
        return super.doSelect(primaryKey);
    }

    @Override
    public List<Locationdtl> findAll() {
        return super.doSelectAll();
    }

    @Override
    public Locationdtl save(Locationdtl entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Locationdtl update(Locationdtl entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Locationdtl create(Locationdtl entity) {
        super.doInsert(entity);
        return entity;
    }

    @Override
    public void delete(String locationdtlid) {
        Object[] primaryKey = new Object[]{locationdtlid};
        super.doDelete(primaryKey);
    }
}
