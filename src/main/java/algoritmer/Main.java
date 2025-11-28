package algoritmer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        World w= new World();

        w.addCity(new City("Corvathen"));
        w.addCity(new City("Vierethra"));
         w.tick();
         w.printStatus();




    }
}