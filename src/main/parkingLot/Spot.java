import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class Spot {
    private String id;
    private SpotType spotType;
    private boolean isEmpty=true;
    private Level level;
    Spot(SpotType spotType){
        this.id= UUID.randomUUID().toString();
        this.spotType=spotType;
    }

}
