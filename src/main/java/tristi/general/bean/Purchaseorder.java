/*
 * Created on 6 Dec 2015 ( Time 04:13:34 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Purchaseorder implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    @Size( min = 1, max = 255 )
    private String purchaseorderid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 255 )
    private String purchaseorderSupplierid;

    @Size( max = 255 )
    private String purchaseorderAccountbankid;

    @Size( max = 255 )
    private String purchaseorderUserid;

    @Size( max = 255 )
    private String purchaseorderPaymentformid;

    @Size( max = 50 )
    private String purchaseordercode;

    @Size( max = 50 )
    private String purchaseorderrefnumber;


    private Date purchaseorderdate;


    private Double puchaseorderamount;


    private Double purchaserorderdiscount;


    private Date purchaseorderdeliverydate;

    @Size( max = 50 )
    private String purchaseorderstatus;


    private Boolean purchaseorderincludetax;


    private Date purchaseordermoddate;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPurchaseorderid( String purchaseorderid ) {
        this.purchaseorderid = purchaseorderid ;
    }

    public String getPurchaseorderid() {
        return this.purchaseorderid;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setPurchaseorderSupplierid( String purchaseorderSupplierid ) {
        this.purchaseorderSupplierid = purchaseorderSupplierid;
    }
    public String getPurchaseorderSupplierid() {
        return this.purchaseorderSupplierid;
    }

    public void setPurchaseorderAccountbankid( String purchaseorderAccountbankid ) {
        this.purchaseorderAccountbankid = purchaseorderAccountbankid;
    }
    public String getPurchaseorderAccountbankid() {
        return this.purchaseorderAccountbankid;
    }

    public void setPurchaseorderUserid( String purchaseorderUserid ) {
        this.purchaseorderUserid = purchaseorderUserid;
    }
    public String getPurchaseorderUserid() {
        return this.purchaseorderUserid;
    }

    public void setPurchaseorderPaymentformid( String purchaseorderPaymentformid ) {
        this.purchaseorderPaymentformid = purchaseorderPaymentformid;
    }
    public String getPurchaseorderPaymentformid() {
        return this.purchaseorderPaymentformid;
    }

    public void setPurchaseordercode( String purchaseordercode ) {
        this.purchaseordercode = purchaseordercode;
    }
    public String getPurchaseordercode() {
        return this.purchaseordercode;
    }

    public void setPurchaseorderrefnumber( String purchaseorderrefnumber ) {
        this.purchaseorderrefnumber = purchaseorderrefnumber;
    }
    public String getPurchaseorderrefnumber() {
        return this.purchaseorderrefnumber;
    }

    public void setPurchaseorderdate( Date purchaseorderdate ) {
        this.purchaseorderdate = purchaseorderdate;
    }
    public Date getPurchaseorderdate() {
        return this.purchaseorderdate;
    }

    public void setPuchaseorderamount( Double puchaseorderamount ) {
        this.puchaseorderamount = puchaseorderamount;
    }
    public Double getPuchaseorderamount() {
        return this.puchaseorderamount;
    }

    public void setPurchaserorderdiscount( Double purchaserorderdiscount ) {
        this.purchaserorderdiscount = purchaserorderdiscount;
    }
    public Double getPurchaserorderdiscount() {
        return this.purchaserorderdiscount;
    }

    public void setPurchaseorderdeliverydate( Date purchaseorderdeliverydate ) {
        this.purchaseorderdeliverydate = purchaseorderdeliverydate;
    }
    public Date getPurchaseorderdeliverydate() {
        return this.purchaseorderdeliverydate;
    }

    public void setPurchaseorderstatus( String purchaseorderstatus ) {
        this.purchaseorderstatus = purchaseorderstatus;
    }
    public String getPurchaseorderstatus() {
        return this.purchaseorderstatus;
    }

    public void setPurchaseorderincludetax( Boolean purchaseorderincludetax ) {
        this.purchaseorderincludetax = purchaseorderincludetax;
    }
    public Boolean getPurchaseorderincludetax() {
        return this.purchaseorderincludetax;
    }

    public void setPurchaseordermoddate( Date purchaseordermoddate ) {
        this.purchaseordermoddate = purchaseordermoddate;
    }
    public Date getPurchaseordermoddate() {
        return this.purchaseordermoddate;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(purchaseorderid);
        sb.append("|");
        sb.append(purchaseorderSupplierid);
        sb.append("|");
        sb.append(purchaseorderAccountbankid);
        sb.append("|");
        sb.append(purchaseorderUserid);
        sb.append("|");
        sb.append(purchaseorderPaymentformid);
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
