package helpers.vehicles;

import helpers.Console;

public abstract class Vehicle {

    public String driver = "";
    public Engine engine;
    public String location;

    private Vehicle() { super(); }

    protected Vehicle(String fuelType, String location) {
        this();
        this.location = location;
        this.engine = new Engine(fuelType);
    }

    public void describe() {
        Console.println("Description:");
        Console.Style.GREEN_BRIGHT.apply();
        Console.println(" Class ........ " + this.getClass().getSimpleName());
        Console.println(" Driver ....... " + driver);
        Console.println(" Location ..... " + location);
        engine.describe();
        Console.Style.RESET.apply();
    }

    public void driveTo(String location) {
        if (driver.trim().equals("")) throw new RuntimeException("Cannot drive the vehicle as there is no driver.");
        engine.start();
        this.location = location;
        engine.stop();
    }

}
