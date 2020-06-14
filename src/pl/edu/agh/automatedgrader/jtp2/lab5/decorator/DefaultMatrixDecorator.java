package pl.edu.agh.automatedgrader.jtp2.lab5.decorator;

import pl.edu.agh.automatedgrader.jtp2.lab5.IMatrix;
import pl.edu.agh.automatedgrader.jtp2.lab5.visitor.IMatrixVisitor;

abstract class DefaultMatrixDecorator implements IMatrix {
    protected IMatrix matrixToBeDecorated;

    public DefaultMatrixDecorator(IMatrix matrixToBeDecorated) {
        this.matrixToBeDecorated = matrixToBeDecorated;
    }

    @Override
    public int getHeight() {
        return matrixToBeDecorated.getHeight();
    }

    @Override
    public int getWidth() {
        return matrixToBeDecorated.getWidth();
    }

    @Override
    public void print() {
        matrixToBeDecorated.print();
    }

    @Override
    public void accept(IMatrixVisitor visitor) {
        visitor.visit(this);
    };
}
