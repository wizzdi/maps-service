package com.wizzdi.maps.service.controller;

import com.flexicore.request.AuthenticationRequest;
import com.flexicore.response.AuthenticationResponse;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.model.MappedPOI;
import com.wizzdi.maps.model.Room;
import com.wizzdi.maps.service.App;
import com.wizzdi.maps.service.request.MappedPOICreate;
import com.wizzdi.maps.service.request.MappedPOIFilter;
import com.wizzdi.maps.service.request.MappedPOIUpdate;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = App.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
public class MappedPOIControllerTest {

  private MappedPOI testMappedPOI;
  @Autowired private TestRestTemplate restTemplate;

  @Autowired private Room room;

  @Autowired private MapIcon mapIcon;

  @BeforeAll
  private void init() {
    ResponseEntity<AuthenticationResponse> authenticationResponse =
        this.restTemplate.postForEntity(
            "/FlexiCore/rest/authenticationNew/login",
            new AuthenticationRequest().setEmail("admin@flexicore.com").setPassword("admin"),
            AuthenticationResponse.class);
    String authenticationKey = authenticationResponse.getBody().getAuthenticationKey();
    restTemplate
        .getRestTemplate()
        .setInterceptors(
            Collections.singletonList(
                (request, body, execution) -> {
                  request.getHeaders().add("authenticationKey", authenticationKey);
                  return execution.execute(request, body);
                }));
  }

