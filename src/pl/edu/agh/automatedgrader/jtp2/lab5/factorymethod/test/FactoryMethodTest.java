package pl.edu.agh.automatedgrader.jtp2.lab5.factorymethod.test;

import pl.edu.agh.automatedgrader.jtp2.lab5.DefaultMatrix;
import pl.edu.agh.automatedgrader.jtp2.lab5.factorymethod.DenseMatrix;
import pl.edu.agh.automatedgrader.jtp2.lab5.factorymethod.SparseMatrix;

import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodTest {
    @org.junit.jupiter.api.Test
    void returnsDenseSparseMatrix() {
        DefaultMatrix denseMatrix = new DenseMatrix(3, 4);
        DefaultMatrix sparseMatrix = new SparseMatrix(3, 4);

        assertTrue(denseMatrix.getData()[0][0].size() == 3);
        assertTrue(sparseMatrix.getData()[0][0].get(0).equals(0.0));
    }
}