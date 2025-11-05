package algoritmer;

public class City {

    private String name;

    public Inventory inventory = new Inventory();

    public City(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Inventory getInventory() {
        return inventory;
    }
     //lage metoden update
    public void update(){
        inventory.addResource("energy", 1);
    }
}
