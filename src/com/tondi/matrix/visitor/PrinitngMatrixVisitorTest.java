package com.tondi.matrix.visitor;

import com.tondi.matrix.IMatrix;
import com.tondi.matrix.Matrix;
import com.tondi.matrix.decorator.PrettyPrintMatrixDecorator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrintingMatrixVisitorTest {

    @Test
    void test() {
        List<IMatrix> matrixesToVisit = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            IMatrix matrix = new Matrix(i, i % 2 == 0 ? i : i + 1);
            matrixesToVisit.add(matrix);
        }

        PrintingMatrixVisitor visitor = new PrintingMatrixVisitor();

        for(IMatrix matrix : matrixesToVisit) {
            matrix.accept(visitor);
        }
    }
}