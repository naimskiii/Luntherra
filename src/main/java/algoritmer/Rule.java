package algoritmer;


@FunctionalInterface // kan bare ha en metode slik at man kan bruke lambdaer
public interface Rule {
    void apply(T element);

    // T er typen det påvirker og kjører regelen for den byen i beholderen
}
