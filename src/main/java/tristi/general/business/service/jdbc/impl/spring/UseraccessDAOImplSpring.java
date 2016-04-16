/*
 * Created on 10 Dec 2015 ( Time 04:32:01 )
 * 
 */
package tristi.general.business.service.jdbc.impl.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import tristi.general.bean.Useraccess;
import tristi.general.business.service.UseraccessService;
import tristi.general.business.service.jdbc.impl.spring.commons.GenericDAO;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Useraccess DAO implementation 
 * 
 *
 */
@Repository
public class UseraccessDAOImplSpring extends GenericDAO<Useraccess> implements UseraccessService {

	private final static String SQL_SELECT_ALL_PAGING = 
		"select userid, user_userid, usercode, username, usermoddate from useraccess limit ? offset ?";

        private final static String SQL_SELECT_ALL = 
		"select userid, user_userid, usercode, username, usermoddate from useraccess";

        private final static String SQL_SELECT_PAGING = 
		"select userid, user_userid, usercode, username, usermoddate from useraccess where userid = ? limit ? offset ?";

        private final static String SQL_SELECT = 
		"select userid, user_userid, usercode, username, usermoddate from useraccess where userid = ?";


	private final static String SQL_INSERT = 
		"insert into useraccess ( user_userid, usercode, username, usermoddate ) values ( ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update useraccess set user_userid = ?, usercode = ?, username = ?, usermoddate = ? where userid = ?";

	private final static String SQL_DELETE = 
		"delete from useraccess where userid = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from useraccess";

	private final static String SQL_COUNT = 
		"select count(*) from useraccess where userid = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public UseraccessDAOImplSpring() {
		super();
	}

	@Override
	public boolean exists( String userid ) {
		Object[] primaryKey = new Object[] { userid };
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
	protected Object[] getValuesForInsert(Useraccess useraccess)  {
		System.out.println("TESTER : "+useraccess.getUserUserid());
		return new Object[] {
			//--- Returns PRIMARY KEY and DATA ( for SQL "SET x=?, y=?, ..." )
//			useraccess.getUserid() , // "userid" : java.lang.String
			useraccess.getUserUserid()==null ?useraccess.getUserUserid():
					UUID.fromString(useraccess.getUserUserid()) , // "user_userid" : java.lang.String
			useraccess.getUsercode() , // "usercode" : java.lang.String
			useraccess.getUsername() , // "username" : java.lang.String
			useraccess.getUsermoddate()  // "usermoddate" : java.util.Date
		};
	}
    //----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForUpdate(Useraccess useraccess) {
		return new Object[] {		
			//--- Returns DATA first ( for SQL "SET x=?, y=?, ..." )
				useraccess.getUserUserid()==null ?useraccess.getUserUserid():
					UUID.fromString(useraccess.getUserUserid()) , // "user_userid" : java.lang.String
			useraccess.getUsercode(), // "usercode" : java.lang.String
			useraccess.getUsername(), // "username" : java.lang.String
			useraccess.getUsermoddate(), // "usermoddate" : java.util.Date
			//--- Returns PRIMARY KEY at the end ( for SQL "WHERE key=?, ..." )
			UUID.fromString(useraccess.getUserid())  // "userid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected Object[] getValuesForPrimaryKey(Useraccess useraccess)  {
		return new Object[] {
			//--- Returns PRIMARY KEY values ( for SQL "WHERE key=?, ..." )
			useraccess.getUserid()  // "userid" : java.lang.String
		};
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Useraccess> getRowMapper(Useraccess o)  {
		//--- RowMapper to populate the given bean instance
		return new UseraccessRowMapper(o) ;
	}
	//----------------------------------------------------------------------
	@Override
	protected RowMapper<Useraccess> getRowMapper()  {
		//--- RowMapper to populate a new bean instance
		return new UseraccessRowMapper() ;
	}

    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param useraccess
	 * @throws SQLException
	 */
	private Useraccess populateBean(ResultSet rs, Useraccess useraccess) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		useraccess.setUserid(rs.getString("userid")); // java.lang.String
		useraccess.setUserUserid(rs.getString("user_userid")); // java.lang.String
		useraccess.setUsercode(rs.getString("usercode")); // java.lang.String
		useraccess.setUsername(rs.getString("username")); // java.lang.String
		useraccess.setUsermoddate(rs.getDate("usermoddate")); // java.util.Date
                return useraccess;
	}
        
    //----------------------------------------------------------------------
	/**
	 * Populates the given bean with the data retrieved from the given ResultSet
	 * @param rs
	 * @param useraccess
	 * @throws SQLException
	 */
	private Useraccess populateBean(ResultSet rs) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
                Useraccess useraccess = new Useraccess();
		useraccess.setUserid(rs.getString("userid")); // java.lang.String
		useraccess.setUserUserid(rs.getString("user_userid")); // java.lang.String
		useraccess.setUsercode(rs.getString("usercode")); // java.lang.String
		useraccess.setUsername(rs.getString("username")); // java.lang.String
		useraccess.setUsermoddate(rs.getDate("usermoddate")); // java.util.Date
                return useraccess;
	}

    //----------------------------------------------------------------------
	/**
	 * Specific inner class for 'RowMapper' implementation
	 */
	private class UseraccessRowMapper implements RowMapper<Useraccess> {

		/**
		 * The bean instance that will be populated from the ResultSet
		 */
		private Useraccess bean ;
		
		/**
		 * Constructor
		 * @param bean the bean to be populated 
		 */
		public UseraccessRowMapper(Useraccess bean) {
			this.bean = bean ;
		}
		
		public UseraccessRowMapper() {
		}
		
		
		@Override
		public Useraccess mapRow(ResultSet rs, int rowNum) throws SQLException {
			if (this.bean != null) {
                return populateBean(rs, bean);
            } else {
                return populateBean(rs);
            }
		}
	}

	@Override
	public Useraccess findById(String userid) {
		Object[] primaryKey = new Object[] { UUID.fromString(userid) };
		return super.doSelect(primaryKey);
	}

	@Override
	public List<Useraccess> findAll() {
		return super.doSelectAll();
	}

	@Override
	public Useraccess save(Useraccess entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Useraccess update(Useraccess entity) {
		super.doUpdate(entity);
		return entity;
	}

	@Override
	public Useraccess create(Useraccess entity) {
		super.doInsert(entity);
		return entity;
	}

	@Override
	public void delete(String userid) {
		Object[] primaryKey = new Object[] { userid };
		super.doDelete(primaryKey);
	}
}
