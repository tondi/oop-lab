package pl.edu.agh.automatedgrader.jtp2.lab6.visitor;

import pl.edu.agh.automatedgrader.jtp2.lab5.DefaultMatrix;
import pl.edu.agh.automatedgrader.jtp2.lab6.interfaces.MatrixVisitor;

public class DefaultPrintingVisitor implements MatrixVisitor {
    @Override
    public void visit(DefaultMatrix matrix) {
        System.out.println("Visiting Matrix");
        matrix.print();
        boolean isSquare = matrix.getRowCount() == matrix.getColumnCount();
        System.out.println("Visited matrix is square matrix: " + isSquare);
    }
}
