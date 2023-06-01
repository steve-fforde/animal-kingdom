package helpers.vehicles;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import helpers.Console;

public abstract class PassengerVehicle extends Vehicle {

    private List<String> seatMap;

    public PassengerVehicle(int capacity, String fuelType, String location) {
        super(fuelType, location);
        this.seatMap = Arrays.asList(new String[capacity]);
        Collections.fill(seatMap, "");
    }



    public int maxCapacity() {
        return seatMap.size();
    }

    public int countPassengers() {
        int count = 0;
        Iterator<String> it = seatMap.iterator();
        while (it.hasNext()) {
            if (!((String) it.next()).trim().equals("")) count++;
        }
        return count;
    }

    public String getPassenger(int seatNum) {
        if (seatNum > seatMap.size()) throw new RuntimeException("You asked who is at seat " + seatNum + " but there are only " + seatMap.size() + " seats.");
        if (seatNum <= 0) throw new IllegalArgumentException("You asked who is at seat " + seatNum + " but this is not a valid seat number.");
        return seatMap.get(seatNum - 1);
    }

    public String setPassenger(int seatNum, String passenger) {
        if (seatNum > seatMap.size()) throw new RuntimeException("You tried to set who is at seat " + seatNum + " but there are only " + seatMap.size() + " seats.");
        if (seatNum <= 0) throw new IllegalArgumentException("You tried to set who is at seat " + seatNum + " but this is not a valid seat number.");
        return seatMap.set(seatNum - 1, passenger);
    }

    public void describe() {
        super.describe();
        Console.Style.GREEN_BRIGHT.apply();
        Console.println(" Capacity ..... " + maxCapacity());
        Console.println(" Passengers ... " + countPassengers());
        Iterator<String> it = seatMap.iterator();
        int seatCount = 1;
        while (it.hasNext()) {
            String name = (String) it.next();
            if (!name.trim().equals("")) {
                Console.println("  -- Seat " + seatCount + ": " + name);
            }
            seatCount++;
        }
        Console.Style.RESET.apply();
    }


}
