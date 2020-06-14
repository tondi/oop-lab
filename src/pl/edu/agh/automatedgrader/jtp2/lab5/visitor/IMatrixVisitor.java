package pl.edu.agh.automatedgrader.jtp2.lab5.visitor;

import pl.edu.agh.automatedgrader.jtp2.lab5.IMatrix;

public interface IMatrixVisitor {
    void visit(IMatrix matrix);
}
