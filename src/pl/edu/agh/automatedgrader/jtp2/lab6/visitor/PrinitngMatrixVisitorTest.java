package pl.edu.agh.automatedgrader.jtp2.lab6.visitor;

import org.junit.jupiter.api.Test;
import pl.edu.agh.automatedgrader.jtp2.lab5.DefaultMatrix;

import java.util.ArrayList;
import java.util.List;

class PrintingMatrixVisitorTest {

    @Test
    void test() {
        List<DefaultMatrix> matrixesToVisit = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            DefaultMatrix matrix = new DefaultMatrix(i, i % 2 == 0 ? i : i + 1);
            matrixesToVisit.add(matrix);
        }

        DefaultPrintingVisitor visitor = new DefaultPrintingVisitor();

        for(DefaultMatrix matrix : matrixesToVisit) {
            matrix.acceptVisitor(visitor);
        }
    }
}