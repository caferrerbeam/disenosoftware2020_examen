package co.edu.eam.disenosoftware.biblioteca.controllers;

import co.edu.eam.disenosoftware.biblioteca.model.entities.Borrow;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class UsersControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  @Sql({"/testdata/getBorrowsByUserIdTest.sql"})
  public void getBorrowsByUserIdTest() throws Exception {

    RequestBuilder request = get("/api/users/1/borrows");

    ResultActions result = mockMvc.perform(request);
    result.andExpect(MockMvcResultMatchers.status().isOk());

    MvcResult response = result.andReturn();

    String json = response.getResponse().getContentAsString();
    System.out.println(json);

    Borrow[] borrows = objectMapper.readValue(json, Borrow[].class);

    Assertions.assertEquals(2, borrows.length);
  }

}
