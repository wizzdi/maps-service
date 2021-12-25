package com.wizzdi.maps.model.service;

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
import com.flexicore.organization.model.Branch;
import com.flexicore.organization.model.Consumer;
import com.flexicore.organization.model.ConsumerToOrganization;
import com.flexicore.organization.model.Customer;
import com.flexicore.organization.model.CustomerDocument;
import com.flexicore.organization.model.Employee;
import com.flexicore.organization.model.IndividualCustomer;
import com.flexicore.organization.model.Industry;
import com.flexicore.organization.model.IndustryToCustomer;
import com.flexicore.organization.model.Organization;
import com.flexicore.organization.model.OrganizationalCustomer;
import com.flexicore.organization.model.SalesPerson;
import com.flexicore.organization.model.SalesPersonToRegion;
import com.flexicore.organization.model.SalesRegion;
import com.flexicore.organization.model.Site;
import com.flexicore.organization.model.Supplier;
import com.flexicore.organization.model.SupplierApi;
import com.viewpark.pricing.model.Currency;
import com.viewpark.pricing.model.OccasionalPrice;
import com.viewpark.pricing.model.OccasionalPriceItem;
import com.viewpark.pricing.model.ParkingLotToPriceList;
import com.viewpark.pricing.model.Price;
import com.viewpark.pricing.model.PriceList;
import com.viewpark.pricing.model.PriceListType;
import com.viewpark.pricing.model.SubscriptionPrice;
import com.viewpark.pricing.model.Voucher;
import com.viewpark.pricing.model.VoucherType;
import com.viewpark.pricing.model.VoucherTypeToOccasionalPrice;
import com.viewpark.subscriptions.model.Car;
import com.viewpark.subscriptions.model.ParkingUser;
import com.viewpark.subscriptions.model.Subscription;
import com.viewpark.subscriptions.model.SubscriptionItem;
import com.viewpark.subscriptions.model.SubscriptionToCar;
import com.viewpark.subscriptions.model.SubscriptionToParkingArea;
import com.viewpark.subscriptions.model.SubscriptionToParkingLot;
import com.viewpark.subscriptions.model.SubscriptionToParkingSpace;
import com.wizzdi.dynamic.properties.converter.JsonConverter;
import com.wizzdi.flexicore.boot.jpa.service.EntitiesHolder;
import com.wizzdi.flexicore.file.model.FileResource;
import com.wizzdi.flexicore.file.model.ZipFile;
import com.wizzdi.flexicore.file.model.ZipFileToFileResource;
import com.wizzdi.maps.model.MappedPOI;
import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import parking.gear.model.Building;
import parking.gear.model.BuildingFloor;
import parking.gear.model.Camera;
import parking.gear.model.Gate;
import parking.gear.model.LPREngine;
import parking.gear.model.Lane;
import parking.gear.model.ParkingArea;
import parking.gear.model.ParkingLot;
import parking.gear.model.ParkingSpace;
import parking.gear.model.ParkingSpaceState;
import parking.gear.model.ParkingSpaceToParkingSpaceState;

@Configuration
public class AppTestEntities {

  @Bean
  @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
  public EntitiesHolder manualEntityHolder() {
    return new EntitiesHolder(
        new HashSet<>(
            Arrays.asList(
                Building.class,
                IndustryToCustomer.class,
                Neighbourhood.class,
                OrganizationalCustomer.class,
                Street.class,
                Site.class,
                SalesRegion.class,
                Consumer.class,
                SalesPersonToRegion.class,
                SalesPerson.class,
                State.class,
                City.class,
                CustomerDocument.class,
                Branch.class,
                SupplierApi.class,
                Organization.class,
                IndividualCustomer.class,
                Employee.class,
                Supplier.class,
                Customer.class,
                Industry.class,
                ConsumerToOrganization.class,
                Address.class,
                ParkingSpace.class,
                ParkingArea.class,
                ParkingLot.class,
                MappedPOI.class,
                Lane.class,
                Camera.class,
                Country.class,
                BuildingFloor.class,
                Gate.class,
                Currency.class,
                ParkingSpaceToParkingSpaceState.class,
                ParkingSpaceState.class,
                PriceListType.class,
                PriceList.class,
                Baseclass.class,
                ParkingLotToPriceList.class,
                SubscriptionPrice.class,
                Price.class,
                OccasionalPrice.class,
                Subscription.class,
                Voucher.class,
                VoucherTypeToOccasionalPrice.class,
                VoucherType.class,
                OccasionalPriceItem.class,
                SubscriptionItem.class,
                LPREngine.class,
                ParkingUser.class,
                Car.class,
                SubscriptionToParkingArea.class,
                SubscriptionToCar.class,
                SubscriptionToParkingSpace.class,
                SubscriptionToParkingLot.class,
                OperationToClazz.class,
                SecurityTenant.class,
                PermissionGroup.class,
                UserToBaseClass.class,
                FileResource.class,
                ZipFile.class,
                SecurityWildcard.class,
                PermissionGroupToBaseclass.class,
                SecurityOperation.class,
                Baselink.class,
                OperationCategory.class,
                TenantToUser.class,
                RoleToBaseclass.class,
                SecurityUser.class,
                RoleToUser.class,
                Clazz.class,
                Role.class,
                SecurityEntity.class,
                ZipFileToFileResource.class,
                SecurityLink.class,
                TenantToBaseClassPremission.class,
                SecurityPolicy.class,
                ClazzLink.class,
                SecuredBasic.class,
                Basic.class,
                FileResource.class,
                JsonConverter.class,
                SecuredBasic.class)));
  }
}
