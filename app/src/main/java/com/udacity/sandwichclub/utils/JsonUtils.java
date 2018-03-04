package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        JSONObject sandwichJson= new JSONObject(json);
        JSONObject name =sandwichJson.getJSONObject("name");
        String mainName=name.getString("mainName");
        JSONArray alsoKnownAsJsonArray=name.getJSONArray("alsoKnownAs");
        List<String> alsoKnownAs=new ArrayList<>();
        if (alsoKnownAsJsonArray!=null){
            for (int i=0;i<alsoKnownAsJsonArray.length();i++){
                alsoKnownAs.add(alsoKnownAsJsonArray.getString(i));
            }
        }

        String placeOfOrigin=sandwichJson.getString("placeOfOrigin");
        String description=sandwichJson.getString("description");
        String image=sandwichJson.getString("image");
        JSONArray ingredientsJsonArray=sandwichJson.getJSONArray("ingredients");
        List<String> ingredients=new ArrayList<>();
        if (ingredientsJsonArray!=null){
            for (int i=0;i<ingredientsJsonArray.length();i++){
                ingredients.add(ingredientsJsonArray.getString(i));
            }
        }

        Sandwich sandwich=new Sandwich(mainName,alsoKnownAs,placeOfOrigin,description,image,ingredients);

        return sandwich;
    }
}