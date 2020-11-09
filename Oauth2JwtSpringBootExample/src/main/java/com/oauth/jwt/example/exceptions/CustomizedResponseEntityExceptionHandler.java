package com.oauth.jwt.example.exceptions;


import com.oauth.jwt.example.exceptions.responses.BadRequestException;
import com.oauth.jwt.example.exceptions.responses.FoundException;
import com.oauth.jwt.example.exceptions.responses.NoContentException;
import com.oauth.jwt.example.exceptions.responses.NotFoundException;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author jhon
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * NotFoundException.
     *
     * @param ex NotFoundException
     * @param request request
     * @return mensaje de error para NotFoundException
     */
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * NotFoundException.
     *
     * @param ex NoContentException
     * @param request request
     * @return mensaje de error para NoContentException
     */
    @ExceptionHandler(NoContentException.class)
    public final ResponseEntity<ExceptionResponse> handleNoContentException(FoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NO_CONTENT);
    }

    /**
     * NotFoundException.
     *
     * @param ex FoundException
     * @param request request
     * @return mensaje de error para FoundException
     */
    @ExceptionHandler(FoundException.class)
    public final ResponseEntity<ExceptionResponse> handleFoundException(FoundException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.FOUND);
    }

    /**
     * BadRequestException.
     *
     * @param ex FoundException
     * @param request request
     * @return mensaje de error para BadRequestException
     */
    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
