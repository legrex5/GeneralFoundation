/*
 * Created on 6 Dec 2015 ( Time 04:08:36 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package tristi.general.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Persistent class for entity stored in table "pricehistory"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="pricehistory", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="PricehistoryEntity.countAll", query="SELECT COUNT(x) FROM PricehistoryEntity x" )
} )
public class PricehistoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="pricehistoryid", nullable=false, length=255)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID     pricehistoryid ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="pricehistorybaseprice")
    private Double     pricehistorybaseprice ;

    @Column(name="pricehistoryprice")
    private Double     pricehistoryprice ;

    @Temporal(TemporalType.DATE)
    @Column(name="pricehistoryfrom")
    private Date       pricehistoryfrom ;

    @Temporal(TemporalType.DATE)
    @Column(name="pricehistoryto")
    private Date       pricehistoryto ;

    @Temporal(TemporalType.DATE)
    @Column(name="pricehistorymoddate")
    private Date       pricehistorymoddate ;

	// "pricehistoryUserid" (column "pricehistory_userid") is not defined by itself because used as FK in a link 
	// "pricehistoryProductid" (column "pricehistory_productid") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="pricehistory_userid", referencedColumnName="userid")
    private UseraccessEntity useraccess  ;

    @ManyToOne
    @JoinColumn(name="pricehistory_productid", referencedColumnName="productid")
    private ProductEntity product     ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public PricehistoryEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPricehistoryid( UUID pricehistoryid ) {
        this.pricehistoryid = pricehistoryid ;
    }
    public UUID getPricehistoryid() {
        return this.pricehistoryid;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : pricehistorybaseprice ( float8 ) 
    public void setPricehistorybaseprice( Double pricehistorybaseprice ) {
        this.pricehistorybaseprice = pricehistorybaseprice;
    }
    public Double getPricehistorybaseprice() {
        return this.pricehistorybaseprice;
    }

    //--- DATABASE MAPPING : pricehistoryprice ( float8 ) 
    public void setPricehistoryprice( Double pricehistoryprice ) {
        this.pricehistoryprice = pricehistoryprice;
    }
    public Double getPricehistoryprice() {
        return this.pricehistoryprice;
    }

    //--- DATABASE MAPPING : pricehistoryfrom ( date ) 
    public void setPricehistoryfrom( Date pricehistoryfrom ) {
        this.pricehistoryfrom = pricehistoryfrom;
    }
    public Date getPricehistoryfrom() {
        return this.pricehistoryfrom;
    }

    //--- DATABASE MAPPING : pricehistoryto ( date ) 
    public void setPricehistoryto( Date pricehistoryto ) {
        this.pricehistoryto = pricehistoryto;
    }
    public Date getPricehistoryto() {
        return this.pricehistoryto;
    }

    //--- DATABASE MAPPING : pricehistorymoddate ( date ) 
    public void setPricehistorymoddate( Date pricehistorymoddate ) {
        this.pricehistorymoddate = pricehistorymoddate;
    }
    public Date getPricehistorymoddate() {
        return this.pricehistorymoddate;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setUseraccess( UseraccessEntity useraccess ) {
        this.useraccess = useraccess;
    }
    public UseraccessEntity getUseraccess() {
        return this.useraccess;
    }

    public void setProduct( ProductEntity product ) {
        this.product = product;
    }
    public ProductEntity getProduct() {
        return this.product;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(pricehistoryid);
        sb.append("]:"); 
        sb.append(pricehistorybaseprice);
        sb.append("|");
        sb.append(pricehistoryprice);
        sb.append("|");
        sb.append(pricehistoryfrom);
        sb.append("|");
        sb.append(pricehistoryto);
        sb.append("|");
        sb.append(pricehistorymoddate);
        return sb.toString(); 
    } 

}
