package com.tondi.matrix;
import com.tondi.matrix.bridge.PrintingStrategy;

import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class Matrix implements IMatrix {
    private final int M;             // number of rows
    private final int N;             // number of columns
    private final Vector<Double>[][] data;   // M-by-N array
    private PrintingStrategy printingStrategy;

    public Matrix(int M, int N) {
        this.M = M;
        this.N = N;
        data = new Vector[M][N];
        this.randomize();
    }

    public Matrix(int M, int N, PrintingStrategy printingStrategy) {
        this.M = M;
        this.N = N;
        data = new Vector[M][N];
        this.randomize();

        // Bridge pattern - separate printing capabilities from their implementation
        this.printingStrategy = printingStrategy;
    }

    @Override
    public int getWidth() {
        return N;
    }

    @Override
    public int getHeight() {
        return M;
    }

    public void print() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (printingStrategy == null) {
                    System.out.print(data[i][j]);
                } else {
                    printingStrategy.print(Arrays.toString(data[i][j].toArray()));
                }
            }
            if (printingStrategy == null) {
                System.out.println();
            } else {
                printingStrategy.println(null);
            }
        }
    }

    public void randomize() {
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                this.data[i][j] = generateVector();
            }
    }

    public Vector generateVector() {
        Vector<Double> x = new Vector();
        x.add(new Random().nextDouble());
        return x;
    }

    public Vector[][] getData() {
        return this.data;
    }
}