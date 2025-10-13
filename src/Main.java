import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static final int MAX = 800;
    static final int MAX_IN_LINE = 15;
    static final boolean WRITE_TO_FILE = false;

    static int getNumberOfDigits(int n) {
        int nd = 0;
        while (n > 0) {
            nd++;
            n = (n - n % 10) / 10;
        }
        return nd;
    }

    public static void main(String[] args) {
        String out = "";
            int maxNoDigits = getNumberOfDigits(MAX);
            for (int i = 1; i <= MAX; i++) {
                for (int j = 0; j < maxNoDigits - getNumberOfDigits(i); j++) {
                    out += " ";
                }
                out += Integer.toString(i);
                if (i < MAX) {
                    out += ", ";
                }
                if (i % MAX_IN_LINE == 0) {
                    out += "\n";
                }
            }
            if (WRITE_TO_FILE){
                try (FileWriter fr = new FileWriter("output/integers.txt");) {
                    fr.write(out);
                } catch (IOException ex) {
                    System.out.println("Something wrong with file: " + ex.getMessage());
                }
            } else {
                System.out.println(out);
            }
    }
}