package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Util {

    public static String getDataFromJSON(String data, JsonElement request) {
        JsonObject obj = request.getAsJsonObject();
        return String.valueOf(obj.get(data));
    }

    public static boolean isSomeoneAllIn(JsonArray players){

        for(JsonElement el: players){
            JsonObject elObj = el.getAsJsonObject();
            if(elObj.get("stack").getAsInt() == elObj.get("bet").getAsInt()){
                return true;
            }
        }

        return false;

    }
}
