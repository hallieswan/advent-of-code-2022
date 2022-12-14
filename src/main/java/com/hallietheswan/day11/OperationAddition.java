package com.hallietheswan.day11;

public class OperationAddition implements Operation {

    private int addend;

    public OperationAddition(String addend) {
        this.addend = Integer.parseInt(addend);
    }

    @Override
    public int updateWorryLevel(int worryLevel) {
        return worryLevel + addend;
    }
}
