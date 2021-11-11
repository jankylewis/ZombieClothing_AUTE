package com.zombieclothing.utilities;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JSONReader {

    public static Object[][] getData(String JSON_path,
                                     String typeData,
                                     int totalDataSet,
                                     int totalKey) throws FileNotFoundException
    {
        JsonParser jsonParser =  new JsonParser();
        JsonObject jsonObj = jsonParser.parse(new FileReader(JSON_path)).getAsJsonObject();
        JsonArray array = (JsonArray) jsonObj.get(typeData);
        return searchJSONElement(array, totalDataSet, totalKey);
    }

    public static Object[][] toArray(List<List<Object>> list)
    {
        Object[][] r = new Object[list.size()+1][];
        int i = 0;
        for (List<Object> next : list)
        {
            r[i++] = next.toArray(new Object[next.size()+1]);
        }
        return r;
    }

    public static Object[][] searchJSONElement(JsonArray jsonArray,
                                                int totalDataSet,
                                                    int totalColumnEntry) throws NullPointerException
    {
        Object[][] matrix = new Object[totalDataSet][totalColumnEntry];
        int i= 0;
        int j= 0;
        for (JsonElement jsonElement : jsonArray)
        {
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet())
            {
                matrix[i][j] = entry.getValue().toString().replace("\"","");
                j++;
            }
            i++;
            j= 0;
        }
        return matrix;
    }
}


