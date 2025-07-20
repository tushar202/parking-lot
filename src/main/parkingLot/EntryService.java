public class EntryService {

    SpotManager spotManager;

    EntryService(SpotManager spotManager){
        this.spotManager=spotManager;
    }

    public Ticket createTicket(Vehicle vehicle){
        Spot spot=spotManager.getEmptySpot(vehicle.getVehicleType());
        if(spot==null){
            throw new RuntimeException("No available spot for Vehicle type: "+vehicle.getVehicleType());
        }
        spotManager.blockSpot(spot);
        return new Ticket(vehicle,spot);

    }
}
