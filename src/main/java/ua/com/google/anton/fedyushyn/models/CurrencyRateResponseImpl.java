package ua.com.google.anton.fedyushyn.models;

public class CurrencyRateResponseImpl implements CurrencyRateResponse {
    private String currencyCode;
    private Float rateBuy;
    private Float rateSell;
    private String date;

    public CurrencyRateResponseImpl() {
    }

    public CurrencyRateResponseImpl(String currencyCode, Float rateBuy, Float rateSell, String date) {
        this.currencyCode = currencyCode;
        this.rateBuy = rateBuy;
        this.rateSell = rateSell;
        this.date = date;
    }

    @Override
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public Float getRateBuy() {
        return rateBuy;
    }

    public void setRateBuy(float rateBuy) {
        this.rateBuy = rateBuy;
    }

    @Override
    public Float getRateSell() {
        return rateSell;
    }

    public void setRateSell(float rateSell) {
        this.rateSell = rateSell;
    }

    @Override
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
