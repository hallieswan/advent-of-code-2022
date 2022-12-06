package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;

public class Day05 implements Day {

    // nested CrateMover class --------------------------------------------------------------------
    public interface CrateMover {
        void moveCrates(int numToMove, int startStack, int destStack);
    }

    public class CrateMover9000 implements CrateMover {
        @Override
        public void moveCrates(int numToMove, int startStack, int destStack) {
            for (int i = 0; i < numToMove; i++) {
                char c = crateMap.get(startStack).pop();
                crateMap.get(destStack).push(c);
            }
        }
    }

    public class CrateMover9001 implements CrateMover {
        @Override
        public void moveCrates(int numToMove, int startStack, int destStack) {
            ArrayDeque<Character> tmpStack = new ArrayDeque();
            for (int i = 0; i < numToMove; i++) {
                char c = crateMap.get(startStack).pop();
                tmpStack.push(c);
            }
            for (int i = 0; i < numToMove; i++) {
                crateMap.get(destStack).push(tmpStack.pop());
            }
        }
    }
    // end CrateMover class ---------------------------------------------------------------------------

    private List<String> input;
    private int lineSpace;
    private HashMap<Integer, ArrayDeque<Character>> crateMap;
    int totalStacks;

    public Day05(String fileName) throws URISyntaxException, IOException {
        input = Utility.readFileLinesFromResources(fileName);
        // find line with space
        lineSpace = 0;
        while (!input.get(lineSpace).equals("")) {
            lineSpace++;
        }
    }

    private void createStacks(String line) {
        String[] numStacks = line.split(" ");
        totalStacks = 0;
        for (String val : numStacks) {
            if (val.matches("\\d+")) {
                totalStacks++;
                crateMap.put(
                        Integer.parseInt(val),
                        new ArrayDeque<Character>()
                );
            }
        }
    }

    private void parseStackLine(String line) {
        int stackIndex = 1;
        int charIndex = 1;
        for (int i = 0; i < totalStacks && charIndex < line.length(); i++) {
            char c = line.charAt(charIndex);
            if (c != ' ') {
                crateMap.get(stackIndex).push(c);
            }
            stackIndex++;
            charIndex += 4;
        }
    }

    private void setupCrateMap() {
        // create new map
        crateMap = new HashMap<Integer, ArrayDeque<Character>>();

        // create stacks
        createStacks(input.get(lineSpace - 1));

        // fill stacks
        for (int index = lineSpace - 2; index >= 0; index--) {
            parseStackLine(input.get(index));
        }
    }

    private void moveCrates(int numToMove, int startStack, int destStack) {
        for (int i = 0; i < numToMove; i++) {
            char c = crateMap.get(startStack).pop();
            crateMap.get(destStack).push(c);
        }
    }

    private void executeProcedure(CrateMover mover) {
        for (int i = lineSpace + 1; i < input.size(); i++) {
            String line = input.get(i);
            String[] instructions = line.split(" ");
            mover.moveCrates(
                    Integer.parseInt(instructions[1]),
                    Integer.parseInt(instructions[3]),
                    Integer.parseInt(instructions[5])
            );
        }
    }

    private String getTopStacks() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= totalStacks; i++) {
            stringBuilder.append(crateMap.get(i).peek());
        }
        return stringBuilder.toString();
    }

    @Override
    public Object part1() {
        CrateMover mover = new CrateMover9000();
        setupCrateMap();
        executeProcedure(mover);
        return getTopStacks();
    }

    @Override
    public Object part2() {
        CrateMover mover = new CrateMover9001();
        setupCrateMap();
        executeProcedure(mover);
        return getTopStacks();
    }
}