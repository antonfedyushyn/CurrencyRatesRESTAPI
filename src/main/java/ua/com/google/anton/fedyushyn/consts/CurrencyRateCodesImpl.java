package ua.com.google.anton.fedyushyn.consts;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class CurrencyRateCodesImpl implements CurrencyRateCodes {
    private Map<String, Integer> currecnyRatesCode = new HashMap();
    private Map<Integer, String> currecnyRatesCodeStr = new HashMap();

    public CurrencyRateCodesImpl() {
    }

    @PostConstruct
    public void initMap(){
        currecnyRatesCode.clear();
        currecnyRatesCode.put("UAN", 980);
        currecnyRatesCode.put("USD", 840);
        currecnyRatesCode.put("EUR", 978);
        currecnyRatesCode.put("GBP", 826);
        currecnyRatesCode.put("JPY", 392);
        currecnyRatesCode.put("CHF", 756);
        currecnyRatesCode.put("CNY", 156);
        currecnyRatesCode.put("RUB", 643);
        currecnyRatesCode.put("PLN", 985);

        currecnyRatesCodeStr.clear();
        currecnyRatesCodeStr.put(980, "UAN");
        currecnyRatesCodeStr.put(840, "USD");
        currecnyRatesCodeStr.put(978, "EUR");
        currecnyRatesCodeStr.put(826, "GBP");
        currecnyRatesCodeStr.put(392, "JPY");
        currecnyRatesCodeStr.put(756, "CHF");
        currecnyRatesCodeStr.put(156, "CNY");
        currecnyRatesCodeStr.put(643, "RUB");
        currecnyRatesCodeStr.put(985, "PLN");
    }

    @Override
    public String getCode(Integer codeInt) {
        if (currecnyRatesCodeStr.isEmpty()) {
            return null;
        }
        if (!currecnyRatesCodeStr.containsKey(codeInt)) {
            return null;
        } else {
            return currecnyRatesCodeStr.get(codeInt);
        }
    }

    @Override
    public Integer getCode(String codeStr) {
        if (currecnyRatesCode.isEmpty()) {
            return null;
        }
        if (!currecnyRatesCode.containsKey(codeStr)) {
            return null;
        } else {
            return currecnyRatesCode.get(codeStr);
        }
    }
}
