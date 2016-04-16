/*
 * Created on 6 Dec 2015
 * 
 */
package tristi.general.business.service;

import java.util.List;

import tristi.general.bean.Salesordercorrection;

/**
 * Business Service Interface for entity Salesordercorrection.
 */
public interface SalesordercorrectionService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param salesordercorrectionid
	 * @return entity
	 */
	Salesordercorrection findById( String salesordercorrectionid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Salesordercorrection> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Salesordercorrection save(Salesordercorrection entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Salesordercorrection update(Salesordercorrection entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Salesordercorrection create(Salesordercorrection entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param salesordercorrectionid
	 */
	void delete( String salesordercorrectionid );
	
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param salesordercorrectionid
	 * @return
	 */
	public boolean exists( String salesordercorrectionid ) ;
	
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;


}
