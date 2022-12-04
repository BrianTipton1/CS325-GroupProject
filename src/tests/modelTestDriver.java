package tests;// Caleb Bayles
// modelTestDriver.java
// 11/13/2022
// Tests the model classes (Game.Room, Game.Thing, Game.Player, Game.Wall, Game.Door)

import Game.*;

import java.util.ArrayList;

class ModelTestDriver {

    public static void main(String args[]) {

        ArrayList<Thing> allThings = new ArrayList<Thing>();
        ArrayList<Room> allRooms = new ArrayList<Room>();

        Player testPlayer = new Player(0);
        allThings.add(testPlayer);

        for (int i = 0; i < 2; i++) {
            allRooms.add(new Room(i));
            for (int j = 0; j < 2; j++) {
                allThings.add(new Door(j, i));
            }
            for (int j = 0; j < 2; j++) {
                allThings.add(new Wall(j, i));
            }
        }

        testPlayer.move(1, 20);
        testPlayer.move(3, 3);
        testPlayer.move(2, 1);

    }

}