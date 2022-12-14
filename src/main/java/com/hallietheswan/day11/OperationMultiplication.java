package com.hallietheswan.day11;

public class OperationMultiplication implements Operation {
    private String multiplier;

    public OperationMultiplication(String multiplier) {
        this.multiplier = multiplier;
    }
    @Override
    public int updateWorryLevel(int worryLevel) {
        if (multiplier.equals("old")) {
            return worryLevel * worryLevel;
        }
        return worryLevel * Integer.parseInt(multiplier);
    }
}
