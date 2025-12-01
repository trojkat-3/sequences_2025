package sequences;

public class Primes extends Sequence {

    public Primes(){
        super("Primes");
        initializeSequence();
    }

    @Override
    void initializeSequence() {
        int p = 1;
        while (p <= max) {
            if (isPrime(p)) {
                sequence.add(p);
            }
            p++;
        }
    }

    private Boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
