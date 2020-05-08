package com.tondi.matrix.factorymethod;

import com.tondi.matrix.Matrix;

import java.util.Random;
import java.util.Vector;

public class DenseMatrix extends Matrix {
    public DenseMatrix(int M, int N) {
        super(M, N);
    }

    @Override
    public Vector generateVector() {
        return this.generateBigVector();
    }

    // Factory Method
    private Vector generateBigVector() {
        Vector<Double> x = new Vector();
        x.add(new Random().nextDouble());
        x.add(new Random().nextDouble());
        x.add(new Random().nextDouble());
        return x;
    }
}
