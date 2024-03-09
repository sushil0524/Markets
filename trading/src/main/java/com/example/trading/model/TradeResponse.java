package com.example.trading.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TradeResponse {
    private Integer id;
    private String type;
    private Integer userId;
    private String symbol;
    private Integer shares;
    private Integer price;
    private Long timeStamp;
}
