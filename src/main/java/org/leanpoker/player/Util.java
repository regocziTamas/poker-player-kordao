package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Util {

    public static String getDataFromJSON(String data, JsonElement request) {
        JsonObject obj = request.getAsJsonObject();
        return String.valueOf(obj.get(data));
    }
}
