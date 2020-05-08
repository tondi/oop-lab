package com.tondi.matrix.bridge.test;

import com.tondi.matrix.Matrix;
import com.tondi.matrix.bridge.LogPrintingStrategy;
import com.tondi.matrix.bridge.StandardPrintingStrategy;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }


    // test
    @Test
    public void testPrinting() {
        Matrix standardOutMatrix = new Matrix(3, 4, new StandardPrintingStrategy());

        LogPrintingStrategy log = new LogPrintingStrategy();
        Matrix logMatrix = new Matrix(3, 4, log);

        logMatrix.print();
        assertTrue(log.getLog().length() > 0);
    }
}