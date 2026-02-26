public class Iteration1 {
    void main() {
        //=== character 1 ===
        //declaring and initializing variables for character 1
        String name1 = "Ragnar";
        int health1 = 85;
        int maxHealth1 = 100;
        int level1 = 5;
        int xp1 = 2300;
        double gold1 = 156.50;
        boolean isAlive1 = true;
        char classType1 = 'W';

        //printing character 1's information
        System.out.println("=== CHARACTER 1 SHEET ===");
        System.out.println("Name: " + name1);
        System.out.println("Class: " + classType1);
        System.out.println("Level: " + level1);
        System.out.println("Health: " + health1 + "/" + maxHealth1);
        System.out.println("XP: " + xp1);
        System.out.println("Gold: " + gold1);
        System.out.println("Alive: " + isAlive1);

        //creating an array of items for character 1's inventory
        String[] inventory1 = {"Sword", "Shield", "Potion"};

        //printing how many items are in the inventory using .length
        System.out.println("\nInventory (" + inventory1.length + " items):");

        //printing each item using its index (Arrays start at index 0)
        System.out.println("- " + inventory1[0]);
        System.out.println("- " + inventory1[1]);
        System.out.println("- " + inventory1[2]);


        //UDFORDRING-------------------------------------------------
        //=== character 2 ===
        //declaring and initializing variables for character 2
        String name2 = "Eloria";
        int health2 = 60;
        int maxHealth2 = 80;
        int level2 = 4;
        int xp2 = 1500;
        double gold2 = 89.99;
        boolean isAlive2 = true;
        char classType2 = 'M';

        //printing character 2's information
        System.out.println("-----------------------------");
        System.out.println("=== CHARACTER 2 SHEET ===");
        System.out.println("Name: " + name2);
        System.out.println("Class: " + classType2);
        System.out.println("Level: " + level2);
        System.out.println("Health: " + health2 + "/" + maxHealth2);
        System.out.println("XP: " + xp2);
        System.out.println("Gold: " + gold2);
        System.out.println("Alive: " + isAlive2);

        //creating an array of items for character 2's inventory
        String[] inventory2 = {"Staff", "Spellbook", "Mana Potion", "Health Potion"};

        //printing inventory size using .length
        System.out.println("\nInventory (" + inventory2.length + " items):");

        //printing each item using its index (Arrays start at index 0)
        System.out.println("- " + inventory2[0]);
        System.out.println("- " + inventory2[1]);
        System.out.println("- " + inventory2[2]);
        System.out.println("- " + inventory2[3]);
        //--------------------------------------------------------------
    }
}