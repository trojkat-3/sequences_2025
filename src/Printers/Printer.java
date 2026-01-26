package Printers;

import sequences.Sequence;

import java.util.ArrayList;
import java.util.Collections;

abstract public class Printer {

    private final int MAX_IN_LINE = 15;

    private int getNumberOfDigits(int n) {
        int nd = 0;
        while (n > 0) {
            nd++;
            n = (n - n % 10) / 10;
        }
        return nd;
    }

    public String print(Sequence sq) {
        String out = "---- " + sq.getName() + " ----\n";
        ArrayList<Integer> list = sq.getSequence();
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
        output(out);
        return out;
    }

    public String printDecomposition(int n, ArrayList<Integer> list){
        String str=n+"=";
        for (int a: list){
            str+=a+"+";
        }
        str=str.substring(0,str.length()-1);
        output(str);
        return str;
    }

    protected abstract void output(String str);

}
