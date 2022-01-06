package com.wizzdi.maps.service.service;

import com.flexicore.model.Baseclass;
import com.flexicore.model.Basic;
import com.flexicore.model.SecuredBasic_;
import com.flexicore.security.SecurityContextBase;
import com.wizzdi.flexicore.boot.base.interfaces.Plugin;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.flexicore.security.service.BaseclassService;
import com.wizzdi.flexicore.security.service.BasicService;
import com.wizzdi.maps.model.Building;
import com.wizzdi.maps.model.Room;
import com.wizzdi.maps.service.data.RoomRepository;
import com.wizzdi.maps.service.request.RoomCreate;
import com.wizzdi.maps.service.request.RoomFilter;
import com.wizzdi.maps.service.request.RoomUpdate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.persistence.metamodel.SingularAttribute;
import org.pf4j.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
@Extension
public class RoomService implements Plugin, IRoomService {

  @Autowired private RoomRepository repository;

  @Autowired private BasicService basicService;

  /**
   * @param roomCreate Object Used to Create Room
   * @param securityContext
   * @return created Room
   */
  @Override
  public Room createRoom(RoomCreate roomCreate, SecurityContextBase securityContext) {
    Room room = createRoomNoMerge(roomCreate, securityContext);
    this.repository.merge(room);
    return room;
  }

  /**
   * @param roomCreate Object Used to Create Room
   * @param securityContext
   * @return created Room unmerged
   */
  @Override
  public Room createRoomNoMerge(RoomCreate roomCreate, SecurityContextBase securityContext) {
    Room room = new Room();
    room.setId(UUID.randomUUID().toString());
    updateRoomNoMerge(room, roomCreate);

    BaseclassService.createSecurityObjectNoMerge(room, securityContext);

    return room;
  }

  /**
   * @param roomCreate Object Used to Create Room
   * @param room
   * @return if room was updated
   */
  @Override
  public boolean updateRoomNoMerge(Room room, RoomCreate roomCreate) {
    boolean update = basicService.updateBasicNoMerge(roomCreate, room);

    if (roomCreate.getBuilding() != null
        && (room.getBuilding() == null
            || !roomCreate.getBuilding().getId().equals(room.getBuilding().getId()))) {
      room.setBuilding(roomCreate.getBuilding());
      update = true;
    }

    if (roomCreate.getX() != null && (!roomCreate.getX().equals(room.getX()))) {
      room.setX(roomCreate.getX());
      update = true;
    }

    if (roomCreate.getY() != null && (!roomCreate.getY().equals(room.getY()))) {
      room.setY(roomCreate.getY());
      update = true;
    }

    if (roomCreate.getZ() != null && (!roomCreate.getZ().equals(room.getZ()))) {
      room.setZ(roomCreate.getZ());
      update = true;
    }

    return update;
  }
  /**
   * @param roomUpdate
   * @param securityContext
   * @return room
   */
  @Override
  public Room updateRoom(RoomUpdate roomUpdate, SecurityContextBase securityContext) {
    Room room = roomUpdate.getRoom();
    if (updateRoomNoMerge(room, roomUpdate)) {
      this.repository.merge(room);
    }
    return room;
  }

  /**
   * @param roomFilter Object Used to List Room
   * @param securityContext
   * @return PaginationResponse containing paging information for Room
   */
  @Override
  public PaginationResponse<Room> getAllRooms(
      RoomFilter roomFilter, SecurityContextBase securityContext) {
    List<Room> list = listAllRooms(roomFilter, securityContext);
    long count = this.repository.countAllRooms(roomFilter, securityContext);
    return new PaginationResponse<>(list, roomFilter, count);
  }

  /**
   * @param roomFilter Object Used to List Room
   * @param securityContext
   * @return List of Room
   */
  @Override
  public List<Room> listAllRooms(RoomFilter roomFilter, SecurityContextBase securityContext) {
    return this.repository.listAllRooms(roomFilter, securityContext);
  }

  /**
   * @param roomFilter Object Used to List Room
   * @param securityContext
   * @throws ResponseStatusException if roomFilter is not valid
   */
  @Override
  public void validate(RoomFilter roomFilter, SecurityContextBase securityContext) {
    basicService.validate(roomFilter, securityContext);

    Set<String> buildingIds =
        roomFilter.getBuildingIds() == null ? new HashSet<>() : roomFilter.getBuildingIds();
    Map<String, Building> building =
        buildingIds.isEmpty()
            ? new HashMap<>()
            : this.repository
                .listByIds(Building.class, buildingIds, SecuredBasic_.security, securityContext)
                .parallelStream()
                .collect(Collectors.toMap(f -> f.getId(), f -> f));
    buildingIds.removeAll(building.keySet());
    if (!buildingIds.isEmpty()) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "No Building with ids " + buildingIds);
    }
    roomFilter.setBuilding(new ArrayList<>(building.values()));
  }

  /**
   * @param roomCreate Object Used to Create Room
   * @param securityContext
   * @throws ResponseStatusException if roomCreate is not valid
   */
  @Override
  public void validate(RoomCreate roomCreate, SecurityContextBase securityContext) {
    basicService.validate(roomCreate, securityContext);

    String buildingId = roomCreate.getBuildingId();
    Building building =
        buildingId == null
            ? null
            : this.repository.getByIdOrNull(
                buildingId, Building.class, SecuredBasic_.security, securityContext);
    if (buildingId != null && building == null) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "No Building with id " + buildingId);
    }
    roomCreate.setBuilding(building);
  }

  @Override
  public <T extends Baseclass> List<T> listByIds(
      Class<T> c, Set<String> ids, SecurityContextBase securityContext) {
    return this.repository.listByIds(c, ids, securityContext);
  }

  @Override
  public <T extends Baseclass> T getByIdOrNull(
      String id, Class<T> c, SecurityContextBase securityContext) {
    return this.repository.getByIdOrNull(id, c, securityContext);
  }

  @Override
  public <D extends Basic, E extends Baseclass, T extends D> T getByIdOrNull(
      String id,
      Class<T> c,
      SingularAttribute<D, E> baseclassAttribute,
      SecurityContextBase securityContext) {
    return this.repository.getByIdOrNull(id, c, baseclassAttribute, securityContext);
  }

  @Override
  public <D extends Basic, E extends Baseclass, T extends D> List<T> listByIds(
      Class<T> c,
      Set<String> ids,
      SingularAttribute<D, E> baseclassAttribute,
      SecurityContextBase securityContext) {
    return this.repository.listByIds(c, ids, baseclassAttribute, securityContext);
  }

  @Override
  public <D extends Basic, T extends D> List<T> findByIds(
      Class<T> c, Set<String> ids, SingularAttribute<D, String> idAttribute) {
    return this.repository.findByIds(c, ids, idAttribute);
  }

  @Override
  public <T extends Basic> List<T> findByIds(Class<T> c, Set<String> requested) {
    return this.repository.findByIds(c, requested);
  }

  @Override
  public <T> T findByIdOrNull(Class<T> type, String id) {
    return this.repository.findByIdOrNull(type, id);
  }

  @Override
  public void merge(java.lang.Object base) {
    this.repository.merge(base);
  }

  @Override
  public void massMerge(List<?> toMerge) {
    this.repository.massMerge(toMerge);
  }
}