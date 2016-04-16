/*
 * Created on 6 Dec 2015 ( Time 04:13:34 )
 * 
 */
package tristi.general.business.service;

import java.util.List;

import tristi.general.bean.Returnsupplier;

/**
 * Business Service Interface for entity Returnsupplier.
 */
public interface ReturnsupplierService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param returnsupplierid
	 * @return entity
	 */
	Returnsupplier findById( String returnsupplierid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Returnsupplier> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Returnsupplier save(Returnsupplier entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Returnsupplier update(Returnsupplier entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Returnsupplier create(Returnsupplier entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param returnsupplierid
	 */
	void delete( String returnsupplierid );
	
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param returnsupplierid
	 * @return
	 */
	public boolean exists( String returnsupplierid ) ;
	
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;


}
