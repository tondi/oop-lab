package com.tondi.matrix;

abstract class MatrixDecorator implements IMatrix {
    protected IMatrix matrixToBeDecorated;

    public MatrixDecorator(IMatrix matrixToBeDecorated) {
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
}
