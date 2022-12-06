package Game;// Caleb Bayles
// Game.Room.java
// 11/13/2022
// Not a Thing, but contains Things

public class Room {

    private int id;
    public boolean explored;
    public int width;
    public int height;

    public Room(int id, int width, int height, boolean hasVisited) {
        this.id = id;
        explored = hasVisited;
        this.width = width;
        this.height = height;
    }

    public Room(int id, int width, int height) {
        this.id = id;
        explored = false;
        this.width = width;
        this.height = height;
    }

    public Room(int id) {
        this.id = id;
        explored = false;
        width = 10;
        height = 10;
    }

    public int getId() {
        return id;
    }
    
}