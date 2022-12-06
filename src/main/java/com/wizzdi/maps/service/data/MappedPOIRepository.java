package com.wizzdi.maps.service.data;

import com.flexicore.model.*;
import com.flexicore.model.territories.Address;
import com.flexicore.security.SecurityContextBase;
import com.flexicore.territories.data.AddressRepository;
import com.flexicore.territories.request.AddressFilter;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.data.BasicRepository;
import com.wizzdi.flexicore.security.data.SecuredBasicRepository;
import com.wizzdi.maps.model.*;
import com.wizzdi.maps.service.request.LocationArea;
import com.wizzdi.maps.service.request.MappedPOIFilter;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Extension
@Component
public class MappedPOIRepository implements Plugin {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private SecuredBasicRepository securedBasicRepository;
    @Autowired
    private MapGroupRepository mapGroupRepository;
    @Autowired
    private AddressRepository addressRepository;

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
            CriteriaQuery<?> q,
            From<?, T> r,
            List<Predicate> preds,
            SecurityContextBase securityContext) {

        this.securedBasicRepository.addSecuredBasicPredicates(
                filtering.getBasicPropertiesFilter(), cb, q, r, preds, securityContext);
        if (filtering.getNameLike()!=null && !filtering.getNameLike().isEmpty()) {
            if (!filtering.getNameLike().startsWith("%")) filtering.setNameLike("%"+filtering.getNameLike());
            if (!filtering.getNameLike().endsWith("%")) filtering.setNameLike(filtering.getNameLike()+"%");
            preds.add(cb.like(r.get(MappedPOI_.name),filtering.getNameLike()));
        }
        if (filtering.getAddress() != null && !filtering.getAddress().isEmpty()) {
            Set<String> ids =
                    filtering.getAddress().parallelStream().map(f -> f.getId()).collect(Collectors.toSet());
            Join<T, Address> join = r.join(MappedPOI_.address);
            Predicate in = join.get(Basic_.id).in(ids);
            preds.add(filtering.isAddressExclude()?cb.not(in):in);
        }

        if (filtering.getRoom() != null && !filtering.getRoom().isEmpty()) {
            Set<String> ids =
                    filtering.getRoom().parallelStream().map(f -> f.getId()).collect(Collectors.toSet());
            Join<T, Room> join = r.join(MappedPOI_.room);
            Predicate in = join.get(Basic_.id).in(ids);
            preds.add(filtering.isRoomExclude()?cb.not(in):in);
        }
        if (filtering.getTenants() != null && !filtering.getTenants().isEmpty()) {
            Set<String> ids =
                    filtering.getTenants().parallelStream().map(f -> f.getId()).collect(Collectors.toSet());
            Join<T, Baseclass> join = r.join(MappedPOI_.security);
            Join<Baseclass, SecurityTenant> tenantJoin = join.join(Baseclass_.tenant);
            Predicate in = tenantJoin.get(Basic_.id).in(ids);
            preds.add(filtering.isTenantsExclude()?cb.not(in):in);
        }
        if (filtering.getMapIcons() != null && !filtering.getMapIcons().isEmpty()) {
            Set<String> ids =
                    filtering.getMapIcons().parallelStream().map(f -> f.getId()).collect(Collectors.toSet());
            Join<T, MapIcon> join = r.join(MappedPOI_.mapIcon);
            Predicate in = join.get(Basic_.id).in(ids);
            preds.add(filtering.isMapIconsExclude()?cb.not(in):in);
        }
        AddressFilter addressFilter = filtering.getAddressFilter();
        if (addressFilter != null) {
            Join<T, Address> join = r.join(MappedPOI_.address);
            addressRepository.addAddressPredicate(addressFilter, q, cb, join, preds, securityContext);
        }

        if (filtering.getRelatedType() != null && !filtering.getRelatedType().isEmpty()) {
            Predicate in = r.get(MappedPOI_.relatedType).in(filtering.getRelatedType());
            preds.add(filtering.isRelatedTypeExclude()?cb.not(in):in);
        }
        if (filtering.getRelatedId() != null && !filtering.getRelatedId().isEmpty()) {
            Predicate in = r.get(MappedPOI_.relatedId).in(filtering.getRelatedId());
            preds.add(filtering.isRelatedIdExclude()?cb.not(in):in);
        }
        LocationArea locationArea = filtering.getLocationArea();
        if (locationArea != null) {
            if (locationArea.getLatStart() != null && locationArea.getLatEnd() != null) {
                preds.add(cb.between(r.get(MappedPOI_.lat), locationArea.getLatStart(), locationArea.getLatEnd()));
            }
            if (locationArea.getLonStart() != null && locationArea.getLonEnd() != null) {
                preds.add(cb.between(r.get(MappedPOI_.lon), locationArea.getLonStart(), locationArea.getLonEnd()));
            }

        }

        if (filtering.getMapGroupFilter() != null) {
            Join<T, MapGroupToMappedPOI> join1 = r.join(MappedPOI_.mapGroupToMappedPOIS);
            Join<MapGroupToMappedPOI, MapGroup> join = join1.join(MapGroupToMappedPOI_.mapGroup);
            mapGroupRepository.addMapGroupPredicate(filtering.getMapGroupFilter(), cb, q, join, preds, securityContext);
            preds.add(cb.isFalse(join1.get(Basic_.softDelete)));
        }
        if(filtering.getPredicateAdder()!=null){
            filtering.getPredicateAdder().addPredicates(filtering,cb,q,r,preds,securityContext);
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
