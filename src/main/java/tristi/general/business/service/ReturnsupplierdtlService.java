/*
 * Created on 6 Dec 2015 ( Time 04:13:34 )
 * 
 */
package tristi.general.business.service;

import java.util.List;

import tristi.general.bean.Returnsupplierdtl;

/**
 * Business Service Interface for entity Returnsupplierdtl.
 */
public interface ReturnsupplierdtlService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param returndtlid
	 * @return entity
	 */
	Returnsupplierdtl findById( String returndtlid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Returnsupplierdtl> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Returnsupplierdtl save(Returnsupplierdtl entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Returnsupplierdtl update(Returnsupplierdtl entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Returnsupplierdtl create(Returnsupplierdtl entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param returndtlid
	 */
	void delete( String returndtlid );
	
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param returndtlid
	 * @return
	 */
	public boolean exists( String returndtlid ) ;
	
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;


}
