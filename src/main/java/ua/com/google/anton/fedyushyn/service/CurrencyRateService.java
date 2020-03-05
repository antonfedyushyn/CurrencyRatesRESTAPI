package ua.com.google.anton.fedyushyn.service;

import ua.com.google.anton.fedyushyn.models.CurrencyRateBank;
import ua.com.google.anton.fedyushyn.models.CurrencyRateResponse;

import java.util.List;

public interface CurrencyRateService {
    String getCurrencyRateBank();
    String getCurrencyRateBank(String codeStr);
    String getCurrencyRateResponse();
    String getCurrencyRateResponse(String codeStr);
}
