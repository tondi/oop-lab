package pl.edu.agh.automatedgrader.jtp2.lab5.factorymethod;

import pl.edu.agh.automatedgrader.jtp2.lab5.DefaultMatrix;

import java.util.Random;
import java.util.Vector;

public class DenseMatrix extends DefaultMatrix {
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
