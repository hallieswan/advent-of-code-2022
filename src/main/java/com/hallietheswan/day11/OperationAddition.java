package com.hallietheswan.day11;

public class OperationAddition implements Operation {

    private int addend;

    public OperationAddition(String addend) {
        this.addend = Integer.parseInt(addend);
    }

    @Override
    public long updateWorryLevel(long worryLevel) {
        return Math.addExact(worryLevel, addend);
    }
}
