public class UpiPaymentProcessor implements PaymentProcessor{

    @Override
    public void processPayment(double fare){
        System.out.println("Payment of Rs. "+fare+" processed via upi");
    }
}
