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
import static org.postgresql.core.Oid.UUID;

/**
 * Persistent class for entity stored in table "detailexpired"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="detailexpired", schema="public" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="DetailexpiredEntity.countAll", query="SELECT COUNT(x) FROM DetailexpiredEntity x" )
} )
public class DetailexpiredEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @Column(name="detailexpiredid", nullable=false, length=255)
    @Type(type = "org.hibernate.type.PostgresUUIDType")
    private UUID     detailexpiredid ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Temporal(TemporalType.DATE)
    @Column(name="detailexpireddate")
    private Date       detailexpireddate ;

    @Column(name="detailexpiredqty")
    private Integer    detailexpiredqty ;

    @Temporal(TemporalType.DATE)
    @Column(name="detailexpiredmoddate")
    private Date       detailexpiredmoddate ;

	// "detailexpiredProductstockid" (column "detailexpired_productstockid") is not defined by itself because used as FK in a link 
	// "detailexpiredUserid" (column "detailexpired_userid") is not defined by itself because used as FK in a link 
	// "detailexpiredLocationdtlid" (column "detailexpired_locationdtlid") is not defined by itself because used as FK in a link 


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @OneToMany(mappedBy="detailexpired", targetEntity=ReturnsupplierdtlEntity.class)
    private List<ReturnsupplierdtlEntity> listOfReturnsupplierdtl;

    @OneToMany(mappedBy="detailexpired", targetEntity=SalesorderdtlEntity.class)
    private List<SalesorderdtlEntity> listOfSalesorderdtl;

    @ManyToOne
    @JoinColumn(name="detailexpired_productstockid", referencedColumnName="productstockid")
    private ProductstockEntity productstock;

    @ManyToOne
    @JoinColumn(name="detailexpired_locationdtlid", referencedColumnName="locationdtlid")
    private LocationdtlEntity locationdtl ;

    @OneToMany(mappedBy="detailexpired", targetEntity=PurchaseorderdtlEntity.class)
    private List<PurchaseorderdtlEntity> listOfPurchaseorderdtl;

    @ManyToOne
    @JoinColumn(name="detailexpired_userid", referencedColumnName="userid")
    private UseraccessEntity useraccess  ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public DetailexpiredEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setDetailexpiredid( UUID detailexpiredid ) {
        this.detailexpiredid = detailexpiredid ;
    }
    public UUID getDetailexpiredid() {
        return this.detailexpiredid;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : detailexpireddate ( date ) 
    public void setDetailexpireddate( Date detailexpireddate ) {
        this.detailexpireddate = detailexpireddate;
    }
    public Date getDetailexpireddate() {
        return this.detailexpireddate;
    }

    //--- DATABASE MAPPING : detailexpiredqty ( int4 ) 
    public void setDetailexpiredqty( Integer detailexpiredqty ) {
        this.detailexpiredqty = detailexpiredqty;
    }
    public Integer getDetailexpiredqty() {
        return this.detailexpiredqty;
    }

    //--- DATABASE MAPPING : detailexpiredmoddate ( date ) 
    public void setDetailexpiredmoddate( Date detailexpiredmoddate ) {
        this.detailexpiredmoddate = detailexpiredmoddate;
    }
    public Date getDetailexpiredmoddate() {
        return this.detailexpiredmoddate;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
    public void setListOfReturnsupplierdtl( List<ReturnsupplierdtlEntity> listOfReturnsupplierdtl ) {
        this.listOfReturnsupplierdtl = listOfReturnsupplierdtl;
    }
    public List<ReturnsupplierdtlEntity> getListOfReturnsupplierdtl() {
        return this.listOfReturnsupplierdtl;
    }

    public void setListOfSalesorderdtl( List<SalesorderdtlEntity> listOfSalesorderdtl ) {
        this.listOfSalesorderdtl = listOfSalesorderdtl;
    }
    public List<SalesorderdtlEntity> getListOfSalesorderdtl() {
        return this.listOfSalesorderdtl;
    }

    public void setProductstock( ProductstockEntity productstock ) {
        this.productstock = productstock;
    }
    public ProductstockEntity getProductstock() {
        return this.productstock;
    }

    public void setLocationdtl( LocationdtlEntity locationdtl ) {
        this.locationdtl = locationdtl;
    }
    public LocationdtlEntity getLocationdtl() {
        return this.locationdtl;
    }

    public void setListOfPurchaseorderdtl( List<PurchaseorderdtlEntity> listOfPurchaseorderdtl ) {
        this.listOfPurchaseorderdtl = listOfPurchaseorderdtl;
    }
    public List<PurchaseorderdtlEntity> getListOfPurchaseorderdtl() {
        return this.listOfPurchaseorderdtl;
    }

    public void setUseraccess( UseraccessEntity useraccess ) {
        this.useraccess = useraccess;
    }
    public UseraccessEntity getUseraccess() {
        return this.useraccess;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(detailexpiredid);
        sb.append("]:"); 
        sb.append(detailexpireddate);
        sb.append("|");
        sb.append(detailexpiredqty);
        sb.append("|");
        sb.append(detailexpiredmoddate);
        return sb.toString(); 
    } 

}
