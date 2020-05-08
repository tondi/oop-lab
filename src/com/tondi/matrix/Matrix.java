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

    //    // create matrix based on 2d array
//    public Matrix(double[][] data) {
//        M = data.length;
//        N = data[0].length;
//        this.data = new double[M][N];
//        for (int i = 0; i < M; i++)
//            for (int j = 0; j < N; j++)
//                this.data[i][j] = data[i][j];
//    }

//    // copy constructor
//    private Matrix(Matrix A) { this(A.data); }
//
    // create and return a random M-by-N matrix with values between 0 and 1
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

//
//    // create and return the N-by-N identity matrix
//    public static Matrix identity(int N) {
//        Matrix I = new Matrix(N, N);
//        for (int i = 0; i < N; i++)
//            I.data[i][i] = 1;
//        return I;
//    }
//
//    // swap rows i and j
//    private void swap(int i, int j) {
//        double[] temp = data[i];
//        data[i] = data[j];
//        data[j] = temp;
//    }
//
//    // create and return the transpose of the invoking matrix
//    public Matrix transpose() {
//        Matrix A = new Matrix(N, M);
//        for (int i = 0; i < M; i++)
//            for (int j = 0; j < N; j++)
//                A.data[j][i] = this.data[i][j];
//        return A;
//    }
//
//    // return C = A + B
//    public Matrix plus(Matrix B) {
//        Matrix A = this;
//        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
//        Matrix C = new Matrix(M, N);
//        for (int i = 0; i < M; i++)
//            for (int j = 0; j < N; j++)
//                C.data[i][j] = A.data[i][j] + B.data[i][j];
//        return C;
//    }
//
//
//    // return C = A - B
//    public Matrix minus(Matrix B) {
//        Matrix A = this;
//        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
//        Matrix C = new Matrix(M, N);
//        for (int i = 0; i < M; i++)
//            for (int j = 0; j < N; j++)
//                C.data[i][j] = A.data[i][j] - B.data[i][j];
//        return C;
//    }
//
//    // does A = B exactly?
//    public boolean eq(Matrix B) {
//        Matrix A = this;
//        if (B.M != A.M || B.N != A.N) throw new RuntimeException("Illegal matrix dimensions.");
//        for (int i = 0; i < M; i++)
//            for (int j = 0; j < N; j++)
//                if (A.data[i][j] != B.data[i][j]) return false;
//        return true;
//    }
//
//    // return C = A * B
//    public Matrix times(Matrix B) {
//        Matrix A = this;
//        if (A.N != B.M) throw new RuntimeException("Illegal matrix dimensions.");
//        Matrix C = new Matrix(A.M, B.N);
//        for (int i = 0; i < C.M; i++)
//            for (int j = 0; j < C.N; j++)
//                for (int k = 0; k < A.N; k++)
//                    C.data[i][j] += (A.data[i][k] * B.data[k][j]);
//        return C;
//    }
//
//
//    // return x = A^-1 b, assuming A is square and has full rank
//    public Matrix solve(Matrix rhs) {
//        if (M != N || rhs.M != N || rhs.N != 1)
//            throw new RuntimeException("Illegal matrix dimensions.");
//
//        // create copies of the data
//        Matrix A = new Matrix(this);
//        Matrix b = new Matrix(rhs);
//
//        // Gaussian elimination with partial pivoting
//        for (int i = 0; i < N; i++) {
//
//            // find pivot row and swap
//            int max = i;
//            for (int j = i + 1; j < N; j++)
//                if (Math.abs(A.data[j][i]) > Math.abs(A.data[max][i]))
//                    max = j;
//            A.swap(i, max);
//            b.swap(i, max);
//
//            // singular
//            if (A.data[i][i] == 0.0) throw new RuntimeException("Matrix is singular.");
//
//            // pivot within b
//            for (int j = i + 1; j < N; j++)
//                b.data[j][0] -= b.data[i][0] * A.data[j][i] / A.data[i][i];
//
//            // pivot within A
//            for (int j = i + 1; j < N; j++) {
//                double m = A.data[j][i] / A.data[i][i];
//                for (int k = i+1; k < N; k++) {
//                    A.data[j][k] -= A.data[i][k] * m;
//                }
//                A.data[j][i] = 0.0;
//            }
//        }
//
//        // back substitution
//        Matrix x = new Matrix(N, 1);
//        for (int j = N - 1; j >= 0; j--) {
//            double t = 0.0;
//            for (int k = j + 1; k < N; k++)
//                t += A.data[j][k] * x.data[k][0];
//            x.data[j][0] = (b.data[j][0] - t) / A.data[j][j];
//        }
//        return x;
//
//    }
//
//    // print matrix to standard output

//
//
//
//    // test client
//    public static void main(String[] args) {
//        double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 1, 3} };
//        Matrix D = new Matrix(d);
//        D.show();
//        StdOut.println();
//
//        Matrix A = Matrix.random(5, 5);
//        A.show();
//        StdOut.println();
//
//        A.swap(1, 2);
//        A.show();
//        StdOut.println();
//
//        Matrix B = A.transpose();
//        B.show();
//        StdOut.println();
//
//        Matrix C = Matrix.identity(5);
//        C.show();
//        StdOut.println();
//
//        A.plus(B).show();
//        StdOut.println();
//
//        B.times(A).show();
//        StdOut.println();
//
//        // shouldn't be equal since AB != BA in general
//        StdOut.println(A.times(B).eq(B.times(A)));
//        StdOut.println();
//
//        Matrix b = Matrix.random(5, 1);
//        b.show();
//        StdOut.println();
//
//        Matrix x = A.solve(b);
//        x.show();
//        StdOut.println();
//
//        A.times(x).show();
//
//    }
}