/*
 * Created on 10 Dec 2015
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Detailexpired;
import tristi.general.business.service.DetailexpiredService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Detailexpired DAO implementation
 *
 * @author Telosys Tools
 *
 */
@Repository
public class DetailexpiredDAOImplSpring extends GenericDAO<Detailexpired> implements DetailexpiredService {

    private final static String SQL_SELECT_ALL_PAGING
            = "select detailexpiredid, detailexpired_productstockid, detailexpired_userid, detailexpired_locationdtlid, detailexpireddate, detailexpiredqty, detailexpiredmoddate from detailexpired limit ? offset ?";

    private final static String SQL_SELECT_ALL
            = "select detailexpiredid, detailexpired_productstockid, detailexpired_userid, detailexpired_locationdtlid, detailexpireddate, detailexpiredqty, detailexpiredmoddate from detailexpired";

    private final static String SQL_SELECT_PAGING
            = "select detailexpiredid, detailexpired_productstockid, detailexpired_userid, detailexpired_locationdtlid, detailexpireddate, detailexpiredqty, detailexpiredmoddate from detailexpired where detailexpiredid = ? limit ? offset ?";

    private final static String SQL_SELECT
            = "select detailexpiredid, detailexpired_productstockid, detailexpired_userid, detailexpired_locationdtlid, detailexpireddate, detailexpiredqty, detailexpiredmoddate from detailexpired where detailexpiredid = ?";

    private final static String SQL_INSERT
            = "insert into detailexpired ( detailexpired_productstockid, detailexpired_userid, detailexpired_locationdtlid, detailexpireddate, detailexpiredqty, detailexpiredmoddate ) values ( ?, ?, ?, ?, ?, ? )";

    private final static String SQL_UPDATE
            = "update detailexpired set detailexpired_productstockid = ?, detailexpired_userid = ?, detailexpired_locationdtlid = ?, detailexpireddate = ?, detailexpiredqty = ?, detailexpiredmoddate = ? where detailexpiredid = ?";

    private final static String SQL_DELETE
            = "delete from detailexpired where detailexpiredid = ?";

    private final static String SQL_COUNT_ALL
            = "select count(*) from detailexpired";

    private final static String SQL_COUNT
            = "select count(*) from detailexpired where detailexpiredid = ?";

    //----------------------------------------------------------------------
    /**
     * DAO constructor
     */
    public DetailexpiredDAOImplSpring() {
        super();
    }

