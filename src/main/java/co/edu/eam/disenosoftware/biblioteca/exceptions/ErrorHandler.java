package co.edu.eam.disenosoftware.biblioteca.exceptions;

import co.edu.eam.disenosoftware.biblioteca.model.responses.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Generic Error handler
 */
@ControllerAdvice
public class ErrorHandler {

  /**
   * BusinessException Error Handler
   *
   * @param exc business exception thrown
   * @return ErrorResponse
   */
  @ResponseBody
  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException exc) {

    ErrorCodesEnum errorCode = exc.getCode();
    ErrorResponse error = new ErrorResponse(errorCode.name(), errorCode.getCode());

    return new ResponseEntity<>(error, errorCode.getStatus());
  }

  @ExceptionHandler({MethodArgumentNotValidException.class})
  public ResponseEntity<ErrorResponse> handleBadParams(MethodArgumentNotValidException exception) {

    String message = "Error en " + exception.getBindingResult().getFieldError().getField() +
            ": " + exception.getBindingResult().getAllErrors().get(0).getDefaultMessage();

    ErrorResponse error = new ErrorResponse(message, "400");
    return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
  }
}
