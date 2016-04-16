/*
 * Created on 10 Dec 2015
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Product;
import tristi.general.business.service.ProductService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Product DAO implementation
 *
 *
 *
 */
@Repository
public class ProductDAOImplSpring extends GenericDAO<Product> implements ProductService {

    private final static String SQL_SELECT_ALL_PAGING
            = "select productid, product_userid, product_typeid, product_categoryid, productcode, productname, productisactive, productbaseprice, productprice, productmoddate from product limit ? offset ?";

    private final static String SQL_SELECT_ALL
            = "select productid, product_userid, product_typeid, product_categoryid, productcode, productname, productisactive, productbaseprice, productprice, productmoddate from product";

    private final static String SQL_SELECT_PAGING
            = "select productid, product_userid, product_typeid, product_categoryid, productcode, productname, productisactive, productbaseprice, productprice, productmoddate from product where productid = ? limit ? offset ?";

    private final static String SQL_SELECT
            = "select productid, product_userid, product_typeid, product_categoryid, productcode, productname, productisactive, productbaseprice, productprice, productmoddate from product where productid = ?";

    private final static String SQL_INSERT
            = "insert into product ( product_userid, product_typeid, product_categoryid, productcode, productname, productisactive, productbaseprice, productprice, productmoddate ) values ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";

    private final static String SQL_UPDATE
            = "update product set product_userid = ?, product_typeid = ?, product_categoryid = ?, productcode = ?, productname = ?, productisactive = ?, productbaseprice = ?, productprice = ?, productmoddate = ? where productid = ?";

    private final static String SQL_DELETE
            = "delete from product where productid = ?";

    private final static String SQL_COUNT_ALL
            = "select count(*) from product";

    private final static String SQL_COUNT
            = "select count(*) from product where productid = ?";

    //----------------------------------------------------------------------
    /**
     * DAO constructor
     */
    public ProductDAOImplSpring() {
        super();
    }

