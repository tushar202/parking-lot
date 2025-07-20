import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create levels and spots
        Level level1 = new Level("L1");
        level1.addSpots(Arrays.asList(
                new Spot(SpotType.TWO_WHEELER),
                new Spot( SpotType.FOUR_WHEELER),
                new Spot( SpotType.EV)
        ));

        Level level2 = new Level("L2");
        level2.addSpots(Arrays.asList(
                new Spot( SpotType.TWO_WHEELER),
                new Spot(SpotType.FOUR_WHEELER),
                new Spot( SpotType.EV)
        ));

        // Create parking lot
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.addLevel(level1);
        parkingLot.addLevel(level2);

        // Create SpotManager
        SpotManager spotManager = new SpotManager(parkingLot.levels, new NearestSpotStrategy());
        spotManager.registerObserver(new DisplayBoard());

        // Create services
        EntryService entryService = new EntryService(spotManager);
        ExitService exitService = new ExitService(new HourlyFeeStrategy(), new UpiPaymentProcessor(), spotManager);

        // Simulate vehicle entry
        Vehicle bike = new Vehicle("KA01AB1234", VehicleType.TWO_WHEELER);
        Ticket bikeTicket = entryService.createTicket(bike);
        System.out.println("Ticket issued for bike: " + bikeTicket.getId());

        Thread.sleep(2000); // Simulate some parking time

        // Simulate vehicle exit
        exitService.processExit(bikeTicket);
        System.out.println("Bike exited.");
    }
}
