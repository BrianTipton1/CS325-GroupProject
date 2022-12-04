package Game;// Caleb Bayles
// Game.Room.java
// 11/13/2022
// Not a Game.Thing, but contains Things

public class Room {

    private int id;
    public boolean explored;

    public Room(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}