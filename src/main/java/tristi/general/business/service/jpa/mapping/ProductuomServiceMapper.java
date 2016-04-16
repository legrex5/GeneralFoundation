/*
 * Created on 6 Dec 2015 ( Time 04:08:59 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service.jpa.mapping;

import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import tristi.general.bean.Productuom;
import tristi.general.bean.jpa.ProductuomEntity;
import tristi.general.bean.jpa.UomEntity;
import tristi.general.bean.jpa.UseraccessEntity;
import tristi.general.bean.jpa.ProductEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class ProductuomServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;

    /**
     * Constructor.
     */
    public ProductuomServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'ProductuomEntity' to 'Productuom'
     *
     * @param productuomEntity
     * @return Productuom
     */
    public Productuom mapProductuomEntityToProductuom(ProductuomEntity productuomEntity) {
        if (productuomEntity == null) {
            return null;
        }

        //--- Generic mapping 
        Productuom productuom = map(productuomEntity, Productuom.class);

        //--- Link mapping ( link to Uom )
        if (productuomEntity.getUom() != null) {
            productuom.setUomid(productuomEntity.getUom().getUomid().toString());
        }
        //--- Link mapping ( link to Useraccess )
        if (productuomEntity.getUseraccess() != null) {
            productuom.setUserid(productuomEntity.getUseraccess().getUserid().toString());
        }
        //--- Link mapping ( link to Product )
        if (productuomEntity.getProduct() != null) {
            productuom.setProductid(productuomEntity.getProduct().getProductid().toString());
        }
        return productuom;
    }

    /**
     * Mapping from 'Productuom' to 'ProductuomEntity'
     *
     * @param productuom
     * @param productuomEntity
     */
    public void mapProductuomToProductuomEntity(Productuom productuom, ProductuomEntity productuomEntity) {
        if (productuom == null) {
            return;
        }

        //--- Generic mapping 
        map(productuom, productuomEntity);

        //--- Link mapping ( link : productuom )
        if (hasLinkToUom(productuom)) {
            UomEntity uom1 = new UomEntity();
            uom1.setUomid(UUID.fromString(productuom.getUomid()));
            productuomEntity.setUom(uom1);
        } else {
            productuomEntity.setUom(null);
        }

        //--- Link mapping ( link : productuom )
        if (hasLinkToUseraccess(productuom)) {
            UseraccessEntity useraccess2 = new UseraccessEntity();
            useraccess2.setUserid(UUID.fromString(productuom.getUserid()));
            productuomEntity.setUseraccess(useraccess2);
        } else {
            productuomEntity.setUseraccess(null);
        }

        //--- Link mapping ( link : productuom )
        if (hasLinkToProduct(productuom)) {
            ProductEntity product3 = new ProductEntity();
            product3.setProductid(UUID.fromString(productuom.getProductid()));
            productuomEntity.setProduct(product3);
        } else {
            productuomEntity.setProduct(null);
        }

    }

    /**
     * Verify that Uom id is valid.
     *
     * @param Uom Uom
     * @return boolean
     */
    private boolean hasLinkToUom(Productuom productuom) {
        return productuom.getUomid() != null;
    }

    /**
     * Verify that Useraccess id is valid.
     *
     * @param Useraccess Useraccess
     * @return boolean
     */
    private boolean hasLinkToUseraccess(Productuom productuom) {
        return productuom.getUserid() != null;
    }

    /**
     * Verify that Product id is valid.
     *
     * @param Product Product
     * @return boolean
     */
    private boolean hasLinkToProduct(Productuom productuom) {
        return productuom.getProductid() != null;
    }

    /**
     * {@inheritDoc}
     *
     * @return ModelMapper
     */
    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    protected void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

}
