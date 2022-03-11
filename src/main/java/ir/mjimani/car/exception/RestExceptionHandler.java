package ir.mjimani.car.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new APIErrorResponse(error), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<Object> buildResponseEntity(APIErrorResponse apiError, HttpStatus httpStatus) {
        return new ResponseEntity<>(apiError, httpStatus);
    }

    private ResponseEntity<Object> buildResponseEntity(APIErrorResponse apiError) {
        return new ResponseEntity<>(apiError, HttpStatus.OK);
    }

    @ExceptionHandler(APIException.class)
    protected ResponseEntity<Object> handleAPIException(APIException ex) {
        APIErrorResponse apiError = new APIErrorResponse(ex.getMessage());
        return buildResponseEntity(apiError);
    }

}