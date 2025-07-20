public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(String levelId,SpotType spotType,int avaiableSpots);
}
