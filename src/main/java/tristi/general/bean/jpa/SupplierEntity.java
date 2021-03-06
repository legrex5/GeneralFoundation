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
import java.util.List;
import java.util.UUID;

import javax.persistence.*;
import org.hibernate.annotations.Type;

/**
 * Persistent class for entity stored in table "supplier"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="supplier", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="SupplierEntity.countAll", query="SELECT COUNT(x) FROM SupplierEntity x" )
} )
public class SupplierEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="supplierid", nullable=false, length=255)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID     supplierid   ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="suppliercode", length=50)
    private String     suppliercode ;

    @Column(name="suppliername", length=100)
    private String     suppliername ;

    @Column(name="supplieraddres", length=200)
    private String     supplieraddres ;

    @Column(name="suppliercity", length=50)
    private String     suppliercity ;

    @Column(name="supplierphone1", length=20)
    private String     supplierphone1 ;

    @Column(name="supplierphone2", length=20)
    private String     supplierphone2 ;

    @Column(name="supplierfax1", length=20)
    private String     supplierfax1 ;

    @Column(name="supplierfax2", length=20)
    private String     supplierfax2 ;

    @Column(name="supplierisactive")
    private Boolean    supplierisactive ;

    @Temporal(TemporalType.DATE)
    @Column(name="suppliermoddate")
    private Date       suppliermoddate ;

	// "supplierUserid" (column "supplier_userid") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="supplier_userid", referencedColumnName="userid")
    private UseraccessEntity useraccess  ;

    @OneToMany(mappedBy="supplier", targetEntity=SupplierproductEntity.class)
    private List<SupplierproductEntity> listOfSupplierproduct;

    @OneToMany(mappedBy="supplier", targetEntity=AccountbankEntity.class)
    private List<AccountbankEntity> listOfAccountbank;

    @OneToMany(mappedBy="supplier", targetEntity=ReturnsupplierEntity.class)
    private List<ReturnsupplierEntity> listOfReturnsupplier;

    @OneToMany(mappedBy="supplier", targetEntity=PurchaseorderEntity.class)
    private List<PurchaseorderEntity> listOfPurchaseorder;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public SupplierEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setSupplierid( UUID supplierid ) {
        this.supplierid = supplierid ;
    }
    public UUID getSupplierid() {
        return this.supplierid;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : suppliercode ( varchar ) 
    public void setSuppliercode( String suppliercode ) {
        this.suppliercode = suppliercode;
    }
    public String getSuppliercode() {
        return this.suppliercode;
    }

    //--- DATABASE MAPPING : suppliername ( varchar ) 
    public void setSuppliername( String suppliername ) {
        this.suppliername = suppliername;
    }
    public String getSuppliername() {
        return this.suppliername;
    }

    //--- DATABASE MAPPING : supplieraddres ( varchar ) 
    public void setSupplieraddres( String supplieraddres ) {
        this.supplieraddres = supplieraddres;
    }
    public String getSupplieraddres() {
        return this.supplieraddres;
    }

    //--- DATABASE MAPPING : suppliercity ( varchar ) 
    public void setSuppliercity( String suppliercity ) {
        this.suppliercity = suppliercity;
    }
    public String getSuppliercity() {
        return this.suppliercity;
    }

    //--- DATABASE MAPPING : supplierphone1 ( varchar ) 
    public void setSupplierphone1( String supplierphone1 ) {
        this.supplierphone1 = supplierphone1;
    }
    public String getSupplierphone1() {
        return this.supplierphone1;
    }

    //--- DATABASE MAPPING : supplierphone2 ( varchar ) 
    public void setSupplierphone2( String supplierphone2 ) {
        this.supplierphone2 = supplierphone2;
    }
    public String getSupplierphone2() {
        return this.supplierphone2;
    }

    //--- DATABASE MAPPING : supplierfax1 ( varchar ) 
    public void setSupplierfax1( String supplierfax1 ) {
        this.supplierfax1 = supplierfax1;
    }
    public String getSupplierfax1() {
        return this.supplierfax1;
    }

    //--- DATABASE MAPPING : supplierfax2 ( varchar ) 
    public void setSupplierfax2( String supplierfax2 ) {
        this.supplierfax2 = supplierfax2;
    }
    public String getSupplierfax2() {
        return this.supplierfax2;
    }

    //--- DATABASE MAPPING : supplierisactive ( bool ) 
    public void setSupplierisactive( Boolean supplierisactive ) {
        this.supplierisactive = supplierisactive;
    }
    public Boolean getSupplierisactive() {
        return this.supplierisactive;
    }

    //--- DATABASE MAPPING : suppliermoddate ( date ) 
    public void setSuppliermoddate( Date suppliermoddate ) {
        this.suppliermoddate = suppliermoddate;
    }
    public Date getSuppliermoddate() {
        return this.suppliermoddate;
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

    public void setListOfSupplierproduct( List<SupplierproductEntity> listOfSupplierproduct ) {
        this.listOfSupplierproduct = listOfSupplierproduct;
    }
    public List<SupplierproductEntity> getListOfSupplierproduct() {
        return this.listOfSupplierproduct;
    }

    public void setListOfAccountbank( List<AccountbankEntity> listOfAccountbank ) {
        this.listOfAccountbank = listOfAccountbank;
    }
    public List<AccountbankEntity> getListOfAccountbank() {
        return this.listOfAccountbank;
    }

    public void setListOfReturnsupplier( List<ReturnsupplierEntity> listOfReturnsupplier ) {
        this.listOfReturnsupplier = listOfReturnsupplier;
    }
    public List<ReturnsupplierEntity> getListOfReturnsupplier() {
        return this.listOfReturnsupplier;
    }

    public void setListOfPurchaseorder( List<PurchaseorderEntity> listOfPurchaseorder ) {
        this.listOfPurchaseorder = listOfPurchaseorder;
    }
    public List<PurchaseorderEntity> getListOfPurchaseorder() {
        return this.listOfPurchaseorder;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(supplierid);
        sb.append("]:"); 
        sb.append(suppliercode);
        sb.append("|");
        sb.append(suppliername);
        sb.append("|");
        sb.append(supplieraddres);
        sb.append("|");
        sb.append(suppliercity);
        sb.append("|");
        sb.append(supplierphone1);
        sb.append("|");
        sb.append(supplierphone2);
        sb.append("|");
        sb.append(supplierfax1);
        sb.append("|");
        sb.append(supplierfax2);
        sb.append("|");
        sb.append(supplierisactive);
        sb.append("|");
        sb.append(suppliermoddate);
        return sb.toString(); 
    } 

}
