//package com.User_Validation.User.Management.With.Validation.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.time.LocalDateTime;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@RestControllerAdvice
//public class GlobalException extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object> handleNodataFoundException(MethodArgumentNotValidException methodArgumentNotValidException) {
//        Map<String, String> body = new LinkedHashMap<>();
//        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach(objectError -> {
//            String error = objectError.getDefaultMessage();
//            String fieldName = ((FieldError)objectError).getField();
//            body.put(fieldName,error);
//        });
//
////        body.put("timestamp", LocalDateTime.now());
////        body.put("message", "No cities found");
//
//        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//    }
//}
