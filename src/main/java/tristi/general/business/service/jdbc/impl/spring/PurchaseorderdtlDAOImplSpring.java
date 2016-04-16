/*
 * Created on 10 Dec 2015
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Purchaseorderdtl;
import tristi.general.business.service.PurchaseorderdtlService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Purchaseorderdtl DAO implementation
 *
 *
 */
@Repository
public class PurchaseorderdtlDAOImplSpring extends GenericDAO<Purchaseorderdtl> implements PurchaseorderdtlService {

    private final static String SQL_SELECT_ALL_PAGING
            = "select purchaseorderdtlid, podtl_poid, podtl_productuomid, podtl_userid, podtl_detailexpiredid, purchaseorderdtlqty, purchaseorderdtlremainingqty, purchaseorderdtlprice, purchaseorderdtldiscount, purchaseorderdtlmoddate from purchaseorderdtl limit ? offset ?";

    private final static String SQL_SELECT_ALL
            = "select purchaseorderdtlid, podtl_poid, podtl_productuomid, podtl_userid, podtl_detailexpiredid, purchaseorderdtlqty, purchaseorderdtlremainingqty, purchaseorderdtlprice, purchaseorderdtldiscount, purchaseorderdtlmoddate from purchaseorderdtl";

    private final static String SQL_SELECT_PAGING
            = "select purchaseorderdtlid, podtl_poid, podtl_productuomid, podtl_userid, podtl_detailexpiredid, purchaseorderdtlqty, purchaseorderdtlremainingqty, purchaseorderdtlprice, purchaseorderdtldiscount, purchaseorderdtlmoddate from purchaseorderdtl where purchaseorderdtlid = ? limit ? offset ?";

    private final static String SQL_SELECT
            = "select purchaseorderdtlid, podtl_poid, podtl_productuomid, podtl_userid, podtl_detailexpiredid, purchaseorderdtlqty, purchaseorderdtlremainingqty, purchaseorderdtlprice, purchaseorderdtldiscount, purchaseorderdtlmoddate from purchaseorderdtl where purchaseorderdtlid = ?";

    private final static String SQL_INSERT
            = "insert into purchaseorderdtl ( podtl_poid, podtl_productuomid, podtl_userid, podtl_detailexpiredid, purchaseorderdtlqty, purchaseorderdtlremainingqty, purchaseorderdtlprice, purchaseorderdtldiscount, purchaseorderdtlmoddate ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";

    private final static String SQL_UPDATE
            = "update purchaseorderdtl set podtl_poid = ?, podtl_productuomid = ?, podtl_userid = ?, podtl_detailexpiredid = ?, purchaseorderdtlqty = ?, purchaseorderdtlremainingqty = ?, purchaseorderdtlprice = ?, purchaseorderdtldiscount = ?, purchaseorderdtlmoddate = ? where purchaseorderdtlid = ?";

    private final static String SQL_DELETE
            = "delete from purchaseorderdtl where purchaseorderdtlid = ?";

    private final static String SQL_COUNT_ALL
            = "select count(*) from purchaseorderdtl";

    private final static String SQL_COUNT
            = "select count(*) from purchaseorderdtl where purchaseorderdtlid = ?";

    //----------------------------------------------------------------------
    /**
     * DAO constructor
     */
    public PurchaseorderdtlDAOImplSpring() {
        super();
    }

