/*
 * Created on 10 Dec 2015
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Type;
import tristi.general.business.service.TypeService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Type DAO implementation 
 * 
 *
 */
@Repository
public class TypeDAOImplSpring extends GenericDAO<Type> implements TypeService {

	private final static String SQL_SELECT_ALL_PAGING = 
		"select typeid, type_userid, typecode, typename, typeisactive, typemoddate from type limit ? offset ?";

        private final static String SQL_SELECT_ALL = 
		"select typeid, type_userid, typecode, typename, typeisactive, typemoddate from type";

        private final static String SQL_SELECT_PAGING = 
		"select typeid, type_userid, typecode, typename, typeisactive, typemoddate from type where typeid = ? limit ? offset ?";

        private final static String SQL_SELECT = 
		"select typeid, type_userid, typecode, typename, typeisactive, typemoddate from type where typeid = ?";


	private final static String SQL_INSERT = 
		"insert into type ( type_userid, typecode, typename, typeisactive, typemoddate ) values ( ?, ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update type set type_userid = ?, typecode = ?, typename = ?, typeisactive = ?, typemoddate = ? where typeid = ?";

	private final static String SQL_DELETE = 
		"delete from type where typeid = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from type";

	private final static String SQL_COUNT = 
		"select count(*) from type where typeid = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public TypeDAOImplSpring() {
		super();
	}

	@Override
	public boolean exists( String typeid ) {
		Object[] primaryKey = new Object[] { typeid };
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
		return SQL_SELECT_ALL ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlSelect() {
		return SQL_SELECT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlInsert() {
		return SQL_INSERT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlUpdate() {
		return SQL_UPDATE ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlDelete() {
		return SQL_DELETE ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlCount() {
		return SQL_COUNT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlCountAll() {
		return SQL_COUNT_ALL ;
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForInsert(Type type)  {
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//			type.getTypeid() , // "typeid" : java.lang.String
			type.getTypeUserid()==null?type.getTypeUserid():UUID.fromString(type.getTypeUserid()) , // "type_userid" : java.lang.String
			type.getTypecode() , // "typecode" : java.lang.String
			type.getTypename() , // "typename" : java.lang.String
			type.getTypeisactive() , // "typeisactive" : java.lang.Boolean
			type.getTypemoddate()  // "typemoddate" : java.util.Date
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Type type) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
			type.getTypeUserid()==null?type.getTypeUserid():UUID.fromString(type.getTypeUserid()) , // "type_userid" : java.lang.String
			type.getTypecode(), // "typecode" : java.lang.String
			type.getTypename(), // "typename" : java.lang.String
			type.getTypeisactive(), // "typeisactive" : java.lang.Boolean
			type.getTypemoddate(), // "typemoddate" : java.util.Date
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			UUID.fromString(type.getTypeid())  // "typeid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Type type)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			type.getTypeid()  // "typeid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Type> getRowMapper(Type o)  {
		//--- RowMapper to populate the given bean instance
		return new TypeRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Type> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new TypeRowMapper() ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param type
	 * @throws SQLException
	 */
	private Type populateBean(ResultSet rs, Type type) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		type.setTypeid(rs.getString("typeid")); // java.lang.String
		type.setTypeUserid(rs.getString("type_userid")); // java.lang.String
		type.setTypecode(rs.getString("typecode")); // java.lang.String
		type.setTypename(rs.getString("typename")); // java.lang.String
		type.setTypeisactive(rs.getBoolean("typeisactive")); // java.lang.Boolean
		type.setTypemoddate(rs.getDate("typemoddate")); // java.util.Date
                return type;
	}
        
    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param type
	 * @throws SQLException
	 */
	private Type populateBean(ResultSet rs) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
            Type type = new Type();
		type.setTypeid(rs.getString("typeid")); // java.lang.String
		type.setTypeUserid(rs.getString("type_userid")); // java.lang.String
		type.setTypecode(rs.getString("typecode")); // java.lang.String
		type.setTypename(rs.getString("typename")); // java.lang.String
		type.setTypeisactive(rs.getBoolean("typeisactive")); // java.lang.Boolean
		type.setTypemoddate(rs.getDate("typemoddate")); // java.util.Date
                return type;
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class TypeRowMapper implements RowMapper<Type> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private Type bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		TypeRowMapper(Type bean) {
			this.bean = bean ;
		}
		
		public TypeRowMapper() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public Type mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
		}
	}

	@Override
	public Type findById(String typeid) {
		Object[] primaryKey = new Object[] { UUID.fromString(typeid) };
		return super.doSelect(primaryKey);	
	}

	@Override
	public List<Type> findAll() {
		return super.doSelectAll();
	}

	@Override
	public Type save(Type entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Type update(Type entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Type create(Type entity) {
		super.doInsert(entity);
		return entity;
	}

	@Override
	public void delete(String typeid) {
		Object[] primaryKey = new Object[] { typeid };
		super.doDelete(primaryKey);
	}
}
