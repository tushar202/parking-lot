package ParkingLotDesign;

import java.time.Duration;
import java.time.Instant;

public class Ticket {

    private final String ticketId;
    private final String vehicleNumber;
    private final ParkingSpot spot;
    private final int levelNumber;
    private final Instant entryTime;
    private Instant exitTime;

    public Ticket(String ticketId,String vehicleNumber,ParkingSpot spot,int levelNumber){
        this.ticketId=ticketId;
        this.vehicleNumber=vehicleNumber;
        this.spot=spot;
        this.levelNumber=levelNumber;
        this.entryTime=Instant.now();
    }

    public void markExit(){
        this.exitTime=Instant.now();
    }
    public int getLevelNumber(){
        return this.levelNumber;
    }
    public String getTicketId(){
        return this.getTicketId();
    }

    public ParkingSpot getSpot(){
        return this.spot;
    }
    public long calculateDurationMinutes(){
        return Duration.between(entryTime,exitTime).toMinutes();
    }
}
