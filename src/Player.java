class Player extends Thing {

    public Player(int roomId, int x, int y, int width, int height) {
        super(0, roomId, x, y, width, height, true);
    }

    public Player(int roomId, int x, int y) {
        super(0, roomId, x, y, 1, 1, true);
    }
    
    public Player(int roomId) {
        super(0, roomId, 0, 0, 1, 1, true);
    }
    
}