package ParkingLotDesign;

public class CashPaymentProcessor implements PaymentProcessor{

    @Override
    public boolean processPayment(String ticketId,double amount){
        System.out.println("Processing cash Payment for "+ticketId+": "+amount);
        return true;
    }


}
