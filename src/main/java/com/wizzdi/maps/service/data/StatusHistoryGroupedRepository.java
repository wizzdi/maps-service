package com.wizzdi.maps.service.data;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.data.BasicRepository;
import com.wizzdi.flexicore.security.data.SecuredBasicRepository;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.model.StatusHistory;
import com.wizzdi.maps.model.StatusHistory_;
import com.wizzdi.maps.service.request.StatusHistoryFilter;
import com.wizzdi.maps.service.request.StatusHistoryGroupedRequest;
import com.wizzdi.maps.service.response.MappedPOIAndDate;
import com.wizzdi.maps.service.response.StatusHistoryGroupedEntry;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Extension
@Component
public class StatusHistoryGroupedRepository implements Plugin {
  @PersistenceContext private EntityManager em;


  /**
   * @param statusHistoryGroupedRequest Object Used to List StatusHistory
   * @param securityContext
   * @return List of StatusHistory
   */
  public List<StatusHistoryGroupedEntry> listAllStatusHistoriesGrouped(
          StatusHistoryGroupedRequest statusHistoryGroupedRequest, SecurityContextBase securityContext) {
    Query nativeQuery = em.createNativeQuery("select latest.mappedPOIIcon_id,count(latest.id) from (" +
            "select h.* from StatusHistory as h inner join (" +
            "select max(dateAtStatus) as maxDateAtStatus,mappedPOI_id where dateAtStatus =< ?1 group by mappedPOI_id " +
            ") groupedStatus on h.dateAtStatus=groupedStatus.maxDateAtStatus and h.mappedPOI_id=groupedStatus.mappedPOI_id" +
            ") as latest group by  latest.mappedPOIIcon_id", StatusHistoryGroupedEntry.class);
    nativeQuery.setParameter(1,statusHistoryGroupedRequest.getStatusAtDate());
    return (List<StatusHistoryGroupedEntry>)nativeQuery.getResultList();

  }

}
