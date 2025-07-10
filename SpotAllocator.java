package ParkingLotDesign;


//Spot Allocation strategy
public interface SpotAllocator {
    ParkingSpot allocate(Level level,Vehicle vehicle);
}
