/*
 * Created on 6 Dec 2015
 * 
 */
package tristi.general.business.service;

import java.util.List;

import tristi.general.bean.Useraccess;

/**
 * Business Service Interface for entity Useraccess.
 */
public interface UseraccessService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param userid
	 * @return entity
	 */
	Useraccess findById( String userid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Useraccess> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Useraccess save(Useraccess entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Useraccess update(Useraccess entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Useraccess create(Useraccess entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param userid
	 */
	void delete( String userid );
	
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param userid
	 * @return
	 */
	public boolean exists( String userid ) ;
	
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;


}
