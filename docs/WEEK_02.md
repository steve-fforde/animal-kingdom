# Week 2

## Using classes

Vehicle classes

```mermaid
classDiagram
    class Vehicle{
        <<abstract>>
        Driver driver
        void moveTo(Location)
    }
    class Engine{
        <<concrete>>
        String vinNumber
        FuelType fuelType
        boolean turnover()
    }
    class MilkFloat{
        <<concrete>>
        bottleCount
        loadBottles()
        removeBottles()
        }
    class PassengerVehicle{
        <<abstract>>
        Passenger[] passenger
        int maxCapacity
        int countPassengers()
    }
    class Car{
        <<concrete>>
    }
    class Van{
        <<concrete>>
    }
    Vehicle *-- Driver
    Vehicle *-- Engine
    Vehicle <|-- MilkFloat
    Vehicle <|-- PassengerVehicle
    PassengerVehicle *-- Passenger
    PassengerVehicle <|-- Car
    PassengerVehicle <|-- Van
   ```

   Person classes


   ```mermaid
classDiagram
    class Person{
        <<abstract>>
        Vehicle[] owns
    }
    class Passenger{
        <<concrete>>
    }
    class Driver{
        <<concrete>>
        hasLicense
        getOut()
    }
    Person <|-- Passenger
    Person <|-- Driver
    Person *-- Vehicle
   ```