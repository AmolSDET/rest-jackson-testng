package com.amol.testing;

import com.amol.testing.ApiPojos.Currency;
import com.amol.testing.ApiPojos.Territory;
import com.amol.testing.handlers.TerritoryResponseHandler;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by adeshmukh on 4/9/18.
 */
public class TestGetCall {

    @Test(dataProvider = "name")
    public void testByName(String name, int size) {
        List<Territory> territories = getTerritories("name/" + name);
        Assert.assertTrue(territories.size() == size, "Incorrect number of territories returned for name " + name);
        for (Territory territory : territories) {
            Assert.assertTrue(territory.getName().toLowerCase().contains(name), "Name doesn't match for territory - " + territory.getName());
        }
    }

    @Test(dataProvider = "currency")
    public void testByCurrency(String expectedCurrency) {
        List<Territory> territories = getTerritories("currency/" + expectedCurrency);
        for (Territory territory : territories) {
            List<Currency> currencies = territory.getCurrencies();
            int count = 0;
            for (Currency currency : currencies) {
                final String actualCurrency = currency.getCode() == null ? "" : currency.getCode();
                if (actualCurrency.toLowerCase().contains(expectedCurrency.toLowerCase())) {
                    count++;
                }
            }
            Assert.assertTrue(count > 0, expectedCurrency + " is not returned for Territory - " + territory.getName());
        }
    }

    private List<Territory> getTerritories(String uri) {
        TerritoryResponseHandler responseHandler = new TerritoryResponseHandler();
        return responseHandler.getTerritoryObject(uri);
    }

    @DataProvider(name = "name")
    public static Object[][] name() {
        return new Object[][]{
                {"india", 2},
                {"united states of america", 1}
        };
    }

    @DataProvider(name = "currency")
    public static Object[][] currency() {
        return new Object[][]{
                {"inr"},
                {"usd"},
                {"aud"}
        };
    }
}
