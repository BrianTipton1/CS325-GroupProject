import Display.Renderer;
import Game.Room;
import Game.Door;
import Game.Player;
import Util.GameDataParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Main {
    static Vector<Room> rooms = new Vector<Room>();
    static Vector<Door> doors = new Vector<Door>();
    static Player player = null;

    public static void main(String[] args) {
        System.out.println("Hello CS325!");
        
        // Load JSON Data
        String fileName = "test.json";
        GameDataParser gameData = new GameDataParser();
        int loaded = gameData.loadJSONFile(fileName);
        if (loaded != 0) {
            System.out.printf("Error loading JSON file %s", fileName);
        } else {
            ArrayList<HashMap<String, Object>> roomsData = gameData.getRoomData();
            loadRooms(roomsData);
            ArrayList<HashMap<String, Object>> doorsData = gameData.getDoorData();
            loadDoors(doorsData);
            ArrayList<HashMap<String, Object>> PlayerData = gameData.getPlayerData();
            loadPlayer(PlayerData);
        }
    }

    public static void loadRooms(ArrayList<HashMap<String, Object>> roomsData) {
        int count = roomsData.size();
        for(int i = 0; i < count; i++) {
            HashMap<String, Object> data = roomsData.get(i);
            int id = (int) data.get("roomID");
            Boolean hasVisted = (Boolean) data.get("hasVisited");
            System.out.println(id);
            System.out.println(hasVisted);

            Room room = new Room(id);
            room.explored = hasVisted;
            rooms.add(room);
        }
    }

    public static void loadDoors(ArrayList<HashMap<String, Object>> doorsData) {
        int count = doorsData.size();
        for(int i = 0; i < count; i++) {
            //Door(int id, int roomId, int x, int y, int width, int height) {
            HashMap<String, Object> data = doorsData.get(i);
            int id = (int) data.get("doorID");
            Boolean isLocked = (Boolean) data.get("hasVisited");
            
            int roomID = 0;
            int x = 0;
            int y = 0;
            int width = 0;
            int height = 0;
            Door door = new Door(id, roomID, x, y, width, height);
            doors.add(door);
        }
    }

    public static void loadPlayer(ArrayList<HashMap<String, Object>> playerData) {
        int count = playerData.size();
        HashMap<String, Object> data = playerData.get(0);
        int roomID = 0;
        int x = (int) data.get("xPos");
        int y = (int) data.get("yPos");
        String facing = (String) data.get("facing");
        int width = 1;
        int height = 1;
        
        // I think you got the Player data mixed up with the Room data
        // Not sure how to add width and height to a player, except to make it 1, 1
        //Player(int roomId, int x, int y, int width, int height) 
        player = new Player(roomID, x, y, width, height);
    }
    
}