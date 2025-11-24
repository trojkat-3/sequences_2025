import sequences.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        IntegerPrinter printerFile = new IntegerPrinter("sequences.txt");
        IntegerPrinter printerStdOut = new IntegerPrinter();
        //Integers
        Sequence sq=new Integers();
        printerStdOut.print(sq);
        printerFile.print(sq);
        //Squares
        sq=new Squares();
        printerStdOut.print(sq);
        printerFile.print(sq);
        //Primes
        sq=new Primes();
        printerStdOut.print(sq);
        printerFile.print(sq);
        //Fibonacci numbers
        sq=new Fibonacci();
        printerStdOut.print(sq);
        printerFile.print(sq);
        // arithmetic & geometric sequences .....
    }
}