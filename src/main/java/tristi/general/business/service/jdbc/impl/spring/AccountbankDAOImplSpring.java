/*
 * Created on 10 Dec 2015 ( Time 04:32:00 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Accountbank;
import tristi.general.business.service.AccountbankService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Accountbank DAO implementation
 *
 * @author Telosys Tools
 *
 */
@Repository
public class AccountbankDAOImplSpring extends GenericDAO<Accountbank> implements AccountbankService {

    private final static String SQL_SELECT_ALL_PAGING
            = "select accountbankid, accountbank_supplierid, accountbank_salesorderid, accountbank_bankid, accountbank_userid, accountbanknumber, accountbankname, accountbankissales, accountbankmoddate from accountbank limit ? offset ?";

    private final static String SQL_SELECT_ALL
            = "select accountbankid, accountbank_supplierid, accountbank_salesorderid, accountbank_bankid, accountbank_userid, accountbanknumber, accountbankname, accountbankissales, accountbankmoddate from accountbank";

    private final static String SQL_SELECT_PAGING
            = "select accountbankid, accountbank_supplierid, accountbank_salesorderid, accountbank_bankid, accountbank_userid, accountbanknumber, accountbankname, accountbankissales, accountbankmoddate from accountbank where accountbankid = ? limit ? offset ?";

    private final static String SQL_SELECT
            = "select accountbankid, accountbank_supplierid, accountbank_salesorderid, accountbank_bankid, accountbank_userid, accountbanknumber, accountbankname, accountbankissales, accountbankmoddate from accountbank where accountbankid = ?";

    private final static String SQL_INSERT
            = "insert into accountbank ( accountbank_supplierid, accountbank_salesorderid, accountbank_bankid, accountbank_userid, accountbanknumber, accountbankname, accountbankissales, accountbankmoddate ) values ( ?, ?, ?, ?, ?, ?, ?, ? )";

    private final static String SQL_UPDATE
            = "update accountbank set accountbank_supplierid = ?, accountbank_salesorderid = ?, accountbank_bankid = ?, accountbank_userid = ?, accountbanknumber = ?, accountbankname = ?, accountbankissales = ?, accountbankmoddate = ? where accountbankid = ?";

    private final static String SQL_DELETE
            = "delete from accountbank where accountbankid = ?";

    private final static String SQL_COUNT_ALL
            = "select count(*) from accountbank";

    private final static String SQL_COUNT
            = "select count(*) from accountbank where accountbankid = ?";

    //----------------------------------------------------------------------
    /**
     * DAO constructor
     */
    public AccountbankDAOImplSpring() {
        super();
    }

