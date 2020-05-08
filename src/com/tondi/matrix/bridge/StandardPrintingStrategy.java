package com.tondi.matrix.bridge;

public class StandardPrintingStrategy implements PrintingStrategy {
    @Override
    public void print(String str) {
        System.out.print(str);
    }

    @Override
    public void println(String str) {
        System.out.println(str);
    }
}
