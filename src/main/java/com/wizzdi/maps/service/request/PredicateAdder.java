package com.wizzdi.maps.service.request;

import com.flexicore.security.SecurityContextBase;
import com.wizzdi.maps.model.MappedPOI;

import javax.persistence.criteria.CommonAbstractCriteria;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Predicate;
import java.util.List;

public interface PredicateAdder<E> {

     <T extends MappedPOI> void addPredicates(
            E mapFilterComponentRequest,
            CriteriaBuilder cb,
            CommonAbstractCriteria q,
            From<?, T> r,
            List<Predicate> preds,
            SecurityContextBase securityContext);
}
