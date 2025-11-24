package sequences;

import java.util.ArrayList;

public class Fibonacci extends Sequence {

    public Fibonacci(){
        super("Fibonacci");
        initializeSequence();
    }

    @Override
    void initializeSequence() {
        int i=0;
        int f;
        while ((f=fibonacci(i,sequence))<=MAX){
            sequence.add(f);
            i++;
        }
    }

    private int fibonacci(int n, ArrayList<Integer> fib) {
        if (n<fib.size()) {
            return fib.get(n);
        }
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1,fib) + fibonacci(n - 2,fib);
        }
    }

}
