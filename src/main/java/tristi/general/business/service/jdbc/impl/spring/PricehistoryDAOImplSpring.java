/*
 * Created on 10 Dec 2015
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Pricehistory;
import tristi.general.business.service.PricehistoryService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Pricehistory DAO implementation
 *
 * @author Telosys Tools
 *
 */
@Repository
public class PricehistoryDAOImplSpring extends GenericDAO<Pricehistory> implements PricehistoryService {

    private final static String SQL_SELECT_ALL_PAGING
            = "select pricehistoryid, pricehistory_userid, pricehistory_productid, pricehistorybaseprice, pricehistoryprice, pricehistoryfrom, pricehistoryto, pricehistorymoddate from pricehistory limit ? offset ?";

    private final static String SQL_SELECT_ALL
            = "select pricehistoryid, pricehistory_userid, pricehistory_productid, pricehistorybaseprice, pricehistoryprice, pricehistoryfrom, pricehistoryto, pricehistorymoddate from pricehistory";

    private final static String SQL_SELECT_PAGING
            = "select pricehistoryid, pricehistory_userid, pricehistory_productid, pricehistorybaseprice, pricehistoryprice, pricehistoryfrom, pricehistoryto, pricehistorymoddate from pricehistory where pricehistoryid = ? limit ? offset ?";

    private final static String SQL_SELECT
            = "select pricehistoryid, pricehistory_userid, pricehistory_productid, pricehistorybaseprice, pricehistoryprice, pricehistoryfrom, pricehistoryto, pricehistorymoddate from pricehistory where pricehistoryid = ?";

    private final static String SQL_INSERT
            = "insert into pricehistory ( pricehistory_userid, pricehistory_productid, pricehistorybaseprice, pricehistoryprice, pricehistoryfrom, pricehistoryto, pricehistorymoddate ) values ( ?, ?, ?, ?, ?, ?, ? )";

    private final static String SQL_UPDATE
            = "update pricehistory set pricehistory_userid = ?, pricehistory_productid = ?, pricehistorybaseprice = ?, pricehistoryprice = ?, pricehistoryfrom = ?, pricehistoryto = ?, pricehistorymoddate = ? where pricehistoryid = ?";

    private final static String SQL_DELETE
            = "delete from pricehistory where pricehistoryid = ?";

    private final static String SQL_COUNT_ALL
            = "select count(*) from pricehistory";

    private final static String SQL_COUNT
            = "select count(*) from pricehistory where pricehistoryid = ?";

    //----------------------------------------------------------------------
    /**
     * DAO constructor
     */
    public PricehistoryDAOImplSpring() {
        super();
    }

