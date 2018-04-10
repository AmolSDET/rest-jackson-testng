package com.amol.testing.handlers;

import com.amol.testing.ApiPojos.Territory;
import com.amol.testing.RestFactory.RestAssuredUtils;

import java.util.List;

/**
 * Created by adeshmukh on 4/9/18.
 */
public class TerritoryResponseHandler extends JsonMapper{


    public List<Territory> getTerritoryObject(String uri) {
        RestAssuredUtils restAssuredUtils = new RestAssuredUtils();
        String jsonResponse = restAssuredUtils.httpGet(uri);
        return getListObjectFromString(jsonResponse, Territory.class);
    }


}
