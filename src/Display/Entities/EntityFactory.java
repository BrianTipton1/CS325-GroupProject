package Display.Entities;

import Game.Thing;

public class EntityFactory {
    public static Entity toEntity(Thing gameObject){
        return new Entity()
                .setxSize(gameObject.getWidth())
                .setySize(gameObject.getHeight())
                .setxPosition(gameObject.getXPosition())
                .setyPosition(gameObject.getYPosition())
                .setType(gameObject);
    }
}
