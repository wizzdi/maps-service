package com.wizzdi.maps.service.data;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.model.territories.Address;
import com.flexicore.model.territories.Address_;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.data.BasicRepository;
import com.wizzdi.flexicore.security.data.SecuredBasicRepository;
import com.wizzdi.maps.model.LocationHistory;
import com.wizzdi.maps.model.LocationHistory_;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.MapIcon_;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.model.MappedPOI_;
import com.wizzdi.maps.model.Room;
import com.wizzdi.maps.model.Room_;
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

@Component
@Extension
public class MappedPOIRepository implements Plugin {
  @PersistenceContext private EntityManager em;

  @Autowired private SecuredBasicRepository securedBasicRepository;

  /**
   * @param mappedPOIFilter Object Used to List MappedPOI
   * @param securityContext
   * @return List of MappedPOI
   */
  public List<MappedPOI> listAllMappedPOIs(
      MappedPOIFilter mappedPOIFilter, SecurityContextBase securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<MappedPOI> q = cb.createQuery(MappedPOI.class);
    Root<MappedPOI> r = q.from(MappedPOI.class);
    List<Predicate> preds = new ArrayList<>();
    addMappedPOIPredicate(mappedPOIFilter, cb, q, r, preds, securityContext);
    q.select(r).where(preds.toArray(new Predicate[0]));
    TypedQuery<MappedPOI> query = em.createQuery(q);

    BasicRepository.addPagination(mappedPOIFilter, query);

    return query.getResultList();
  }