    @Override
    public boolean exists(String accountbankid) {
        Object[] primaryKey = new Object[]{accountbankid};
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
    protected Object[] getValuesForInsert(Accountbank accountbank) {
        return new Object[]{
            //--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//            accountbank.getAccountbankid(), // "accountbankid" : java.lang.String
        	accountbank.getAccountbankSupplierid()==null?accountbank.getAccountbankSupplierid():UUID.fromString(accountbank.getAccountbankSupplierid()), // "accountbank_supplierid" : java.lang.String
        	accountbank.getAccountbankSalesorderid()==null?accountbank.getAccountbankSalesorderid():UUID.fromString(accountbank.getAccountbankSalesorderid()), // "accountbank_salesorderid" : java.lang.String
        	accountbank.getAccountbankBankid()==null?accountbank.getAccountbankBankid():UUID.fromString(accountbank.getAccountbankBankid()), // "accountbank_bankid" : java.lang.String
        	accountbank.getAccountbankUserid()==null?accountbank.getAccountbankUserid():UUID.fromString(accountbank.getAccountbankUserid()), // "accountbank_userid" : java.lang.String
        	accountbank.getAccountbanknumber(), // "accountbanknumber" : java.lang.String
            accountbank.getAccountbankname(), // "accountbankname" : java.lang.String
            accountbank.getAccountbankissales(), // "accountbankissales" : java.lang.Boolean
            accountbank.getAccountbankmoddate() // "accountbankmoddate" : java.util.Date
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForUpdate(Accountbank accountbank) {
        return new Object[]{
            //--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
            accountbank.getAccountbankSupplierid()==null?accountbank.getAccountbankSupplierid():UUID.fromString(accountbank.getAccountbankSupplierid()), // "accountbank_supplierid" : java.lang.String
            accountbank.getAccountbankSalesorderid()==null?accountbank.getAccountbankSalesorderid():UUID.fromString(accountbank.getAccountbankSalesorderid()), // "accountbank_salesorderid" : java.lang.String
            accountbank.getAccountbankBankid()==null?accountbank.getAccountbankBankid():UUID.fromString(accountbank.getAccountbankBankid()), // "accountbank_bankid" : java.lang.String
            accountbank.getAccountbankUserid()==null?accountbank.getAccountbankUserid():UUID.fromString(accountbank.getAccountbankUserid()), // "accountbank_userid" : java.lang.String
            accountbank.getAccountbanknumber(), // "accountbanknumber" : java.lang.String
            accountbank.getAccountbankname(), // "accountbankname" : java.lang.String
            accountbank.getAccountbankissales(), // "accountbankissales" : java.lang.Boolean
            accountbank.getAccountbankmoddate(), // "accountbankmoddate" : java.util.Date
            //--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
            UUID.fromString(accountbank.getAccountbankid()) // "accountbankid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForPrimaryKey(Accountbank accountbank) {
        return new Object[]{
            //--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
            accountbank.getAccountbankid() // "accountbankid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Accountbank> getRowMapper(Accountbank o) {
        //--- RowMapper to populate the given bean instance
        return new AccountbankRowMapper(o);
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Accountbank> getRowMapper() {
        //--- RowMapper to populate a new bean instance
        return new AccountbankRowMapper();
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param accountbank
     * @throws SQLException
     */
    private Accountbank populateBean(ResultSet rs, Accountbank accountbank) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        accountbank.setAccountbankid(rs.getString("accountbankid")); // java.lang.String
        accountbank.setAccountbankSupplierid(rs.getString("accountbank_supplierid")); // java.lang.String
        accountbank.setAccountbankSalesorderid(rs.getString("accountbank_salesorderid")); // java.lang.String
        accountbank.setAccountbankBankid(rs.getString("accountbank_bankid")); // java.lang.String
        accountbank.setAccountbankUserid(rs.getString("accountbank_userid")); // java.lang.String
        accountbank.setAccountbanknumber(rs.getString("accountbanknumber")); // java.lang.String
        accountbank.setAccountbankname(rs.getString("accountbankname")); // java.lang.String
        accountbank.setAccountbankissales(rs.getBoolean("accountbankissales")); // java.lang.Boolean
        accountbank.setAccountbankmoddate(rs.getDate("accountbankmoddate")); // java.util.Date
        return accountbank;
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param accountbank
     * @throws SQLException
     */
    private Accountbank populateBean(ResultSet rs) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        Accountbank accountbank = new Accountbank();
        accountbank.setAccountbankid(rs.getString("accountbankid")); // java.lang.String
        accountbank.setAccountbankSupplierid(rs.getString("accountbank_supplierid")); // java.lang.String
        accountbank.setAccountbankSalesorderid(rs.getString("accountbank_salesorderid")); // java.lang.String
        accountbank.setAccountbankBankid(rs.getString("accountbank_bankid")); // java.lang.String
        accountbank.setAccountbankUserid(rs.getString("accountbank_userid")); // java.lang.String
        accountbank.setAccountbanknumber(rs.getString("accountbanknumber")); // java.lang.String
        accountbank.setAccountbankname(rs.getString("accountbankname")); // java.lang.String
        accountbank.setAccountbankissales(rs.getBoolean("accountbankissales")); // java.lang.Boolean
        accountbank.setAccountbankmoddate(rs.getDate("accountbankmoddate")); // java.util.Date
        return accountbank;
    }

    //----------------------------------------------------------------------
    /**
     * Specific inner class for 'RowMapper' implementation
     */
    private class AccountbankRowMapper implements RowMapper<Accountbank> {

        /**
         * The bean instance that will be populated from the ResultSet
         */
        private Accountbank bean;

        /**
         * Constructor
         *
         * @param bean the bean to be populated
         */
        AccountbankRowMapper(Accountbank bean) {
            this.bean = bean;
        }
        
        public AccountbankRowMapper() {
			// TODO Auto-generated constructor stub
		}

        @Override
        public Accountbank mapRow(ResultSet rs, int rowNum) throws SQLException {
        	if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
        }
    }

    @Override
    public Accountbank findById(String accountbankid) {
        Object[] primaryKey = new Object[]{UUID.fromString(accountbankid)};
        return super.doSelect(primaryKey);
    }

    @Override
    public List<Accountbank> findAll() {
        return super.doSelectAll();
    }

    @Override
    public Accountbank save(Accountbank entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Accountbank update(Accountbank entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Accountbank create(Accountbank entity) {
        super.doInsert(entity);
        return entity;
    }

    @Override
    public void delete(String accountbankid) {
        Object[] primaryKey = new Object[]{accountbankid};
        super.doDelete(primaryKey);
    }
}
