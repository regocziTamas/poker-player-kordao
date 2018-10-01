package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.*;

public class Player {

    static Random rng = new Random();

    static final String VERSION = String.valueOf(rng.nextInt(5000));

    public static int betRequest(JsonElement request) {

        System.out.println("REQUEST" + request);

        JsonObject obj = request.getAsJsonObject();

        JsonArray arr = obj.get("players").getAsJsonArray();

        JsonObject ourCards = null;

        //
        int playerOutCounter = 0;
        int allPlayers = 0;
        int ourstack = 0;
        //

        for(JsonElement element: arr){


            //
            allPlayers++;
            if (element.getAsJsonObject().get("status").getAsString().equals("out"))
                playerOutCounter++;
            //



            JsonObject objElement = element.getAsJsonObject();
            String name = objElement.get("name").getAsString();
            if(name.equals("KorDAO")){

                //
                ourstack = element.getAsJsonObject().get("stack").getAsInt();
                //

                ourCards = objElement;
            }
        }

        List<Card> cards = new ArrayList<Card>();

        JsonArray holeCards = ourCards.get("hole_cards").getAsJsonArray();

        for(JsonElement cardElement: holeCards){
            JsonObject cardObj = cardElement.getAsJsonObject();
            cards.add(new Card(cardObj.get("rank").getAsString(), cardObj.get("suit").getAsString()));
        }



        JsonArray comCards = obj.get("community_cards").getAsJsonArray();


        for(JsonElement comCardElement: comCards){
            System.out.println("community_cards");
            JsonObject comCardObj = comCardElement.getAsJsonObject();
            cards.add(new Card(comCardObj.get("rank").getAsString(), comCardObj.get("suit").getAsString()));
        }

        int currentBuyIn = obj.get("current_buy_in").getAsInt();

        System.out.println("Current buy in: " + currentBuyIn);


        Card[] cardsArray = new Card[cards.size()];

        for (int i=0; i < cards.size(); i++) {
            cardsArray[i] = cards.get(i);
        }

        if (Combinations.hasPairInHand(cardsArray) >= 10)
            return currentBuyIn + currentBuyIn * (Combinations.hasPairInHand(cardsArray) - 10);

        //
        if (allPlayers - playerOutCounter == 2)
            return ourstack;
        //


        if (cards.size() == 2) {return Strategy.firstPhase(cardsArray, currentBuyIn);}
        if (cards.size() == 5) {return Strategy.secondPhase(cardsArray, currentBuyIn, ourstack);}
        if (cards.size() == 6) {return Strategy.thirdPhase(cardsArray, currentBuyIn, ourstack);}
        if (cards.size() == 7) {return Strategy.fourthPhase(cardsArray, currentBuyIn, ourstack);}


        return 0;
    }

    public static void showdown(JsonElement game) {
    }

}
