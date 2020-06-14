package pl.edu.agh.automatedgrader.jtp2.lab5.decorator;

import pl.edu.agh.automatedgrader.jtp2.lab5.IMatrix;

public class PrettyPrintMatrixDecorator extends DefaultMatrixDecorator {
    public PrettyPrintMatrixDecorator(IMatrix matrixToBeDecorated) {
        super(matrixToBeDecorated);
    }

    @Override
    public void print() {
        printDimensions();
        super.print();
    }

    public void printDimensions() {
        System.out.println("Width: " + matrixToBeDecorated.getWidth() + " Height: " + matrixToBeDecorated.getHeight());
    }
}
