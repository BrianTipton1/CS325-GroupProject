public abstract class Thing {
    protected int id;
    protected int roomId;
    private int xPosition;
    private int yPosition;
    private int width;
    private int height;
    boolean collidable;

    //CONSTRUCTORS
    Thing(int id, int roomId, int x, int y, int width, int height, boolean collidable) {
        this.id = id;
        this.roomId = roomId;
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
    public void setXPosition(int x) {
        xPosition = x;
    }
    public void setYPosition(int y) {
        yPosition = y;
    }
    public void setRoomId(int id) {
        roomId = id;
    }

}
