import gameobjects.Room;
import gameobjects.Treasure;

import java.util.*;

public class GameMap {
    private Room start, profDelcourtOffice, hciLab, leakyBeaker, middleOfNowhere, lectureHall1, lectureHall2;

    public GameMap() {
        createRooms();
        defineExits();
    }
    
    private void createRooms() {
        start = new Room("The Nook", "It’s 12:00 am. You passed the legal staying time at Sci. Now the building \nis angry at you for violating the Honor Code. You need to find a way to \nescape. ");
        profDelcourtOffice = new Room("Professor Delcourt's Office", "It's so odd. Professor Delcourt is still in her office over midnight(?).  \nThe board on her office now says she is having office hour right now. Is \nthis the real Professor Delcourt? Who knows. but at least \"Professor \nDelcourt\" is showing kindness and willingness to help you out with \nanything when you need. ");
        hciLab = new Room("HCI Lab", "A fancy lab that you always wanted to join. ");
        leakyBeaker = new Room("Leaky Beaker Cafe", "The lady at the counter greets you. ");
        middleOfNowhere = new Room("Middle of Nowhere", "It's the Innovation Hub (if you'd like to call it this way). ");
        lectureHall1 = new Room("Lecture Hall 1", "Lifeless statues fill the hall.");
        lectureHall2 = new Room("Lecture Hall 2", "Silent, dark and ominous.");
        
        hciLab.lockRoom();
        
        // Placing items
        profDelcourtOffice.addTreasure(new Treasure("Key", "A key to the HCI Lab."));
        profDelcourtOffice.addTreasure(new Treasure("Coin", "A shiny coin."));
        // wanted to add but too lazy to implement
        // hciLab.addTreasure(new Treasure("USB Drive", "Contains 'Science Center’s Secrets'."));
        hciLab.addTreasure(new Treasure("Coin", "A shiny coin."));
        lectureHall1.addTreasure(new Treasure("Map Fragment", "Clue for navigating the science center."));
        lectureHall1.addTreasure(new Treasure("Coin", "Another shiny coin"));
        lectureHall2.addTreasure(new Treasure("Coin", "A shiny coin."));
        // wanted to add but too lazy to implement
        // leakyBeaker.addTreasure(new Treasure("Sandwich", "Looks edible."));
        // wanted to add but too lazy to implement, this could be something that harms the player
        // leakyBeaker.addTreasure(new Treasure("Mystery Drink", "Could be useful or harmful."));
        leakyBeaker.addTreasure(new Treasure("Coin", "A shiny coin."));
    }
    
    private void defineExits() {
        start.setExit("right", profDelcourtOffice);
        profDelcourtOffice.setExit("forward", hciLab);
        profDelcourtOffice.setExit("backward", start);
        hciLab.setExit("backward", profDelcourtOffice);
        hciLab.setExit("forward", leakyBeaker);
        leakyBeaker.setExit("forward", middleOfNowhere);
        leakyBeaker.setExit("backward", hciLab);
        middleOfNowhere.setExit("left", lectureHall1);
        middleOfNowhere.setExit("right", lectureHall2);
        middleOfNowhere.setExit("backward", leakyBeaker);
        lectureHall1.setExit("backward", middleOfNowhere);
        lectureHall2.setExit("backward", middleOfNowhere);
    }
    
    public Room getStartRoom() {
        return start;
    }
}
