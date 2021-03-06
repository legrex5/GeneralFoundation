/*
 * Created on 6 Dec 2015 ( Time 04:13:34 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service;

import java.util.List;

import tristi.general.bean.Location;

/**
 * Business Service Interface for entity Location.
 */
public interface LocationService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param locationid
	 * @return entity
	 */
	Location findById( String locationid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Location> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Location save(Location entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Location update(Location entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Location create(Location entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param locationid
	 */
	void delete( String locationid );
	
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param locationid
	 * @return
	 */
	public boolean exists( String locationid ) ;
	
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;


}
