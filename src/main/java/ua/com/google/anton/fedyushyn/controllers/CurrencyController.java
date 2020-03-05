package ua.com.google.anton.fedyushyn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.com.google.anton.fedyushyn.service.CurrencyRateService;

import java.util.List;

@RestController
public class CurrencyController {
    private CurrencyRateService currencyRateBankService;

    @Autowired
    public CurrencyController(CurrencyRateService currencyRateBankService) {
        this.currencyRateBankService = currencyRateBankService;
    }

    @GetMapping("/{currency}")
    public String GetCurrencyRates(@PathVariable(value = "currency") String currencyCode){
        return currencyRateBankService.getCurrencyRateResponse(currencyCode);

    }
    @GetMapping("/")
    public String GetCurrencyRates(){
        return currencyRateBankService.getCurrencyRateResponse();

    }
}
