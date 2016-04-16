/*
 * Created on 6 Dec 2015
 * 
 */
package tristi.general.business.service;

import java.util.List;

import tristi.general.bean.Type;

/**
 * Business Service Interface for entity Type.
 */
public interface TypeService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param typeid
	 * @return entity
	 */
	Type findById( String typeid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Type> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Type save(Type entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Type update(Type entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Type create(Type entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param typeid
	 */
	void delete( String typeid );
	
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param typeid
	 * @return
	 */
	public boolean exists( String typeid ) ;
	
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;


}
