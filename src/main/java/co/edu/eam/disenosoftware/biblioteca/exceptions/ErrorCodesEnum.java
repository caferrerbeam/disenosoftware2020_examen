package co.edu.eam.disenosoftware.biblioteca.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Error codes for exceptions
 */
public enum ErrorCodesEnum {

  /**
   * example
   */
  NOT_FOUND_USER("0001",HttpStatus.NOT_FOUND),
  NOT_FOUND_BOOK("0002",HttpStatus.NOT_FOUND),
  BOOK_ALREADY_IN_USER("0003",HttpStatus.PRECONDITION_FAILED),
  MORE_THAN_3_BOOKS("0004",HttpStatus.PRECONDITION_FAILED);

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
