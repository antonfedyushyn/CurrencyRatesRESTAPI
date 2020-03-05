package ua.com.google.anton.fedyushyn.models;

import ua.com.google.anton.fedyushyn.consts.CurrencyRateCodes;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrencyRateBankAdapter implements CurrencyRateResponse {
    private CurrencyRateBank currencyRateBank;
    private CurrencyRateCodes codes;

    public CurrencyRateBankAdapter(CurrencyRateBank currencyRateBank, CurrencyRateCodes codes) {
        this.currencyRateBank = currencyRateBank;
        this.codes = codes;
    }

    @Override
    public String getCurrencyCode() {
        if (codes == null) {
            return null;
        }
        return codes.getCode(currencyRateBank.getCurrencyCodeA());
    }

    @Override
    public Float getRateBuy() {
        return currencyRateBank.getRateBuy();
    }

    @Override
    public Float getRateSell() {
        return currencyRateBank.getRateSell();
    }

    @Override
    public String getDate() {
        if (currencyRateBank.getDate() == null) {
            return "";
        }
        Date date = new Date(currencyRateBank.getDate()*1000);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
