package Display;

import Display.Patcher.Patch;

import java.util.*;

public class Renderer {
    private ArrayList<ArrayList<String>> mainDisplay;

    private void clearScreen() {
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

    public void showPatch(Patch patch) {
        // !TODO
        int x = patch.getxCord();
        int y = patch.getyCord();
        int xSize = patch.getxSize();
        int ySize = patch.getySize();
        for (int row = x; row < xSize; row++) {
            for (int column = y; column < ySize; column++) {
                this.getMainDisplay()
                        .get(row);
//                        .set(column, patch.getEntity().type.toString());
            }
        }
    }

    public void hidePatch(Patch patch) {
        // !TODO needs testing still
        int x = patch.getxCord();
        int y = patch.getyCord();
        int xSize = patch.getxSize();
        int ySize = patch.getySize();
        for (int row = x; row < xSize; row++) {
            for (int column = y; column < ySize; column++) {
                this.getMainDisplay()
                        .get(row)
                        .set(column, " ");
            }
        }
    }

    public ArrayList<Patch> movePatches(ArrayList<Patch> patches, int incrementX, int incrementY) {
        for (Patch patch :
                patches) {
            patch.setxSize(patch.getxSize() + incrementX);
            patch.setySize(patch.getySize() + incrementY);
        }
        return patches;
    }
}
