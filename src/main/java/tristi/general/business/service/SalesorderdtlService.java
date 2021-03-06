/*
 * Created on 6 Dec 2015
 * 
 */
package tristi.general.business.service;

import java.util.List;

import tristi.general.bean.Salesorderdtl;

/**
 * Business Service Interface for entity Salesorderdtl.
 */
public interface SalesorderdtlService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param salesorderdtlid
	 * @return entity
	 */
	Salesorderdtl findById( String salesorderdtlid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Salesorderdtl> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Salesorderdtl save(Salesorderdtl entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Salesorderdtl update(Salesorderdtl entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Salesorderdtl create(Salesorderdtl entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param salesorderdtlid
	 */
	void delete( String salesorderdtlid );
	
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param salesorderdtlid
	 * @return
	 */
	public boolean exists( String salesorderdtlid ) ;
	
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;


}
