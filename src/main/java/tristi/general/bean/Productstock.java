/*
 * Created on 6 Dec 2015 ( Time 04:13:34 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Productstock implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    @Size( min = 1, max = 255 )
    private String productstockid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 255 )
    private String productstockLocationid;

    @Size( max = 255 )
    private String productstockUserid;

    @Size( max = 255 )
    private String productstockProductuomid;


    private Integer productstockqty;


    private Integer productstockmin;


    private Integer productstockmax;


    private Date productstockmoddate;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setProductstockid( String productstockid ) {
        this.productstockid = productstockid ;
    }

    public String getProductstockid() {
        return this.productstockid;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setProductstockLocationid( String productstockLocationid ) {
        this.productstockLocationid = productstockLocationid;
    }
    public String getProductstockLocationid() {
        return this.productstockLocationid;
    }

    public void setProductstockUserid( String productstockUserid ) {
        this.productstockUserid = productstockUserid;
    }
    public String getProductstockUserid() {
        return this.productstockUserid;
    }

    public void setProductstockProductuomid( String productstockProductuomid ) {
        this.productstockProductuomid = productstockProductuomid;
    }
    public String getProductstockProductuomid() {
        return this.productstockProductuomid;
    }

    public void setProductstockqty( Integer productstockqty ) {
        this.productstockqty = productstockqty;
    }
    public Integer getProductstockqty() {
        return this.productstockqty;
    }

    public void setProductstockmin( Integer productstockmin ) {
        this.productstockmin = productstockmin;
    }
    public Integer getProductstockmin() {
        return this.productstockmin;
    }

    public void setProductstockmax( Integer productstockmax ) {
        this.productstockmax = productstockmax;
    }
    public Integer getProductstockmax() {
        return this.productstockmax;
    }

    public void setProductstockmoddate( Date productstockmoddate ) {
        this.productstockmoddate = productstockmoddate;
    }
    public Date getProductstockmoddate() {
        return this.productstockmoddate;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(productstockid);
        sb.append("|");
        sb.append(productstockLocationid);
        sb.append("|");
        sb.append(productstockUserid);
        sb.append("|");
        sb.append(productstockProductuomid);
        sb.append("|");
        sb.append(productstockqty);
        sb.append("|");
        sb.append(productstockmin);
        sb.append("|");
        sb.append(productstockmax);
        sb.append("|");
        sb.append(productstockmoddate);
        return sb.toString(); 
    } 


}
