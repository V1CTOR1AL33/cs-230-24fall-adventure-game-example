package gameobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private ArrayList<Treasure> items;
    private Map<String, Room> exits;
    private boolean isLocked = false; // for locked rooms like HCI Lab
    
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.exits = new HashMap<>();
    }
    
    public String getName(){
        return name;
    }
    
    public String getDescription(){
        return description;
    }
    
    public ArrayList<Treasure> getThings(){
        return items;
    }

    public void addTreasure(Treasure t) {
        items.add(t);
    }

    public void removeTreasure(String treasureName) {
        Treasure toRemove = null;
        for (Treasure t : items) {
            if (t.getName().equals(treasureName)) {
                toRemove = t;
                break;
            }
        }
        if (toRemove != null) {
            items.remove(toRemove);
        }
    }

    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void lockRoom() {
        this.isLocked = true;
    }

    public void unlockRoom() {
        this.isLocked = false;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public Treasure findTreasure(String objname){
        for(Treasure t: items){
            if(t.getName().equals(objname)){
                return t;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder s;
        if (isLocked()) {
            s = new StringBuilder(name + ": ");
            s.append("\nAvailable Exits: ").append(exits.keySet());
        }
        else {
            s = new StringBuilder(name + ": \n" + description + "\nItems: ");
            for (Treasure item : items) s.append(item.getName()).append(" ");
            s.append("\nAvailable Exits: ").append(exits.keySet());
        }
        return s.toString();
    }
    
    public String getExitsDescription() {
        StringBuilder description = new StringBuilder("Available exits: ");
        for (String direction : exits.keySet()) {
            description.append(direction).append(" ");
        }
        return description.toString().trim();
    }
    
    public List<String> getPrioritizedExits() {
        PriorityQueue<String> prioritizedExits = new PriorityQueue<>((exit1, exit2) -> {
            if (exits.get(exit1).isLocked() && !exits.get(exit2).isLocked()) {
                return 1;
            }
            else if (!exits.get(exit1).isLocked() && exits.get(exit2).isLocked()) {
                return -1;
            }
            else {
                return 0;
            }
        });
        prioritizedExits.addAll(exits.keySet());
        
        return new ArrayList<>(prioritizedExits);
    }
}
