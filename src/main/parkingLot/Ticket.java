import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Ticket {

    private String id;
    private Date entryTime;
    Vehicle vehicle;
    Spot spot;

    Ticket(Vehicle vehicle,Spot spot){
        this.id= UUID.randomUUID().toString();
        this.vehicle=vehicle;
        this.spot=spot;
        this.entryTime=new Date();
    }

}
