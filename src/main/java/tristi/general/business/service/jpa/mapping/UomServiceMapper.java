/*
 * Created on 6 Dec 2015 ( Time 04:09:00 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package tristi.general.business.service.jpa.mapping;

import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import tristi.general.bean.Uom;
import tristi.general.bean.jpa.UomEntity;
import tristi.general.bean.jpa.UseraccessEntity;

/**
 * Mapping between entity beans and display beans.
 */
@Component
public class UomServiceMapper extends AbstractServiceMapper {

    /**
     * ModelMapper : bean to bean mapping library.
     */
    private ModelMapper modelMapper;

    /**
     * Constructor.
     */
    public UomServiceMapper() {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Mapping from 'UomEntity' to 'Uom'
     *
     * @param uomEntity
     * @return Uom
     */
    public Uom mapUomEntityToUom(UomEntity uomEntity) {
        if (uomEntity == null) {
            return null;
        }

        //--- Generic mapping 
        Uom uom = map(uomEntity, Uom.class);

        //--- Link mapping ( link to Useraccess )
        if (uomEntity.getUseraccess() != null) {
            uom.setUomUserid(uomEntity.getUseraccess().getUserid().toString());
        }
        return uom;
    }

    /**
     * Mapping from 'Uom' to 'UomEntity'
     *
     * @param uom
     * @param uomEntity
     */
    public void mapUomToUomEntity(Uom uom, UomEntity uomEntity) {
        if (uom == null) {
            return;
        }

        //--- Generic mapping 
        map(uom, uomEntity);

        //--- Link mapping ( link : uom )
        if (hasLinkToUseraccess(uom)) {
            UseraccessEntity useraccess1 = new UseraccessEntity();
            useraccess1.setUserid(UUID.fromString(uom.getUomUserid()));
            uomEntity.setUseraccess(useraccess1);
        } else {
            uomEntity.setUseraccess(null);
        }

    }

    /**
     * Verify that Useraccess id is valid.
     *
     * @param Useraccess Useraccess
     * @return boolean
     */
    private boolean hasLinkToUseraccess(Uom uom) {
        return uom.getUomUserid() != null;
    }

    /**
     * {@inheritDoc}
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
