package com.hallietheswan;

import com.hallietheswan.day11.Monkey;
import com.hallietheswan.day11.Operation;
import com.hallietheswan.day11.OperationAddition;
import com.hallietheswan.day11.OperationMultiplication;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Day11 implements Day {
    Map<Integer, Monkey> monkeyMap;

    public Day11(String fileName) throws URISyntaxException, IOException {
        List<String> input = Utility.readFileLinesFromResources(fileName);
        buildMonkeyMap(input);
    }

    private int getIdFromInputString(String string) {
        return Integer.parseInt(string.replaceAll(":", "").split(" ")[1]);
    }

    private List<Integer> getItemsFromInputString(String string) {
        List<Integer> items = new ArrayList<>();
        String[] splitString = string.replaceAll(".*: |,", "").split(" ");
        for (String val : splitString) {
            items.add(Integer.parseInt(val));
        }
        return items;
    }

    private Operation getOperationFromInputString(String string) {
        String[] splitString = string.split(" ");
        int length = splitString.length;
        String val = splitString[length - 1];
        if (splitString[length - 2].equals("*")) {
            return new OperationMultiplication(val);
        }
        return new OperationAddition(val);
    }

    private int getLastValFromStringAsInt(String string) {
        String[] splitString = string.split(" ");
        return Integer.parseInt(splitString[splitString.length - 1]);
    }

    private void buildMonkeyMap(List<String> input) {
        monkeyMap = new TreeMap<>();
        int i = 0;
        while (i < input.size()) {
            int id = getIdFromInputString(input.get(i));
            List<Integer> items = getItemsFromInputString(input.get(i + 1));
            Operation operation = getOperationFromInputString(input.get(i + 2));
            int divisor = getLastValFromStringAsInt(input.get(i + 3));
            int trueMonkeyId = getLastValFromStringAsInt(input.get(i + 4));
            int falseMonkeyId = getLastValFromStringAsInt(input.get(i + 5));
            monkeyMap.put(id, new Monkey(id, divisor, trueMonkeyId, falseMonkeyId, operation, items, monkeyMap));
            i += 7;
        }
    }

    private void executeRounds(int nRounds) {
        for (int i = 0; i < nRounds; i++) {
            for (int id : monkeyMap.keySet()) {
                Monkey monkey = monkeyMap.get(id);
                monkey.turn();
            }
        }
    }

    private int calculateMonkeyBusiness() {
        // identify the two most active monkeys
        int largest = 0;
        int secondLargest = 0;
        for (Monkey monkey : monkeyMap.values()) {
            int val = monkey.getTotalItemsInspected();
            if (val > largest) {
                secondLargest = largest;
                largest = val;
            } else if (val > secondLargest) {
                secondLargest = val;
            }
        }
        // then multiply their results
        return largest * secondLargest;
    }

    @Override
    public Object part1(){
        executeRounds(20);
        return calculateMonkeyBusiness();
    }

    @Override
    public Object part2() {
        return -1;
    }
}
