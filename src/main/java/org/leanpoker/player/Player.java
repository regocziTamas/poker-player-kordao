package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public class Player {

    static final String VERSION = "Default Java folding player";

    public static int betRequest(JsonElement request) {

        System.out.println("REQUEST" + request);

        JsonObject obj = request.getAsJsonObject();

        JsonArray arr = obj.get("players").getAsJsonArray();

        JsonObject ourCards = null;

        System.out.println("ARRARRRARR: "+ arr);

        for(JsonElement element: arr){
            JsonObject objElement = (JsonObject) element;
            if(objElement.get("name").equals("KorDAO")){
                ourCards = objElement;
            }
        }



        System.out.println("blablabla" + ourCards);


        return 1;
    }

    public static void showdown(JsonElement game) {
    }
}
