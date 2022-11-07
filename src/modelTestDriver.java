import java.util.ArrayList;

class ModelTestDriver {

    public static void main(String args[]) {

        ArrayList<Thing> things = new ArrayList<Thing>();
        ArrayList<Room> rooms = new ArrayList<Room>();

        for (int i = 0; i < 2; i++) {
            rooms.add(new Room(i));
            for (int j = 0; j < 2; j++) {
                things.add(new Door(j, i));
            }
            for (int j = 0; j < 2; j++) {
                things.add(new Wall(j, i));
            }
            things.add(new Player(i));
        }

        for (int i = 0; i < things.size(); i++) {
            System.out.print(things.get(i).getClass());
            System.out.print(": ");
            System.out.print(things.get(i).getId());
            System.out.print("  Room: ");
            System.out.println(things.get(i).getRoomId());
        }

    }

}