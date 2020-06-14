package pl.edu.agh.automatedgrader.jtp2.lab5.factorymethod;

import pl.edu.agh.automatedgrader.jtp2.lab5.DefaultMatrix;

import java.util.Vector;

public class DefaultSparseMatrix extends DefaultMatrix {
    public DefaultSparseMatrix(int M, int N) {
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
