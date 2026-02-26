package Iteration4;

public class Armor {
    //instance fields
    String name;
    int defense;
    int durability;

    //making a constructor that gets called when creating a new armor
    Armor(String name, int defense, int durability) {
        this.name = name;
        this.defense = defense;
        this.durability = durability;
    }

    //converts the armor into a readable string for printing
    @Override
    public String toString() {
        return name + " (Defense: " + defense + ", Durability: " + durability + ")";
    }
}
