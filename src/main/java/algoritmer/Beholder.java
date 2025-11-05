package algoritmer;

import java.util.Iterator;

public interface Beholder<T> extends Iterable<T>{
        boolean leggInn( T verdi);
        boolean fjern( T verdi);
        boolean inneholder( T verdi);
        int antall();
        boolean tom();
        void nullstill();
        void oppdater();
        void handleEvent(String event);
        T hentTilfeldig();
        void applyRule(Rule<T> rule);

        @Override
        Iterator<T> iterator();

}
