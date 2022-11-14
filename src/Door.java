// Caleb Bayles
// Door.java
// 11/13/2022
// Subclass of Thing that opens and closes

class Door extends Thing {

    private int roomAId;
    private int roomBId;

    public Door(int id, int roomId, int x, int y, int width, int height) {
        super(id, roomId, x, y, width, height, true);
    }

    public Door(int id, int roomId, int x, int y) {
        super(id, roomId, x, y, 1, 1, true);
    }

    public Door(int id, int roomId) {
        super(id, roomId, 0, 0, 1, 1, true);
    }

    public boolean isClosed() {
        return collidable;
    }

    public void setClosed(boolean closed) {
        this.collidable = closed;
    }

    public int getRoomAId() {
        return roomAId;
    }
    
    public int getRoomBId() {
        return roomBId;
    }

}