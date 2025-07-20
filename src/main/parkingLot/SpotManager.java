import java.util.ArrayList;
import java.util.List;

public class SpotManager implements Subject{

    List<Observer> observers=new ArrayList<>();
    List<Level> levels;
    SpotAllocationStrategy spotAllocationStrategy;

    SpotManager(List<Level> levels,SpotAllocationStrategy strategy){
        this.levels=levels;
        this.spotAllocationStrategy=strategy;
    }

    public Spot getEmptySpot(VehicleType type){
        return spotAllocationStrategy.assignSpot(levels,type);
    }

    public void blockSpot(Spot spot){
        spot.setEmpty(false);
        notifyObserver(spot.getLevel().getId(),spot.getSpotType(),getAvailableCount(spot.getSpotType()));
    }

    public void freeUpSpot(Spot spot){
        spot.setEmpty(true);
        notifyObserver(spot.getLevel().getId(),spot.getSpotType(),getAvailableCount(spot.getSpotType()));
    }

    private int getAvailableCount(SpotType type){
        int count=0;
        for(Level level:levels){
            for(Spot spot:level.getSpots()){
                if(spot.isEmpty()&&spot.getSpotType()==type){
                    count+=1;
                }
            }
        }
        return count;
    }

    @Override
    public void registerObserver(Observer observer){
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

    @Override
    public void notifyObserver(String levelId,SpotType spotType,int avaibleNumber){
        for(Observer observer:observers){
            observer.update(levelId,spotType,avaibleNumber);
        }
    }
}
