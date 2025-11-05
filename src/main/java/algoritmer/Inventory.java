package algoritmer;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<String, Integer> resources = new HashMap<>();

    public void addResource(String name, int amount){
        resources.put(name, resources.getOrDefault(name, 0) + amount);
    }

    public int getResources(String name){
        return resources.getOrDefault(name, 0);
    }

    @Override
    public String toString(){
        return resources.toString();
    }
}
