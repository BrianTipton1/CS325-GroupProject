package Display.Patcher;

import Display.Entities.Entity;

public class PatchFactory {
    public static Patch createPatch(Entity entity, int xCord, int yCord) {
        return new Patch(xCord, yCord)
                .setxSize(entity.getxSize())
                .setySize(entity.getxSize())
                .sizePatch();
    }
}
