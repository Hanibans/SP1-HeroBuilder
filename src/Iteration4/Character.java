package Iteration4;

import java.util.ArrayList;
import java.util.Random;

public class Character {
    //all variables become instance fields
    String name;
    char classType;
    int level;
    int health;
    int maxHealth;
    double gold;
    ArrayList<Item> inventory;
    Weapon equippedWeapon;
    Armor equippedArmor;

    //making a constructor that gets called when creating a new character
    Character(String name, char classType) {
        this.name = name;
        this.classType = classType;
        this.level = 1;
        this.maxHealth = 100;
        this.health = maxHealth;
        this.gold = 0.0;
        this.inventory = new ArrayList<>();
    }

    //returns true if health is above 0
    boolean isAlive() {
        return health > 0;
    }

    //printing the characters information
    void printCharacterSheet() {
        //convert the single-letter (char) class into a String using a switch case
        String className = "";
        switch (classType) {
            case 'W':
                className = "Warrior";
                break;
            case 'M':
                className = "Mage";
                break;
            case 'R':
                className = "Rogue";
                break;
            default:
                className = "Unknown";
                break;
        }
        System.out.println("=== " + name.toUpperCase() + " (" + className + ") ===");
        System.out.println("Level: " + level + " | Health: " + health + "/" + maxHealth + " | Gold: " + gold);

        //shows current equipped weapon
        System.out.println("Weapon: " + (equippedWeapon != null ? equippedWeapon : "None"));

        //syntax: condition ? valueIfTrue : valueIfFalse

        //shows current equipped armor
        System.out.println("Armor: " + (equippedArmor != null ? equippedArmor : "None"));

        System.out.println();
    }

    //healing system
    void heal(int amount) {
        int oldHealth = health;
        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }

        System.out.println(name + " heals " + amount + " HP! Health: " + oldHealth + " -> " + health);
    }

    //damage taken system
    void takeDamage(int amount) {
        int defense = 0;

        //if armor is equipped, use its defense value and reduce durability
        if (equippedArmor != null) {
            defense = equippedArmor.defense;
            equippedArmor.durability--; //armor weakens with each hit
        }

        //damage can't be less than 0
        int actualDamage = Math.max(amount - defense, 0);

        int oldHealth = health;
        health -= actualDamage;

        //prevent negative health
        if (health < 0) {
            health = 0;
        }

        System.out.println(name + " takes " + actualDamage + " damage! Health: " + oldHealth + " -> " + health);

        //if armor breaks, remove it
        if (equippedArmor != null && equippedArmor.durability <= 0) {
            System.out.println(equippedArmor.name + " broke!");
            equippedArmor = null;
        }

        //checks if the character has died
        if (!isAlive()) {
            System.out.println(name + " has died!");
        }

        System.out.println();
    }

    //attack system
    void attack(Character enemy) {
        Random random = new Random(); //attack points are different every game
        int baseDamage;

        //if a weapon is equipped, use its damage and reduce durability
        if (equippedWeapon != null) {
            baseDamage = equippedWeapon.damage;
            equippedWeapon.durability--;
        } else {
            baseDamage = 5; //default unequipped damage
        }

        //adds a random number to damage (random number + 5 (base number))
        int damage = random.nextInt(6) + baseDamage;

        System.out.println(name + " attacks " + enemy.name + " for " + damage + " damage!");
        enemy.takeDamage(damage);

        //if weapon breaks, remove it
        if (equippedWeapon != null && equippedWeapon.durability <= 0) {
            System.out.println(equippedWeapon.name + " broke!");
            equippedWeapon = null;
        }
    }

    //gold system
    void addGold(double amount) {
        gold += amount;
        System.out.println(name + " receives " + amount + " gold!");
    }

    //health check
    boolean isLowHealth() {
        return health <= maxHealth * 0.25; //true if health is 25% or lower
    }

    //method for using a health potion
    void useHealthPotion() {
        //if a health potion exists in inventory, heal then remove it
        if (removeItem("Health Potion")) {
            System.out.println(name + " used a Health Potion!");
            heal(30);
            System.out.println("Health Potion was removed from inventory.");
        } else {
            //if a health potion don't exist, then there's no healing
            System.out.println(name + " has no Health Potion!");
        }
        System.out.println();
    }

    //adds an item in the inventory
    void addItem(Item item) {
        inventory.add(item);
        System.out.println(name + " acquired " + item.name + "!");
    }

    //removes an item in the inventory
    public boolean removeItem(String itemName) {
        //search the inventory for an item with a matching name
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).name.equalsIgnoreCase(itemName)) {
                inventory.remove(i);
                return true; //item successfully removed
            }
        }
        return false; //item not found
    }

    //when the hero equips a weapon
    void equipWeapon(Weapon weapon) {
        equippedWeapon = weapon;
        System.out.println(name + " equips weapon: " + weapon.name);
    }

    //when the hero equips armor
    void equipArmor(Armor armor) {
        equippedArmor = armor;
        System.out.println(name + " equips armor: " + armor.name);
    }
}
