package com.example.trading.service;
import com.example.trading.exception.TradeNotFoundException;
import com.example.trading.mapper.TradeMapper;
import com.example.trading.model.StockTrade;
import com.example.trading.model.TradeRequest;
import com.example.trading.model.TradeResponse;
import com.example.trading.repository.StockTradeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TradeServiceImpl implements  TradeService{
    private final StockTradeRepository stockTradeRepository;
    private final TradeMapper tradeMapper;
    public TradeServiceImpl(StockTradeRepository stockTradeRepository, TradeMapper tradeMapper) {
        this.stockTradeRepository = stockTradeRepository;
        this.tradeMapper = tradeMapper;
    }
    @Override
    public TradeResponse createTrade(TradeRequest tradeRequest) {
        StockTrade stockTrade=tradeMapper.transformToEntity(tradeRequest);
        return  tradeMapper.transformToDto(stockTradeRepository.save(stockTrade));
    }
    @Override
    public List<TradeResponse> getAllTrades() {
        return stockTradeRepository.findAll()
                .stream()
                .map(tradeMapper::transformToDto).collect(Collectors.toList());
    }
    @Override
    public TradeResponse getTrade(Integer Id) {
       Optional<StockTrade> existingStockTradeOptional=stockTradeRepository.findById(Id);
           if(existingStockTradeOptional.isPresent()){
           return tradeMapper.transformToDto(existingStockTradeOptional.get());
       } else{
               throw new TradeNotFoundException("Trade not found");
           }
    }
    @Override
    public List<TradeResponse> getTradeByType(String type) {
        List<StockTrade> all = stockTradeRepository.findAll()
                .stream()
                .filter(stockTrade -> stockTrade.getType().equals(type))
                .toList();
        if (! all.isEmpty()){
            return all.stream().map(tradeMapper::transformToDto).collect(Collectors.toList());
        }
        else
            throw new TradeNotFoundException("Trade Details not available for the type ");
    }

    @Override
    public List<TradeResponse> getTradeByUser(Integer userId) {
        List<StockTrade> all = stockTradeRepository.findAll()
                .stream()
                .filter(stockTrade -> stockTrade.getUserId().equals(userId))
                .toList();
        if (!all.isEmpty()){
            return all.stream().map(tradeMapper::transformToDto).collect(Collectors.toList());
        }
        else
            throw new TradeNotFoundException("Trade Details not available for the Id ");
    }

}
