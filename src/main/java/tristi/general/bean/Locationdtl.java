/*
 * Created on 6 Dec 2015 ( Time 04:13:34 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Locationdtl implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    @Size( min = 1, max = 255 )
    private String locationdtlid;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 255 )
    private String locationdtlLocationid;

    @Size( max = 255 )
    private String locationdtlUserid;

    @Size( max = 100 )
    private String locationdtlname;


    private Boolean locationdtlisactive;


    private Date locationdtlmoddate;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setLocationdtlid( String locationdtlid ) {
        this.locationdtlid = locationdtlid ;
    }

    public String getLocationdtlid() {
        return this.locationdtlid;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setLocationdtlLocationid( String locationdtlLocationid ) {
        this.locationdtlLocationid = locationdtlLocationid;
    }
    public String getLocationdtlLocationid() {
        return this.locationdtlLocationid;
    }

    public void setLocationdtlUserid( String locationdtlUserid ) {
        this.locationdtlUserid = locationdtlUserid;
    }
    public String getLocationdtlUserid() {
        return this.locationdtlUserid;
    }

    public void setLocationdtlname( String locationdtlname ) {
        this.locationdtlname = locationdtlname;
    }
    public String getLocationdtlname() {
        return this.locationdtlname;
    }

    public void setLocationdtlisactive( Boolean locationdtlisactive ) {
        this.locationdtlisactive = locationdtlisactive;
    }
    public Boolean getLocationdtlisactive() {
        return this.locationdtlisactive;
    }

    public void setLocationdtlmoddate( Date locationdtlmoddate ) {
        this.locationdtlmoddate = locationdtlmoddate;
    }
    public Date getLocationdtlmoddate() {
        return this.locationdtlmoddate;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(locationdtlid);
        sb.append("|");
        sb.append(locationdtlLocationid);
        sb.append("|");
        sb.append(locationdtlUserid);
        sb.append("|");
        sb.append(locationdtlname);
        sb.append("|");
        sb.append(locationdtlisactive);
        sb.append("|");
        sb.append(locationdtlmoddate);
        return sb.toString(); 
    } 


}
