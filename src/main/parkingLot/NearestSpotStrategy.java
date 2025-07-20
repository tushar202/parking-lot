import java.util.List;

public class NearestSpotStrategy implements SpotAllocationStrategy{

    @Override
    public Spot assignSpot(List<Level> levels,VehicleType vehicleType){
        for(Level level:levels){
            for(Spot spot:level.getSpots()){
                if(spot.isEmpty()&&spot.getSpotType().name().equals(vehicleType.name())){
                    return spot;
                }
            }
        }
        return null;
    }
}
