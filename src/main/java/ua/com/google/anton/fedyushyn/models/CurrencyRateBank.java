package ua.com.google.anton.fedyushyn.models;

public interface CurrencyRateBank {
    int getCurrencyCodeA();

    int getCurrencyCodeB();

    Long getDate();

    Float getRateBuy();

    Float getRateSell();

    Float getRateCross();
}
