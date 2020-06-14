package pl.edu.agh.automatedgrader.jtp2.lab5.interfaces;

public interface Matrix
{
	String print();

	int getRowCount();

	int getColumnCount();

	//metoda ta dotyczy lab6, klasa MatrixVisitor jest zdefiniowana w lab6,
//	void acceptVisitor(MatrixVisitor matrixVisitor);
}
