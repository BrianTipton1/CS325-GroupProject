package Util;
// Cole Warden
// 11/17/2022
// GameDataParser takes in a JSON file and gets level specific data such as "doors", "rooms", and "user"
// Returns data as a ArrayList<HashMap<String, Object>>


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

import lib.JSONArray;
import lib.JSONException;
import lib.JSONObject;

public class GameDataParser {
    JSONObject jsonO = null;
    public void main(String[] args) {}
    
    public int loadJSONFile(String fileName) {
        try {
            jsonO = getJSON(fileName);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.printf("Error loading file %s", fileName);
            return 1;
        }
        return 0;
    }

    public ArrayList<HashMap<String, Object>> getRoomData() {
        if (isValidJSON(jsonO)) {
            return getArrayListFromJSON(jsonO, "rooms");
        }
        return null;
    }

    public ArrayList<HashMap<String, Object>> getDoorData() {
        if (isValidJSON(jsonO)) {
            return getArrayListFromJSON(jsonO, "doors");
        }
        return null;
    }

    public ArrayList<HashMap<String, Object>> getPlayerData() {
        if (isValidJSON(jsonO)) {
            return getArrayListFromJSON(jsonO, "user");
        }
        return null;
    }

    // Takes in a file name.
    // Returns a JSONObject.
    private JSONObject getJSON(String fileName) throws Exception {
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
    private boolean isValidJSON(JSONObject jsonObj) {
        return (jsonObj != null);
    }

    // Takes in a file name, opens it, and reads it.
    // Returns file contents as string.
    private String readFileAsString(String fileName)throws Exception {
        File file = new File(fileName);
        if(file.exists() && !file.isDirectory()) { 
            byte[] byteArray = Files.readAllBytes(Paths.get(fileName));
            return new String(byteArray);
        }
        return "";
        
    }

    // Gets the jsonObject at key
    // Returns Object if key was found, else null.
    private Object get(JSONObject jsonObj, String key) {
        if (jsonObj.has(key)) {
            Object name = jsonObj.get(key);
            return name;
        }
        return null;
    };

    // Sets the jsonObject at key with value
    private void set(JSONObject jsonObj, String key, Object value) {
        jsonObj.put(key, value);
    };

    // Turns JSONObject to HashMap of (String-> Objects)
    // Takes in a JSONObject.
    // Returns as an HashMap of keys with values.
    // Ex: getHashMapFromJSONObject(jsonObj) => {isLocked=true, doorID=1, room1=1, room2=2}
    private HashMap<String, Object> getHashMapFromJSONObject(JSONObject jsonObj) {
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
    private ArrayList<HashMap<String, Object>> getArrayListFromJSON(JSONObject jsonObj, String key) {
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
    private int getArrayListSize(ArrayList arrayList) {
        return arrayList.size();
    }

    // Takes in an ArrayList and an index
    // Returns an object at index if within bounds, else return null.
    private Object getArrayListAt(ArrayList arrayList, int index) {
        int size = getArrayListSize(arrayList);
        if ((index >= 0) && (index < size)) {
            return arrayList.get(index);
        }
        return null;
    }
}