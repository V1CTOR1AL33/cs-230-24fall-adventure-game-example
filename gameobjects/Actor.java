/*
 * Bitwise Books & Courses - sample Java code
 * http://www.bitwisebooks
 * http://www.bitwisecourses.com
 */

package gameobjects;

public class Actor {

    private Room room; // the Room where the Person is at present
    private Inventory things;
    private String name;
    private String desc;

    public Actor(String aName, String aDescription, Room aRoom) {
        this.name = aName;
        this.desc = aDescription;
        this.room = aRoom;
        things = new Inventory();
    }

    public void setRoom(Room aRoom) {
        this.room = aRoom;
    }

    public Room getRoom() {
        return this.room;
    }
    
    public void addToInventory(Treasure t) {
        things.add(t);
    }
    
    public void removeFromInventory(Treasure t){
        things.remove(t);
    }
    
    public Inventory getInventory(){
        return things;
    }
    
    public Treasure getTreasureFromInventory(String name){
        return things.thisOb(name);
    }
}
