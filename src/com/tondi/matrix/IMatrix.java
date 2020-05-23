package com.tondi.matrix;

import com.tondi.matrix.visitor.IMatrixVisitor;

import java.util.Vector;

public interface IMatrix {
    public void print();
    public int getHeight();
    public int getWidth();
    void accept(IMatrixVisitor visitor);
}
