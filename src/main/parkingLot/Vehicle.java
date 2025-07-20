import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;

    public Vehicle(String vehicleNumber,VehicleType vehicleType){
        this.vehicleNumber=vehicleNumber;
        this.vehicleType=vehicleType;
    }

}
