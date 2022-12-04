package Display.Patcher;

import Display.Entities.Entity;

import java.util.ArrayList;
import java.util.UUID;

public class Patch {
    private UUID patchId;
    private int xCord;
    private int yCord;
    private int xSize;
    private int ySize;
    private  ArrayList<ArrayList<String>> area;
    private Entity entity;

    public Patch(int xCord, int yCord) {
        this.patchId = UUID.randomUUID();
        this.area = new ArrayList<>();
        this.xCord = xCord;
        this.yCord = yCord;
        this.xSize = 1;
        this.ySize = 1;
        this.entity = new Entity();
    }

    public Patch sizePatch(){
        for (int rows = 0; rows < xSize; rows++) {
            ArrayList<String> tmp = new ArrayList<String>();
            for (int columns = 0; columns < ySize; columns++) {
                tmp.add(" ");
            }
            this.getArea().add(tmp);
        }
        return this;
    }

    public ArrayList<ArrayList<String>> getArea() {
        return area;
    }

    public void setArea(ArrayList<ArrayList<String>> area) {
        this.area = area;
    }

    public int getxCord() {
        return xCord;
    }

    public void setxCord(int xCord) {
        this.xCord = xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public void setyCord(int yCord) {
        this.yCord = yCord;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public Patch setxSize(int xSize) {
        this.xSize = xSize;
        return this;
    }
    public Patch setySize(int ySize) {
        this.ySize = ySize;
        return this;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public UUID getPatchId() {
        return patchId;
    }

    public void setPatchId(UUID patchId) {
        this.patchId = patchId;
    }
}
