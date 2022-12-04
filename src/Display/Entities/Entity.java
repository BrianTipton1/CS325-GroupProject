package Display.Entities;

public class Entity {
    private int xSize;
    private int ySize;

    public EntityTypes type;

    public int getxSize() {
        return xSize;
    }

    public void setxSize(int xSize) {
        this.xSize = xSize;
    }


    public int getySize() {
        return ySize;
    }

    public void setySize(int ySize) {
        this.ySize = ySize;
    }
}
