package com.tondi.matrix;

public class PrettyPrintMatrixDecorator extends MatrixDecorator {
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
