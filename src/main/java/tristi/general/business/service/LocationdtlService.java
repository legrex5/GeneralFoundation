/*
 * Created on 6 Dec 2015 ( Time 04:13:34 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service;

import java.util.List;

import tristi.general.bean.Locationdtl;

/**
 * Business Service Interface for entity Locationdtl.
 */
public interface LocationdtlService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param locationdtlid
	 * @return entity
	 */
	Locationdtl findById( String locationdtlid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Locationdtl> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Locationdtl save(Locationdtl entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Locationdtl update(Locationdtl entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Locationdtl create(Locationdtl entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param locationdtlid
	 */
	void delete( String locationdtlid );
	
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param locationdtlid
	 * @return
	 */
	public boolean exists( String locationdtlid ) ;
	
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;


}
