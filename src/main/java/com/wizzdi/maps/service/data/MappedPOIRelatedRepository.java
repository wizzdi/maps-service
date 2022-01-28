package com.wizzdi.maps.service.data;

import com.flexicore.model.Basic;
import com.flexicore.model.Basic_;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.data.BasicRepository;
import com.wizzdi.maps.model.Building;
import org.pf4j.Extension;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@Extension
public class MappedPOIRelatedRepository implements Plugin {

    @PersistenceContext
    private EntityManager em;

    public <T extends Basic> List<T> getRelatedForType(Class<T> type, Set<String> ids){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> q = cb.createQuery(type);
        Root<T> r = q.from(type);

        q.select(r).where(r.get(Basic_.id).in(ids));
        TypedQuery<T> query = em.createQuery(q);
        return query.getResultList();
    }
}
