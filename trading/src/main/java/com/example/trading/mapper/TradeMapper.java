package com.example.trading.mapper;
import com.example.trading.model.StockTrade;
import com.example.trading.model.TradeRequest;
import com.example.trading.model.TradeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TradeMapper {
    StockTrade transformToEntity(TradeRequest tradeRequest);
    TradeResponse transformToDto(StockTrade stockTrade);
}
