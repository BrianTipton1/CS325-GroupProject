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

    private boolean playerCanKeepStepping(int x, int y) {
        /*if () { // IF WALL ON THAT SPOT
            return false;
        } else if () { // IF DOOR ON THAT SPOT AND DOOR CLOSED
            return false;
        } else {
        return true;
        }*/
        return true;
    }

    public void move(int direction, int distance) {

        for (int i = 0; i < distance; i++) {

            if (direction == 1) { // LEFT
                if (playerCanKeepStepping(xPosition - 1, yPosition)) {
                    xPosition--;
                }
            } else if (direction == 2) { // RIGHT
                if (playerCanKeepStepping(xPosition + 1, yPosition)) {
                    xPosition++;
                }
            } else if (direction == 3) { // UP
                if (playerCanKeepStepping(xPosition, yPosition - 1)) {
                    yPosition--;
                }
            } else if (direction == 4) { // DOWN
                if (playerCanKeepStepping(xPosition, yPosition + 1)) {
                    yPosition++;
                }
            }

            //DEBUGGING
            /*System.out.print(xPosition);
            System.out.print(", ");
            System.out.println(yPosition);
            */
        }

    }

}