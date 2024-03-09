package com.example.trading.controller;


import com.example.trading.model.TradeRequest;
import com.example.trading.model.TradeResponse;
import com.example.trading.service.TradeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/trades")
public class StockTradeRestController {
    private final TradeService tradeService;
    public StockTradeRestController(TradeService tradeService) {
        this.tradeService = tradeService;
    }
    @PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TradeResponse> createTrade(@Valid @RequestBody TradeRequest tradeRequest){
         TradeResponse tradeResponse=tradeService.createTrade(tradeRequest);
         return ResponseEntity.status(HttpStatus.CREATED).body(tradeResponse);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TradeResponse> getAllTrades(@RequestParam(value="type",required = false) String type,
                                            @RequestParam(value ="userId",required = false) Integer userId){
        if(type!=null && !type.isEmpty()){
            tradeService.getTradeByType(type);
        } else if (userId!=null) {
            tradeService.getTradeByUser(userId);
        }
        return tradeService.getAllTrades();
    }
    @GetMapping(value = "/{Id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TradeResponse> getTrade(@PathVariable("Id") Integer Id){
           TradeResponse tradeResponse=tradeService.getTrade(Id);
           return  ResponseEntity.ok(tradeResponse);
    }

}