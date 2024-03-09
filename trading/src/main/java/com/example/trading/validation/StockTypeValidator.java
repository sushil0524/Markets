package com.example.trading.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class StockTypeValidator implements ConstraintValidator<StockType, String> {
    List<String> stockTypes = Arrays.asList("buy", "sell");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return stockTypes.contains(value);
    }
}
