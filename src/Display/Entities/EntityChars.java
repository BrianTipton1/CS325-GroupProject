package Display.Entities;


public class EntityChars {
    public static final String verticalWall = "|";
    public static final String horizontalWall = "-";
    public static final String wallCorner = "+";
    public static final String door = "$";
    public static enum User {
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
