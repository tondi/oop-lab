package com.tondi.matrix.decorator;

import com.tondi.matrix.IMatrix;
import com.tondi.matrix.visitor.IMatrixVisitor;

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
