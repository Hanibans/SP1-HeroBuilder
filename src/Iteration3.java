import java.util.ArrayList;

public class Iteration3 {
    //global variable is declared outside of functions,
    //making it accessible throughout the entire program
    //declaring and initializing variables
    String name = "Ragnar";
    int health = 85;
    int maxHealth = 100;
    int level = 5;
    int xp = 2300;
    int xpForNextLevel = 3000;
    double gold = 50.0;
    boolean isAlive = true;
    char classType = 'W';

    //ArrayList is like a flexible array (can add/remove items)
    ArrayList<String> inventory = new ArrayList<>();

    void main() {
        printCharacterSheet();

        takeDamage(30);
        heal(20);
        addXP(500);

        //checks if there's enough money to purchase an item using if-else
        if (removeGold(100.0)) {
            System.out.println("Bought a potion!");
        } else {
            System.out.println("Not enough gold!");
        }

        System.out.println("Health: " + getHealthPercentage() + "%");

        if (isHealthCritical()) {
            System.out.println("WARNING: Find a healer!");
        }

        System.out.println();
        printCharacterSheet();

        //UDFORDRING----------------------------
        //inventory section
        inventory.add("Sword");
        inventory.add("Shield");
        inventory.add("Potion");
        printInventory();

        System.out.println();
        addItem("Helmet"); //using own method to add item

        printInventory();
        System.out.println();

        //checks if player has a potion
        if (hasItem("Potion")) {
            System.out.println("You drink a potion!");
            removeItem("Potion");
        }

        printInventory();
        //-------------------------------------
    }

    //printing the characters information
    void printCharacterSheet() {
        System.out.println("=== CHARACTER SHEET ===");
        System.out.println("Name: " + name);

        //checking which class the character belongs to using if-else statements
        if (classType == 'W') {
            System.out.println("Class: " + classType + " (Warrior)");
        } else if (classType == 'M') {
            System.out.println("Class: " + classType + " (Mage)");
        } else if (classType == 'R') {
            System.out.println("Class: " + classType + " (Rogue)");
        } else {
            System.out.println("Class: Invalid!");
        }

        System.out.println("Level: " + level);
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("XP: " + xp);
        System.out.println("Gold: " + gold);
        System.out.println("Alive: " + isAlive); //prints the VARIABLE isAlive (not the method)
    }

    //damage system
    void takeDamage(int amount) {
        int oldHealth = health; //save old health before damage
        health -= amount; //subtract an amount of damage from health

        //prevent health going below 0
        if (health < 0) {
            health = 0;
        }

        System.out.println("\n" + name + " takes " + amount + " damage! Health: " + oldHealth + " -> " + health);

        //check if the character died
        if (!isAlive()) {
            System.out.println(name + " has died!");
        }
    }

    //healing system
    void heal(int amount) {
        int oldHealth = health; //save old health before healing
        health += amount; //adds an amount of healing to health

        //prevent healing above max health
        if (health > maxHealth) {
            health = maxHealth;
        }

        System.out.println(name + " heals " + amount + " HP! Health: " + oldHealth + " -> " + health);
    }

    //gold system
    void addGold(double amount) {
        gold += amount;
    }

    //returns true if purchase is successful
    boolean removeGold(double amount) {
        if (gold >= amount) {
            gold -= amount;
            return true; //purchase successful
        }
        return false; //not enough gold
    }

    //xp system
    void addXP(int amount) {
        xp += amount;
        System.out.println(name + " gains " + amount + " XP! Total: " + xp);

        //check if there's enough xp to level up
        if (xp >= xpForNextLevel) {
            levelUp();
        }
    }

    //level system
    void levelUp() {
        level++; //increase level
        xp = 0; //reset xp
        maxHealth += 20; //increase max health
        health = maxHealth; //fully heal

        System.out.println("LEVEL UP! " + name + " is now level " + level + "!");
    }

    //status check methods
    //returns true if health is below 25% of max health
    boolean isHealthCritical() {
        return health < (maxHealth *0.25);
    }

    //returns true if health is above 0
    boolean isAlive() {
        return health > 0;
    }

    //returns health as percentage
    double getHealthPercentage() {
        //(double) forces decimal division
        return ((double) health / maxHealth) * 100;
    }

    //inventory methods
    void printInventory() {

        //when using ArrayList, use .size() instead of .length, which is used in arrays
        System.out.println("\nInventory (" + inventory.size() + " items):");

        //using for-each loop makes it loop through all items
        for (String item : inventory) {
            System.out.println("- " + item);
        }
    }

    //UDFORDRING-------------------------------------------
    //adds items to inventory
    void addItem(String item) {
        inventory.add(item);
        System.out.println(item + " was added to inventory");
    }

    //removes item if it exists
    boolean removeItem(String item) {
        if (inventory.contains(item)) {
            inventory.remove(item);
            System.out.println(item + " was removed from inventory");
            return true;
        }
        System.out.println(item + " not found in inventory");
        return false;
    }

    //checks if the item exists
    boolean hasItem(String item) {
        return inventory.contains(item);
    }
    //----------------------------------------------
}
