package helpers.vehicles;

import java.util.HashMap;
import java.util.Iterator;

import helpers.Console;

public class Van extends PassengerVehicle {
    
    private HashMap<String, Integer> cargo =  new HashMap<String, Integer>();

    public Van(int capacity, String fuelType, String location) {
        super (capacity, fuelType, location);
    }

    public void loadGoods(int qty, String goods) {
        int oldQty = 0;
        if (cargo.containsKey(goods)) oldQty = cargo.get(goods);
        cargo.put(goods, oldQty + qty);
    }

    public void unloadGoods(int qty, String goods) {
        int oldQty = 0;
        if (cargo.containsKey(goods)) oldQty = cargo.get(goods);
        if (qty > oldQty) throw new RuntimeException("You tried to unload " + qty + " of \"" + goods + "\" but there are only " + oldQty + " left.");
        cargo.put(goods, oldQty + qty);
    }

    public void describe() {
        super.describe();
        Console.Style.GREEN_BRIGHT.apply();
        Console.println(" Cargo:");
        Iterator<String> it = cargo.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            if (cargo.get(key) > 0) {
                Console.println("  -- " + cargo.get(key) + "x " + key );
            }
        }
        Console.Style.RESET.apply();

    }

}
