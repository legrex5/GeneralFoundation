/*
 * Created on 6 Dec 2015 ( Time 04:13:34 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Productuom implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    @Size( min = 1, max = 255 )
    private String productuomid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 255 )
    private String userid;

    @Size( max = 255 )
    private String productid;

    @Size( max = 255 )
    private String uomid;


    private Double productuomvalue;


    private Double productuomissalesunit;


    private Double productuomisstockunit;


    private Double productuomisbaseunit;


    private Integer productuomsequence;


    private Boolean productuomisactive;


    private Date productuommoddate;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setProductuomid( String productuomid ) {
        this.productuomid = productuomid ;
    }

    public String getProductuomid() {
        return this.productuomid;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setUserid( String userid ) {
        this.userid = userid;
    }
    public String getUserid() {
        return this.userid;
    }

    public void setProductid( String productid ) {
        this.productid = productid;
    }
    public String getProductid() {
        return this.productid;
    }

    public void setUomid( String uomid ) {
        this.uomid = uomid;
    }
    public String getUomid() {
        return this.uomid;
    }

    public void setProductuomvalue( Double productuomvalue ) {
        this.productuomvalue = productuomvalue;
    }
    public Double getProductuomvalue() {
        return this.productuomvalue;
    }

    public void setProductuomissalesunit( Double productuomissalesunit ) {
        this.productuomissalesunit = productuomissalesunit;
    }
    public Double getProductuomissalesunit() {
        return this.productuomissalesunit;
    }

    public void setProductuomisstockunit( Double productuomisstockunit ) {
        this.productuomisstockunit = productuomisstockunit;
    }
    public Double getProductuomisstockunit() {
        return this.productuomisstockunit;
    }

    public void setProductuomisbaseunit( Double productuomisbaseunit ) {
        this.productuomisbaseunit = productuomisbaseunit;
    }
    public Double getProductuomisbaseunit() {
        return this.productuomisbaseunit;
    }

    public void setProductuomsequence( Integer productuomsequence ) {
        this.productuomsequence = productuomsequence;
    }
    public Integer getProductuomsequence() {
        return this.productuomsequence;
    }

    public void setProductuomisactive( Boolean productuomisactive ) {
        this.productuomisactive = productuomisactive;
    }
    public Boolean getProductuomisactive() {
        return this.productuomisactive;
    }

    public void setProductuommoddate( Date productuommoddate ) {
        this.productuommoddate = productuommoddate;
    }
    public Date getProductuommoddate() {
        return this.productuommoddate;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(productuomid);
        sb.append("|");
        sb.append(userid);
        sb.append("|");
        sb.append(productid);
        sb.append("|");
        sb.append(uomid);
        sb.append("|");
        sb.append(productuomvalue);
        sb.append("|");
        sb.append(productuomissalesunit);
        sb.append("|");
        sb.append(productuomisstockunit);
        sb.append("|");
        sb.append(productuomisbaseunit);
        sb.append("|");
        sb.append(productuomsequence);
        sb.append("|");
        sb.append(productuomisactive);
        sb.append("|");
        sb.append(productuommoddate);
        return sb.toString(); 
    } 


}
