package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Player {

    static Random rng = new Random();

    static final String VERSION = String.valueOf(rng.nextInt(5000));

    public static int betRequest(JsonElement request) {

        System.out.println("REQUEST" + request);

        JsonObject obj = request.getAsJsonObject();

        JsonArray arr = obj.get("players").getAsJsonArray();

        JsonObject ourCards = null;




        for(JsonElement element: arr){
            JsonObject objElement = element.getAsJsonObject();
            String name = objElement.get("name").getAsString();
            if(name.equals("KorDAO")){
                ourCards = objElement;
            }
        }

        List<Card> cards = new ArrayList<Card>();

        JsonArray holeCards = ourCards.get("hole_cards").getAsJsonArray();

        for(JsonElement cardElement: holeCards){
            JsonObject cardObj = cardElement.getAsJsonObject();
            cards.add(new Card(cardObj.get("rank").getAsString(), cardObj.get("suit").getAsString()));
        }



        JsonArray comCards = request.getAsJsonObject().get("community_cards").getAsJsonArray();

        for(JsonElement comCardElement: comCards){
            JsonObject comCardObj = comCardElement.getAsJsonObject();
            cards.add(new Card(comCardObj.get("rank").getAsString(), comCardObj.get("suit").getAsString()));
        }

        System.err.println("Our cards: " + cards);






        return 1;
    }

    public static void showdown(JsonElement game) {
    }
}
