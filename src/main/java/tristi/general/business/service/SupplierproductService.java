/*
 * Created on 6 Dec 2015
 * 
 */
package tristi.general.business.service;

import java.util.List;

import tristi.general.bean.Supplierproduct;

/**
 * Business Service Interface for entity Supplierproduct.
 */
public interface SupplierproductService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param supplierproductid
	 * @return entity
	 */
	Supplierproduct findById( String supplierproductid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Supplierproduct> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Supplierproduct save(Supplierproduct entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Supplierproduct update(Supplierproduct entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Supplierproduct create(Supplierproduct entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param supplierproductid
	 */
	void delete( String supplierproductid );
	
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param supplierproductid
	 * @return
	 */
	public boolean exists( String supplierproductid ) ;
	
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;


}
