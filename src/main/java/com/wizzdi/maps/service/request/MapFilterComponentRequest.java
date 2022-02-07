package com.wizzdi.maps.service.request;

import com.wizzdi.flexicore.security.request.BasicPropertiesFilter;
import com.wizzdi.flexicore.security.request.PaginationFilter;

public class MapFilterComponentRequest extends PaginationFilter {

    private BasicPropertiesFilter basicPropertiesFilter;
    private MappedPOIFilter mappedPOIFilter;

    private FilterComponentType filterComponentType;

    public BasicPropertiesFilter getBasicPropertiesFilter() {
        return basicPropertiesFilter;
    }

    public <T extends MapFilterComponentRequest> T setBasicPropertiesFilter(BasicPropertiesFilter basicPropertiesFilter) {
        this.basicPropertiesFilter = basicPropertiesFilter;
        return (T) this;
    }

    public MappedPOIFilter getMappedPOIFilter() {
        return mappedPOIFilter;
    }

    public <T extends MapFilterComponentRequest> T setMappedPOIFilter(MappedPOIFilter mappedPOIFilter) {
        this.mappedPOIFilter = mappedPOIFilter;
        return (T) this;
    }

    public FilterComponentType getFilterComponentType() {
        return filterComponentType;
    }

    public <T extends MapFilterComponentRequest> T setFilterComponentType(FilterComponentType filterComponentType) {
        this.filterComponentType = filterComponentType;
        return (T) this;
    }
}
