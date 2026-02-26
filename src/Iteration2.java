import java.util.Random;

public class Iteration2 {
    void main() {
        //declaring and initializing variables for the character
        String name = "Ragnar";
        int health = 85;
        int maxHealth = 100;
        int level = 5;
        int xp = 5100;
        double gold = 156.50;
        boolean isAlive = true;
        char classType = 'W';

        //printing the characters information
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
        System.out.println("Alive: " + isAlive);

        //creating an array of items for the characters inventory
        String[] inventory = {"Sword", "Shield", "Potion"};

        //printing how many items are in the inventory using .length
        System.out.println("\nInventory (" + inventory.length + " items):");

        //using for-each loop makes this automatically go through every item in the array
        for (String item : inventory) {
            System.out.println("- " + item);
        }

        System.out.println("\n=== STATUS ===");

        //check if health is below 25% of max health
        if (health < (0.25 * maxHealth)) {
            System.out.println("WARNING: Health critical!");
        }

        //if health is 0 or below, character dies
        if (health <= 0) {
            isAlive = false;
        }

        //check if xp is enough to level up (example: 1000 xp per level)
        if (xp > (1000 * level)) {
            System.out.println("Ready to level up!");
        }

        System.out.println("\n=== COMBAT ===");
        int damage = 30;
        int oldHealth = health; //save old health before damage
        System.out.println(name + " takes " + damage + " damage!");
        health -= damage; //subtract damage from health

        //show health before and after damage
        System.out.println("Health: " + oldHealth + " -> " + health);

        //chack if character is alive
        if (isAlive) {
            System.out.println(name + " is still alive.");
        } else {
            System.out.println(name + " is dead.");
        }

        //UDFORDING---------------------------------------------
        int maxRounds = 5; //number of combat rounds
        int round = 1; //starting round number

        //creating random object to generate random damage
        Random random = new Random();

        System.out.println("\n=== MULTI ROUND COMBAT ===");

        //using while loop makes the code run as long as the character is alive
        //AND we haven't reached max rounds
        while (isAlive && round <= maxRounds) {

            System.out.println("\n-- Round " + round + " --");

            //generate random damage between 0 and 24
            int incomingDamage = random.nextInt(25);
            int oldHealth1 = health; //store health before damage
            System.out.println(name + " takes " + incomingDamage + " damage!");

            //apply damage
            health -= incomingDamage;

            //if health drops to 0 or below, the character dies
            if (health <= 0) {
                health = 0; //prevent negative health
                isAlive = false;
            }

            //show health change
            System.out.println("Health: " + oldHealth1 + " -> " + health);

            //warning if health is below 25% but still alive
            if (health > 0 && health < (0.25 * maxHealth)) {
                System.out.println("WARNING: Health critical!");
            }

            //if dead, stop the loop immediately
            if (!isAlive) {
                System.out.println(name + " has fallen in battle!");
                break;
            }

            round++; //move to next round
        }

        //if character survived all rounds
        if (isAlive) {
            System.out.println("\n" + name + " survived all " + maxRounds + " rounds and won the battle!");
        }
        //-----------------------------------------------------------
    }
}