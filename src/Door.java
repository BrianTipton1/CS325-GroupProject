class Door extends Thing {
    public Door(int id, int roomId, int x, int y, int width, int height) {
        super(id, roomId, x, y, width, height, true);
    }

    public Door(int id, int roomId, int x, int y) {
        super(id, roomId, x, y, 1, 1, true);
    }

    public Door(int id, int roomId) {
        super(id, roomId, 0, 0, 1, 1, true);
    }
}