package com.wizzdi.maps.model.service.data;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.model.Basic_;
import com.flexicore.model.territories.Address;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.security.data.BasicRepository;
import com.wizzdi.flexicore.security.data.SecuredBasicRepository;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.model.MappedPOI_;
import com.wizzdi.maps.model.service.request.MappedPOIFilter;
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
public class MappedPOIRepository implements Plugin, IMappedPOIRepository {
  @PersistenceContext private EntityManager em;
  @Autowired private SecuredBasicRepository securedBasicRepository;

  /**
   * @param filtering
   * @param securityContext
   * @return List of MappedPOI
   */
  @Override
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

  @Override
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

    if (filtering.getIcon() != null && !filtering.getIcon().isEmpty()) {
      Set<String> ids =
          filtering.getIcon().parallelStream().map(f -> f.getId()).collect(Collectors.toSet());
      Join<T, FileResource> join = r.join(MappedPOI_.icon);
      preds.add(join.get(Basic_.id).in(ids));
    }
  }
  /**
   * @param filtering
   * @param securityContext
   * @return count of MappedPOI
   */
  @Override
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

  @Override
  public <T extends Baseclass> List<T> listByIds(
      Class<T> c, Set<String> ids, SecurityContextBase securityContext) {
    return securedBasicRepository.listByIds(c, ids, securityContext);
  }

  @Override
  public <T extends Baseclass> T getByIdOrNull(
      String id, Class<T> c, SecurityContextBase securityContext) {
    return securedBasicRepository.getByIdOrNull(id, c, securityContext);
  }

  @Override
  public <D extends Basic, E extends Baseclass, T extends D> T getByIdOrNull(
      String id,
      Class<T> c,
      SingularAttribute<D, E> baseclassAttribute,
      SecurityContextBase securityContext) {
    return securedBasicRepository.getByIdOrNull(id, c, baseclassAttribute, securityContext);
  }

  @Override
  public <D extends Basic, E extends Baseclass, T extends D> List<T> listByIds(
      Class<T> c,
      Set<String> ids,
      SingularAttribute<D, E> baseclassAttribute,
      SecurityContextBase securityContext) {
    return securedBasicRepository.listByIds(c, ids, baseclassAttribute, securityContext);
  }

  @Override
  public <D extends Basic, T extends D> List<T> findByIds(
      Class<T> c, Set<String> ids, SingularAttribute<D, String> idAttribute) {
    return securedBasicRepository.findByIds(c, ids, idAttribute);
  }

  @Override
  public <T extends Basic> List<T> findByIds(Class<T> c, Set<String> requested) {
    return securedBasicRepository.findByIds(c, requested);
  }

  @Override
  public <T> T findByIdOrNull(Class<T> type, String id) {
    return securedBasicRepository.findByIdOrNull(type, id);
  }

  @Override
  @Transactional
  public void merge(Object base) {
    securedBasicRepository.merge(base);
  }

  @Override
  @Transactional
  public void massMerge(List<?> toMerge) {
    securedBasicRepository.massMerge(toMerge);
  }
}
