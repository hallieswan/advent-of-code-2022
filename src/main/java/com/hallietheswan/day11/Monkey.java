package com.hallietheswan.day11;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Monkey {

    private int id;
    private int totalItemsInspected;
    private Queue<Long> items;
    private int worryLevelDivisor;
    private Operation operation;
    private int trueMonkeyId;
    private int falseMonkeyId;
    private Map<Integer, Monkey> monkeyMap;

    public Monkey(int id, int worryLevelDivisor, int trueMonkeyId, int falseMonkeyId, Operation operation, List<Long> items, Map<Integer, Monkey> monkeyMap) {
        this.id = id;
        this.worryLevelDivisor = worryLevelDivisor;
        this.trueMonkeyId = trueMonkeyId;
        this.falseMonkeyId = falseMonkeyId;
        this.operation = operation;
        this.items = new LinkedList<>();
        for (long item : items) {
            acceptItem(item);
        }
        this.monkeyMap = monkeyMap;
    }

    public boolean acceptItem(long itemWorry) {
        return items.offer(itemWorry);
    }

    private boolean transferItem(long itemWorryLevel) {
        if (itemWorryLevel % worryLevelDivisor == 0) {
            return offerItem(trueMonkeyId, itemWorryLevel);
        }
        return offerItem(falseMonkeyId, itemWorryLevel);
    }

    private boolean offerItem(int monkeyId, long itemWorry) {
        return monkeyMap.get(monkeyId).acceptItem(itemWorry);
    }

    private boolean inspectAndThrowItem(int reliefLevel, int monkeyLeastCommonMultiple) {
        boolean didInspect = !items.isEmpty();
        if (didInspect) {
            totalItemsInspected++;
            long itemWorryLevel = items.poll() % monkeyLeastCommonMultiple;
            itemWorryLevel = (operation.updateWorryLevel(itemWorryLevel) / reliefLevel);
            transferItem(itemWorryLevel);
        }
        return didInspect;
    }

    public void turn(int reliefLevel, int monkeyLeastCommonMultiple) {
        while (inspectAndThrowItem(reliefLevel, monkeyLeastCommonMultiple));
    }

    public int getTotalItemsInspected() {
        return totalItemsInspected;
    }


}
