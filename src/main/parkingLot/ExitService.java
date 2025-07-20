public class ExitService {

    public FeeCalculationStrategy feeStrategy;
    public PaymentProcessor paymentProcessor;
    SpotManager spotManager;


    public ExitService(FeeCalculationStrategy feeStrategy,PaymentProcessor paymentProcessor,SpotManager spotManager){
        this.feeStrategy=feeStrategy;
        this.paymentProcessor=paymentProcessor;
        this.spotManager=spotManager;
    }

    public void processExit(Ticket ticket){
        double fare=feeStrategy.calculateFare(ticket);
        paymentProcessor.processPayment(fare);
        spotManager.freeUpSpot(ticket.getSpot());
    }
}
