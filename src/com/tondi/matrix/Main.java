package com.tondi.matrix;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.println("test");

        IMatrix prettyMatrix = new PrettyPrintMatrixDecorator(new Matrix(3, 4));
        prettyMatrix.print();
    }
}
