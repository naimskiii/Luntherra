package algoritmer;

public interface Beholder<T> {
        boolean leggInn(T verdi);
        boolean fjern(T verdi);
        boolean inneholder(T verdi);
        int antall();
        boolean tom();
        void nullstill();
        void oppdater();
        void handleEvent(String event);
        T hentTilfeldig();

}
