import java.util.ArrayList;

class ModelTestDriver {

    public static void main(String args[]) {

        ArrayList<Thing> things = new ArrayList<Thing>();
        ArrayList<Room> rooms = new ArrayList<Room>();

        Player player = new Player(0);
        things.add(player);

        for (int i = 0; i < 2; i++) {
            rooms.add(new Room(i));
            for (int j = 0; j < 2; j++) {
                things.add(new Door(j, i));
            }
            for (int j = 0; j < 2; j++) {
                things.add(new Wall(j, i));
            }
        }

        player.move(1, 20);
        player.move(3, 3);
        player.move(2, 1);

    }

}