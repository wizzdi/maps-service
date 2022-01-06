package com.wizzdi.maps.service.controller;

import com.flexicore.request.AuthenticationRequest;
import com.flexicore.response.AuthenticationResponse;
import com.wizzdi.flexicore.security.response.PaginationResponse;
import com.wizzdi.maps.model.MapIcon;
import com.wizzdi.maps.service.App;
import com.wizzdi.maps.service.request.MapIconCreate;
import com.wizzdi.maps.service.request.MapIconFilter;
import com.wizzdi.maps.service.request.MapIconUpdate;
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
public class MapIconControllerTest {

  private MapIcon testMapIcon;
  @Autowired private TestRestTemplate restTemplate;

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
  public void testMapIconCreate() {
    String name = UUID.randomUUID().toString();
    MapIconCreate request = new MapIconCreate().setName(name);

    request.setExternalId("test-string");

    ResponseEntity<MapIcon> response =
        this.restTemplate.postForEntity("/MapIcon/createMapIcon", request, MapIcon.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testMapIcon = response.getBody();
    assertMapIcon(request, testMapIcon);
  }

  @Test
  @Order(2)
  public void testListAllMapIcons() {
    MapIconFilter request = new MapIconFilter();
    ParameterizedTypeReference<PaginationResponse<MapIcon>> t =
        new ParameterizedTypeReference<>() {};

    ResponseEntity<PaginationResponse<MapIcon>> response =
        this.restTemplate.exchange(
            "/MapIcon/getAllMapIcons", HttpMethod.POST, new HttpEntity<>(request), t);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    PaginationResponse<MapIcon> body = response.getBody();
    Assertions.assertNotNull(body);
    List<MapIcon> MapIcons = body.getList();
    Assertions.assertNotEquals(0, MapIcons.size());
    Assertions.assertTrue(MapIcons.stream().anyMatch(f -> f.getId().equals(testMapIcon.getId())));
  }

  public void assertMapIcon(MapIconCreate request, MapIcon testMapIcon) {
    Assertions.assertNotNull(testMapIcon);

    if (request.getExternalId() != null) {

      Assertions.assertEquals(request.getExternalId(), testMapIcon.getExternalId());
    }
  }

  @Test
  @Order(3)
  public void testMapIconUpdate() {
    String name = UUID.randomUUID().toString();
    MapIconUpdate request = new MapIconUpdate().setId(testMapIcon.getId()).setName(name);
    ResponseEntity<MapIcon> response =
        this.restTemplate.exchange(
            "/MapIcon/updateMapIcon", HttpMethod.PUT, new HttpEntity<>(request), MapIcon.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testMapIcon = response.getBody();
    assertMapIcon(request, testMapIcon);
  }
}
