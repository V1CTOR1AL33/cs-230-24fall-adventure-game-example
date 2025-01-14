import gameobjects.Room;
import gameobjects.Treasure;
import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Treasure> inventory;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.inventory = new ArrayList<>();
    }
    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public void displayExits() {
        System.out.println(currentRoom.getExitsDescription());
    }

    public void move(String direction) {
        Room nextRoom = currentRoom.getExit(direction);
        if (nextRoom != null) {
            currentRoom = nextRoom;
            System.out.println("You moved to: " + currentRoom.getName());
        } 
        else {
            System.out.println("No exit in that direction.");
        }
    }

    public void takeItem(String itemName) {
        Treasure item = currentRoom.findTreasure(itemName);
        if (item != null) {
            inventory.add(item);
            currentRoom.removeTreasure(item.getName());
            System.out.println("You picked up: " + itemName);
        }
        else {
            System.out.println("No such item here.");
        }
    }

    public void useItem(String itemName) {
        Treasure item = null;
        for (Treasure t : inventory) {
            if (t.getName().equalsIgnoreCase(itemName)) {
                item = t;
                break;
            }
        }

        if (item == null) {
            System.out.println("You don't have that item.");
            return;
        }

        switch (itemName.toLowerCase()) {
            case "key":
                if (currentRoom.getName().equals("Professor Delcourt's Office")) {
                    currentRoom.getExit("forward").unlockRoom();
                    System.out.println("The HCI Lab is now unlocked.");
                } else {
                    System.out.println("Nothing happens.");
                }
                break;
            // Other item interactions here as per storyline
            default:
                System.out.println("Nothing happens.");
        }
    }
}
