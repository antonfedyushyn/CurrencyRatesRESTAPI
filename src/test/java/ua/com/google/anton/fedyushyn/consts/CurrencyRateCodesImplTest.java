package ua.com.google.anton.fedyushyn.consts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CurrencyRateCodesImplTest {
    private CurrencyRateCodesImpl codes;

    @Before
    public void initTest() {
        codes = new CurrencyRateCodesImpl();
        codes.initMap();
    }

    @After
    public void afterTest() {
        codes = null;
    }

    @Test
    public void getCode() throws Exception {
       assertEquals(new Integer(980), codes.getCode("UAN"));
    }

    @Test
    public void getCode1() throws Exception {
        assertEquals("UAN", codes.getCode(980));
        assertEquals("USD", codes.getCode(840));
        assertEquals("EUR", codes.getCode(978));

    }

}