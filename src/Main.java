import exceptions.CantDecomposeException;
import exceptions.OutOfBoundsException;
import sequences.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        IntegerPrinter printerFile = new IntegerPrinter("sequences.txt");
        IntegerPrinter printerStdOut = new IntegerPrinter();
        //Integers
        Sequence sq = new Integers();
        //printerStdOut.print(sq);
        printerFile.print(sq);
        //Squares
        sq = new Squares();
        try {
            System.out.println(sq.decompose(206));
        } catch (CantDecomposeException ex) {
            System.out.println(ex.getMessage());
        }
        //printerStdOut.print(sq);
        printerFile.print(sq);
        //Primes
        sq = new Primes();
        //printerStdOut.print(sq);
        printerFile.print(sq);
        try {
            System.out.println(sq.sum(3000));
            System.out.println(sq.decompose(206));
            System.out.println(sq.decompose(500));
        } catch (OutOfBoundsException | CantDecomposeException ex) {
            System.out.println(ex.getMessage());
        }
        //Fibonacci numbers
        sq = new Fibonacci();
        sq.setMax(100000);
        //printerStdOut.print(sq);
        printerFile.print(sq);
        //Fibonacci numbers starting with (-3,2)
        sq = new Fibonacci(1, 5);
        sq.setMax(10000);
        //printerStdOut.print(sq);
        printerFile.print(sq);
        // arithmetic & geometric sequences .....
    }
}