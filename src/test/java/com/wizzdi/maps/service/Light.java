package com.wizzdi.maps.service;

import com.wizzdi.maps.model.MappedPOI;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Light extends MappedPOI {

    @ManyToOne(targetEntity = LightOperator.class)
    private LightOperator lightOperator;

    @ManyToOne(targetEntity = LightOperator.class)
    public LightOperator getLightOperator() {
        return lightOperator;
    }

    public <T extends Light> T setLightOperator(LightOperator lightOperator) {
        this.lightOperator = lightOperator;
        return (T) this;
    }
}
