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
 * Persistent class for entity stored in table "paymentform"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="paymentform", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="PaymentformEntity.countAll", query="SELECT COUNT(x) FROM PaymentformEntity x" )
} )
public class PaymentformEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="paymentformid", nullable=false, length=255)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID     paymentformid ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="paymentformcode", length=50)
    private String     paymentformcode ;

    @Column(name="paymentformname", length=50)
    private String     paymentformname ;

    @Column(name="paymentformiscredit")
    private Boolean    paymentformiscredit ;

    @Column(name="paymentformneedbank")
    private Boolean    paymentformneedbank ;

    @Column(name="paymentformisactive")
    private Boolean    paymentformisactive ;

    @Temporal(TemporalType.DATE)
    @Column(name="paymentformmoddate")
    private Date       paymentformmoddate ;

	// "paymentformUserid" (column "paymentform_userid") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="paymentform", targetEntity=SalesorderEntity.class)
    private List<SalesorderEntity> listOfSalesorder;

    @ManyToOne
    @JoinColumn(name="paymentform_userid", referencedColumnName="userid")
    private UseraccessEntity useraccess  ;

    @OneToMany(mappedBy="paymentform", targetEntity=PurchaseorderEntity.class)
    private List<PurchaseorderEntity> listOfPurchaseorder;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public PaymentformEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPaymentformid( UUID paymentformid ) {
        this.paymentformid = paymentformid ;
    }
    public UUID getPaymentformid() {
        return this.paymentformid;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : paymentformcode ( varchar ) 
    public void setPaymentformcode( String paymentformcode ) {
        this.paymentformcode = paymentformcode;
    }
    public String getPaymentformcode() {
        return this.paymentformcode;
    }

    //--- DATABASE MAPPING : paymentformname ( varchar ) 
    public void setPaymentformname( String paymentformname ) {
        this.paymentformname = paymentformname;
    }
    public String getPaymentformname() {
        return this.paymentformname;
    }

    //--- DATABASE MAPPING : paymentformiscredit ( bool ) 
    public void setPaymentformiscredit( Boolean paymentformiscredit ) {
        this.paymentformiscredit = paymentformiscredit;
    }
    public Boolean getPaymentformiscredit() {
        return this.paymentformiscredit;
    }

    //--- DATABASE MAPPING : paymentformneedbank ( bool ) 
    public void setPaymentformneedbank( Boolean paymentformneedbank ) {
        this.paymentformneedbank = paymentformneedbank;
    }
    public Boolean getPaymentformneedbank() {
        return this.paymentformneedbank;
    }

    //--- DATABASE MAPPING : paymentformisactive ( bool ) 
    public void setPaymentformisactive( Boolean paymentformisactive ) {
        this.paymentformisactive = paymentformisactive;
    }
    public Boolean getPaymentformisactive() {
        return this.paymentformisactive;
    }

    //--- DATABASE MAPPING : paymentformmoddate ( date ) 
    public void setPaymentformmoddate( Date paymentformmoddate ) {
        this.paymentformmoddate = paymentformmoddate;
    }
    public Date getPaymentformmoddate() {
        return this.paymentformmoddate;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfSalesorder( List<SalesorderEntity> listOfSalesorder ) {
        this.listOfSalesorder = listOfSalesorder;
    }
    public List<SalesorderEntity> getListOfSalesorder() {
        return this.listOfSalesorder;
    }

    public void setUseraccess( UseraccessEntity useraccess ) {
        this.useraccess = useraccess;
    }
    public UseraccessEntity getUseraccess() {
        return this.useraccess;
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
        sb.append(paymentformid);
        sb.append("]:"); 
        sb.append(paymentformcode);
        sb.append("|");
        sb.append(paymentformname);
        sb.append("|");
        sb.append(paymentformiscredit);
        sb.append("|");
        sb.append(paymentformneedbank);
        sb.append("|");
        sb.append(paymentformisactive);
        sb.append("|");
        sb.append(paymentformmoddate);
        return sb.toString(); 
    } 

}