package Display;

import Display.Entities.Entity;
import Display.Entities.EntityFactory;
import Game.Door;
import Game.Player;
import Game.Room;

import java.util.ArrayList;
import java.util.Vector;

public class State {
    private Vector<Room> rooms;
    private Vector<Door> doors;
    private Player player;

    private ArrayList<Entity> doorEntities;
    private ArrayList<Entity> roomEntities;
    private Entity playerEntity;

    public State(Vector<Room> rooms, Vector<Door> doors, Player player) {
        this.rooms = rooms;
        this.doors = doors;
        this.player = player;
        this.doorEntities = new ArrayList<>();
        this.roomEntities = new ArrayList<>();
        this.playerEntity = EntityFactory.toEntity(player);
        this.createDoorEntities();
        this.createRoomEntities();
    }


    private void createDoorEntities() {
        for (Door door : this.doors) {
            this.doorEntities
                    .add(EntityFactory.toEntity(door));
        }
    }
    private void createRoomEntities(){
        for(Room room: this.rooms){
            this.roomEntities
                    .add(EntityFactory.toEntity(room));
        }
    }
}
