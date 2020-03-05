package ua.com.google.anton.fedyushyn.models;

public interface CurrencyRateResponse {
    String getCurrencyCode();
    Float getRateBuy();
    Float getRateSell();
    String getDate();
}
