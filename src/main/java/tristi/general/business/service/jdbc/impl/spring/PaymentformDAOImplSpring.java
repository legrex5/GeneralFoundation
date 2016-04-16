/*
 * Created on 10 Dec 2015
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Paymentform;
import tristi.general.business.service.PaymentformService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Paymentform DAO implementation
 *
 * @author Telosys Tools
 *
 */
@Repository
public class PaymentformDAOImplSpring extends GenericDAO<Paymentform> implements PaymentformService {

    private final static String SQL_SELECT_ALL_PAGING
            = "select paymentformid, paymentform_userid, paymentformcode, paymentformname, paymentformiscredit, paymentformneedbank, paymentformisactive, paymentformmoddate from paymentform limit ? offset ?";

    private final static String SQL_SELECT_ALL
            = "select paymentformid, paymentform_userid, paymentformcode, paymentformname, paymentformiscredit, paymentformneedbank, paymentformisactive, paymentformmoddate from paymentform";

    private final static String SQL_SELECT_PAGING
            = "select paymentformid, paymentform_userid, paymentformcode, paymentformname, paymentformiscredit, paymentformneedbank, paymentformisactive, paymentformmoddate from paymentform where paymentformid = ? limit ? offset ?";

    private final static String SQL_SELECT
            = "select paymentformid, paymentform_userid, paymentformcode, paymentformname, paymentformiscredit, paymentformneedbank, paymentformisactive, paymentformmoddate from paymentform where paymentformid = ?";

    private final static String SQL_INSERT
            = "insert into paymentform ( paymentform_userid, paymentformcode, paymentformname, paymentformiscredit, paymentformneedbank, paymentformisactive, paymentformmoddate ) values ( ?, ?, ?, ?, ?, ?, ? )";

    private final static String SQL_UPDATE
            = "update paymentform set paymentform_userid = ?, paymentformcode = ?, paymentformname = ?, paymentformiscredit = ?, paymentformneedbank = ?, paymentformisactive = ?, paymentformmoddate = ? where paymentformid = ?";

    private final static String SQL_DELETE
            = "delete from paymentform where paymentformid = ?";

    private final static String SQL_COUNT_ALL
            = "select count(*) from paymentform";

    private final static String SQL_COUNT
            = "select count(*) from paymentform where paymentformid = ?";

    //----------------------------------------------------------------------
    /**
     * DAO constructor
     */
    public PaymentformDAOImplSpring() {
        super();
    }

