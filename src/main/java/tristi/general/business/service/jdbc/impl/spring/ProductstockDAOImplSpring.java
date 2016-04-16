/*
 * Created on 10 Dec 2015
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Productstock;
import tristi.general.business.service.ProductstockService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Productstock DAO implementation
 *
 *
 */
@Repository
public class ProductstockDAOImplSpring extends GenericDAO<Productstock> implements ProductstockService {

    private final static String SQL_SELECT_ALL_PAGING
            = "select productstockid, productstock_locationid, productstock_userid, productstock_productuomid, productstockqty, productstockmin, productstockmax, productstockmoddate from productstock limit ? offset ?";

    private final static String SQL_SELECT_ALL
            = "select productstockid, productstock_locationid, productstock_userid, productstock_productuomid, productstockqty, productstockmin, productstockmax, productstockmoddate from productstock";

    private final static String SQL_SELECT_PAGING
            = "select productstockid, productstock_locationid, productstock_userid, productstock_productuomid, productstockqty, productstockmin, productstockmax, productstockmoddate from productstock where productstockid = ? limit ? offset ?";

    private final static String SQL_SELECT
            = "select productstockid, productstock_locationid, productstock_userid, productstock_productuomid, productstockqty, productstockmin, productstockmax, productstockmoddate from productstock where productstockid = ?";

    private final static String SQL_INSERT
            = "insert into productstock ( productstock_locationid, productstock_userid, productstock_productuomid, productstockqty, productstockmin, productstockmax, productstockmoddate ) values ( ?, ?, ?, ?, ?, ?, ? )";

    private final static String SQL_UPDATE
            = "update productstock set productstock_locationid = ?, productstock_userid = ?, productstock_productuomid = ?, productstockqty = ?, productstockmin = ?, productstockmax = ?, productstockmoddate = ? where productstockid = ?";

    private final static String SQL_DELETE
            = "delete from productstock where productstockid = ?";

    private final static String SQL_COUNT_ALL
            = "select count(*) from productstock";

    private final static String SQL_COUNT
            = "select count(*) from productstock where productstockid = ?";

    //----------------------------------------------------------------------
    /**
     * DAO constructor
     */
    public ProductstockDAOImplSpring() {
        super();
    }

