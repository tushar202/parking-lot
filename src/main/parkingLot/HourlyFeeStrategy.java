import java.util.Date;

public class HourlyFeeStrategy implements FeeCalculationStrategy{

    @Override
    public double calculateFare(Ticket ticket){
        long duration=(new Date().getTime()-ticket.getEntryTime().getTime())/(1000*60*60);
        return (duration+1)*10;
    }
}
