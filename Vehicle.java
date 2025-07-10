package ParkingLotDesign;

abstract public class Vehicle {
    private final String vehicleNumber;
    private final SpotType requiredSpot;

    Vehicle(String vehicleNumber,SpotType requiredSpot){
        this.vehicleNumber=vehicleNumber;
        this.requiredSpot=requiredSpot;
    }

    public String getVehicleNumber(){
        return this.vehicleNumber;
    }

    public SpotType getRequiredSpot(){
        return requiredSpot;
    }
}
