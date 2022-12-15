package com.hallietheswan.day11;

public class OperationMultiplication implements Operation {
    private String multiplier;

    public OperationMultiplication(String multiplier) {
        this.multiplier = multiplier;
    }
    @Override
    public long updateWorryLevel(long worryLevel) {
        if (multiplier.equals("old")) {
            return Math.multiplyExact(worryLevel, worryLevel);
        }
        return Math.multiplyExact(worryLevel, Long.parseLong(multiplier));
    }
}
