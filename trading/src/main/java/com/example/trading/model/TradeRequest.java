package com.example.trading.model;
import com.example.trading.validation.StockType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeRequest {
@StockType
private String type;
private Integer userId;
private String symbol;
@Min(value = 1, message = "share value should not be less than 1")
@Max(value = 100,message = "Share value should not be more than 100")
private Integer shares;
private Integer price;
private Long timeStamp;
}
