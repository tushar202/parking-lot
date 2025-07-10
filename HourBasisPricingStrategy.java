package ParkingLotDesign;

public class HourBasisPricingStrategy implements PricingStrategy{

    @Override
    public double calculateAmount(long duration){
        if(duration<120L){
            return 50;
        }else{
            return 50+ (double) (20 * (duration - 120L)) /60L;
        }
    }
}
