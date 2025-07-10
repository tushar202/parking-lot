package ParkingLotDesign;

public class NearestFirstAllocator implements SpotAllocator{

    @Override
    public ParkingSpot allocate(Level level,Vehicle v){
        return level.getFreeSpot(v.getRequiredSpot());
    }
}
