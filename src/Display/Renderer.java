package Display;

import Display.Patcher.Patch;

import java.util.*;

public class Renderer {
    private ArrayList<ArrayList<String>> mainDisplay;

    private void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public Renderer() {
        this.setMainDisplay(new ArrayList<ArrayList<String>>());
        for (int rows = 0; rows < 18; rows++) {
            ArrayList<String> tmp = new ArrayList<String>();
            for (int columns = 0; columns < 75; columns++) {
                tmp.add(" ");
            }
            this.getMainDisplay().add(tmp);
        }
    }
    private void fullDraw() {
        this.clearScreen();
        for (ArrayList<String> row : this.getMainDisplay()) {
            String s = String.join("", row);
            System.out.println(s);
        }
    }

    public ArrayList<ArrayList<String>> getMainDisplay() {
        return mainDisplay;
    }

    public void setMainDisplay(ArrayList<ArrayList<String>> mainDisplay) {
        this.mainDisplay = mainDisplay;
    }

    public void showPatch(Patch patch){
            // !TODO
    }
    public void hidePatch(Patch patch){
        // !TODO
    }

    public ArrayList<Patch> movePatches(ArrayList<Patch> patches, int incrementX, int incrementY){
        // !TODO Increment all patches x, y distance
        return patches;
    }
}
