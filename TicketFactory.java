package ParkingLotDesign;

import java.util.concurrent.atomic.AtomicLong;

public class TicketFactory {
    private final AtomicLong counter=new AtomicLong(0);

    public Ticket create(Vehicle v,ParkingSpot spot,int levelNumber){
        String ticketId="TKT"+counter.incrementAndGet();
        return new Ticket(ticketId,v.getVehicleNumber(),spot,levelNumber);
    }
}
