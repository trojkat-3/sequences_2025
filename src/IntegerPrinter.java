import sequences.Sequence;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class IntegerPrinter {

    private final int MAX_IN_LINE = 15;
    private String fName;
    //boolean writeToFile;

    public IntegerPrinter() {
        fName = null;
    }

    public IntegerPrinter(String fileName) {
        this.fName = fileName;
        try (FileWriter fr = new FileWriter("output/" + fName);) {
            fr.write("");
        } catch (IOException ex) {
            System.out.println("Something wrong with file: " + ex.getMessage());
        }
    }

    private int getNumberOfDigits(int n) {
        int nd = 0;
        while (n > 0) {
            nd++;
            n = (n - n % 10) / 10;
        }
        return nd;
    }

    void print(Sequence sq) {
        String out = "---- "+sq.getName()+ " ----\n";
        ArrayList<Integer> list=sq.getSequence();
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
        out = out.stripTrailing();
        out = out.substring(0, out.length() - 1);
        out += "\n";
        if (fName != null) {
            try (FileWriter fr = new FileWriter("output/" + fName, true);) {
                fr.write(out);
            } catch (IOException ex) {
                System.out.println("Something wrong with file: " + ex.getMessage());
            }
        } else {
            System.out.println(out);
        }
    }
}
