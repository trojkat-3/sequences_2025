package Printers;

import java.io.FileWriter;
import java.io.IOException;

public class PrinterFile extends Printer {
    private String fName;

    public PrinterFile(String fileName) {
        this.fName = fileName;
        try (FileWriter fr = new FileWriter("output/" + fName);) {
            fr.write("");
        } catch (IOException ex) {
            System.out.println("Something wrong with file: " + ex.getMessage());
        }
    }

    @Override
    protected void output(String str) {
        try (FileWriter fr = new FileWriter("output/" + fName, true);) {
            fr.write(str);
        } catch (IOException ex) {
            System.out.println("Something wrong with file: " + ex.getMessage());
        }
    }
}
