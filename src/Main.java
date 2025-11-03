import sequences.Integers;
import sequences.Sequence;

import java.util.ArrayList;

public class Main {

    static final int MAX = 1000;

    static Boolean isPrime(int n) {
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

    static int Fibonacci(int n, ArrayList<Integer> fib) {
        if (n<fib.size()) {
            return fib.get(n);
        }
        if (n <= 1) {
            return n;
        } else {
            return Fibonacci(n - 1,fib) + Fibonacci(n - 2,fib);
        }
    }

    public static void main(String[] args) {
        IntegerPrinter printerFile = new IntegerPrinter("integers.txt");
        IntegerPrinter printerStdOut = new IntegerPrinter();
        Sequence sq=new Integers();

        ArrayList<Integer> list = new ArrayList<>();
        //Integers
        for (int i = 1; i <= MAX; i++) {
            list.add(i);
        }
        printerFile.print(list, "Integers");
        list.clear();
        //Squares
        for (int i = 1; i * i <= MAX; i++) {
            list.add(i * i);
        }
        printerFile.print(list, "Squares");
        //Primes
        list.clear();
        int p = 1;
        while (p <= MAX) {
            if (isPrime(p)) {
                list.add(p);
            }
            p++;
        }
        printerFile.print(list,"Primes");
        printerStdOut.print(list,"Primes");
        //Fibonacci numbers
        list.clear();
        int i=0;
        int f;
        while ((f=Fibonacci(i,list))<=MAX){
            list.add(f);
            i++;
        }
        printerStdOut.print(list, "Fibonacci numbers");
        // arithmetic & geometric sequences .....
    }
}