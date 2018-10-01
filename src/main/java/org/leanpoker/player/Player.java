package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {

        JsonObject obj = request.getAsJsonObject();

        JsonElement el = obj.get("players");

        JsonArray arr = el.getAsJsonArray();

        JsonElement ourCards = null;

        for(JsonElement element: arr){
            if(((JsonObject) element).get("name").equals("KorDAO")){
                ourCards = element;
            }
        }

        System.out.println(ourCards);
       

        return 1;
    }

    public static void showdown(JsonElement game) {
    }
}
