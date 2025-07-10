```mermaid
classDiagram
    class ParkingLot {
        - List~Level~ levels
        - SpotAllocator allocator
        - PricingStrategy pricingStrategy
        - PaymentProcessor paymentProcessor
        - Map~String, Ticket~ activeTickets
        + parkVehicle(v: Vehicle): Ticket
        + unParkVehicle(ticketId: String): double
    }

    class Level {
        - int floor
        - List~ParkingSpot~ spots
        + isFull(): boolean
        + getAvailableSpots(type: SpotType): int
    }

    class ParkingSpot {
        - String id
        - SpotType type
        - SpotStatus status
        - Vehicle parkedVehicle
        + assignVehicle(v: Vehicle)
        + removeVehicle()
    }

    class Vehicle {
        - String licenseNumber
        - SpotType type
    }
    class Car
    class MotorBike

    class Ticket {
        - String ticketId
        - Vehicle vehicle
        - ParkingSpot spot
        - LocalDateTime entryTime
        - LocalDateTime exitTime
        + calculateFee(): double
    }

    class TicketFactory {
        + createTicket(v: Vehicle, spot: ParkingSpot): Ticket
    }

    class PricingStrategy {
        <<interface>>
        + calculateFee(t: Ticket): double
    }
    class HourBasisPricingStrategy

    class PaymentProcessor {
        <<interface>>
        + processPayment(amount: double): boolean
    }
    class CashPaymentProcessor
    class CardPaymentProcessor

    class SpotAllocator {
        <<interface>>
        + allocateSpot(levels: Level[], v: Vehicle): ParkingSpot
    }
    class NearestFirstAllocator

    class SpotType {
        <<enumeration>>
        MOTORBIKE
        CAR
        TRUCK
    }
    class SpotStatus {
        <<enumeration>>
        FREE
        OCCUPIED
    }

    %% relationships %%
    ParkingLot "1" *-- "*" Level
    Level "1" *-- "*" ParkingSpot
    ParkingSpot "1" o-- "0..1" Vehicle
    Vehicle <|-- Car
    Vehicle <|-- MotorBike

    ParkingLot o-- SpotAllocator
    ParkingLot o-- PricingStrategy
    ParkingLot o-- PaymentProcessor
    ParkingLot o-- TicketFactory
    ParkingLot o-- Ticket : activeTickets

    TicketFactory ..> Ticket
    Ticket ..> Vehicle
    Ticket ..> ParkingSpot

    PricingStrategy <|.. HourBasisPricingStrategy
    PaymentProcessor <|.. CashPaymentProcessor
    PaymentProcessor <|.. CardPaymentProcessor
    SpotAllocator <|.. NearestFirstAllocator

    ParkingSpot ..> SpotType
    ParkingSpot ..> SpotStatus
