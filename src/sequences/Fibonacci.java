package sequences;

import java.util.ArrayList;

public class Fibonacci extends Sequence {
    private int[] initialVal= new int[2];

    public Fibonacci(){
        this(0,1);
    }

    public Fibonacci(int f0, int f1){
        super("Fibonacci (f0="+f0+", f1="+f1+")");
        initialVal[0]=f0;
        initialVal[1]=f1;
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
            return initialVal[n];
        } else {
            return fibonacci(n - 1,fib) + fibonacci(n - 2,fib);
        }
    }

}
