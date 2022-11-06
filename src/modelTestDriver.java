class ModelTestDriver {

    public static void main(String args[]) {
        Room myRoom = new Room(1);
        Door myDoor = new Door(1, 1);
        Player myPlayer = new Player(1, 1);
        Wall myWall = new Wall(1, 1);

        System.out.println(myRoom.getId());
        System.out.println(myDoor.getId());
        System.out.println(myPlayer.getId());
        System.out.println(myWall.getId());

    }
    
}