    @Override
    public boolean exists(String productstockid) {
        Object[] primaryKey = new Object[]{productstockid};
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
    protected Object[] getValuesForInsert(Productstock productstock) {
        return new Object[]{
            //--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//            productstock.getProductstockid(), // "productstockid" : java.lang.String
            productstock.getProductstockLocationid()==null?productstock.getProductstockLocationid():UUID.fromString(productstock.getProductstockLocationid()), // "productstock_locationid" : java.lang.String
            productstock.getProductstockUserid()==null?productstock.getProductstockUserid():UUID.fromString(productstock.getProductstockUserid()), // "productstock_userid" : java.lang.String
            productstock.getProductstockProductuomid()==null?productstock.getProductstockProductuomid():UUID.fromString(productstock.getProductstockProductuomid()), // "productstock_productuomid" : java.lang.String
            productstock.getProductstockqty(), // "productstockqty" : java.lang.Integer
            productstock.getProductstockmin(), // "productstockmin" : java.lang.Integer
            productstock.getProductstockmax(), // "productstockmax" : java.lang.Integer
            productstock.getProductstockmoddate() // "productstockmoddate" : java.util.Date
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForUpdate(Productstock productstock) {
        return new Object[]{
            //--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
        	productstock.getProductstockLocationid()==null?productstock.getProductstockLocationid():UUID.fromString(productstock.getProductstockLocationid()), // "productstock_locationid" : java.lang.String
        	productstock.getProductstockUserid()==null?productstock.getProductstockUserid():UUID.fromString(productstock.getProductstockUserid()), // "productstock_userid" : java.lang.String
        	productstock.getProductstockProductuomid()==null?productstock.getProductstockProductuomid():UUID.fromString(productstock.getProductstockProductuomid()), // "productstock_productuomid" : java.lang.String
        	productstock.getProductstockqty(), // "productstockqty" : java.lang.Integer
            productstock.getProductstockmin(), // "productstockmin" : java.lang.Integer
            productstock.getProductstockmax(), // "productstockmax" : java.lang.Integer
            productstock.getProductstockmoddate(), // "productstockmoddate" : java.util.Date
            //--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
            UUID.fromString(productstock.getProductstockid()) // "productstockid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForPrimaryKey(Productstock productstock) {
        return new Object[]{
            //--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
            productstock.getProductstockid() // "productstockid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Productstock> getRowMapper(Productstock o) {
        //--- RowMapper to populate the given bean instance
        return new ProductstockRowMapper(o);
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Productstock> getRowMapper() {
        //--- RowMapper to populate a new bean instance
        return new ProductstockRowMapper();
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param productstock
     * @throws SQLException
     */
    private Productstock populateBean(ResultSet rs, Productstock productstock) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        productstock.setProductstockid(rs.getString("productstockid")); // java.lang.String
        productstock.setProductstockLocationid(rs.getString("productstock_locationid")); // java.lang.String
        productstock.setProductstockUserid(rs.getString("productstock_userid")); // java.lang.String
        productstock.setProductstockProductuomid(rs.getString("productstock_productuomid")); // java.lang.String
        productstock.setProductstockqty(rs.getInt("productstockqty")); // java.lang.Integer
        if (rs.wasNull()) {
            productstock.setProductstockqty(null);
        }; // not primitive number => keep null value if any
        productstock.setProductstockmin(rs.getInt("productstockmin")); // java.lang.Integer
        if (rs.wasNull()) {
            productstock.setProductstockmin(null);
        }; // not primitive number => keep null value if any
        productstock.setProductstockmax(rs.getInt("productstockmax")); // java.lang.Integer
        if (rs.wasNull()) {
            productstock.setProductstockmax(null);
        }; // not primitive number => keep null value if any
        productstock.setProductstockmoddate(rs.getDate("productstockmoddate")); // java.util.Date
        return productstock;
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param productstock
     * @throws SQLException
     */
    private Productstock populateBean(ResultSet rs) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        Productstock productstock = new Productstock();
        productstock.setProductstockid(rs.getString("productstockid")); // java.lang.String
        productstock.setProductstockLocationid(rs.getString("productstock_locationid")); // java.lang.String
        productstock.setProductstockUserid(rs.getString("productstock_userid")); // java.lang.String
        productstock.setProductstockProductuomid(rs.getString("productstock_productuomid")); // java.lang.String
        productstock.setProductstockqty(rs.getInt("productstockqty")); // java.lang.Integer
        if (rs.wasNull()) {
            productstock.setProductstockqty(null);
        }; // not primitive number => keep null value if any
        productstock.setProductstockmin(rs.getInt("productstockmin")); // java.lang.Integer
        if (rs.wasNull()) {
            productstock.setProductstockmin(null);
        }; // not primitive number => keep null value if any
        productstock.setProductstockmax(rs.getInt("productstockmax")); // java.lang.Integer
        if (rs.wasNull()) {
            productstock.setProductstockmax(null);
        }; // not primitive number => keep null value if any
        productstock.setProductstockmoddate(rs.getDate("productstockmoddate")); // java.util.Date
        return productstock;
    }

    //----------------------------------------------------------------------
    /**
     * Specific inner class for 'RowMapper' implementation
     */
    private class ProductstockRowMapper implements RowMapper<Productstock> {

        /**
         * The bean instance that will be populated from the ResultSet
         */
        private Productstock bean;

        /**
         * Constructor
         *
         * @param bean the bean to be populated
         */
        ProductstockRowMapper(Productstock bean) {
            this.bean = bean;
        }
        
        public ProductstockRowMapper() {
			// TODO Auto-generated constructor stub
		}

        @Override
        public Productstock mapRow(ResultSet rs, int rowNum) throws SQLException {
        	if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
        }
    }

    @Override
    public Productstock findById(String productstockid) {
        Object[] primaryKey = new Object[]{UUID.fromString(productstockid)};
        return super.doSelect(primaryKey);
    }

    @Override
    public List<Productstock> findAll() {
        return super.doSelectAll();
    }

    @Override
    public Productstock save(Productstock entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Productstock update(Productstock entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Productstock create(Productstock entity) {
        super.doInsert(entity);
        return entity;
    }

    @Override
    public void delete(String productstockid) {
        Object[] primaryKey = new Object[]{productstockid};
        super.doDelete(primaryKey);
    }
}
