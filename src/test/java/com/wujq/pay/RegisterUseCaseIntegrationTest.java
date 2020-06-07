package com.wujq.pay;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.wujq.pay.employee.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RegisterUseCaseIntegrationTest {

  public static MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);
  private Gson gson = new Gson();

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private EmployeeController userRepository;

  @Test
  void getAllEmployees() throws Exception {
//    Employee user = new Employee("Zaphod", "zaphod@galaxy.net");
//    insert into employee (id, name, last_name, age, pesel, employee_role)
//    values(2,'Rob', 'Robovsky', 33, 66666666666, 'WORKER');

//    insert into address (id, employee_id, address_type, city, home_number, province, street, zip )
//    values(1, 1, 'HOME', 'Wroclaw', 21, 'dolnoslaskie', 'Armii Krajowej', '50-550');

    MvcResult result = mockMvc.perform(get("/employees")
            .contentType("application/json"))
            .andExpect(status().isOk())
            .andReturn();
    System.out.println("ok");
  }

  @Test
  void checkAgeValidation() throws Exception {
    Address address = new Address();
    address.setAddressType(AddressType.HOME);
    address.setHomeNumber(10);
    address.setStreet("Street");
    address.setCity("Wroclaw");
    address.setProvince("dolnoslaskie");
    address.setZip("50-140");
    address.setCountry("Poland");
    Employee employee = new Employee(null, "Liam", "Fury", 17, "123456789", Collections.emptyList(), EmployeeRole.CEO);
//    address.setEmployee(employee);
//    insert into address (id, employee_id, address_type, city, home_number, province, street, zip )
//    values(1, 1, 'HOME', 'Wroclaw', 21, 'dolnoslaskie', 'Armii Krajowej', '50-550');

    MvcResult result =  mockMvc.perform(post("/employees")
            .content(gson.toJson(employee))
            .contentType(APPLICATION_JSON_VALUE))
            .andExpect(status().isBadRequest())
            .andReturn();
    System.out.println("ok");
  }

}
