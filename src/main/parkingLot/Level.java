import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Level {

    private String id;
    private List<Spot> spots=new ArrayList<>();
    private DisplayBoard displayBoard=new DisplayBoard();

    public Level(String id){
        this.id=id;
    }

    void addSpots(List<Spot> newSpots){
        newSpots.forEach(spot -> spot.setLevel(this));
        this.spots.addAll(newSpots);
    }
    void removeSpot(Spot spot){
        this.spots.remove(spot);
    }
}
