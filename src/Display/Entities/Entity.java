package Display.Entities;

import Game.Thing;

public class Entity {
    private int xSize;
    private int ySize;
    private int xPosition;
    private int yPosition;

    public EntityTypes.Traits type;

    public Entity setType(Thing gameObject) {
        Class<? extends Thing> unknownType = gameObject.getClass();
        switch (unknownType.getSimpleName()) {
            case "Door" -> this.type = EntityTypes.Traits.DOOR;
            case "Player" -> this.type = EntityTypes.Traits.USER;
            case "Room" -> this.type = EntityTypes.Traits.ROOM;
        }
        return this;
    }

    public EntityTypes.Traits getType() {
        return this.type;
    }

    public int getxSize() {
        return xSize;
    }

    public Entity setxSize(int xSize) {
        this.xSize = xSize;
        return this;
    }

    public int getySize() {
        return ySize;
    }

    public Entity setySize(int ySize) {
        this.ySize = ySize;
        return this;
    }

    public int getxPosition() {
        return xPosition;
    }

    public Entity setxPosition(int xPosition) {
        this.xPosition = xPosition;
        return this;
    }

    public int getyPosition() {
        return yPosition;
    }

    public Entity setyPosition(int yPosition) {
        this.yPosition = yPosition;
        return this;
    }
}
