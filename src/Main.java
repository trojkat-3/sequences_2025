import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static final int MAX = 2000;
    static final int MAX_IN_LINE = 20;

    static int getNumberOfDigits(int n) {
        int nd = 0;
        while (n > 0) {
            nd++;
            n = (n - n % 10) / 10;
        }
        return nd;
    }

    public static void main(String[] args) {

        try {
            FileWriter fileWriter = new FileWriter("output/integers.txt");
            fileWriter.write("Hello!");
            fileWriter.close();
        } catch (IOException ex) {
            System.out.println("Something wrong with file: "+ex.getMessage());
        }
        int maxNoDigits = getNumberOfDigits(MAX);
        for (int i = 1; i <= MAX; i++) {
            for (int j = 0; j < maxNoDigits - getNumberOfDigits(i); j++) {
                System.out.print(" ");
            }
            System.out.print(i);
            if (i < MAX) {
                System.out.print(", ");
            }
            if (i % MAX_IN_LINE == 0) {
                System.out.print("\n");
            }
        }
    }
}