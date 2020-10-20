package co.edu.eam.disenosoftware.biblioteca.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Error codes for exceptions
 */
public enum ErrorCodesEnum {

  /**
   * example
   */
  EXAMPLE(""),
  NOT_FOUND("0001"),
  NOT_FOUND1("0002"),
  PRECONDITION_FAILED("0003"),
  PRECONDITION_FAILED1("0004"),
  ;

  /**
   * error code
   */
  private String code;

  /**
   * http status code associated to this error
   */
  private HttpStatus status;

  ErrorCodesEnum(String code) {
    this.code = code;
    status = HttpStatus.INTERNAL_SERVER_ERROR;
  }

  ErrorCodesEnum(String code, HttpStatus status) {
    this.code = code;
    this.status = status;
  }

  /**
   * get de error code description
   * @return error code
   */
  public String getCode() {
    return code;
  }

  /**
   * Get the status code associated to this error
   * @return http status code
   */
  public HttpStatus getStatus() {
    return status;
  }
}
