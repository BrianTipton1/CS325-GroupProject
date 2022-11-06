public abstract class Thing {
    private int id;
    private int roomId;
    private int xPosition;
    private int yPosition;
    private int width;
    private int height;
    boolean collidable;

    //CONSTRUCTORS
    Thing(int id, int roomId, int x, int y, int width, int height, boolean collidable) {
        this.id = id;
        this.roomId = id;
        xPosition = x;
        yPosition = y;
        this.width = width;
        this.height = height;
        this.collidable = collidable;
    }

    //GETTERS
    public int getId() {
        return id;
    }
    public int getRoomId() {
        return roomId;
    }
    public int getXPosition() {
        return xPosition;
    }
    public int getYPosition() {
        return yPosition;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public boolean isCollidable() {
        return collidable;
    }

    //SETTERS
    public int setRoomId() {
        return roomId;
    }
    public int setXPosition() {
        return xPosition;
    }
    public int setYPosition() {
        return yPosition;
    }

}
