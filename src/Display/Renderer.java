package Display;

import java.util.*;

public class Renderer {
    public ArrayList<ArrayList<String>> mainDisplay;


    public Renderer() {
        this.mainDisplay = new ArrayList<ArrayList<String>>();
        for (int rows = 0; rows < 18; rows++) {
            ArrayList<String> tmp = new ArrayList<String>();
            for (int columns = 0; columns < 75; columns++) {
                tmp.add(" ");
            }
            this.mainDisplay.add(tmp);
        }
    }

    private void Draw() {
        for (ArrayList<String> row : this.mainDisplay) {
            String s = String.join("", row);
            System.out.println(s);
        }
    }
}
