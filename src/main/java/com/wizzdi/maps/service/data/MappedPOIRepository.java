package com.wizzdi.maps.service.data;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.model.Basic_;
import com.flexicore.model.territories.Address;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.security.data.BasicRepository;
import com.wizzdi.flexicore.security.data.SecuredBasicRepository;
import com.wizzdi.maps.model.*;
import com.wizzdi.maps.service.request.LocationArea;
import com.wizzdi.maps.service.request.MappedPOIFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;

import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Extension
@Component
public class MappedPOIRepository implements Plugin {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SecuredBasicRepository securedBasicRepository;
    @Autowired
    private MapGroupRepository mapGroupRepository;

    /**
     * @param filtering
     * @param securityContext
     * @return List of MappedPOI
     */
    public List<MappedPOI> listAllMappedPOIs(
            MappedPOIFilter filtering, SecurityContextBase securityContext) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<MappedPOI> q = cb.createQuery(MappedPOI.class);
        Root<MappedPOI> r = q.from(MappedPOI.class);
        List<Predicate> preds = new ArrayList<>();
        addMappedPOIPredicate(filtering, cb, q, r, preds, securityContext);
        q.select(r).where(preds.toArray(new Predicate[0]));
        TypedQuery<MappedPOI> query = em.createQuery(q);
        BasicRepository.addPagination(filtering, query);
        return query.getResultList();
    }

    public <T extends MappedPOI> void addMappedPOIPredicate(
            MappedPOIFilter filtering,
            CriteriaBuilder cb,
            CommonAbstractCriteria q,
            From<?, T> r,
            List<Predicate> preds,
            SecurityContextBase securityContext) {

        this.securedBasicRepository.addSecuredBasicPredicates(
                filtering.getBasicPropertiesFilter(), cb, q, r, preds, securityContext);

        if (filtering.getAddress() != null && !filtering.getAddress().isEmpty()) {
            Set<String> ids =
                    filtering.getAddress().parallelStream().map(f -> f.getId()).collect(Collectors.toSet());
            Join<T, Address> join = r.join(MappedPOI_.address);
            preds.add(join.get(Basic_.id).in(ids));
        }

        if (filtering.getRoom() != null && !filtering.getRoom().isEmpty()) {
            Set<String> ids =
                    filtering.getRoom().parallelStream().map(f -> f.getId()).collect(Collectors.toSet());
            Join<T, Room> join = r.join(MappedPOI_.room);
            preds.add(join.get(Basic_.id).in(ids));
        }
        if (filtering.getMapGroupFilter() != null) {
            Join<T, MapGroupToMappedPOI> join1 = r.join(MappedPOI_.mapGroupToMappedPOIS);
            Join<MapGroupToMappedPOI, MapGroup> join = join1.join(MapGroupToMappedPOI_.mapGroup);

            if (filtering.getRelatedType() != null && !filtering.getRelatedType().isEmpty()) {
                preds.add(r.get(MappedPOI_.relatedType).in(filtering.getRelatedType()));
            }
            if (filtering.getRelatedId() != null && !filtering.getRelatedId().isEmpty()) {
                preds.add(r.get(MappedPOI_.relatedId).in(filtering.getRelatedId()));
            }
            LocationArea locationArea = filtering.getLocationArea();
            if (locationArea != null ) {
                if(locationArea.getLatStart()!=null&&locationArea.getLatEnd()!=null){
                    preds.add(cb.between(r.get(MappedPOI_.lat), locationArea.getLatStart(), locationArea.getLatEnd()));
                }
                if(locationArea.getLonStart()!=null&&locationArea.getLonEnd()!=null){
                    preds.add(cb.between(r.get(MappedPOI_.lon), locationArea.getLonStart(), locationArea.getLonEnd()));
                }

            }

            mapGroupRepository.addMapGroupPredicate(filtering.getMapGroupFilter(), cb, q, join, preds, securityContext);
            preds.add(cb.isFalse(join1.get(Basic_.softDelete)));
        }
    }

    /**
     * @param filtering
     * @param securityContext
     * @return count of MappedPOI
     */
    public Long countAllMappedPOIs(MappedPOIFilter filtering, SecurityContextBase securityContext) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> q = cb.createQuery(Long.class);
        Root<MappedPOI> r = q.from(MappedPOI.class);
        List<Predicate> preds = new ArrayList<>();
        addMappedPOIPredicate(filtering, cb, q, r, preds, securityContext);
        q.select(cb.count(r)).where(preds.toArray(new Predicate[0]));
        TypedQuery<Long> query = em.createQuery(q);
        return query.getSingleResult();
    }


    public <T extends Baseclass> List<T> listByIds(
            Class<T> c, Set<String> ids, SecurityContextBase securityContext) {
        return securedBasicRepository.listByIds(c, ids, securityContext);
    }


    public <T extends Baseclass> T getByIdOrNull(
            String id, Class<T> c, SecurityContextBase securityContext) {
        return securedBasicRepository.getByIdOrNull(id, c, securityContext);
    }


    public <D extends Basic, E extends Baseclass, T extends D> T getByIdOrNull(
            String id,
            Class<T> c,
            SingularAttribute<D, E> baseclassAttribute,
            SecurityContextBase securityContext) {
        return securedBasicRepository.getByIdOrNull(id, c, baseclassAttribute, securityContext);
    }


    public <D extends Basic, E extends Baseclass, T extends D> List<T> listByIds(
            Class<T> c,
            Set<String> ids,
            SingularAttribute<D, E> baseclassAttribute,
            SecurityContextBase securityContext) {
        return securedBasicRepository.listByIds(c, ids, baseclassAttribute, securityContext);
    }


    public <D extends Basic, T extends D> List<T> findByIds(
            Class<T> c, Set<String> ids, SingularAttribute<D, String> idAttribute) {
        return securedBasicRepository.findByIds(c, ids, idAttribute);
    }


    public <T extends Basic> List<T> findByIds(Class<T> c, Set<String> requested) {
        return securedBasicRepository.findByIds(c, requested);
    }


    public <T> T findByIdOrNull(Class<T> type, String id) {
        return securedBasicRepository.findByIdOrNull(type, id);
    }


    @Transactional
    public void merge(java.lang.Object base) {
        securedBasicRepository.merge(base);
    }


    @Transactional
    public void massMerge(List<?> toMerge) {
        securedBasicRepository.massMerge(toMerge);
    }
}
