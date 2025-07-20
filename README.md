```mermaid
classDiagram
    class ParkingLot {
        +List~Level~ levels
        +addLevel(Level)
    }

    class Level {
        +String id
        +List~Spot~ spots
        +DisplayBoard displayBoard
        +addSpots(List~Spot~)
        +removeSpot(Spot)
    }

    class Spot {
        +String id
        +Level level
        +SpotType spotType
        +boolean isEmpty
    }

    class SpotManager {
        +List~Observer~ observers
        +List~Level~ levels
        +SpotAllocationStrategy strategy
        +getEmptySpot(VehicleType): Spot
        +blockSpot(Spot)
        +freeUpSpot(Spot)
        +registerObserver(Observer)
        +removeObserver(Observer)
        +notifyObservers(levelId, spotType, availableSpots)
    }

    class Observer {
        <<interface>>
        +update(levelId, spotType, availableSpots)
    }

    class DisplayBoard {
        +update(levelId, spotType, availableSpots)
    }

    class SpotAllocationStrategy {
        <<interface>>
        +assignSpot(List~Level~, VehicleType): Spot
    }

    class EntryService {
        +createTicket(Vehicle): Ticket
    }

    class ExitService {
        +getFare(Ticket): double
        +acceptPayment(fare)
    }

    class Ticket {
        +String id
        +Date entryTime
        +Vehicle vehicle
        +Spot spot
    }

    class Vehicle {
        +String vehicleNumber
        +VehicleType vehicleType
    }

    class FeeCalculationStrategy {
        <<interface>>
        +calculateFare(Ticket): double
    }

    class PaymentProcessor {
        <<interface>>
        +processPayment(fare)
    }

    ParkingLot --> Level
    Level --> Spot
    Level --> DisplayBoard
    SpotManager --> Level
    SpotManager --> SpotAllocationStrategy
    SpotManager --> Observer
    Observer <|.. DisplayBoard
    EntryService --> SpotManager
    ExitService --> FeeCalculationStrategy
    ExitService --> PaymentProcessor
    Ticket --> Vehicle
    Ticket --> Spot
