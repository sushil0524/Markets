package com.example.trading.service;
import com.example.trading.model.TradeRequest;
import com.example.trading.model.TradeResponse;

import java.util.List;

public interface TradeService {

    TradeResponse createTrade(TradeRequest tradeRequest);

    List<TradeResponse> getAllTrades();

    TradeResponse getTrade(Integer id);

    List<TradeResponse> getTradeByType(String type);

    List<TradeResponse> getTradeByUser(Integer userId);
}
