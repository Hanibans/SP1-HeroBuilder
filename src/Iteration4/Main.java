package Iteration4;

import java.util.Random;

public class Main {
    void main() {
        //create the hero character
        Character hero = new Character("Ragnar", 'W');

        //add a health potion to the hero's inventory
        hero.addItem(new Item("Health Potion",0.5,100));

        //create a weapon and armor
        Weapon sword = new Weapon("Iron Sword", 15, 5);
        Armor armor = new Armor("Steel Armor",20 , 4);

        //equip the hero with the weapon and armor
        hero.equipWeapon(sword);
        hero.equipArmor(armor);

        System.out.println();

        Random random = new Random(); //gold drops are different every game

        //create the enemy character
        Character goblin = new Character("Goblin", 'R');
        Character orc = new Character("Orc", 'W');

        //random gold between 20-89
        goblin.gold = random.nextInt(70) + 20;;
        orc.gold = random.nextInt(70) + 20;;

        //stores enemies in an array for easier looping
        Character[] enemies = {goblin, orc};

        hero.printCharacterSheet(); //shows the hero's stats

        //shows all the enemies stats
        for (Character enemy : enemies)
            enemy.printCharacterSheet();

        //=== dungeon simulation ===
        //loop through each enemy one by one
        for (Character enemy : enemies) {

            //track if the hero has used a health potion this fight
            boolean potionUsed = false;

            System.out.println("\n=== Encounter: " + enemy.name + " ===");

            //the fight continues while both are alive using while loop
            while (hero.isAlive() && enemy.isAlive()) {

                hero.attack(enemy); //hero attacks the enemy

                if (enemy.isAlive()) {
                    enemy.attack(hero); //enemy attacks back if it's still alive
                }

                //checks if the hero's health is low and a health potion hasn't been used yet
                if (hero.isLowHealth() && !potionUsed) {
                    hero.useHealthPotion(); //if true, the hero uses a health potion
                    potionUsed = true; //only allow one potion per fight
                }
            }

            //after the fight ends
            if (hero.isAlive()) {
                System.out.println(hero.name + " defeated " + enemy.name + "!");
                hero.addGold(enemy.gold); //the hero gains gold if it successfully wins
                enemy.gold = 0; //enemy drops all gold
                System.out.println();
            } else {
                System.out.println(hero.name + " was defeated in the dungeon!");
                break; //the dungeon simulation ends if the hero dies
            }
        }

        hero.printCharacterSheet(); //shows the final stats for the hero

        //shows the final stats for all enemies
        for (Character enemy : enemies) {
            enemy.printCharacterSheet();
        }
    }
}


