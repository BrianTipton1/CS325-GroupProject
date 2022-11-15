package Display;


public class Entity {
    private static final String verticalWall = "|";
    private static final String horizontalWall = "-";
    private static final String wallCorner = "+";
    private static final String door = "$";
    private static enum User {
        NORTH {
            public String toString() {
                return "^";
            }
        },
        EAST {
            public String toString() {
                return ">";
            }
        },
        SOUTH {
            public String toString() {
                return "v";
            }
        },
        WEST {
            public String toString() {
                return "<";
            }
        },
        ;
    }
}
