# Week 2

## Using classes

Vehicle classes

```mermaid
classDiagram

    class Vehicle{
        <<Abstract>>
        String driver
        Engine engine
        String location
        Vehicle(String fuelType, String location)$
        String describe()
        void driveTo(String location)
    }
    class Engine{
        String fuelType
        boolean isRunning
        Engine(String fuelType)$
        void describe()
        void start()
        void stop()
    }
    class MilkFloat{
        int numBottles
        MilkFloat(String location)$
        void loadBottles(int numToLoad)
        void removeBottles(int numToRemove)
        }
    class PassengerVehicle{
        <<Abstract>>
        PassengerVehicle(int capacity, String fuelType, String location)$
        int maxCapacity()
        int countPassengers()
        String getPassenger(int seatNum)
        void setPassenger(int seatNum, String passenger)
    }
    class Car{
        
    }
    class Van{
        loadGoods(int qty, String goods)
        unloadGoods(int qty, String goods)
    }
    Vehicle *-- Engine : has a
    Vehicle <|-- MilkFloat : is a
    Vehicle <|-- PassengerVehicle : is a
    PassengerVehicle <|-- Car : is a
    PassengerVehicle <|-- Van : is a

   ```