    @Override
    public boolean exists(String pricehistoryid) {
        Object[] primaryKey = new Object[]{pricehistoryid};
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
    protected Object[] getValuesForInsert(Pricehistory pricehistory) {
        return new Object[]{
            //--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//          pricehistory.getPricehistoryid(), // "pricehistoryid" : java.lang.String
            pricehistory.getPricehistoryUserid()==null?pricehistory.getPricehistoryUserid():UUID.fromString(pricehistory.getPricehistoryUserid()), // "pricehistory_userid" : java.lang.String
            pricehistory.getPricehistoryProductid()==null?pricehistory.getPricehistoryProductid():UUID.fromString(pricehistory.getPricehistoryProductid()), // "pricehistory_productid" : java.lang.String
            pricehistory.getPricehistorybaseprice(), // "pricehistorybaseprice" : java.lang.Double
            pricehistory.getPricehistoryprice(), // "pricehistoryprice" : java.lang.Double
            pricehistory.getPricehistoryfrom(), // "pricehistoryfrom" : java.util.Date
            pricehistory.getPricehistoryto(), // "pricehistoryto" : java.util.Date
            pricehistory.getPricehistorymoddate() // "pricehistorymoddate" : java.util.Date
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForUpdate(Pricehistory pricehistory) {
        return new Object[]{
            //--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
        	pricehistory.getPricehistoryUserid()==null?pricehistory.getPricehistoryUserid():UUID.fromString(pricehistory.getPricehistoryUserid()), // "pricehistory_userid" : java.lang.String
        	pricehistory.getPricehistoryProductid()==null?pricehistory.getPricehistoryProductid():UUID.fromString(pricehistory.getPricehistoryProductid()), // "pricehistory_productid" : java.lang.String
        	pricehistory.getPricehistorybaseprice(), // "pricehistorybaseprice" : java.lang.Double
            pricehistory.getPricehistoryprice(), // "pricehistoryprice" : java.lang.Double
            pricehistory.getPricehistoryfrom(), // "pricehistoryfrom" : java.util.Date
            pricehistory.getPricehistoryto(), // "pricehistoryto" : java.util.Date
            pricehistory.getPricehistorymoddate(), // "pricehistorymoddate" : java.util.Date
            //--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
            UUID.fromString(pricehistory.getPricehistoryid()) // "pricehistoryid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForPrimaryKey(Pricehistory pricehistory) {
        return new Object[]{
            //--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
            pricehistory.getPricehistoryid() // "pricehistoryid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Pricehistory> getRowMapper(Pricehistory o) {
        //--- RowMapper to populate the given bean instance
        return new PricehistoryRowMapper(o);
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Pricehistory> getRowMapper() {
        //--- RowMapper to populate a new bean instance
        return new PricehistoryRowMapper();
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param pricehistory
     * @throws SQLException
     */
    private Pricehistory populateBean(ResultSet rs, Pricehistory pricehistory) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        pricehistory.setPricehistoryid(rs.getString("pricehistoryid")); // java.lang.String
        pricehistory.setPricehistoryUserid(rs.getString("pricehistory_userid")); // java.lang.String
        pricehistory.setPricehistoryProductid(rs.getString("pricehistory_productid")); // java.lang.String
        pricehistory.setPricehistorybaseprice(rs.getDouble("pricehistorybaseprice")); // java.lang.Double
        if (rs.wasNull()) {
            pricehistory.setPricehistorybaseprice(null);
        }; // not primitive number => keep null value if any
        pricehistory.setPricehistoryprice(rs.getDouble("pricehistoryprice")); // java.lang.Double
        if (rs.wasNull()) {
            pricehistory.setPricehistoryprice(null);
        }; // not primitive number => keep null value if any
        pricehistory.setPricehistoryfrom(rs.getDate("pricehistoryfrom")); // java.util.Date
        pricehistory.setPricehistoryto(rs.getDate("pricehistoryto")); // java.util.Date
        pricehistory.setPricehistorymoddate(rs.getDate("pricehistorymoddate")); // java.util.Date
        return pricehistory;
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param pricehistory
     * @throws SQLException
     */
    private Pricehistory populateBean(ResultSet rs) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        Pricehistory pricehistory = new Pricehistory();
        pricehistory.setPricehistoryid(rs.getString("pricehistoryid")); // java.lang.String
        pricehistory.setPricehistoryUserid(rs.getString("pricehistory_userid")); // java.lang.String
        pricehistory.setPricehistoryProductid(rs.getString("pricehistory_productid")); // java.lang.String
        pricehistory.setPricehistorybaseprice(rs.getDouble("pricehistorybaseprice")); // java.lang.Double
        if (rs.wasNull()) {
            pricehistory.setPricehistorybaseprice(null);
        }; // not primitive number => keep null value if any
        pricehistory.setPricehistoryprice(rs.getDouble("pricehistoryprice")); // java.lang.Double
        if (rs.wasNull()) {
            pricehistory.setPricehistoryprice(null);
        }; // not primitive number => keep null value if any
        pricehistory.setPricehistoryfrom(rs.getDate("pricehistoryfrom")); // java.util.Date
        pricehistory.setPricehistoryto(rs.getDate("pricehistoryto")); // java.util.Date
        pricehistory.setPricehistorymoddate(rs.getDate("pricehistorymoddate")); // java.util.Date
        return pricehistory;
    }

    //----------------------------------------------------------------------
    /**
     * Specific inner class for 'RowMapper' implementation
     */
    private class PricehistoryRowMapper implements RowMapper<Pricehistory> {

        /**
         * The bean instance that will be populated from the ResultSet
         */
        private Pricehistory bean;

        /**
         * Constructor
         *
         * @param bean the bean to be populated
         */
        PricehistoryRowMapper(Pricehistory bean) {
            this.bean = bean;
        }
        
        public PricehistoryRowMapper() {
			// TODO Auto-generated constructor stub
		}

        @Override
        public Pricehistory mapRow(ResultSet rs, int rowNum) throws SQLException {
        	if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
        }
    }

    @Override
    public Pricehistory findById(String pricehistoryid) {
        Object[] primaryKey = new Object[]{UUID.fromString(pricehistoryid)};
        return super.doSelect(primaryKey);
    }

    @Override
    public List<Pricehistory> findAll() {
        return super.doSelectAll();
    }

    @Override
    public Pricehistory save(Pricehistory entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Pricehistory update(Pricehistory entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Pricehistory create(Pricehistory entity) {
        super.doInsert(entity);
        return entity;
    }

    @Override
    public void delete(String pricehistoryid) {
        Object[] primaryKey = new Object[]{pricehistoryid};
        super.doDelete(primaryKey);
    }
}
