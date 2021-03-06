/*
 * Created on 6 Dec 2015 ( Time 04:13:34 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Pricehistory implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    @Size( min = 1, max = 255 )
    private String pricehistoryid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 255 )
    private String pricehistoryUserid;

    @Size( max = 255 )
    private String pricehistoryProductid;


    private Double pricehistorybaseprice;


    private Double pricehistoryprice;


    private Date pricehistoryfrom;


    private Date pricehistoryto;


    private Date pricehistorymoddate;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setPricehistoryid( String pricehistoryid ) {
        this.pricehistoryid = pricehistoryid ;
    }

    public String getPricehistoryid() {
        return this.pricehistoryid;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setPricehistoryUserid( String pricehistoryUserid ) {
        this.pricehistoryUserid = pricehistoryUserid;
    }
    public String getPricehistoryUserid() {
        return this.pricehistoryUserid;
    }

    public void setPricehistoryProductid( String pricehistoryProductid ) {
        this.pricehistoryProductid = pricehistoryProductid;
    }
    public String getPricehistoryProductid() {
        return this.pricehistoryProductid;
    }

    public void setPricehistorybaseprice( Double pricehistorybaseprice ) {
        this.pricehistorybaseprice = pricehistorybaseprice;
    }
    public Double getPricehistorybaseprice() {
        return this.pricehistorybaseprice;
    }

    public void setPricehistoryprice( Double pricehistoryprice ) {
        this.pricehistoryprice = pricehistoryprice;
    }
    public Double getPricehistoryprice() {
        return this.pricehistoryprice;
    }

    public void setPricehistoryfrom( Date pricehistoryfrom ) {
        this.pricehistoryfrom = pricehistoryfrom;
    }
    public Date getPricehistoryfrom() {
        return this.pricehistoryfrom;
    }

    public void setPricehistoryto( Date pricehistoryto ) {
        this.pricehistoryto = pricehistoryto;
    }
    public Date getPricehistoryto() {
        return this.pricehistoryto;
    }

    public void setPricehistorymoddate( Date pricehistorymoddate ) {
        this.pricehistorymoddate = pricehistorymoddate;
    }
    public Date getPricehistorymoddate() {
        return this.pricehistorymoddate;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(pricehistoryid);
        sb.append("|");
        sb.append(pricehistoryUserid);
        sb.append("|");
        sb.append(pricehistoryProductid);
        sb.append("|");
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