    @Override
    public boolean exists(String paymentformid) {
        Object[] primaryKey = new Object[]{paymentformid};
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
    protected Object[] getValuesForInsert(Paymentform paymentform) {
        return new Object[]{
            //--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//            paymentform.getPaymentformid(), // "paymentformid" : java.lang.String
            paymentform.getPaymentformUserid()==null?paymentform.getPaymentformUserid():UUID.fromString(paymentform.getPaymentformUserid()), // "paymentform_userid" : java.lang.String
            paymentform.getPaymentformcode(), // "paymentformcode" : java.lang.String
            paymentform.getPaymentformname(), // "paymentformname" : java.lang.String
            paymentform.getPaymentformiscredit(), // "paymentformiscredit" : java.lang.Boolean
            paymentform.getPaymentformneedbank(), // "paymentformneedbank" : java.lang.Boolean
            paymentform.getPaymentformisactive(), // "paymentformisactive" : java.lang.Boolean
            paymentform.getPaymentformmoddate() // "paymentformmoddate" : java.util.Date
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForUpdate(Paymentform paymentform) {
        return new Object[]{
            //--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
        	paymentform.getPaymentformUserid()==null?paymentform.getPaymentformUserid():UUID.fromString(paymentform.getPaymentformUserid()), // "paymentform_userid" : java.lang.String
        	paymentform.getPaymentformcode(), // "paymentformcode" : java.lang.String
            paymentform.getPaymentformname(), // "paymentformname" : java.lang.String
            paymentform.getPaymentformiscredit(), // "paymentformiscredit" : java.lang.Boolean
            paymentform.getPaymentformneedbank(), // "paymentformneedbank" : java.lang.Boolean
            paymentform.getPaymentformisactive(), // "paymentformisactive" : java.lang.Boolean
            paymentform.getPaymentformmoddate(), // "paymentformmoddate" : java.util.Date
            //--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
            UUID.fromString(paymentform.getPaymentformid()) // "paymentformid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForPrimaryKey(Paymentform paymentform) {
        return new Object[]{
            //--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
            paymentform.getPaymentformid() // "paymentformid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Paymentform> getRowMapper(Paymentform o) {
        //--- RowMapper to populate the given bean instance
        return new PaymentformRowMapper(o);
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Paymentform> getRowMapper() {
        //--- RowMapper to populate a new bean instance
        return new PaymentformRowMapper();
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param paymentform
     * @throws SQLException
     */
    private Paymentform populateBean(ResultSet rs, Paymentform paymentform) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        paymentform.setPaymentformid(rs.getString("paymentformid")); // java.lang.String
        paymentform.setPaymentformUserid(rs.getString("paymentform_userid")); // java.lang.String
        paymentform.setPaymentformcode(rs.getString("paymentformcode")); // java.lang.String
        paymentform.setPaymentformname(rs.getString("paymentformname")); // java.lang.String
        paymentform.setPaymentformiscredit(rs.getBoolean("paymentformiscredit")); // java.lang.Boolean
        paymentform.setPaymentformneedbank(rs.getBoolean("paymentformneedbank")); // java.lang.Boolean
        paymentform.setPaymentformisactive(rs.getBoolean("paymentformisactive")); // java.lang.Boolean
        paymentform.setPaymentformmoddate(rs.getDate("paymentformmoddate")); // java.util.Date
        return paymentform;
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param paymentform
     * @throws SQLException
     */
    private Paymentform populateBean(ResultSet rs) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        Paymentform paymentform = new Paymentform();
        paymentform.setPaymentformid(rs.getString("paymentformid")); // java.lang.String
        paymentform.setPaymentformUserid(rs.getString("paymentform_userid")); // java.lang.String
        paymentform.setPaymentformcode(rs.getString("paymentformcode")); // java.lang.String
        paymentform.setPaymentformname(rs.getString("paymentformname")); // java.lang.String
        paymentform.setPaymentformiscredit(rs.getBoolean("paymentformiscredit")); // java.lang.Boolean
        paymentform.setPaymentformneedbank(rs.getBoolean("paymentformneedbank")); // java.lang.Boolean
        paymentform.setPaymentformisactive(rs.getBoolean("paymentformisactive")); // java.lang.Boolean
        paymentform.setPaymentformmoddate(rs.getDate("paymentformmoddate")); // java.util.Date
        return paymentform;
    }

    //----------------------------------------------------------------------
    /**
     * Specific inner class for 'RowMapper' implementation
     */
    private class PaymentformRowMapper implements RowMapper<Paymentform> {

        /**
         * The bean instance that will be populated from the ResultSet
         */
        private Paymentform bean;

        /**
         * Constructor
         *
         * @param bean the bean to be populated
         */
        PaymentformRowMapper(Paymentform bean) {
            this.bean = bean;
        }
        
        public PaymentformRowMapper() {
			// TODO Auto-generated constructor stub
		}

        @Override
        public Paymentform mapRow(ResultSet rs, int rowNum) throws SQLException {
        	if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
        }
    }

    @Override
    public Paymentform findById(String paymentformid) {
        Object[] primaryKey = new Object[]{UUID.fromString(paymentformid)};
        return super.doSelect(primaryKey);
    }

    @Override
    public List<Paymentform> findAll() {
        return super.doSelectAll();
    }

    @Override
    public Paymentform save(Paymentform entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Paymentform update(Paymentform entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Paymentform create(Paymentform entity) {
        super.doInsert(entity);
        return entity;
    }

    @Override
    public void delete(String paymentformid) {
        Object[] primaryKey = new Object[]{paymentformid};
        super.doDelete(primaryKey);
    }
}
