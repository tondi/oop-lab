package pl.edu.agh.automatedgrader.jtp2.lab5.bridge;

public class StandardPrintingStrategy implements PrintingStrategy {
    @Override
    public void print(String str) {
        System.out.print(str);
    }

    @Override
    public void println(String str) {
        System.out.println(str);
    }
}
