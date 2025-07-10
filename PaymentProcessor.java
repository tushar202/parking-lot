package ParkingLotDesign;

public interface PaymentProcessor {

    boolean processPayment(String ticketId,double amount);
}
