public class DisplayBoard implements Observer{
    @Override
    public void update(String levelId,SpotType spotType,int avaiableSpots){
        System.out.println("Level: "+ levelId+", spotType: "+spotType +" Available: "+ avaiableSpots);
    }
}
