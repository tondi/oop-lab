package com.tondi.matrix.factorymethod;

import com.tondi.matrix.Matrix;

import java.util.Random;
import java.util.Vector;

public class SparseMatrix extends Matrix {
    public SparseMatrix(int M, int N) {
        super(M, N);
    }

    @Override
    public Vector generateVector() {
        return this.generateNullVector();
    }

    // Factory Method
    private Vector generateNullVector() {
        Vector<Double> x = new Vector();
        x.add(0.0);
        return x;
    }
}