    @Override
    public boolean exists(String detailexpiredid) {
        Object[] primaryKey = new Object[]{detailexpiredid};
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
    protected Object[] getValuesForInsert(Detailexpired detailexpired) {
        return new Object[]{
            //--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//          detailexpired.getDetailexpiredid(), // "detailexpiredid" : java.lang.String
            detailexpired.getDetailexpiredProductstockid()==null?detailexpired.getDetailexpiredProductstockid():UUID.fromString(detailexpired.getDetailexpiredProductstockid()), // "detailexpired_productstockid" : java.lang.String
            detailexpired.getDetailexpiredUserid()==null?detailexpired.getDetailexpiredUserid():UUID.fromString(detailexpired.getDetailexpiredUserid()), // "detailexpired_userid" : java.lang.String
            detailexpired.getDetailexpiredLocationdtlid()==null?detailexpired.getDetailexpiredLocationdtlid():UUID.fromString(detailexpired.getDetailexpiredLocationdtlid()), // "detailexpired_locationdtlid" : java.lang.String
            detailexpired.getDetailexpireddate(), // "detailexpireddate" : java.util.Date
            detailexpired.getDetailexpiredqty(), // "detailexpiredqty" : java.lang.Integer
            detailexpired.getDetailexpiredmoddate() // "detailexpiredmoddate" : java.util.Date
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForUpdate(Detailexpired detailexpired) {
        return new Object[]{
            //--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
        	detailexpired.getDetailexpiredProductstockid()==null?detailexpired.getDetailexpiredProductstockid():UUID.fromString(detailexpired.getDetailexpiredProductstockid()), // "detailexpired_productstockid" : java.lang.String
        	detailexpired.getDetailexpiredUserid()==null?detailexpired.getDetailexpiredUserid():UUID.fromString(detailexpired.getDetailexpiredUserid()), // "detailexpired_userid" : java.lang.String
        	detailexpired.getDetailexpiredLocationdtlid()==null?detailexpired.getDetailexpiredLocationdtlid():UUID.fromString(detailexpired.getDetailexpiredLocationdtlid()), // "detailexpired_locationdtlid" : java.lang.String
        	detailexpired.getDetailexpireddate(), // "detailexpireddate" : java.util.Date
            detailexpired.getDetailexpiredqty(), // "detailexpiredqty" : java.lang.Integer
            detailexpired.getDetailexpiredmoddate(), // "detailexpiredmoddate" : java.util.Date
            //--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
            UUID.fromString(detailexpired.getDetailexpiredid()) // "detailexpiredid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForPrimaryKey(Detailexpired detailexpired) {
        return new Object[]{
            //--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
            detailexpired.getDetailexpiredid() // "detailexpiredid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Detailexpired> getRowMapper(Detailexpired o) {
        //--- RowMapper to populate the given bean instance
        return new DetailexpiredRowMapper(o);
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Detailexpired> getRowMapper() {
        //--- RowMapper to populate a new bean instance
        return new DetailexpiredRowMapper();
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param detailexpired
     * @throws SQLException
     */
    private Detailexpired populateBean(ResultSet rs, Detailexpired detailexpired) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        detailexpired.setDetailexpiredid(rs.getString("detailexpiredid")); // java.lang.String
        detailexpired.setDetailexpiredProductstockid(rs.getString("detailexpired_productstockid")); // java.lang.String
        detailexpired.setDetailexpiredUserid(rs.getString("detailexpired_userid")); // java.lang.String
        detailexpired.setDetailexpiredLocationdtlid(rs.getString("detailexpired_locationdtlid")); // java.lang.String
        detailexpired.setDetailexpireddate(rs.getDate("detailexpireddate")); // java.util.Date
        detailexpired.setDetailexpiredqty(rs.getInt("detailexpiredqty")); // java.lang.Integer
        if (rs.wasNull()) {
            detailexpired.setDetailexpiredqty(null);
        }; // not primitive number => keep null value if any
        detailexpired.setDetailexpiredmoddate(rs.getDate("detailexpiredmoddate")); // java.util.Date
        return detailexpired;
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param detailexpired
     * @throws SQLException
     */
    private Detailexpired populateBean(ResultSet rs) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        Detailexpired detailexpired = new Detailexpired();
        detailexpired.setDetailexpiredid(rs.getString("detailexpiredid")); // java.lang.String
        detailexpired.setDetailexpiredProductstockid(rs.getString("detailexpired_productstockid")); // java.lang.String
        detailexpired.setDetailexpiredUserid(rs.getString("detailexpired_userid")); // java.lang.String
        detailexpired.setDetailexpiredLocationdtlid(rs.getString("detailexpired_locationdtlid")); // java.lang.String
        detailexpired.setDetailexpireddate(rs.getDate("detailexpireddate")); // java.util.Date
        detailexpired.setDetailexpiredqty(rs.getInt("detailexpiredqty")); // java.lang.Integer
        if (rs.wasNull()) {
            detailexpired.setDetailexpiredqty(null);
        }; // not primitive number => keep null value if any
        detailexpired.setDetailexpiredmoddate(rs.getDate("detailexpiredmoddate")); // java.util.Date
        return detailexpired;
    }

    //----------------------------------------------------------------------
    /**
     * Specific inner class for 'RowMapper' implementation
     */
    private class DetailexpiredRowMapper implements RowMapper<Detailexpired> {

        /**
         * The bean instance that will be populated from the ResultSet
         */
        private Detailexpired bean;

        /**
         * Constructor
         *
         * @param bean the bean to be populated
         */
        DetailexpiredRowMapper(Detailexpired bean) {
            this.bean = bean;
        }
        
        public DetailexpiredRowMapper() {
			// TODO Auto-generated constructor stub
		}

        @Override
        public Detailexpired mapRow(ResultSet rs, int rowNum) throws SQLException {
        	if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
        }
    }

    @Override
    public Detailexpired findById(String detailexpiredid) {
        Object[] primaryKey = new Object[]{UUID.fromString(detailexpiredid)};
        return super.doSelect(primaryKey);
    }

    @Override
    public List<Detailexpired> findAll() {
        return super.doSelectAll();
    }

    @Override
    public Detailexpired save(Detailexpired entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Detailexpired update(Detailexpired entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Detailexpired create(Detailexpired entity) {
        super.doInsert(entity);
        return entity;
    }

    @Override
    public void delete(String detailexpiredid) {
        Object[] primaryKey = new Object[]{detailexpiredid};
        super.doDelete(primaryKey);
    }
}
