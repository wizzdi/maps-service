package com.wizzdi.maps.service.service;

import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.events.BasicCreated;
import com.wizzdi.flexicore.security.events.BasicUpdated;
import com.wizzdi.flexicore.security.interfaces.SecurityContextProvider;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.model.StatusHistory;
import com.wizzdi.maps.service.request.LocationHistoryCreate;
import com.wizzdi.maps.service.request.StatusHistoryCreate;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.time.OffsetDateTime;

@Component
@Extension
public class StatusHistoryCreator implements Plugin {
    @Autowired
    @Lazy
    private SecurityContextProvider securityContextProvider;
    @Autowired
    private StatusHistoryService statusHistoryService;


    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT )
    public void onMappedPOICreated(BasicCreated<MappedPOI> mappedPoiCreated){
        MappedPOI mappedPOI = mappedPoiCreated.getBaseclass();
        if(mappedPOI.isKeepStatusHistory()){

            createStatusHistory(mappedPOI);
        }
    }

    private StatusHistory createStatusHistory(MappedPOI mappedPOI) {
        SecurityContextBase securityContext = securityContextProvider.getSecurityContext(mappedPOI.getSecurity().getCreator());
        securityContext.setTenantToCreateIn(mappedPOI.getSecurity().getTenant());
        OffsetDateTime now = OffsetDateTime.now();
        String name = mappedPOI.getName() + " status change to " + (mappedPOI.getMapIcon()!=null?mappedPOI.getMapIcon().getName():"null") + " at " + now;
        StatusHistoryCreate statusHistoryCreate = new StatusHistoryCreate()
                .setMappedPOI(mappedPOI)
                .setMapIcon(mappedPOI.getMapIcon())
                .setDateAtStatus(now)
                .setName(name) ;
        return statusHistoryService.createStatusHistory(statusHistoryCreate,securityContext);

    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT )
    public void onMappedPOIUpdated(BasicUpdated<MappedPOI> mappedPOIBasicUpdated){
        MappedPOI mappedPOI = mappedPOIBasicUpdated.getBaseclass();
        if(mappedPOI.isKeepStatusHistory()){
            createStatusHistory(mappedPOI);
        }
    }
}
