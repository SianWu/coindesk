package com.cathaybk.coindesk.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
class CoinDeskControllerTest {

  @Autowired private WebApplicationContext webApplicationContext;
  @Autowired MockMvc mvc;

  @BeforeEach
  void setUp() {}

  @Test
  void getOriginData() throws Exception {
    String uri = "/coindesk";
    MockHttpServletRequestBuilder accept = MockMvcRequestBuilders.get(uri);
    MvcResult result = mvc.perform(accept).andReturn();
    int status = result.getResponse().getStatus();
    System.out.println(status);
    assertEquals(200, status);
  }

  @Test
  void find() throws Exception {
    String uri = "/coindesk/find/USD";
    MockHttpServletRequestBuilder accept =
        MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
    MvcResult result = mvc.perform(accept).andReturn();
    int status = result.getResponse().getStatus();
    System.out.println(status);
    assertEquals(200, status);
  }

  @Test
  void findAll() throws Exception {
    String uri = "/coindesk/findall";
    MockHttpServletRequestBuilder accept =
        MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
    MvcResult result = mvc.perform(accept).andReturn();
    int status = result.getResponse().getStatus();
    System.out.println(status);
    assertEquals(200, status);
  }

  @Test
  void save() throws Exception {
    String uri = "/coindesk/add";
    MockHttpServletRequestBuilder accept =
        MockMvcRequestBuilders.post(uri)
            .content(
                "{\n"
                    + "    \"currency\": \"TWD\",\n"
                    + "    \"currencyName\": \"台幣\",\n"
                    + "    \"disclaimer\": \"This data was produced from the CoinDesk Bitcoin Price Index (TWD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org\",\n"
                    + "    \"chartName\": \"Bitcoin\",\n"
                    + "    \"updatedISO\": \"2021-06-08T07:05:00\",\n"
                    + "    \"updated\": \"2021-06-08T07:05:00\",\n"
                    + "    \"updateduk\": \"2021-06-08T08:05:00\",\n"
                    + "    \"code\": \"TWD\",\n"
                    + "    \"symbol\": \"&euro;\",\n"
                    + "    \"rate\": \"920,264.77\",\n"
                    + "    \"description\": \"taiwan\",\n"
                    + "    \"rate_float\": 920264.77\n"
                    + "}")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);
    MvcResult result = mvc.perform(accept).andReturn();
    int status = result.getResponse().getStatus();
    System.out.println(status);
    assertEquals(200, status);
  }

  @Test
  void update() throws Exception {
    String uri = "/coindesk/update/USD";
    MockHttpServletRequestBuilder accept =
        MockMvcRequestBuilders.put(uri)
            .content(
                "{\n"
                    + "    \"currencyName\": \"台幣\",\n"
                    + "    \"updated\": \"2021-06-08T07:05:00\",\n"
                    + "    \"rate\": \"920,264.77\",\n"
                    + "    \"rate_float\": 920264.77\n"
                    + "}")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON);
    MvcResult result = mvc.perform(accept).andReturn();
    int status = result.getResponse().getStatus();
    System.out.println(status);
    assertEquals(200, status);
  }

  @Test
  void remove() throws Exception {
    String uri = "/coindesk/remove/TWD";
    MockHttpServletRequestBuilder accept =
        MockMvcRequestBuilders.delete(uri).accept(MediaType.APPLICATION_JSON);
    MvcResult result = mvc.perform(accept).andReturn();
    int status = result.getResponse().getStatus();
    System.out.println(status);
    assertEquals(200, status);
  }
}
