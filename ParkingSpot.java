package ParkingLotDesign;

public class ParkingSpot {
    private final String id;
    private final SpotType type;
    private volatile SpotStatus status;

    public ParkingSpot(String id,SpotType type){
        this.id=id;
        this.type=type;
    }

    public String getId(){
        return id;
    }

    public SpotType getType(){
        return type;
    }

    public SpotStatus getStatus(){
        return status;
    }

    public boolean occupy(){
        if(status==SpotStatus.FREE){
            status=SpotStatus.OCCUPIED;
            return true;
        }else{
            return false;
        }
    }

    public void vacate(){
        status=SpotStatus.FREE;
    }


}
