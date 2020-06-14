package pl.edu.agh.automatedgrader.jtp2.lab5.visitor;

import pl.edu.agh.automatedgrader.jtp2.lab5.IMatrix;

public class PrintingMatrixVisitor implements IMatrixVisitor {
    @Override
    public void visit(IMatrix matrix) {
        System.out.println("Visiting Matrix");
        matrix.print();
        boolean isSquare = matrix.getHeight() == matrix.getWidth();
        System.out.println("Visited matrix is square matrix: " + isSquare);
    }
}
