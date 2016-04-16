/*
 * Created on 6 Dec 2015
 * 
 */
package tristi.general.business.service;

import java.util.List;

import tristi.general.bean.Uom;

/**
 * Business Service Interface for entity Uom.
 */
public interface UomService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param uomid
	 * @return entity
	 */
	Uom findById( String uomid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Uom> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Uom save(Uom entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Uom update(Uom entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Uom create(Uom entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param uomid
	 */
	void delete( String uomid );
	
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param uomid
	 * @return
	 */
	public boolean exists( String uomid ) ;
	
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;


}
