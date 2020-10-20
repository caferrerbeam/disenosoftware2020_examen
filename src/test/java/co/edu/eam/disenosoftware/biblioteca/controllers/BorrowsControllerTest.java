package co.edu.eam.disenosoftware.biblioteca.controllers;

import co.edu.eam.disenosoftware.biblioteca.model.responses.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BorrowsControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  @Sql({"/testdata/borrowBookOkTest.sql"})
  public void testBorrowBookOk() throws Exception {
    String jsonBody = "{\"userId\":\"1\", \"bookCode\":\"1\"}";

    RequestBuilder request = post("/api/borrows")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);
    result.andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  @Sql({"/testdata/borrowRepeatedBookTest.sql"})
  public void borrowRepeatedBookTest() throws Exception {
    String jsonBody = "{\"userId\":\"1\", \"bookCode\":\"1\"}";

    RequestBuilder request = post("/api/borrows")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);
    verifyErrorResponse(result, 412, "0003");
  }

  @Test
  @Sql({"/testdata/borrowsMaximunBooksByUserIdTest.sql"})
  public void borrowsMaximunBooksByUserIdTest() throws Exception {
    String jsonBody = "{\"userId\":\"1\", \"bookCode\":\"4\"}";

    RequestBuilder request = post("/api/borrows")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);
    verifyErrorResponse(result, 412, "0004");

  }

  @Test
  @Sql({"/testdata/borrowNotFoundUserTest.sql"})
  public void borrowsNotFoundUserTest() throws Exception {
    String jsonBody = "{\"userId\":\"2\", \"bookCode\":\"1\"}";

    RequestBuilder request = post("/api/borrows")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);
    verifyErrorResponse(result, 404, "0001");
  }

  @Test
  @Sql({"/testdata/borrowNotFoundBookTest.sql"})
  public void borrowNotFoundBookTest() throws Exception {
    String jsonBody = "{\"userId\":\"1\", \"bookCode\":\"3\"}";

    RequestBuilder request = post("/api/borrows")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonBody);

    ResultActions result = mockMvc.perform(request);
    verifyErrorResponse(result, 404, "0002");
  }

  private void verifyErrorResponse(ResultActions result, int status, String errorCode) throws Exception {
    result.andExpect(MockMvcResultMatchers.status().is(status));

    String jsonResponse = result.andReturn().getResponse().getContentAsString();
    ErrorResponse error = objectMapper.readValue(jsonResponse, ErrorResponse.class);
    Assertions.assertEquals(errorCode, error.getErrorCode());
  }
}
