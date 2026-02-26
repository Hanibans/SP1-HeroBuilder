package Iteration4;

public class Item {
    //instance fields
    String name;
    double weight;
    double value;

    //making a constructor that gets called when creating a new item
    Item(String name, double weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    //converts the item into a readable string for printing
    @Override
    public String toString() {
        return name + " (Weight: " + weight + ", Value: " + value + ")";
    }
}
