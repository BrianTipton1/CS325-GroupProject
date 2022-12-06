import Display.Renderer;
import Game.Room;
import Game.Door;
import Game.Player;
import Util.GameDataParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.Scanner;

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

        // GAME LOOP
        Scanner userInput = new Scanner(System.in);
        String command;
        while (true) {

            // GET COMMAND
            System.out.print("Command: ");
            command = userInput.nextLine();
            if (command.equals("QUIT")) {
                break;
            }

            // DO STUFF BASED ON COMMAND

            int myCurrentRoomId = -1;
            Room myCurrentRoom;

            if (command.equals("get my room")) {
                if (player != null) {
                    myCurrentRoomId = player.getRoomId();
                    
                    // GET PLAYER'S CURRENT ROOM BASED ON THEIR ROOM ID
                    for (int i = 0; i < rooms.size(); i++) {
                        if (rooms.get(i).getId() == myCurrentRoomId) {
                            myCurrentRoom = rooms.get(i);
                        }
                    }
                }
                System.out.println("You are currently in room " + myCurrentRoomId);
            }

            // UPDATE SCREEN

        }
        userInput.close();
    }

    public static void loadRooms(ArrayList<HashMap<String, Object>> roomsData) {
        int count = roomsData.size();
        for(int i = 0; i < count; i++) {
            HashMap<String, Object> data = roomsData.get(i);
            int id = (int) data.get("roomID");
            Boolean hasVisted = (Boolean) data.get("hasVisited");
            int width = (int) data.get("width");
            int height = (int) data.get("height");
            System.out.println(id);
            System.out.println(hasVisted);
            System.out.println(width);
            System.out.println(height);

            Room room = new Room(id, width, height, hasVisted);
            rooms.add(room);
        }
    }

    public static void loadDoors(ArrayList<HashMap<String, Object>> doorsData) {
        int count = doorsData.size();
        for(int i = 0; i < count; i++) {
            HashMap<String, Object> data = doorsData.get(i);
            int id = (int) data.get("doorID");
            Boolean isLocked = (Boolean) data.get("isLocked");
            int room1Id = (int) data.get("room1");
            int room2Id = (int) data.get("room2");
            int x = 0;
            int y = 0;

            Door door = new Door(id, room1Id, room2Id, x, y, isLocked);
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
        
        player = new Player(roomID, x, y, facing);
    }
    
}