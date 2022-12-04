package Util;// Util.GameDataParser
// Util.GameDataParser takes in a JSON file and gets level specific data such as "doors", "rooms", and "user"
// Returns data as a ArrayList<HashMap<String, Object>>

import lib.JSONArray;
import lib.JSONException;
import lib.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;


public class GameDataParser {
    public static void main(String[] args) throws Exception {
        // Test
        JSONObject jsonO = getJSON("test2.json");
        if (isValidJSON(jsonO)) {
            System.out.println(getArrayListFromJSON(jsonO, "rooms2"));
            System.out.println(getArrayListFromJSON(jsonO, "doors"));
            System.out.println(getArrayListFromJSON(jsonO, "user"));
        }
       
    }
    
    // Takes in a file name.
    // Returns a JSONObject.
    public static JSONObject getJSON(String fileName) throws Exception {
        String jsonString = readFileAsString(fileName);
        try {
            JSONObject jsonObj = new JSONObject(jsonString);
            return jsonObj;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Takes in a JSONObject and checks if it's null
    // Returns boolean if it is valid.
    public static boolean isValidJSON(JSONObject jsonObj) {
        return (jsonObj != null);
    }

    // Takes in a file name, opens it, and reads it.
    // Returns file contents as string.
    public static String readFileAsString(String fileName)throws Exception {
        File file = new File(fileName);
        if(file.exists() && !file.isDirectory()) { 
            byte[] byteArray = Files.readAllBytes(Paths.get(fileName));
            return new String(byteArray);
        }
        return "";
        
    }

    // Gets the jsonObject at key
    // Returns Object if key was found, else null.
    public static Object get(JSONObject jsonObj, String key) {
        if (jsonObj.has(key)) {
            Object name = jsonObj.get(key);
            return name;
        }
        return null;
    };

    // Sets the jsonObject at key with value
    public static void set(JSONObject jsonObj, String key, Object value) {
        jsonObj.put(key, value);
    };

    // Turns JSONObject to HashMap of (String-> Objects)
    // Takes in a JSONObject.
    // Returns as an HashMap of keys with values.
    // Ex: getHashMapFromJSONObject(jsonObj) => {isLocked=true, doorID=1, room1=1, room2=2}
    public static HashMap<String, Object> getHashMapFromJSONObject(JSONObject jsonObj) {
        HashMap<String, Object> data = new HashMap<String, Object>();
        Iterator<String> keySet = jsonObj.keys();
        for (int j = 0; j < jsonObj.length(); j++) {
            String key = keySet.next();
            Object value = jsonObj.get(key);
            data.put(key, value);
        }
        return data;
    }

    
    // Gets level data from JSON file.
    // Takes in a JSONObject and a string to search.
    // Returns as an Array list of keys with values.
    // Ex: getArrayListFromJSON(jsonObj, "doors") => [{isLocked=true, doorID=1, room1=1, room2=2}, {isLocked=false...}, ...]
    // Keys are commonly: "doors", "rooms", or "user".
    public static ArrayList<HashMap<String, Object>> getArrayListFromJSON(JSONObject jsonObj, String key) {
        ArrayList<HashMap<String, Object>> arrayListData = new ArrayList<HashMap<String, Object>>();
        JSONArray array = (JSONArray) get(jsonObj, key);
        if (array != null) {
            for(int i = 0; i < array.length(); i++) {
                JSONObject subJsonObj = (JSONObject) array.get(i);
                HashMap<String, Object> data = getHashMapFromJSONObject(subJsonObj);
                arrayListData.add(data);
            }
        }
       return arrayListData;
    };

    // Takes in an ArrayList.
    // Returns the ArrayList size.
    public static int getArrayListSize(ArrayList arrayList) {
        return arrayList.size();
    }

    // Takes in an ArrayList and an index
    // Returns an object at index if within bounds, else return null.
    public static Object getArrayListAt(ArrayList arrayList, int index) {
        int size = getArrayListSize(arrayList);
        if ((index >= 0) && (index < size)) {
            return arrayList.get(index);
        }
        return null;
    }
}