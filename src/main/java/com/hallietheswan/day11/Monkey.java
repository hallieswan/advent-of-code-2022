package com.hallietheswan.day11;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Monkey {

    private int id;
    private int totalItemsInspected;
    private Queue<Integer> items;
    private int worryLevelDivisor;
    private Operation operation;
    private int trueMonkeyId;
    private int falseMonkeyId;
    private Map<Integer, Monkey> monkeyMap;

    public Monkey(int id, int worryLevelDivisor, int trueMonkeyId, int falseMonkeyId, Operation operation, List<Integer> items, Map<Integer, Monkey> monkeyMap) {
        this.id = id;
        this.worryLevelDivisor = worryLevelDivisor;
        this.trueMonkeyId = trueMonkeyId;
        this.falseMonkeyId = falseMonkeyId;
        this.operation = operation;
        this.items = new LinkedList<>();
        for (int item : items) {
            acceptItem(item);
        }
        this.monkeyMap = monkeyMap;
    }

    public boolean acceptItem(int itemWorry) {
        return items.offer(itemWorry);
    }

    private boolean transferItem(int itemWorryLevel) {
        if (itemWorryLevel % worryLevelDivisor == 0) {
            return offerItem(trueMonkeyId, itemWorryLevel);
        }
        return offerItem(falseMonkeyId, itemWorryLevel);
    }

    private boolean offerItem(int monkeyId, int itemWorry) {
        return monkeyMap.get(monkeyId).acceptItem(itemWorry);
    }

    private boolean inspectAndThrowItem() {
        boolean didInspect = !items.isEmpty();
        if (didInspect) {
            totalItemsInspected++;
            int itemWorryLevel = items.poll();
            itemWorryLevel = operation.updateWorryLevel(itemWorryLevel); // inspect
            itemWorryLevel /= 3; // relief
            transferItem(itemWorryLevel);
        }
        return didInspect;
    }

    public void turn() {
        while (inspectAndThrowItem());
    }

    public int getTotalItemsInspected() {
        return totalItemsInspected;
    }


}
