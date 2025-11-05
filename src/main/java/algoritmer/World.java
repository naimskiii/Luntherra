package algoritmer;

import java.util.ArrayList;

public class World {

    private ArrayList<City> cities = new ArrayList<>();
    private long tick=0;


    public void addCity(City city){
        cities.add(city);
    }

    public void tick(){
        tick++;
        for(City c: cities){
            c.update();
        }
    }

    public long getTick(){
        return tick;
    }
    public void printStatus(){
        System.out.println("World tick " + tick + ": " + cities.size() + " cities");
    }
}
