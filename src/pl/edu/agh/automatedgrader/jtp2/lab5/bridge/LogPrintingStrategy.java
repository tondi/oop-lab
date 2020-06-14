package pl.edu.agh.automatedgrader.jtp2.lab5.bridge;

public class LogPrintingStrategy implements PrintingStrategy {
    private StringBuilder log = new StringBuilder();

    @Override
    public void print(String str) {
        log.append(str);
    }

    @Override
    public void println(String str) {
        log.append("\n" + str + "\n");
    }

    public String getLog() {
        return log.toString();
    }
}