  public <T extends MappedPOI> void addMappedPOIPredicate(
      MappedPOIFilter mappedPOIFilter,
      CriteriaBuilder cb,
      CommonAbstractCriteria q,
      From<?, T> r,
      List<Predicate> preds,
      SecurityContextBase securityContext) {

    this.securedBasicRepository.addSecuredBasicPredicates(
        mappedPOIFilter.getBasicPropertiesFilter(), cb, q, r, preds, securityContext);

    if (mappedPOIFilter.getGeoHash7() != null && !mappedPOIFilter.getGeoHash7().isEmpty()) {
      preds.add(r.get(MappedPOI_.geoHash7).in(mappedPOIFilter.getGeoHash7()));
    }

    if (mappedPOIFilter.getGeoHash10() != null && !mappedPOIFilter.getGeoHash10().isEmpty()) {
      preds.add(r.get(MappedPOI_.geoHash10).in(mappedPOIFilter.getGeoHash10()));
    }

    if (mappedPOIFilter.getRelatedId() != null && !mappedPOIFilter.getRelatedId().isEmpty()) {
      preds.add(r.get(MappedPOI_.relatedId).in(mappedPOIFilter.getRelatedId()));
    }

    if (mappedPOIFilter.getGeoHash6() != null && !mappedPOIFilter.getGeoHash6().isEmpty()) {
      preds.add(r.get(MappedPOI_.geoHash6).in(mappedPOIFilter.getGeoHash6()));
    }

    if (mappedPOIFilter.getGeoHash8() != null && !mappedPOIFilter.getGeoHash8().isEmpty()) {
      preds.add(r.get(MappedPOI_.geoHash8).in(mappedPOIFilter.getGeoHash8()));
    }

    if (mappedPOIFilter.getZ() != null && !mappedPOIFilter.getZ().isEmpty()) {
      preds.add(r.get(MappedPOI_.z).in(mappedPOIFilter.getZ()));
    }

    if (mappedPOIFilter.getRoom() != null && !mappedPOIFilter.getRoom().isEmpty()) {
      Set<String> ids =
          mappedPOIFilter.getRoom().parallelStream()
              .map(f -> f.getId())
              .collect(Collectors.toSet());
      Join<T, Room> join = r.join(MappedPOI_.room);
      preds.add(join.get(Room_.id).in(ids));
    }

    if (mappedPOIFilter.getLat() != null && !mappedPOIFilter.getLat().isEmpty()) {
      preds.add(r.get(MappedPOI_.lat).in(mappedPOIFilter.getLat()));
    }

    if (mappedPOIFilter.getKeepLocationHistory() != null
        && !mappedPOIFilter.getKeepLocationHistory().isEmpty()) {
      preds.add(r.get(MappedPOI_.keepLocationHistory).in(mappedPOIFilter.getKeepLocationHistory()));
    }

    if (mappedPOIFilter.getMappedPOILocationHistories() != null
        && !mappedPOIFilter.getMappedPOILocationHistories().isEmpty()) {
      Set<String> ids =
          mappedPOIFilter.getMappedPOILocationHistories().parallelStream()
              .map(f -> f.getId())
              .collect(Collectors.toSet());
      Join<T, LocationHistory> join = r.join(MappedPOI_.mappedPOILocationHistories);
      preds.add(join.get(LocationHistory_.id).in(ids));
    }

    if (mappedPOIFilter.getGeoHash12() != null && !mappedPOIFilter.getGeoHash12().isEmpty()) {
      preds.add(r.get(MappedPOI_.geoHash12).in(mappedPOIFilter.getGeoHash12()));
    }

    if (mappedPOIFilter.getRelatedType() != null && !mappedPOIFilter.getRelatedType().isEmpty()) {
      preds.add(r.get(MappedPOI_.relatedType).in(mappedPOIFilter.getRelatedType()));
    }

    if (mappedPOIFilter.getExternalId() != null && !mappedPOIFilter.getExternalId().isEmpty()) {
      preds.add(r.get(MappedPOI_.externalId).in(mappedPOIFilter.getExternalId()));
    }

    if (mappedPOIFilter.getGeoHash2() != null && !mappedPOIFilter.getGeoHash2().isEmpty()) {
      preds.add(r.get(MappedPOI_.geoHash2).in(mappedPOIFilter.getGeoHash2()));
    }

    if (mappedPOIFilter.getY() != null && !mappedPOIFilter.getY().isEmpty()) {
      preds.add(r.get(MappedPOI_.y).in(mappedPOIFilter.getY()));
    }

    if (mappedPOIFilter.getGeoHash11() != null && !mappedPOIFilter.getGeoHash11().isEmpty()) {
      preds.add(r.get(MappedPOI_.geoHash11).in(mappedPOIFilter.getGeoHash11()));
    }

    if (mappedPOIFilter.getGeoHash4() != null && !mappedPOIFilter.getGeoHash4().isEmpty()) {
      preds.add(r.get(MappedPOI_.geoHash4).in(mappedPOIFilter.getGeoHash4()));
    }

    if (mappedPOIFilter.getGeoHash1() != null && !mappedPOIFilter.getGeoHash1().isEmpty()) {
      preds.add(r.get(MappedPOI_.geoHash1).in(mappedPOIFilter.getGeoHash1()));
    }

    if (mappedPOIFilter.getGeoHash3() != null && !mappedPOIFilter.getGeoHash3().isEmpty()) {
      preds.add(r.get(MappedPOI_.geoHash3).in(mappedPOIFilter.getGeoHash3()));
    }

    if (mappedPOIFilter.getMapIcon() != null && !mappedPOIFilter.getMapIcon().isEmpty()) {
      Set<String> ids =
          mappedPOIFilter.getMapIcon().parallelStream()
              .map(f -> f.getId())
              .collect(Collectors.toSet());
      Join<T, MapIcon> join = r.join(MappedPOI_.mapIcon);
      preds.add(join.get(MapIcon_.id).in(ids));
    }

    if (mappedPOIFilter.getGeoHash9() != null && !mappedPOIFilter.getGeoHash9().isEmpty()) {
      preds.add(r.get(MappedPOI_.geoHash9).in(mappedPOIFilter.getGeoHash9()));
    }

    if (mappedPOIFilter.getX() != null && !mappedPOIFilter.getX().isEmpty()) {
      preds.add(r.get(MappedPOI_.x).in(mappedPOIFilter.getX()));
    }

    if (mappedPOIFilter.getKeepStatusHistory() != null
        && !mappedPOIFilter.getKeepStatusHistory().isEmpty()) {
      preds.add(r.get(MappedPOI_.keepStatusHistory).in(mappedPOIFilter.getKeepStatusHistory()));
    }

    if (mappedPOIFilter.getAddress() != null && !mappedPOIFilter.getAddress().isEmpty()) {
      Set<String> ids =
          mappedPOIFilter.getAddress().parallelStream()
              .map(f -> f.getId())
              .collect(Collectors.toSet());
      Join<T, Address> join = r.join(MappedPOI_.address);
      preds.add(join.get(Address_.id).in(ids));
    }

    if (mappedPOIFilter.getLon() != null && !mappedPOIFilter.getLon().isEmpty()) {
      preds.add(r.get(MappedPOI_.lon).in(mappedPOIFilter.getLon()));
    }

    if (mappedPOIFilter.getGeoHash5() != null && !mappedPOIFilter.getGeoHash5().isEmpty()) {
      preds.add(r.get(MappedPOI_.geoHash5).in(mappedPOIFilter.getGeoHash5()));
    }
  }
  /**
   * @param mappedPOIFilter Object Used to List MappedPOI
   * @param securityContext
   * @return count of MappedPOI
   */
  public Long countAllMappedPOIs(
      MappedPOIFilter mappedPOIFilter, SecurityContextBase securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Long> q = cb.createQuery(Long.class);
    Root<MappedPOI> r = q.from(MappedPOI.class);
    List<Predicate> preds = new ArrayList<>();
    addMappedPOIPredicate(mappedPOIFilter, cb, q, r, preds, securityContext);
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
