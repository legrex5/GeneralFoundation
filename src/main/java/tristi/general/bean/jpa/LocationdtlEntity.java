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
 * Persistent class for entity stored in table "locationdtl"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="locationdtl", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="LocationdtlEntity.countAll", query="SELECT COUNT(x) FROM LocationdtlEntity x" )
} )
public class LocationdtlEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="locationdtlid", nullable=false, length=255)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID     locationdtlid ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="locationdtlname", length=100)
    private String     locationdtlname ;

    @Column(name="locationdtlisactive")
    private Boolean    locationdtlisactive ;

    @Temporal(TemporalType.DATE)
    @Column(name="locationdtlmoddate")
    private Date       locationdtlmoddate ;

	// "locationdtlLocationid" (column "locationdtl_locationid") is not defined by itself because used as FK in a link 
	// "locationdtlUserid" (column "locationdtl_userid") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="locationdtl", targetEntity=DetailexpiredEntity.class)
    private List<DetailexpiredEntity> listOfDetailexpired;

    @ManyToOne
    @JoinColumn(name="locationdtl_userid", referencedColumnName="userid")
    private UseraccessEntity useraccess  ;

    @ManyToOne
    @JoinColumn(name="locationdtl_locationid", referencedColumnName="locationid")
    private LocationEntity location    ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public LocationdtlEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setLocationdtlid( UUID locationdtlid ) {
        this.locationdtlid = locationdtlid ;
    }
    public UUID getLocationdtlid() {
        return this.locationdtlid;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : locationdtlname ( varchar ) 
    public void setLocationdtlname( String locationdtlname ) {
        this.locationdtlname = locationdtlname;
    }
    public String getLocationdtlname() {
        return this.locationdtlname;
    }

    //--- DATABASE MAPPING : locationdtlisactive ( bool ) 
    public void setLocationdtlisactive( Boolean locationdtlisactive ) {
        this.locationdtlisactive = locationdtlisactive;
    }
    public Boolean getLocationdtlisactive() {
        return this.locationdtlisactive;
    }

    //--- DATABASE MAPPING : locationdtlmoddate ( date ) 
    public void setLocationdtlmoddate( Date locationdtlmoddate ) {
        this.locationdtlmoddate = locationdtlmoddate;
    }
    public Date getLocationdtlmoddate() {
        return this.locationdtlmoddate;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfDetailexpired( List<DetailexpiredEntity> listOfDetailexpired ) {
        this.listOfDetailexpired = listOfDetailexpired;
    }
    public List<DetailexpiredEntity> getListOfDetailexpired() {
        return this.listOfDetailexpired;
    }

    public void setUseraccess( UseraccessEntity useraccess ) {
        this.useraccess = useraccess;
    }
    public UseraccessEntity getUseraccess() {
        return this.useraccess;
    }

    public void setLocation( LocationEntity location ) {
        this.location = location;
    }
    public LocationEntity getLocation() {
        return this.location;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(locationdtlid);
        sb.append("]:"); 
        sb.append(locationdtlname);
        sb.append("|");
        sb.append(locationdtlisactive);
        sb.append("|");
        sb.append(locationdtlmoddate);
        return sb.toString(); 
    } 

}
