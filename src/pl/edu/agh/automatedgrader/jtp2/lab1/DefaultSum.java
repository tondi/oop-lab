package pl.edu.agh.automatedgrader.jtp2.lab1;

import pl.edu.agh.automatedgrader.jtp2.lab1.interfaces.Sum;

import java.util.List;

public class DefaultSum implements Sum {
    private final List<Integer> list;
    private final int count;

    DefaultSum(List<Integer> list, int count) {
        this.count = count;
        this.list = list;
    }

    @Override
    public int getHowMany() {
        return this.list.size();
    }

    @Override
    public List<Integer> getList() {
        return this.list;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            synchronized (list) {
                Integer last = list.get(list.size() - 1);
                Integer prevLast = list.get(list.size() - 2);
                list.add(last + prevLast);
            }
        }
    }

}
