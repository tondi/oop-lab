package pl.edu.agh.automatedgrader.jtp2.lab5.visitor;

import pl.edu.agh.automatedgrader.jtp2.lab5.IMatrix;
import pl.edu.agh.automatedgrader.jtp2.lab5.DefaultMatrix;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PrintingMatrixVisitorTest {

    @Test
    void test() {
        List<IMatrix> matrixesToVisit = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            IMatrix matrix = new DefaultMatrix(i, i % 2 == 0 ? i : i + 1);
            matrixesToVisit.add(matrix);
        }

        PrintingMatrixVisitor visitor = new PrintingMatrixVisitor();

        for(IMatrix matrix : matrixesToVisit) {
            matrix.accept(visitor);
        }
    }
}