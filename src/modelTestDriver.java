class modelTestDriver {

    public static void main(String args[]) {
        Room myRoom = new Room();
        Door myDoor = new Door();
        Player myPlayer = new Player();
        Wall myWall = new Wall();
        System.out.println("TESTING...");

        myRoom.toString();
        myDoor.toString();
        myPlayer.toString();
        myWall.toString();

    }

}