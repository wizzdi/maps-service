package com.wizzdi.maps.service.request;

import com.wizzdi.flexicore.security.request.BasicCreate;
import com.wizzdi.maps.model.LayerType;


public class LayerCreate extends BasicCreate {

    private LayerType layerType;

    public LayerType getLayerType() {
        return layerType;
    }

    public LayerCreate setLayerType(LayerType layerType) {
        this.layerType = layerType;
        return this;
    }
}
