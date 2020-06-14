package pl.edu.agh.automatedgrader.jtp2.lab5;

import pl.edu.agh.automatedgrader.jtp2.lab5.visitor.IMatrixVisitor;

public interface IMatrix {
    public void print();
    public int getHeight();
    public int getWidth();
    void accept(IMatrixVisitor visitor);
}
