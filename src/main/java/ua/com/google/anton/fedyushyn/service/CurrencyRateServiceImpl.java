package ua.com.google.anton.fedyushyn.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.google.anton.fedyushyn.consts.CurrencyRateCodes;
import ua.com.google.anton.fedyushyn.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyRateServiceImpl implements CurrencyRateService{
    private final static String uanStrCode = "UAN";
    private final static Integer uanIntCode = 980;
    private final static String url = "https://api.monobank.ua/bank/currency";

    private CurrencyRateCodes currencyRateCodes;

    @Autowired
    public CurrencyRateServiceImpl(CurrencyRateCodes currencyRateCodes) {
        this.currencyRateCodes = currencyRateCodes;
    }

    private List<CurrencyRateBank> getBankList(String value) {
        Type itemsListType = new TypeToken<List<CurrencyRateBankImpl>>() {}.getType();
        return new Gson().fromJson(value, itemsListType);
    }

    private List<CurrencyRateBank> getCurrencyRates() throws IOException {

        int responseCode = 0;
        StringBuffer response = new StringBuffer();
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        responseCode = connection.getResponseCode();
        try(BufferedReader in = new BufferedReader(
            new InputStreamReader(connection.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }
        return getBankList(response.toString());

    }

    private List<CurrencyRateResponse> toCurrentRatesResponse(List<CurrencyRateBank> list) {
        List<CurrencyRateResponse> responseList = new ArrayList<>();
        for (CurrencyRateBank bank: list) {
            if ((bank.getRateBuy() != null) && (bank.getRateSell() != null) && (bank.getCurrencyCodeB() == uanIntCode)) {
                CurrencyRateResponse res = new CurrencyRateBankAdapter(bank, currencyRateCodes);
                CurrencyRateResponse response = new CurrencyRateResponseImpl(res.getCurrencyCode(), res.getRateBuy(), res.getRateSell(), res.getDate());
                if (response.getCurrencyCode().length() > 0) {
                    responseList.add(response);
                }
            }
        }
        return responseList;
    }

    private CurrencyRateResponse getRateResponse(List<CurrencyRateBank> list, String code) {
        List<CurrencyRateResponse> responseList = toCurrentRatesResponse(list);
        for (CurrencyRateResponse resp: responseList){
            if (resp.getCurrencyCode().equals(code)) {
                return resp;
            }
        }
        return null;
    }

    @Override
    public String getCurrencyRateBank() {
        try {
            List<CurrencyRateBank> bankList = getCurrencyRates();
            return new Gson().toJson(bankList);
        } catch (Exception e){
            ErrorResponse response = new ErrorResponse("error get data!");
            return new Gson().toJson(response);
        }
    }

    @Override
    public String getCurrencyRateResponse() {
        try {
            List<CurrencyRateBank> bankList = getCurrencyRates();
            List<CurrencyRateResponse> responseList = toCurrentRatesResponse(bankList);
            return new Gson().toJson(responseList);
        } catch (Exception e){
            ErrorResponse response = new ErrorResponse("error get data!");
            return new Gson().toJson(response);
        }
    }

    @Override
    public String getCurrencyRateResponse(String codeStr) {
        try {
            List<CurrencyRateBank> bankList = getCurrencyRates();
            CurrencyRateResponse response = getRateResponse(bankList, codeStr.toUpperCase());
            if (response == null) {
                ErrorResponse res = new ErrorResponse("currency rate not found!");
                return new Gson().toJson(res);
            } else {
                return new Gson().toJson(response);
            }
        } catch (Exception e){
            ErrorResponse response = new ErrorResponse("error get data!");
            return new Gson().toJson(response);
        }
    }
}
