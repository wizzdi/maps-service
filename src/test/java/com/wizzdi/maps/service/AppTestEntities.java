package com.wizzdi.maps.service;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Baselink;
import com.flexicore.model.Basic;
import com.flexicore.model.Clazz;
import com.flexicore.model.ClazzLink;
import com.flexicore.model.OperationCategory;
import com.flexicore.model.OperationToClazz;
import com.flexicore.model.PermissionGroup;
import com.flexicore.model.PermissionGroupToBaseclass;
import com.flexicore.model.Role;
import com.flexicore.model.RoleToBaseclass;
import com.flexicore.model.RoleToUser;
import com.flexicore.model.SecuredBasic;
import com.flexicore.model.SecurityEntity;
import com.flexicore.model.SecurityLink;
import com.flexicore.model.SecurityOperation;
import com.flexicore.model.SecurityTenant;
import com.flexicore.model.SecurityUser;
import com.flexicore.model.SecurityWildcard;
import com.flexicore.model.TenantToBaseClassPremission;
import com.flexicore.model.TenantToUser;
import com.flexicore.model.UserToBaseClass;
import com.flexicore.model.security.SecurityPolicy;
import com.flexicore.model.territories.Address;
import com.flexicore.model.territories.City;
import com.flexicore.model.territories.Country;
import com.flexicore.model.territories.Neighbourhood;
import com.flexicore.model.territories.State;
import com.flexicore.model.territories.Street;
import com.wizzdi.dynamic.properties.converter.JsonConverter;
import com.wizzdi.flexicore.boot.jpa.service.EntitiesHolder;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.file.model.ZipFile;
import com.wizzdi.flexicore.file.model.ZipFileToFileResource;
import com.wizzdi.maps.model.Building;
import com.wizzdi.maps.model.LocationHistory;
import com.wizzdi.maps.model.MapGroup;
import com.wizzdi.maps.model.MapGroupToMappedPOI;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.model.Room;
import com.wizzdi.maps.model.StatusHistory;
import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppTestEntities {

  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
  public EntitiesHolder manualEntityHolder() {
    return new EntitiesHolder(
        new HashSet<>(
            Arrays.asList(
                MappedPOI.class,
                PermissionGroup.class,
                Baselink.class,
                Neighbourhood.class,
                City.class,
                Street.class,
                State.class,
                Address.class,
                Country.class,
                SecurityEntity.class,
                Baseclass.class,
                SecurityTenant.class,
                Clazz.class,
                SecurityWildcard.class,
                Basic.class,
                SecurityWildcard.class,
                SecurityEntity.class,
                SecuredBasic.class,
                UserToBaseClass.class,
                RoleToUser.class,
                SecurityOperation.class,
                OperationCategory.class,
                ClazzLink.class,
                RoleToBaseclass.class,
                TenantToBaseClassPremission.class,
                SecurityUser.class,
                Role.class,
                SecurityPolicy.class,
                TenantToUser.class,
                PermissionGroupToBaseclass.class,
                OperationToClazz.class,
                SecurityLink.class,
                Role.class,
                Clazz.class,
                Basic.class,
                SecurityUser.class,
                SecurityPolicy.class,
                PermissionGroupToBaseclass.class,
                PermissionGroup.class,
                RoleToUser.class,
                TenantToUser.class,
                RoleToBaseclass.class,
                Baselink.class,
                Baseclass.class,
                TenantToBaseClassPremission.class,
                SecuredBasic.class,
                OperationToClazz.class,
                SecurityTenant.class,
                FileResource.class,
                ZipFile.class,
                ZipFileToFileResource.class,
                Room.class,
                MapGroup.class,
                MapIcon.class,
                Building.class,
                MapGroupToMappedPOI.class,
                StatusHistory.class,
                LocationHistory.class,
                FileResource.class,
                JsonConverter.class,
                SecuredBasic.class)));
  }
}
