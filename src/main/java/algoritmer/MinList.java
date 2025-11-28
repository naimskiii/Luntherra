package algoritmer;


import java.util.Iterator;


public class MinList<T> implements Beholder<T>{
    private Object[] values;
    private int size= 0;

    public MinList(){
        values = new Object[10];
    }

    @Override
    public boolean leggInn( T verdi){
        if(size== values.length) utvid();
        values[size++] = verdi;
        return true;
    }

    @Override
    public void oppdater(){
        for(int i =0; i< size; i++){
        }
    }

    private void utvid(){
        Object[] ny = new Object[values.length*1];
        System.arraycopy(values, 0,ny,0 , values.length);
        values=ny;
    }


   /* public void applyRule(Rule<T> rule) {
        for (int i = 0; i < size; i++) {
            rule.apply((T) values[i]);
        }
    }*/


    @Override public boolean fjern(T verdi) { return false; }
    @Override public boolean inneholder(T verdi) { return false; }
    @Override public int antall() { return size; }
    @Override public boolean tom() { return size == 0; }
    @Override public void nullstill() { size = 0; values = new Object[10]; }
    @Override public T hentTilfeldig() { return null; }
    @Override public void handleEvent(String event) {}
    //@Override public Iterator<T> iterator() { return null; }
}
