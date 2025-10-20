import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class IntegerPrinter {

    static final int MAX_IN_LINE = 15;
    boolean writeToFile;

    public IntegerPrinter(Boolean writeToFile){
        this.writeToFile=writeToFile;
    }

    int getNumberOfDigits(int n) {
        int nd = 0;
        while (n > 0) {
            nd++;
            n = (n - n % 10) / 10;
        }
        return nd;
    }

    void printIntegers(ArrayList<Integer> list){
        String out = "";
        int maxNoDigits = getNumberOfDigits(Collections.max(list));
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < maxNoDigits - getNumberOfDigits(list.get(i)); j++) {
                out += " ";
            }
            out += Integer.toString(list.get(i));
            out += ", ";
            if ((i + 1) % MAX_IN_LINE == 0) {
                out += "\n";
            }
        }
        out=out.stripTrailing();
        out=out.substring(0,out.length()-1);
        if (writeToFile) {
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
