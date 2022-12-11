package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;

public class Day09 implements Day {

    private List<String> input;
    private HashSet<String> tailPositions;

    private int headRow;
    private int headCol;
    private int tailRow;
    private int tailCol;

    public Day09(String fileName) throws URISyntaxException, IOException {
        input = Utility.readFileLinesFromResources(fileName);
        tailPositions = new HashSet();
        headRow = 0;
        headCol = 0;
        tailRow = 0;
        tailCol = 0;
        executeInput();
    }

    private boolean isTouching() {
        return Math.abs(headRow - tailRow) <= 1 && Math.abs(headCol - tailCol) <= 1;
    }

    private boolean shouldMoveVertically() {
        return !isTouching() && headCol == tailCol;
    }

    private boolean shouldMoveHorizontally() {
        return !isTouching() && headRow == tailRow;
    }

    private boolean shouldMoveDiagonally() {
        return !isTouching() && !shouldMoveVertically() && !shouldMoveHorizontally();
    }

    private void moveHorizontally() {
        tailCol = headCol > tailCol ? tailCol + 1 : tailCol - 1;
    }

    private void moveVertically() {
        tailRow = headRow > tailRow ? tailRow + 1 : tailRow - 1;
    }

    private void updateTail() {
        // move tail
        if (shouldMoveVertically()) {
            moveVertically();
        } else if (shouldMoveHorizontally()) {
            moveHorizontally();
        } else if (shouldMoveDiagonally()) {
            moveVertically();
            moveHorizontally();
        }
        // record this position
        tailPositions.add(String.format("[%s,%s]", tailRow, tailCol));
    }

    private void moveHead(String direction, int steps) {
        int increment = direction.equals("R") || direction.equals("U") ? 1 : -1;
        boolean moveHorizontally = direction.equals("R") || direction.equals("L");
        for (int step = 0; step < steps; step++) {
            if (moveHorizontally) {
                headCol += increment;
            } else {
                headRow += increment;
            }
            updateTail();
        }
    }

    private void executeInput() {
        for (String steps : input) {
            String[] parts = steps.split(" ");
            moveHead(parts[0], Integer.parseInt(parts[1]));
        }
    }

    @Override
    public Object part1() {
        return tailPositions.size();
    }

    @Override
    public Object part2() {
        return -1;
    }
}
