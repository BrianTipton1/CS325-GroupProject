import Display.Renderer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Renderer r = new Renderer();
       System.out.println("");
        for (ArrayList<String> row : r.mainDisplay) {
            String s = String.join("",row);
            System.out.println(s);
        }
    }
}