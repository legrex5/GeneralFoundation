/*
 * Created on 6 Dec 2015
 * 
 */
package tristi.general.business.service;

import java.util.List;

import tristi.general.bean.Salesorder;

/**
 * Business Service Interface for entity Salesorder.
 */
public interface SalesorderService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param salesorderid
	 * @return entity
	 */
	Salesorder findById( String salesorderid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Salesorder> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Salesorder save(Salesorder entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Salesorder update(Salesorder entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Salesorder create(Salesorder entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param salesorderid
	 */
	void delete( String salesorderid );
	
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param salesorderid
	 * @return
	 */
	public boolean exists( String salesorderid ) ;
	
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;


}
