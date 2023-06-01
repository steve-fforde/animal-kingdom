package helpers.vehicles;

import helpers.Console;

public class MilkFloat extends Vehicle {
    
    public int numBottles = 0;

    public MilkFloat(String location) {
        super("Electric", location);
        Console.note("MilkFloat(location:\"" + location + "\"): MilkFloat Contructor");
    }

    public void loadBottles(int numToLoad) {
        this.numBottles += numToLoad;
        Console.note("MilkFloat.loadBottles(numToLoad:" + numToLoad + "): Loaded " + numToLoad + " bottles, there are now " + numBottles + ".");
    }

    public void removeBottles(int numToRemove) {
        if (numToRemove > numBottles) throw new RuntimeException("There are not enough bottles left (" + numBottles + ") to remove " + numToRemove + " bottles.");
        this.numBottles -= numToRemove;
        Console.note("MilkFloat.removeBottles(numToRemove: " + numToRemove + "): Removed " + numToRemove + " bottles, there are now " + numBottles + ".");
    }

    public void describe() {
        super.describe();
        Console.Style.GREEN_BRIGHT.apply();
        Console.println(" Num bottles .. " + numBottles);
        Console.Style.RESET.apply();
    }

}
