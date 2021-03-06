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
 * Persistent class for entity stored in table "accountbank"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="accountbank", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="AccountbankEntity.countAll", query="SELECT COUNT(x) FROM AccountbankEntity x" )
} )
public class AccountbankEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="accountbankid", nullable=false, length=255)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID     accountbankid ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="accountbanknumber", length=50)
    private String     accountbanknumber ;

    @Column(name="accountbankname", length=100)
    private String     accountbankname ;

    @Column(name="accountbankissales")
    private Boolean    accountbankissales ;

    @Temporal(TemporalType.DATE)
    @Column(name="accountbankmoddate")
    private Date       accountbankmoddate ;

	// "accountbankSupplierid" (column "accountbank_supplierid") is not defined by itself because used as FK in a link 
	// "accountbankSalesorderid" (column "accountbank_salesorderid") is not defined by itself because used as FK in a link 
	// "accountbankBankid" (column "accountbank_bankid") is not defined by itself because used as FK in a link 
	// "accountbankUserid" (column "accountbank_userid") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="accountbank", targetEntity=PurchaseorderEntity.class)
    private List<PurchaseorderEntity> listOfPurchaseorder;

    @ManyToOne
    @JoinColumn(name="accountbank_salesorderid", referencedColumnName="salesorderid")
    private SalesorderEntity salesorder  ;

    @ManyToOne
    @JoinColumn(name="accountbank_userid", referencedColumnName="userid")
    private UseraccessEntity useraccess  ;

    @ManyToOne
    @JoinColumn(name="accountbank_bankid", referencedColumnName="bankid")
    private BankEntity bank        ;

    @ManyToOne
    @JoinColumn(name="accountbank_supplierid", referencedColumnName="supplierid")
    private SupplierEntity supplier    ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public AccountbankEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setAccountbankid( UUID accountbankid ) {
        this.accountbankid = accountbankid ;
    }
    public UUID getAccountbankid() {
        return this.accountbankid;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : accountbanknumber ( varchar ) 
    public void setAccountbanknumber( String accountbanknumber ) {
        this.accountbanknumber = accountbanknumber;
    }
    public String getAccountbanknumber() {
        return this.accountbanknumber;
    }

    //--- DATABASE MAPPING : accountbankname ( varchar ) 
    public void setAccountbankname( String accountbankname ) {
        this.accountbankname = accountbankname;
    }
    public String getAccountbankname() {
        return this.accountbankname;
    }

    //--- DATABASE MAPPING : accountbankissales ( bool ) 
    public void setAccountbankissales( Boolean accountbankissales ) {
        this.accountbankissales = accountbankissales;
    }
    public Boolean getAccountbankissales() {
        return this.accountbankissales;
    }

    //--- DATABASE MAPPING : accountbankmoddate ( date ) 
    public void setAccountbankmoddate( Date accountbankmoddate ) {
        this.accountbankmoddate = accountbankmoddate;
    }
    public Date getAccountbankmoddate() {
        return this.accountbankmoddate;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfPurchaseorder( List<PurchaseorderEntity> listOfPurchaseorder ) {
        this.listOfPurchaseorder = listOfPurchaseorder;
    }
    public List<PurchaseorderEntity> getListOfPurchaseorder() {
        return this.listOfPurchaseorder;
    }

    public void setSalesorder( SalesorderEntity salesorder ) {
        this.salesorder = salesorder;
    }
    public SalesorderEntity getSalesorder() {
        return this.salesorder;
    }

    public void setUseraccess( UseraccessEntity useraccess ) {
        this.useraccess = useraccess;
    }
    public UseraccessEntity getUseraccess() {
        return this.useraccess;
    }

    public void setBank( BankEntity bank ) {
        this.bank = bank;
    }
    public BankEntity getBank() {
        return this.bank;
    }

    public void setSupplier( SupplierEntity supplier ) {
        this.supplier = supplier;
    }
    public SupplierEntity getSupplier() {
        return this.supplier;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(accountbankid);
        sb.append("]:"); 
        sb.append(accountbanknumber);
        sb.append("|");
        sb.append(accountbankname);
        sb.append("|");
        sb.append(accountbankissales);
        sb.append("|");
        sb.append(accountbankmoddate);
        return sb.toString(); 
    } 

}
