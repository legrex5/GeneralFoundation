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
 * Persistent class for entity stored in table "purchaseorder"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="purchaseorder", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="PurchaseorderEntity.countAll", query="SELECT COUNT(x) FROM PurchaseorderEntity x" )
} )
public class PurchaseorderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="purchaseorderid", nullable=false, length=255)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID     purchaseorderid ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="purchaseorder_userid", length=255)
    private String     purchaseorderUserid ;

    @Column(name="purchaseordercode", length=50)
    private String     purchaseordercode ;

    @Column(name="purchaseorderrefnumber", length=50)
    private String     purchaseorderrefnumber ;

    @Temporal(TemporalType.DATE)
    @Column(name="purchaseorderdate")
    private Date       purchaseorderdate ;

    @Column(name="puchaseorderamount")
    private Double     puchaseorderamount ;

    @Column(name="purchaserorderdiscount")
    private Double     purchaserorderdiscount ;

    @Temporal(TemporalType.DATE)
    @Column(name="purchaseorderdeliverydate")
    private Date       purchaseorderdeliverydate ;

    @Column(name="purchaseorderstatus", length=50)
    private String     purchaseorderstatus ;

    @Column(name="purchaseorderincludetax")
    private Boolean    purchaseorderincludetax ;

    @Temporal(TemporalType.DATE)
    @Column(name="purchaseordermoddate")
    private Date       purchaseordermoddate ;

	// "purchaseorderSupplierid" (column "purchaseorder_supplierid") is not defined by itself because used as FK in a link 
	// "purchaseorderAccountbankid" (column "purchaseorder_accountbankid") is not defined by itself because used as FK in a link 
	// "purchaseorderPaymentformid" (column "purchaseorder_paymentformid") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="purchaseorder_supplierid", referencedColumnName="supplierid")
    private SupplierEntity supplier    ;

    @ManyToOne
    @JoinColumn(name="purchaseorder_paymentformid", referencedColumnName="paymentformid")
    private PaymentformEntity paymentform ;

    @ManyToOne
    @JoinColumn(name="purchaseorder_accountbankid", referencedColumnName="accountbankid")
    private AccountbankEntity accountbank ;

    @OneToMany(mappedBy="purchaseorder", targetEntity=PurchaseorderdtlEntity.class)
    private List<PurchaseorderdtlEntity> listOfPurchaseorderdtl;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public PurchaseorderEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPurchaseorderid( UUID purchaseorderid ) {
        this.purchaseorderid = purchaseorderid ;
    }
    public UUID getPurchaseorderid() {
        return this.purchaseorderid;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : purchaseorder_userid ( varchar ) 
    public void setPurchaseorderUserid( String purchaseorderUserid ) {
        this.purchaseorderUserid = purchaseorderUserid;
    }
    public String getPurchaseorderUserid() {
        return this.purchaseorderUserid;
    }

    //--- DATABASE MAPPING : purchaseordercode ( varchar ) 
    public void setPurchaseordercode( String purchaseordercode ) {
        this.purchaseordercode = purchaseordercode;
    }
    public String getPurchaseordercode() {
        return this.purchaseordercode;
    }

    //--- DATABASE MAPPING : purchaseorderrefnumber ( varchar ) 
    public void setPurchaseorderrefnumber( String purchaseorderrefnumber ) {
        this.purchaseorderrefnumber = purchaseorderrefnumber;
    }
    public String getPurchaseorderrefnumber() {
        return this.purchaseorderrefnumber;
    }

    //--- DATABASE MAPPING : purchaseorderdate ( date ) 
    public void setPurchaseorderdate( Date purchaseorderdate ) {
        this.purchaseorderdate = purchaseorderdate;
    }
    public Date getPurchaseorderdate() {
        return this.purchaseorderdate;
    }

    //--- DATABASE MAPPING : puchaseorderamount ( float8 ) 
    public void setPuchaseorderamount( Double puchaseorderamount ) {
        this.puchaseorderamount = puchaseorderamount;
    }
    public Double getPuchaseorderamount() {
        return this.puchaseorderamount;
    }

    //--- DATABASE MAPPING : purchaserorderdiscount ( float8 ) 
    public void setPurchaserorderdiscount( Double purchaserorderdiscount ) {
        this.purchaserorderdiscount = purchaserorderdiscount;
    }
    public Double getPurchaserorderdiscount() {
        return this.purchaserorderdiscount;
    }

    //--- DATABASE MAPPING : purchaseorderdeliverydate ( date ) 
    public void setPurchaseorderdeliverydate( Date purchaseorderdeliverydate ) {
        this.purchaseorderdeliverydate = purchaseorderdeliverydate;
    }
    public Date getPurchaseorderdeliverydate() {
        return this.purchaseorderdeliverydate;
    }

    //--- DATABASE MAPPING : purchaseorderstatus ( varchar ) 
    public void setPurchaseorderstatus( String purchaseorderstatus ) {
        this.purchaseorderstatus = purchaseorderstatus;
    }
    public String getPurchaseorderstatus() {
        return this.purchaseorderstatus;
    }

    //--- DATABASE MAPPING : purchaseorderincludetax ( bool ) 
    public void setPurchaseorderincludetax( Boolean purchaseorderincludetax ) {
        this.purchaseorderincludetax = purchaseorderincludetax;
    }
    public Boolean getPurchaseorderincludetax() {
        return this.purchaseorderincludetax;
    }

    //--- DATABASE MAPPING : purchaseordermoddate ( date ) 
    public void setPurchaseordermoddate( Date purchaseordermoddate ) {
        this.purchaseordermoddate = purchaseordermoddate;
    }
    public Date getPurchaseordermoddate() {
        return this.purchaseordermoddate;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setSupplier( SupplierEntity supplier ) {
        this.supplier = supplier;
    }
    public SupplierEntity getSupplier() {
        return this.supplier;
    }

    public void setPaymentform( PaymentformEntity paymentform ) {
        this.paymentform = paymentform;
    }
    public PaymentformEntity getPaymentform() {
        return this.paymentform;
    }

    public void setAccountbank( AccountbankEntity accountbank ) {
        this.accountbank = accountbank;
    }
    public AccountbankEntity getAccountbank() {
        return this.accountbank;
    }

    public void setListOfPurchaseorderdtl( List<PurchaseorderdtlEntity> listOfPurchaseorderdtl ) {
        this.listOfPurchaseorderdtl = listOfPurchaseorderdtl;
    }
    public List<PurchaseorderdtlEntity> getListOfPurchaseorderdtl() {
        return this.listOfPurchaseorderdtl;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(purchaseorderid);
        sb.append("]:"); 
        sb.append(purchaseorderUserid);
        sb.append("|");
        sb.append(purchaseordercode);
        sb.append("|");
        sb.append(purchaseorderrefnumber);
        sb.append("|");
        sb.append(purchaseorderdate);
        sb.append("|");
        sb.append(puchaseorderamount);
        sb.append("|");
        sb.append(purchaserorderdiscount);
        sb.append("|");
        sb.append(purchaseorderdeliverydate);
        sb.append("|");
        sb.append(purchaseorderstatus);
        sb.append("|");
        sb.append(purchaseorderincludetax);
        sb.append("|");
        sb.append(purchaseordermoddate);
        return sb.toString(); 
    } 

}
