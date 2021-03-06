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
 * Persistent class for entity stored in table "salesorder"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="salesorder", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="SalesorderEntity.countAll", query="SELECT COUNT(x) FROM SalesorderEntity x" )
} )
public class SalesorderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="salesorderid", nullable=false, length=255)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID     salesorderid ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="salesordercorrection_id", length=255)
    private String     salesordercorrectionId ;

    @Column(name="salesorder_userid", length=255)
    private String     salesorderUserid ;

    @Column(name="salesordercode", length=50)
    private String     salesordercode ;

    @Temporal(TemporalType.DATE)
    @Column(name="salesorderdate")
    private Date       salesorderdate ;

    @Temporal(TemporalType.DATE)
    @Column(name="salesorderdeliverydate")
    private Date       salesorderdeliverydate ;

    @Column(name="salesorderstatus", length=50)
    private String     salesorderstatus ;

    @Column(name="salesorderdiscount")
    private Double     salesorderdiscount ;

    @Column(name="salesorderbilling")
    private Double     salesorderbilling ;

    @Column(name="salesorderpaying")
    private Double     salesorderpaying ;

    @Column(name="salesorderincludetax")
    private Boolean    salesorderincludetax ;

    @Temporal(TemporalType.DATE)
    @Column(name="salesordermoddate")
    private Date       salesordermoddate ;

	// "paymentformid" (column "paymentformid") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="salesorder", targetEntity=AccountbankEntity.class)
    private List<AccountbankEntity> listOfAccountbank;

    @OneToMany(mappedBy="salesorder", targetEntity=SalesorderdtlEntity.class)
    private List<SalesorderdtlEntity> listOfSalesorderdtl;

    @ManyToOne
    @JoinColumn(name="salesorder_paymentformid", referencedColumnName="paymentformid")
    private PaymentformEntity paymentform ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public SalesorderEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setSalesorderid( UUID salesorderid ) {
        this.salesorderid = salesorderid ;
    }
    public UUID getSalesorderid() {
        return this.salesorderid;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : salesordercorrection_id ( varchar ) 
    public void setSalesordercorrectionId( String salesordercorrectionId ) {
        this.salesordercorrectionId = salesordercorrectionId;
    }
    public String getSalesordercorrectionId() {
        return this.salesordercorrectionId;
    }

    //--- DATABASE MAPPING : salesorder_userid ( varchar ) 
    public void setSalesorderUserid( String salesorderUserid ) {
        this.salesorderUserid = salesorderUserid;
    }
    public String getSalesorderUserid() {
        return this.salesorderUserid;
    }

    //--- DATABASE MAPPING : salesordercode ( bpchar ) 
    public void setSalesordercode( String salesordercode ) {
        this.salesordercode = salesordercode;
    }
    public String getSalesordercode() {
        return this.salesordercode;
    }

    //--- DATABASE MAPPING : salesorderdate ( date ) 
    public void setSalesorderdate( Date salesorderdate ) {
        this.salesorderdate = salesorderdate;
    }
    public Date getSalesorderdate() {
        return this.salesorderdate;
    }

    //--- DATABASE MAPPING : salesorderdeliverydate ( date ) 
    public void setSalesorderdeliverydate( Date salesorderdeliverydate ) {
        this.salesorderdeliverydate = salesorderdeliverydate;
    }
    public Date getSalesorderdeliverydate() {
        return this.salesorderdeliverydate;
    }

    //--- DATABASE MAPPING : salesorderstatus ( varchar ) 
    public void setSalesorderstatus( String salesorderstatus ) {
        this.salesorderstatus = salesorderstatus;
    }
    public String getSalesorderstatus() {
        return this.salesorderstatus;
    }

    //--- DATABASE MAPPING : salesorderdiscount ( float8 ) 
    public void setSalesorderdiscount( Double salesorderdiscount ) {
        this.salesorderdiscount = salesorderdiscount;
    }
    public Double getSalesorderdiscount() {
        return this.salesorderdiscount;
    }

    //--- DATABASE MAPPING : salesorderbilling ( float8 ) 
    public void setSalesorderbilling( Double salesorderbilling ) {
        this.salesorderbilling = salesorderbilling;
    }
    public Double getSalesorderbilling() {
        return this.salesorderbilling;
    }

    //--- DATABASE MAPPING : salesorderpaying ( float8 ) 
    public void setSalesorderpaying( Double salesorderpaying ) {
        this.salesorderpaying = salesorderpaying;
    }
    public Double getSalesorderpaying() {
        return this.salesorderpaying;
    }

    //--- DATABASE MAPPING : salesorderincludetax ( bool ) 
    public void setSalesorderincludetax( Boolean salesorderincludetax ) {
        this.salesorderincludetax = salesorderincludetax;
    }
    public Boolean getSalesorderincludetax() {
        return this.salesorderincludetax;
    }

    //--- DATABASE MAPPING : salesordermoddate ( date ) 
    public void setSalesordermoddate( Date salesordermoddate ) {
        this.salesordermoddate = salesordermoddate;
    }
    public Date getSalesordermoddate() {
        return this.salesordermoddate;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfAccountbank( List<AccountbankEntity> listOfAccountbank ) {
        this.listOfAccountbank = listOfAccountbank;
    }
    public List<AccountbankEntity> getListOfAccountbank() {
        return this.listOfAccountbank;
    }

    public void setListOfSalesorderdtl( List<SalesorderdtlEntity> listOfSalesorderdtl ) {
        this.listOfSalesorderdtl = listOfSalesorderdtl;
    }
    public List<SalesorderdtlEntity> getListOfSalesorderdtl() {
        return this.listOfSalesorderdtl;
    }

    public void setPaymentform( PaymentformEntity paymentform ) {
        this.paymentform = paymentform;
    }
    public PaymentformEntity getPaymentform() {
        return this.paymentform;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(salesorderid);
        sb.append("]:"); 
        sb.append(salesordercorrectionId);
        sb.append("|");
        sb.append(salesorderUserid);
        sb.append("|");
        sb.append(salesordercode);
        sb.append("|");
        sb.append(salesorderdate);
        sb.append("|");
        sb.append(salesorderdeliverydate);
        sb.append("|");
        sb.append(salesorderstatus);
        sb.append("|");
        sb.append(salesorderdiscount);
        sb.append("|");
        sb.append(salesorderbilling);
        sb.append("|");
        sb.append(salesorderpaying);
        sb.append("|");
        sb.append(salesorderincludetax);
        sb.append("|");
        sb.append(salesordermoddate);
        return sb.toString(); 
    } 

}
