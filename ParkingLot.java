package ParkingLotDesign;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    private static volatile ParkingLot INSTANCE;
    private final Map<Integer,Level> levels=new ConcurrentHashMap<>();
    private final SpotAllocator allocator;
    private final TicketFactory ticketFactory;
    private final double ratePerMinute=0.5;
    private final PricingStrategy pricingStrategy;

    private ParkingLot(SpotAllocator allocator,TicketFactory factory,PricingStrategy pricingStrategy){
        this.allocator=allocator;
        this.ticketFactory=factory;
        this.pricingStrategy=pricingStrategy;
    }

    public static ParkingLot getInstance(SpotAllocator allocator,TicketFactory factory,PricingStrategy pricingStrategy){
        if(INSTANCE==null){
            synchronized (ParkingLot.class){
                if(INSTANCE==null){
                    INSTANCE=new ParkingLot(allocator,factory,pricingStrategy);
                }
            }
        }
        return INSTANCE;
    }

    public void  addLevel(Level level){
        levels.put(level.getLevelNumber(), level);
    }

    public Ticket assignSpot(Vehicle vehicle){
        for(Level level:levels.values()){
            ParkingSpot spot=allocator.allocate(level,vehicle);
            if(spot!=null){
                return ticketFactory.create(vehicle,spot,level.getLevelNumber());
            }
        }
        throw new RuntimeException("Parking Full");
    }

    public void releaseSpot(Ticket ticket,PaymentProcessor paymentProcessor){
        Level level=levels.get(ticket.getLevelNumber());

        ticket.markExit();
        long duration= ticket.calculateDurationMinutes();
        double amount=pricingStrategy.calculateAmount(duration);
        paymentProcessor.processPayment(ticket.getTicketId(),amount);
        level.returnSpot(ticket.getSpot());
    }


}
