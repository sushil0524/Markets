package com.example.trading.exception;

public class TradeNotFoundException extends RuntimeException{
    public TradeNotFoundException(String message){
        super(message);
    }
}
