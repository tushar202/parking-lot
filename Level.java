package ParkingLotDesign;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Level {
    private final int levelNumber;
    private final Map<SpotType, ConcurrentLinkedQueue<ParkingSpot>> spotQueues=new EnumMap<>(SpotType.class);

    public Level(int levelNumber, Map<SpotType, List<ParkingSpot>> initialSpots){
        this.levelNumber=levelNumber;
        Arrays.stream(SpotType.values()).forEach(spotType -> spotQueues.put(spotType,new ConcurrentLinkedQueue<>()));

        initialSpots.forEach(((spotType, parkingSpots) -> spotQueues.get(spotType).addAll(parkingSpots)));
    }

    public int getLevelNumber(){
        return levelNumber;
    }



    public ParkingSpot getFreeSpot(SpotType type){
        ParkingSpot spot=spotQueues.get(type).poll();
        if(spot!=null&&spot.occupy()){
            return spot;
        }
        return null;
    }

    public void returnSpot(ParkingSpot spot){
        spot.vacate();
        spotQueues.get(spot.getType()).add(spot);
    }


}
