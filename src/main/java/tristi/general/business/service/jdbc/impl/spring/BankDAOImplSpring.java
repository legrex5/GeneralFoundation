/*
 * Created on 10 Dec 2015 ( Time 04:32:00 )
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Bank;
import tristi.general.business.service.BankService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Bank DAO implementation
 *
 * @author Telosys Tools
 *
 */
@Repository
public class BankDAOImplSpring extends GenericDAO<Bank> implements BankService {

    private final static String SQL_SELECT_ALL_PAGING
            = "select bankid, bank_userid, bankname, bankdescription, bankisactive, bankmoddate from bank limit ? offset ?";

    private final static String SQL_SELECT_ALL
            = "select bankid, bank_userid, bankname, bankdescription, bankisactive, bankmoddate from bank";

    private final static String SQL_SELECT_PAGING
            = "select bankid, bank_userid, bankname, bankdescription, bankisactive, bankmoddate from bank where bankid = ? limit ? offset ?";

    private final static String SQL_SELECT
            = "select bankid, bank_userid, bankname, bankdescription, bankisactive, bankmoddate from bank where bankid = ?";

    private final static String SQL_INSERT
            = "insert into bank ( bank_userid, bankname, bankdescription, bankisactive, bankmoddate ) values (?, ?, ?, ?, ? )";

    private final static String SQL_UPDATE
            = "update bank set bank_userid = ?, bankname = ?, bankdescription = ?, bankisactive = ?, bankmoddate = ? where bankid = ?";

    private final static String SQL_DELETE
            = "delete from bank where bankid = ?";

    private final static String SQL_COUNT_ALL
            = "select count(*) from bank";

    private final static String SQL_COUNT
            = "select count(*) from bank where bankid = ?";

    //----------------------------------------------------------------------
    /**
     * DAO constructor
     */
    public BankDAOImplSpring() {
        super();
    }

    @Override
    public boolean exists(String bankid) {
        Object[] primaryKey = new Object[]{bankid};
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
    protected Object[] getValuesForInsert(Bank bank) {
        return new Object[]{
            //--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//          bank.getBankid(), // "bankid" : java.lang.String
            bank.getBankUserid()==null?bank.getBankUserid():UUID.fromString(bank.getBankUserid()), // "bank_userid" : java.lang.String
            bank.getBankname(), // "bankname" : java.lang.String
            bank.getBankdescription(), // "bankdescription" : java.lang.String
            bank.getBankisactive(), // "bankisactive" : java.lang.Boolean
            bank.getBankmoddate() // "bankmoddate" : java.util.Date
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForUpdate(Bank bank) {
        return new Object[]{
            //--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
            bank.getBankUserid()==null?bank.getBankUserid():UUID.fromString(bank.getBankUserid()), // "bank_userid" : java.lang.String
            bank.getBankname(), // "bankname" : java.lang.String
            bank.getBankdescription(), // "bankdescription" : java.lang.String
            bank.getBankisactive(), // "bankisactive" : java.lang.Boolean
            bank.getBankmoddate(), // "bankmoddate" : java.util.Date
            //--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
            UUID.fromString(bank.getBankid()) // "bankid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForPrimaryKey(Bank bank) {
        return new Object[]{
            //--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
            bank.getBankid() // "bankid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Bank> getRowMapper(Bank o) {
        //--- RowMapper to populate the given bean instance
        return new BankRowMapper(o);
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Bank> getRowMapper() {
        //--- RowMapper to populate a new bean instance
        return new BankRowMapper();
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param bank
     * @throws SQLException
     */
    private Bank populateBean(ResultSet rs, Bank bank) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        bank.setBankid(rs.getString("bankid")); // java.lang.String
        bank.setBankUserid(rs.getString("bank_userid")); // java.lang.String
        bank.setBankname(rs.getString("bankname")); // java.lang.String
        bank.setBankdescription(rs.getString("bankdescription")); // java.lang.String
        bank.setBankisactive(rs.getBoolean("bankisactive")); // java.lang.Boolean
        bank.setBankmoddate(rs.getDate("bankmoddate")); // java.util.Date
        return bank;
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param bank
     * @throws SQLException
     */
    private Bank populateBean(ResultSet rs) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        Bank bank = new Bank();
        bank.setBankid(rs.getString("bankid")); // java.lang.String
        bank.setBankUserid(rs.getString("bank_userid")); // java.lang.String
        bank.setBankname(rs.getString("bankname")); // java.lang.String
        bank.setBankdescription(rs.getString("bankdescription")); // java.lang.String
        bank.setBankisactive(rs.getBoolean("bankisactive")); // java.lang.Boolean
        bank.setBankmoddate(rs.getDate("bankmoddate")); // java.util.Date
        return bank;
    }

    //----------------------------------------------------------------------
    /**
     * Specific inner class for 'RowMapper' implementation
     */
    private class BankRowMapper implements RowMapper<Bank> {

        /**
         * The bean instance that will be populated from the ResultSet
         */
        private Bank bean;

        /**
         * Constructor
         *
         * @param bean the bean to be populated
         */
        BankRowMapper(Bank bean) {
            this.bean = bean;
        }
        
        public BankRowMapper() {
			// TODO Auto-generated constructor stub
		}

        @Override
        public Bank mapRow(ResultSet rs, int rowNum) throws SQLException {
        	if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
        }
    }

    @Override
    public Bank findById(String bankid) {
        Object[] primaryKey = new Object[]{UUID.fromString(bankid)};
        return super.doSelect(primaryKey);
    }

    @Override
    public List<Bank> findAll() {
        return super.doSelectAll();
    }

    @Override
    public Bank save(Bank entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Bank update(Bank entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Bank create(Bank entity) {
        super.doInsert(entity);
        return entity;
    }

    @Override
    public void delete(String bankid) {
        Object[] primaryKey = new Object[]{bankid};
        super.doDelete(primaryKey);
    }
}
