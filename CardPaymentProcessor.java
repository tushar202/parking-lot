package ParkingLotDesign;

public class CardPaymentProcessor implements PaymentProcessor{

    @Override
    public boolean processPayment(String ticketId,double amount){
        System.out.println("Processing card payment for:"+ticketId+":"+amount);
        return true;
    }
}
