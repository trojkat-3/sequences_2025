import java.util.ArrayList;

public class Main {

    static final int MAX = 1000;

    public static void main(String[] args) {
        IntegerPrinter printerFile= new IntegerPrinter(true);
        IntegerPrinter printerStdOut= new IntegerPrinter(false);
        ArrayList<Integer> list = new ArrayList<>();
        //Integers
        for (int i = 1; i <= MAX; i++) {
            list.add(i);
        }
        printerFile.printIntegers(list);
        list.clear();
        //Squares
        for (int i = 1; i*i <= MAX; i++) {
            list.add(i*i);
        }
        printerStdOut.printIntegers(list);
    }
}