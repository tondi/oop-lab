package com.tondi.matrix.decorator.test;

import com.tondi.matrix.IMatrix;
import com.tondi.matrix.Matrix;
import com.tondi.matrix.decorator.PrettyPrintMatrixDecorator;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class DecoratorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    void testMatrix() {
        IMatrix prettyMatrix = new PrettyPrintMatrixDecorator(new Matrix(3, 4));
        prettyMatrix.print();

//        System.out.println(Arrays.stream(outContent.toString().split(" ")).anyMatch(str -> Objects.equals(str, "Width:")));

        assertTrue(Arrays.stream(outContent.toString().split(" ")).anyMatch(str -> Objects.equals(str, "Width:")));
    }
}