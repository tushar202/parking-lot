import java.util.List;

public interface SpotAllocationStrategy {
    public Spot assignSpot(List<Level> levels,VehicleType type);
}
