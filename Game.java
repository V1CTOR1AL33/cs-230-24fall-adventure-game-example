import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        GameMap map = new GameMap();
        Player player = new Player(map.getStartRoom());
        Scanner scanner = new Scanner(System.in);
        String command;

        boolean tookCoffee = false;
        boolean visitedProfOffice = false;
        boolean hasKey = false;
        boolean enteredHciLab = false;
        boolean unlockedHciLab = false;
        boolean enteredLectureHall1 = false;
        boolean gotMapFragment = false;
        boolean paidLady = false;
        boolean warnedAboutLectureHall1 = false;
        boolean enteredLectureHall2 = false;
        boolean enteredFinalLBC = false;
        int coinsCollected = 0;
        
        System.out.println("Welcome to the game!\n");
        System.out.println("Commands: 'move [direction]', 'take [item]', 'use [item]', 'exit' to quit.\n");
        System.out.println("You are a CS 230 student, and your midterm is tomorrow. You have no idea \nwhat is going on in the course, and you decide to study until at least \nmidnight at the science center, even if you know that the science center \ncloses at midnight and staying over midnight is a violation of the honor \ncode. \n");
        
        boolean gameRunning = true;
        
        System.out.println("As you walk past the Leaky Beaker, you see a cup of coffee on the counter.\nDo you grab it? (yes/no)");
        command = scanner.nextLine().trim().toLowerCase();
        if (command.equals("yes")) {
            tookCoffee = true;
            System.out.println("You feel a bit more alert (thanks to the caffine) and head to the nook \nbeside your professor's office.");
        }
        else {
            System.out.println("You settle down in the nook beside your professor's office without caffeine\n and fall asleep...");
            System.out.println("You wake up at 10 am the next day, missing the exam.");
            System.out.println("**Bad Ending 1** – you’ve failed your midterm.");
            return;
        }
        
        System.out.println("\nAt 11 pm, you decided to take a 20-minute nap. But when you wake up, it's \n00:30am already. It's Halloween today, so everything is weird. It seems \nlike the science center building knew that you violated the honor code by \nstaying in the building after midnight, and it's giving you a punishment \nby not allowing you to leave the building. You might need to solve the \npuzzle and figure out how to leave. ");
        
        while (gameRunning) {
            System.out.println();
            System.out.println(player.getCurrentRoom());
            
            String currentRoom = player.getCurrentRoom().getName();
            
            switch (currentRoom) {
                case "Professor Delcourt's Office":
                    if (!visitedProfOffice) {
                        visitedProfOffice = true;
                        System.out.println("\"Professor Delcourt\" smiles at you, hinting at you about the key on her \ndesk. Maybe you wanna grab it. ");
                    }
                    break;

                case "HCI Lab":
                    if (hasKey && !unlockedHciLab) {
                        System.out.println("Please use Key to unlock the door");
                    }
                    if (unlockedHciLab) {
                        enteredHciLab = true;
                        System.out.println("The HCI lab reveals clues about the science center’s secrets. Going to \nLecture Hall 1 might be a good idea. ");
                    }
                    else if (!hasKey) {
                        System.out.println("The HCI Lab is locked. You need a key.");
                    }
                    break;

                case "Lecture Hall 1":
                    if (!warnedAboutLectureHall1) {
                        enteredLectureHall1 = true;
                        System.out.println("You notice strange statues and find a map fragment. You might need it. \nI lied. I did not implement Map Fragment. ");
                    }
                    else {
                        System.out.println("**Bad Ending 3** – Ignoring the warning, you return to Lecture Hall 1. The \nstatues come to life and trap you. You become one of them.");
                        gameRunning = false; 
                        break;
                    }
                    break;

                case "Lecture Hall 2":
                    enteredLectureHall2 = true;
                    if (!warnedAboutLectureHall1) {
                        System.out.println("**Bad Ending 2** – it's a chemistry professor's seminar, they are very mad \nat the fact that you intruded. They poisoned you to death. ");
                        gameRunning = false;
                    }
                    else {
                        System.out.println("Lecture Hall 2 is eerily quiet, but you notice a clue left behind by \nprevious students.");
                    }
                    break;

                case "Leaky Beaker Cafe":
                    if (enteredLectureHall2) { 
                        // figure out how to make user make decision
                        System.out.println("The truth is revealed!! It is actually not because you violated the honor \ncode of staying over midnight at science center so you get punished \n(because no one really cares whether or not you stay at science center \nlate) the truth is that, during the day, you grabbed a cup of coffee from \nleaky beaker because you did not know that coffee should be paid before \nthis (you are just a first-year student!) The lady is pretty mad at you so \nshe set up this trick and trap you inside science center until you figure \nout what you did. Fortunately, you still have three options: \n=> a. fight the lady\n=> b. pay the lady\n=> c. let me think twice! (no enough coins)");
                        System.out.println("Please indicate your choice. (a/b/c)");
                        command = scanner.nextLine().trim().toLowerCase();
                        if (command.equals("a")) {
                            System.out.println("**Bad Ending 4** - You decide to confront the lady. She reveals a sinister \npower, and you are expelled from the college in shame. ");
                            gameRunning = false;
                            continue;
                        }
                        else if (command.equals("b")) {
                            if (coinsCollected >= 5) {
                                System.out.println("The lady smiles as you pay her with coins, allowing you to leave.");
                                System.out.println("**Happy Ending** - You exit the science center with an eerie feeling that it hasn’t let go entirely. ");
                                gameRunning = false; 
                            }
                            else {
                                System.out.println("You do not have enough coins! The lady warns you about breaking rules without payment. You’ll need coins to leave.");
                            }
                        }
                    }
                    else if (enteredLectureHall1) {
                        System.out.println("The lady mentions that the seminar should be over now, so you may go to \nLecture Hall 2 now, but you may not want to go back to Lecture Hall 1. \nYou should trust her. ");
                        warnedAboutLectureHall1 = true;
                    }
                    else {
                        System.out.println("The lady mentions to you that there's a seminar going on in Lecture Hall \n2 (it's the lecture hall on the right), so you may not want to intrude. ");
                    }
                    break;
            }
            
            if (!gameRunning) {
                System.out.print("THE END. ");
                break;
            }
            
            System.out.print("Enter command: ");
            command = scanner.nextLine().trim().toLowerCase();
            
            if (command.equals("exit")) {
                System.out.println("Exiting game...");
                break;
            }
            else if (command.startsWith("move")) {
                player.move(command.split(" ")[1]);
            }
            else if (command.startsWith("take")) {
                String itemName = command.substring(5);

                if (itemName.equalsIgnoreCase("Key") && player.getCurrentRoom().getName().equals("Professor Delcourt's Office") && !player.getCurrentRoom().findTreasure("Key").equals(null)) {
                    hasKey = true;
                    player.takeItem("Key");
                }
                else if (itemName.equalsIgnoreCase("Coin") && !player.getCurrentRoom().findTreasure("Coin").equals(null)) {
                    coinsCollected++;
                    player.takeItem("Coin");
                    System.out.println("Coin collected. You now have " + coinsCollected + " coin(s).");
                }
                else if (itemName.equalsIgnoreCase("Map Fragment")) {
                    gotMapFragment = true;
                }
                else {
                    System.out.println("Please take a valid item. ");
                }
            }
            else if (command.startsWith("use")) {
                String itemName = command.substring(4).trim();

                if (itemName.equalsIgnoreCase("Coin") && player.getCurrentRoom().getName().equals("Leaky Beaker Cafe")) {
                    if (coinsCollected >= 5) {
                        paidLady = true;
                        coinsCollected -= 5;
                        System.out.println("You paid the lady with 5 coins.");
                    }
                    else {
                        System.out.println("You don't have enough coins to pay the lady.");
                    }
                }
                
                if (itemName.equalsIgnoreCase("Key") && hasKey) {
                    unlockedHciLab = true;
                    player.getCurrentRoom().unlockRoom();
                    System.out.println("HCI lab is now open. ");
                }
                else if (itemName.equalsIgnoreCase("Key") && !hasKey) {
                    System.out.println("You do not have the Key. ");
                }
            }
            else {
                System.out.println("Please enter a valid command. ");
            }
        }
        
        scanner.close();
    }
}
