package com.example.trading.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TradeNotFoundException.class)
    public ProblemDetail handleTradeNotFoundException(TradeNotFoundException tradeNotFoundException){
        return  ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,tradeNotFoundException.getMessage());
    }
}