  @Test
  @Order(1)
  public void testMappedPOICreate() {
    String name = UUID.randomUUID().toString();
    MappedPOICreate request = new MappedPOICreate().setName(name);

    request.setGeoHash7("test-string");

    request.setExternalId("test-string");

    request.setGeoHash10("test-string");

    request.setGeoHash2("test-string");

    request.setRelatedId("test-string");

    request.setY(10D);

    request.setGeoHash11("test-string");

    request.setGeoHash4("test-string");

    request.setGeoHash6("test-string");

    request.setGeoHash8("test-string");

    request.setZ(10D);

    request.setGeoHash1("test-string");

    request.setGeoHash3("test-string");

    request.setMapIconId(this.mapIcon.getId());

    request.setGeoHash9("test-string");

    request.setRoomId(this.room.getId());

    request.setLat(10D);

    request.setX(10D);

    request.setKeepHistory(true);

    request.setGeoHash12("test-string");

    request.setLon(10D);

    request.setRelatedType("test-string");

    request.setGeoHash5("test-string");

    ResponseEntity<MappedPOI> response =
        this.restTemplate.postForEntity("/MappedPOI/createMappedPOI", request, MappedPOI.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testMappedPOI = response.getBody();
    assertMappedPOI(request, testMappedPOI);
  }

  @Test
  @Order(2)
  public void testListAllMappedPOIs() {
    MappedPOIFilter request = new MappedPOIFilter();
    ParameterizedTypeReference<PaginationResponse<MappedPOI>> t =
        new ParameterizedTypeReference<>() {};

    ResponseEntity<PaginationResponse<MappedPOI>> response =
        this.restTemplate.exchange(
            "/MappedPOI/getAllMappedPOIs", HttpMethod.POST, new HttpEntity<>(request), t);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    PaginationResponse<MappedPOI> body = response.getBody();
    Assertions.assertNotNull(body);
    List<MappedPOI> MappedPOIs = body.getList();
    Assertions.assertNotEquals(0, MappedPOIs.size());
    Assertions.assertTrue(
        MappedPOIs.stream().anyMatch(f -> f.getId().equals(testMappedPOI.getId())));
  }

  public void assertMappedPOI(MappedPOICreate request, MappedPOI testMappedPOI) {
    Assertions.assertNotNull(testMappedPOI);

    if (request.getGeoHash7() != null) {
      Assertions.assertEquals(request.getGeoHash7(), testMappedPOI.getGeoHash7());
    }

    if (request.getExternalId() != null) {
      Assertions.assertEquals(request.getExternalId(), testMappedPOI.getExternalId());
    }

    if (request.getGeoHash10() != null) {
      Assertions.assertEquals(request.getGeoHash10(), testMappedPOI.getGeoHash10());
    }

    if (request.getGeoHash2() != null) {
      Assertions.assertEquals(request.getGeoHash2(), testMappedPOI.getGeoHash2());
    }

    if (request.getRelatedId() != null) {
      Assertions.assertEquals(request.getRelatedId(), testMappedPOI.getRelatedId());
    }

    if (request.getY() != null) {
      Assertions.assertEquals(request.getY(), testMappedPOI.getY());
    }

    if (request.getGeoHash11() != null) {
      Assertions.assertEquals(request.getGeoHash11(), testMappedPOI.getGeoHash11());
    }

    if (request.getGeoHash4() != null) {
      Assertions.assertEquals(request.getGeoHash4(), testMappedPOI.getGeoHash4());
    }

    if (request.getGeoHash6() != null) {
      Assertions.assertEquals(request.getGeoHash6(), testMappedPOI.getGeoHash6());
    }

    if (request.getGeoHash8() != null) {
      Assertions.assertEquals(request.getGeoHash8(), testMappedPOI.getGeoHash8());
    }

    if (request.getZ() != null) {
      Assertions.assertEquals(request.getZ(), testMappedPOI.getZ());
    }

    if (request.getGeoHash1() != null) {
      Assertions.assertEquals(request.getGeoHash1(), testMappedPOI.getGeoHash1());
    }

    if (request.getGeoHash3() != null) {
      Assertions.assertEquals(request.getGeoHash3(), testMappedPOI.getGeoHash3());
    }

    if (request.getMapIconId() != null) {

      Assertions.assertNotNull(testMappedPOI.getMapIcon());
      Assertions.assertEquals(request.getMapIconId(), testMappedPOI.getMapIcon().getId());
    }

    if (request.getGeoHash9() != null) {
      Assertions.assertEquals(request.getGeoHash9(), testMappedPOI.getGeoHash9());
    }

    if (request.getRoomId() != null) {

      Assertions.assertNotNull(testMappedPOI.getRoom());
      Assertions.assertEquals(request.getRoomId(), testMappedPOI.getRoom().getId());
    }

    if (request.getLat() != null) {
      Assertions.assertEquals(request.getLat(), testMappedPOI.getLat());
    }

    if (request.getX() != null) {
      Assertions.assertEquals(request.getX(), testMappedPOI.getX());
    }

    if (request.getKeepHistory() != null) {
      Assertions.assertEquals(request.getKeepHistory(), testMappedPOI.isKeepHistory());
    }

    if (request.getGeoHash12() != null) {
      Assertions.assertEquals(request.getGeoHash12(), testMappedPOI.getGeoHash12());
    }

    if (request.getLon() != null) {
      Assertions.assertEquals(request.getLon(), testMappedPOI.getLon());
    }

    if (request.getRelatedType() != null) {
      Assertions.assertEquals(request.getRelatedType(), testMappedPOI.getRelatedType());
    }

    if (request.getGeoHash5() != null) {
      Assertions.assertEquals(request.getGeoHash5(), testMappedPOI.getGeoHash5());
    }
  }

  @Test
  @Order(3)
  public void testMappedPOIUpdate() {
    String name = UUID.randomUUID().toString();
    MappedPOIUpdate request = new MappedPOIUpdate().setId(testMappedPOI.getId()).setName(name);
    ResponseEntity<MappedPOI> response =
        this.restTemplate.exchange(
            "/MappedPOI/updateMappedPOI",
            HttpMethod.PUT,
            new HttpEntity<>(request),
            MappedPOI.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testMappedPOI = response.getBody();
    assertMappedPOI(request, testMappedPOI);
  }
}
