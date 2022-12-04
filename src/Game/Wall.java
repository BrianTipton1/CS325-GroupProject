package Game;// Caleb Bayles
// Game.Wall.java
// 11/13/2022
// A wall. The player can't move past it.

public class Wall extends Thing {
    
    public Wall(int id, int roomId, int x, int y, int width, int height) {
        super(id, roomId, x, y, width, height, true);
    }

    public Wall(int id, int roomId, int x, int y) {
        super(id, roomId, x, y, 1, 1, true);
    }

    public Wall(int id, int roomId) {
        super(id, roomId, 0, 0, 1, 1, true);
    }

}