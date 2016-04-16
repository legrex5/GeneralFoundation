/*
 * Created on 6 Dec 2015 ( Time 04:13:35 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service;

import java.util.List;

import tristi.general.bean.Supplier;

/**
 * Business Service Interface for entity Supplier.
 */
public interface SupplierService { 

	/**
	 * Loads an entity from the database using its Primary Key
	 * @param supplierid
	 * @return entity
	 */
	Supplier findById( String supplierid  ) ;

	/**
	 * Loads all entities.
	 * @return all entities
	 */
	List<Supplier> findAll();

	/**
	 * Saves the given entity in the database (create or update)
	 * @param entity
	 * @return entity
	 */
	Supplier save(Supplier entity);

	/**
	 * Updates the given entity in the database
	 * @param entity
	 * @return
	 */
	Supplier update(Supplier entity);

	/**
	 * Creates the given entity in the database
	 * @param entity
	 * @return
	 */
	Supplier create(Supplier entity);

	/**
	 * Deletes an entity using its Primary Key
	 * @param supplierid
	 */
	void delete( String supplierid );
	
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param supplierid
	 * @return
	 */
	public boolean exists( String supplierid ) ;
	
	/**
	 * Counts all the records present in the database table
	 * @return
	 */
	public long count() ;


}