    @Override
    public boolean exists(String productid) {
        Object[] primaryKey = new Object[]{productid};
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
    protected Object[] getValuesForInsert(Product product) {
        return new Object[]{
            //--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//            product.getProductid(), // "productid" : java.lang.String
        	product.getProductUserid()==null?product.getProductUserid():UUID.fromString(product.getProductUserid()), // "product_userid" : java.lang.String
        	product.getProductTypeid()==null?product.getProductTypeid():UUID.fromString(product.getProductTypeid()), // "product_typeid" : java.lang.String
        	product.getProductCategoryid()==null?product.getProductCategoryid():UUID.fromString(product.getProductCategoryid()), // "product_categoryid" : java.lang.String
            product.getProductcode(), // "productcode" : java.lang.String
            product.getProductname(), // "productname" : java.lang.String
            product.getProductisactive(), // "productisactive" : java.lang.Boolean
            product.getProductbaseprice(), // "productbaseprice" : java.lang.Double
            product.getProductprice(), // "productprice" : java.lang.Double
            product.getProductmoddate() // "productmoddate" : java.util.Date
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForUpdate(Product product) {
        return new Object[]{
            //--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
        	product.getProductUserid()==null?product.getProductUserid():UUID.fromString(product.getProductUserid()), // "product_userid" : java.lang.String
        	product.getProductTypeid()==null?product.getProductTypeid():UUID.fromString(product.getProductTypeid()), // "product_typeid" : java.lang.String
        	product.getProductCategoryid()==null?product.getProductCategoryid():UUID.fromString(product.getProductCategoryid()), // "product_categoryid" : java.lang.String
        	product.getProductcode(), // "productcode" : java.lang.String
            product.getProductname(), // "productname" : java.lang.String
            product.getProductisactive(), // "productisactive" : java.lang.Boolean
            product.getProductbaseprice(), // "productbaseprice" : java.lang.Double
            product.getProductprice(), // "productprice" : java.lang.Double
            product.getProductmoddate(), // "productmoddate" : java.util.Date
            //--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
            UUID.fromString(product.getProductid()) // "productid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected Object[] getValuesForPrimaryKey(Product product) {
        return new Object[]{
            //--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
            product.getProductid() // "productid" : java.lang.String
        };
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Product> getRowMapper(Product o) {
        //--- RowMapper to populate the given bean instance
        return new ProductRowMapper(o);
    }

    //----------------------------------------------------------------------

    @Override
    protected RowMapper<Product> getRowMapper() {
        //--- RowMapper to populate a new bean instance
        return new ProductRowMapper();
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param product
     * @throws SQLException
     */
    private Product populateBean(ResultSet rs, Product product) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        product.setProductid(rs.getString("productid")); // java.lang.String
        product.setProductUserid(rs.getString("product_userid")); // java.lang.String
        product.setProductTypeid(rs.getString("product_typeid")); // java.lang.String
        product.setProductCategoryid(rs.getString("product_categoryid")); // java.lang.String
        product.setProductcode(rs.getString("productcode")); // java.lang.String
        product.setProductname(rs.getString("productname")); // java.lang.String
        product.setProductisactive(rs.getBoolean("productisactive")); // java.lang.Boolean
        product.setProductbaseprice(rs.getDouble("productbaseprice")); // java.lang.Double
        if (rs.wasNull()) {
            product.setProductbaseprice(null);
        }; // not primitive number => keep null value if any
        product.setProductprice(rs.getDouble("productprice")); // java.lang.Double
        if (rs.wasNull()) {
            product.setProductprice(null);
        }; // not primitive number => keep null value if any
        product.setProductmoddate(rs.getDate("productmoddate")); // java.util.Date
        return product;
    }

    //----------------------------------------------------------------------
    /**
     * Populates the given bean with the data retrieved from the given ResultSet
     *
     * @param rs
     * @param product
     * @throws SQLException
     */
    private Product populateBean(ResultSet rs) throws SQLException {

        //--- Set data from ResultSet to Bean attributes
        Product product = new Product();
        product.setProductid(rs.getString("productid")); // java.lang.String
        product.setProductUserid(rs.getString("product_userid")); // java.lang.String
        product.setProductTypeid(rs.getString("product_typeid")); // java.lang.String
        product.setProductCategoryid(rs.getString("product_categoryid")); // java.lang.String
        product.setProductcode(rs.getString("productcode")); // java.lang.String
        product.setProductname(rs.getString("productname")); // java.lang.String
        product.setProductisactive(rs.getBoolean("productisactive")); // java.lang.Boolean
        product.setProductbaseprice(rs.getDouble("productbaseprice")); // java.lang.Double
        if (rs.wasNull()) {
            product.setProductbaseprice(null);
        }; // not primitive number => keep null value if any
        product.setProductprice(rs.getDouble("productprice")); // java.lang.Double
        if (rs.wasNull()) {
            product.setProductprice(null);
        }; // not primitive number => keep null value if any
        product.setProductmoddate(rs.getDate("productmoddate")); // java.util.Date
        return product;
    }

    //----------------------------------------------------------------------
    /**
     * Specific inner class for 'RowMapper' implementation
     */
    private class ProductRowMapper implements RowMapper<Product> {

        /**
         * The bean instance that will be populated from the ResultSet
         */
        private Product bean;

        /**
         * Constructor
         *
         * @param bean the bean to be populated
         */
        public ProductRowMapper(Product bean) {
            this.bean = bean;
        }
        
        public ProductRowMapper(){}

        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        	if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
        }
    }

    @Override
    public Product findById(String productid) {
        Object[] primaryKey = new Object[]{UUID.fromString(productid)};
        return super.doSelect(primaryKey);
    }

    @Override
    public List<Product> findAll() {
        return super.doSelectAll();
    }

    @Override
    public Product save(Product entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Product update(Product entity) {
        super.doUpdate(entity);
        return entity;
    }

    @Override
    public Product create(Product entity) {
        super.doInsert(entity);
        return entity;
    }

    @Override
    public void delete(String productid) {
        Object[] primaryKey = new Object[]{productid};
        super.doDelete(primaryKey);
    }
}
