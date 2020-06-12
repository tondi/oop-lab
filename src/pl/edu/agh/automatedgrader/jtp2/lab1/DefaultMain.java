package pl.edu.agh.automatedgrader.jtp2.lab1;

import pl.edu.agh.automatedgrader.jtp2.lab1.interfaces.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultMain implements Main {
    @Override
    public List<Integer> sum(int count, int threadCount, int firstElement, int secondElement) {
        List<Integer> list = new ArrayList<>(Arrays.asList(firstElement, secondElement));

        for(int i = 0; i < threadCount; i++) {
            DefaultSum sum = new DefaultSum(list, count);
            sum.run();
        }

        return list;
    }
}