    @Override
    public boolean exists(String purchaseorderdtlid) {
        Object[] primaryKey = new Object[]{purchaseorderdtlid};
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
    protected Object[] getValuesForInsert(Purchaseorderdtl purchaseorderdtl) {
        return new Object[]{
            //--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//            purchaseorderdtl.getPurchaseorderdtlid(), // "purchaseorderdtlid" : java.lang.String
            purchaseorderdtl.getPodtlPoid()==null?purchaseorderdtl.getPodtlPoid():UUID.fromString(purchaseorderdtl.getPodtlPoid()), // "podtl_poid" : java.lang.String
            purchaseorderdtl.getPodtlProductuomid()==null?purchaseorderdtl.getPodtlProductuomid():UUID.fromString(purchaseorderdtl.getPodtlProductuomid()), // "podtl_productuomid" : java.lang.String
            purchaseorderdtl.getPodtlUserid()==null?purchaseorderdtl.getPodtlUserid():UUID.fromString(purchaseorderdtl.getPodtlUserid()), // "podtl_userid" : java.lang.String
            purchaseorderdtl.getPodtlDetailexpiredid()==null?purchaseorderdtl.getPodtlDetailexpiredid():UUID.fromString(purchaseorderdtl.getPodtlDetailexpiredid()), // "podtl_detailexpiredid" : java.lang.String
            purchaseorderdtl.getPurchaseorderdtlqty(), // "purchaseorderdtlqty" : java.lang.Integer
            purchaseorderdtl.getPurchaseorderdtlremainingqty(), // "purchaseorderdtlremainingqty" : java.lang.Integer
            purchaseorderdtl.getPurchaseorderdtlprice(), // "purchaseorderdtlprice" : java.lang.Double
            purchaseorderdtl.getPurchaseorderdtldiscount(), // "purchaseorderdtldiscount" : java.lang.Double
            purchaseorderdtl.getPurchaseorderdtlmoddate() // "purchaseorderdtlmoddate" : java.util.Date
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForUpdate(Purchaseorderdtl purchaseorderdtl) {
        return new Object[]{
            //--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
        	purchaseorderdtl.getPodtlPoid()==null?purchaseorderdtl.getPodtlPoid():UUID.fromString(purchaseorderdtl.getPodtlPoid()), // "podtl_poid" : java.lang.String
        	purchaseorderdtl.getPodtlProductuomid()==null?purchaseorderdtl.getPodtlProductuomid():UUID.fromString(purchaseorderdtl.getPodtlProductuomid()), // "podtl_productuomid" : java.lang.String
        	purchaseorderdtl.getPodtlUserid()==null?purchaseorderdtl.getPodtlUserid():UUID.fromString(purchaseorderdtl.getPodtlUserid()), // "podtl_userid" : java.lang.String
        	purchaseorderdtl.getPodtlDetailexpiredid()==null?purchaseorderdtl.getPodtlDetailexpiredid():UUID.fromString(purchaseorderdtl.getPodtlDetailexpiredid()), // "podtl_detailexpiredid" : java.lang.String
        	purchaseorderdtl.getPurchaseorderdtlqty(), // "purchaseorderdtlqty" : java.lang.Integer
            purchaseorderdtl.getPurchaseorderdtlremainingqty(), // "purchaseorderdtlremainingqty" : java.lang.Integer
            purchaseorderdtl.getPurchaseorderdtlprice(), // "purchaseorderdtlprice" : java.lang.Double
            purchaseorderdtl.getPurchaseorderdtldiscount(), // "purchaseorderdtldiscount" : java.lang.Double
            purchaseorderdtl.getPurchaseorderdtlmoddate(), // "purchaseorderdtlmoddate" : java.util.Date
            //--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
            UUID.fromString(purchaseorderdtl.getPurchaseorderdtlid()) // "purchaseorderdtlid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForPrimaryKey(Purchaseorderdtl purchaseorderdtl) {
        return new Object[]{
            //--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
            purchaseorderdtl.getPurchaseorderdtlid() // "purchaseorderdtlid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Purchaseorderdtl> getRowMapper(Purchaseorderdtl o) {
        //--- RowMapper to populate the given bean instance
        return new PurchaseorderdtlRowMapper(o);
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Purchaseorderdtl> getRowMapper() {
        //--- RowMapper to populate a new bean instance
        return new PurchaseorderdtlRowMapper();
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param purchaseorderdtl
     * @throws SQLException
     */
    private Purchaseorderdtl populateBean(ResultSet rs, Purchaseorderdtl purchaseorderdtl) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        purchaseorderdtl.setPurchaseorderdtlid(rs.getString("purchaseorderdtlid")); // java.lang.String
        purchaseorderdtl.setPodtlPoid(rs.getString("podtl_poid")); // java.lang.String
        purchaseorderdtl.setPodtlProductuomid(rs.getString("podtl_productuomid")); // java.lang.String
        purchaseorderdtl.setPodtlUserid(rs.getString("podtl_userid")); // java.lang.String
        purchaseorderdtl.setPodtlDetailexpiredid(rs.getString("podtl_detailexpiredid")); // java.lang.String
        purchaseorderdtl.setPurchaseorderdtlqty(rs.getInt("purchaseorderdtlqty")); // java.lang.Integer
        if (rs.wasNull()) {
            purchaseorderdtl.setPurchaseorderdtlqty(null);
        }; // not primitive number => keep null value if any
        purchaseorderdtl.setPurchaseorderdtlremainingqty(rs.getInt("purchaseorderdtlremainingqty")); // java.lang.Integer
        if (rs.wasNull()) {
            purchaseorderdtl.setPurchaseorderdtlremainingqty(null);
        }; // not primitive number => keep null value if any
        purchaseorderdtl.setPurchaseorderdtlprice(rs.getDouble("purchaseorderdtlprice")); // java.lang.Double
        if (rs.wasNull()) {
            purchaseorderdtl.setPurchaseorderdtlprice(null);
        }; // not primitive number => keep null value if any
        purchaseorderdtl.setPurchaseorderdtldiscount(rs.getDouble("purchaseorderdtldiscount")); // java.lang.Double
        if (rs.wasNull()) {
            purchaseorderdtl.setPurchaseorderdtldiscount(null);
        }; // not primitive number => keep null value if any
        purchaseorderdtl.setPurchaseorderdtlmoddate(rs.getDate("purchaseorderdtlmoddate")); // java.util.Date
        return purchaseorderdtl;
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param purchaseorderdtl
     * @throws SQLException
     */
    private Purchaseorderdtl populateBean(ResultSet rs) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        Purchaseorderdtl purchaseorderdtl = new Purchaseorderdtl();
        purchaseorderdtl.setPurchaseorderdtlid(rs.getString("purchaseorderdtlid")); // java.lang.String
        purchaseorderdtl.setPodtlPoid(rs.getString("podtl_poid")); // java.lang.String
        purchaseorderdtl.setPodtlProductuomid(rs.getString("podtl_productuomid")); // java.lang.String
        purchaseorderdtl.setPodtlUserid(rs.getString("podtl_userid")); // java.lang.String
        purchaseorderdtl.setPodtlDetailexpiredid(rs.getString("podtl_detailexpiredid")); // java.lang.String
        purchaseorderdtl.setPurchaseorderdtlqty(rs.getInt("purchaseorderdtlqty")); // java.lang.Integer
        if (rs.wasNull()) {
            purchaseorderdtl.setPurchaseorderdtlqty(null);
        }; // not primitive number => keep null value if any
        purchaseorderdtl.setPurchaseorderdtlremainingqty(rs.getInt("purchaseorderdtlremainingqty")); // java.lang.Integer
        if (rs.wasNull()) {
            purchaseorderdtl.setPurchaseorderdtlremainingqty(null);
        }; // not primitive number => keep null value if any
        purchaseorderdtl.setPurchaseorderdtlprice(rs.getDouble("purchaseorderdtlprice")); // java.lang.Double
        if (rs.wasNull()) {
            purchaseorderdtl.setPurchaseorderdtlprice(null);
        }; // not primitive number => keep null value if any
        purchaseorderdtl.setPurchaseorderdtldiscount(rs.getDouble("purchaseorderdtldiscount")); // java.lang.Double
        if (rs.wasNull()) {
            purchaseorderdtl.setPurchaseorderdtldiscount(null);
        }; // not primitive number => keep null value if any
        purchaseorderdtl.setPurchaseorderdtlmoddate(rs.getDate("purchaseorderdtlmoddate")); // java.util.Date
        return purchaseorderdtl;
    }

    //----------------------------------------------------------------------
    /**
     * Specific inner class for 'RowMapper' implementation
     */
    private class PurchaseorderdtlRowMapper implements RowMapper<Purchaseorderdtl> {

        /**
         * The bean instance that will be populated from the ResultSet
         */
        private Purchaseorderdtl bean;

        /**
         * Constructor
         *
         * @param bean the bean to be populated
         */
        PurchaseorderdtlRowMapper(Purchaseorderdtl bean) {
            this.bean = bean;
        }
        
        public PurchaseorderdtlRowMapper() {
			// TODO Auto-generated constructor stub
		}

        @Override
        public Purchaseorderdtl mapRow(ResultSet rs, int rowNum) throws SQLException {
        	if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
        }
    }

    @Override
    public Purchaseorderdtl findById(String purchaseorderdtlid) {
        Object[] primaryKey = new Object[]{UUID.fromString(purchaseorderdtlid)};
        return super.doSelect(primaryKey);
    }

    @Override
    public List<Purchaseorderdtl> findAll() {
        return super.doSelectAll();
    }

    @Override
    public Purchaseorderdtl save(Purchaseorderdtl entity) {
        super.doUpdate(entity);
        return null;
    }

    @Override
    public Purchaseorderdtl update(Purchaseorderdtl entity) {
        super.doUpdate(entity);
        return null;
    }

    @Override
    public Purchaseorderdtl create(Purchaseorderdtl entity) {
        super.doInsert(entity);
        return entity;
    }

    @Override
    public void delete(String purchaseorderdtlid) {
        Object[] primaryKey = new Object[]{purchaseorderdtlid};
        super.doDelete(primaryKey);
    }
}
