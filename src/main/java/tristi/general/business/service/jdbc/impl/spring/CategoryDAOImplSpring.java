/*
 * Created on 10 Dec 2015 ( Time 04:32:00 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Category;
import tristi.general.business.service.CategoryService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Category DAO implementation
 *
 * @author Telosys Tools
 *
 */
@Repository
public class CategoryDAOImplSpring extends GenericDAO<Category> implements CategoryService {

    private final static String SQL_SELECT_ALL_PAGING
            = "select categoryid, category_userid, categorycode, categoryname, categoryisactive, categorymoddate from category limit ? offset ?";

    private final static String SQL_SELECT_ALL
            = "select categoryid, category_userid, categorycode, categoryname, categoryisactive, categorymoddate from category";

    private final static String SQL_SELECT_PAGING
            = "select categoryid, category_userid, categorycode, categoryname, categoryisactive, categorymoddate from category where categoryid = ? limit ? offset ?";

    private final static String SQL_SELECT
            = "select categoryid, category_userid, categorycode, categoryname, categoryisactive, categorymoddate from category where categoryid = ?";

    private final static String SQL_INSERT
            = "insert into category ( category_userid, categorycode, categoryname, categoryisactive, categorymoddate ) values ( ?, ?, ?, ?, ? )";

    private final static String SQL_UPDATE
            = "update category set category_userid = ?, categorycode = ?, categoryname = ?, categoryisactive = ?, categorymoddate = ? where categoryid = ?";

    private final static String SQL_DELETE
            = "delete from category where categoryid = ?";

    private final static String SQL_COUNT_ALL
            = "select count(*) from category";

    private final static String SQL_COUNT
            = "select count(*) from category where categoryid = ?";

    //----------------------------------------------------------------------
    /**
     * DAO constructor
     */
    public CategoryDAOImplSpring() {
        super();
    }

    @Override
    public boolean exists(String categoryid) {
        Object[] primaryKey = new Object[]{categoryid};
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
    protected Object[] getValuesForInsert(Category category) {
        return new Object[]{
            //--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
            //ID Generate with Postgresql Function
            //category.getCategoryid() , // "categoryid" : java.util.UUID
            category.getCategoryUserid()==null?category.getCategoryUserid():UUID.fromString(category.getCategoryUserid()), // "category_userid" : java.lang.String
            category.getCategorycode(), // "categorycode" : java.lang.String
            category.getCategoryname(), // "categoryname" : java.lang.String
            category.getCategoryisactive(), // "categoryisactive" : java.lang.Boolean
            category.getCategorymoddate() // "categorymoddate" : java.util.Date
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForUpdate(Category category) {
        return new Object[]{
            //--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
        	category.getCategoryUserid()==null?category.getCategoryUserid():UUID.fromString(category.getCategoryUserid()), // "category_userid" : java.lang.String
            category.getCategorycode(), // "categorycode" : java.lang.String
            category.getCategoryname(), // "categoryname" : java.lang.String
            category.getCategoryisactive(), // "categoryisactive" : java.lang.Boolean
            category.getCategorymoddate(), // "categorymoddate" : java.util.Date
            //--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
            UUID.fromString(category.getCategoryid()) // "categoryid" : java.util.UUID
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForPrimaryKey(Category category) {
        return new Object[]{
            //--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
            category.getCategoryid() // "categoryid" : java.util.UUID
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Category> getRowMapper(Category o) {
        //--- RowMapper to populate the given bean instance
        return new CategoryRowMapper(o);
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Category> getRowMapper() {
        //--- RowMapper to populate a new bean instance
        return new CategoryRowMapper();
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param category
     * @throws SQLException
     */
    private Category populateBean(ResultSet rs, Category category) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        category.setCategoryid(rs.getString("categoryid")); // java.lang.String
        category.setCategoryUserid(rs.getString("category_userid")); // java.lang.String
        category.setCategorycode(rs.getString("categorycode")); // java.lang.String
        category.setCategoryname(rs.getString("categoryname")); // java.lang.String
        category.setCategoryisactive(rs.getBoolean("categoryisactive")); // java.lang.Boolean
        category.setCategorymoddate(rs.getDate("categorymoddate")); // java.util.Date
        return category;
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @throws SQLException
     */
    private Category populateBean(ResultSet rs) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        Category category = new Category();
        category.setCategoryid(rs.getString("categoryid")); // java.lang.String
        category.setCategoryUserid(rs.getString("category_userid")); // java.lang.String
        category.setCategorycode(rs.getString("categorycode")); // java.lang.String
        category.setCategoryname(rs.getString("categoryname")); // java.lang.String
        category.setCategoryisactive(rs.getBoolean("categoryisactive")); // java.lang.Boolean
        category.setCategorymoddate(rs.getDate("categorymoddate")); // java.util.Date
        return category;
    }

    //----------------------------------------------------------------------
    /**
     * Specific inner class for 'RowMapper' implementation
     */
    private class CategoryRowMapper implements RowMapper<Category> {

        /**
         * The bean instance that will be populated from the ResultSet
         */
        private Category bean;

        /**
         * Constructor
         *
         * @param bean the bean to be populated
         */
        CategoryRowMapper(Category bean) {
            this.bean = bean;
        }

        CategoryRowMapper() {}

        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
        }
    }

    @Override
    public Category findById(String categoryid) {
        Object[] primaryKey = new Object[]{UUID.fromString(categoryid)};
        return super.doSelect(primaryKey);
    }

    @Override
    public List<Category> findAll() {

        return super.doSelectAll();
    }

    @Override
    public Category save(Category entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Category update(Category entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Category create(Category entity) {
        super.doInsert(entity);
        return entity;
    }

    @Override
    public void delete(String categoryid) {
        Object[] primaryKey = new Object[]{categoryid};
        super.doDelete(primaryKey);
    }
}
