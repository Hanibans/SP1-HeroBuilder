package Iteration4;

public class Weapon {
    //instance fields
    String name;
    int damage;
    int durability;

    //making a constructor that gets called when creating a new weapon
    Weapon(String name, int damage, int durability) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
    }

    //converts the weapon into a readable string for printing
    @Override
    public String toString() {
        return name + " (Damage: " + damage + ", Durability: " + durability + ")";
    }
}
