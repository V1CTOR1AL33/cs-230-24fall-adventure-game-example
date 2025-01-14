package gameobjects;

import java.util.ArrayList;

/**
 * Write a description of class Inventory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Inventory extends ArrayList<Treasure>{

    public String toString() {
        String s = "";
        if (this.size() == 0) {
            s = "nothing.\n";
        } else {
            for (Treasure t : this) {
                s = s + t.getName() + ": " + t.getDescription() + "\n";
            }
        }
        return s;
    }
    
    public Treasure thisOb(String aName) {
        Treasure athing = null;
        String thingName = "";
        String aNameLowCase = aName.trim().toLowerCase();
        for (Treasure t : this) {
            thingName = t.getName().trim().toLowerCase();
            if (thingName.equals(aNameLowCase)) {
                athing = t;
            }
        }
        return athing;
    }
}
