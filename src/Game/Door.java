package Game;// Caleb Bayles
// Game.Door.java
// 11/13/2022
// Subclass of Game.Thing that opens and closes

public class Door extends Thing {

    private int roomAId;
    private int roomBId;

    public Door(int id, int roomAId, int roomBId, int x, int y, Boolean closed) {
        super(id, roomAId, x, y, 1, 1, closed);
        this.roomAId = roomAId;
        this.roomBId = roomBId;
    }
    
    public Door(int id, int roomAId, int roomBId, int x, int y) {
        super(id, roomAId, x, y, 1, 1, true);
        this.roomAId = roomAId;
        this.roomBId = roomBId;
    }

    public Door(int id, int roomAId, int roomBId) {
        super(id, roomAId, 0, 0, 1, 1, true);
        this.roomAId = roomAId;
        this.roomBId = roomBId;
    }

    public boolean isClosed() {
        return collidable;
    }

    public void close() {
        this.collidable = true;
    }

    public void open() {
        this.collidable = false;
    }

    public int getRoomAId() {
        return roomAId;
    }
    
    public int getRoomBId() {
        return roomBId;
    }

}