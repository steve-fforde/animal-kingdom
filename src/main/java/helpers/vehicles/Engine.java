package helpers.vehicles;

import helpers.Console;

public class Engine {

    public String fuelType;
    boolean isRunning = false;

    private Engine() { super(); }

    protected Engine(String fuelType) {
        this();
        this.fuelType = fuelType;
    }

    public void describe() {
        Console.Style.GREEN_BRIGHT.apply();
        Console.println(" Is running? .. " + isRunning);
        Console.println(" Fuel type .... " + fuelType);
        Console.Style.RESET.apply();
    }

    public void start() {
        if (isRunning) throw new RuntimeException("Cannot start as the engine it is already running.");
        isRunning = true;
    }
    
    public void stop() {
        if (!isRunning) throw new RuntimeException("Cannot stop as the engine it is not running.");
        isRunning = false;
    }
}
