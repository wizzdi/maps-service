package com.wizzdi.maps.service.request;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public interface FilterComponentPropertyProvider {

    Path<?> getPropertyPath(Root<?> r, CriteriaQuery q,List<Predicate> predicates,MapFilterComponentRequest filter);

    Class<?> getType(MapFilterComponentRequest filter);
}
