package com.tondi.matrix.factorymethod.test;

import com.tondi.matrix.Matrix;
import com.tondi.matrix.factorymethod.DenseMatrix;
import com.tondi.matrix.factorymethod.SparseMatrix;

import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodTest {
    @org.junit.jupiter.api.Test
    void returnsDenseSparseMatrix() {
        Matrix denseMatrix = new DenseMatrix(3, 4);
        Matrix sparseMatrix = new SparseMatrix(3, 4);

        assertTrue(denseMatrix.getData()[0][0].size() == 3);
        assertTrue(sparseMatrix.getData()[0][0].get(0).equals(0.0));
    }
}