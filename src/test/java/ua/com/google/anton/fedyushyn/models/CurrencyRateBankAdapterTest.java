package ua.com.google.anton.fedyushyn.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.com.google.anton.fedyushyn.consts.CurrencyRateCodesImpl;

import java.util.Date;

import static org.junit.Assert.*;

public class CurrencyRateBankAdapterTest {
    private CurrencyRateBankImpl currencyRateBank;
    private CurrencyRateCodesImpl codes;
    private CurrencyRateBankAdapter adapter;

    @Before
    public void initTest() {
        codes = new CurrencyRateCodesImpl();
        codes.initMap();
        currencyRateBank = new CurrencyRateBankImpl();
        currencyRateBank.setCurrencyCodeA(840);
        currencyRateBank.setCurrencyCodeB(980);
        currencyRateBank.setRateBuy(24.95F);
        currencyRateBank.setRateSell(25.05F);
        currencyRateBank.setDate(new Date().getTime()/1000);
        adapter = new CurrencyRateBankAdapter(currencyRateBank, codes);
    }

    @After
    public void afterTest() {
        adapter          = null;
        currencyRateBank = null;
        codes            = null;
    }

    @Test
    public void getCurrencyCode() throws Exception {
        assertEquals("USD", adapter.getCurrencyCode());
    }

    @Test
    public void getRateBuy() throws Exception {
        assertEquals(new Float(24.95), adapter.getRateBuy());
    }

    @Test
    public void getRateSell() throws Exception {
        assertEquals(new Float(25.05), adapter.getRateSell());
    }

    @Test
    public void getDate() throws Exception {
        assertEquals("2020-03-05", adapter.getDate());
    }



    @Test()
    public void getDate1() throws Exception {
        assertFalse(adapter.getDate().equals("2020-06-05"));
    }

}