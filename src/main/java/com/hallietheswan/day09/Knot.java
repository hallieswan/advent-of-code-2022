package com.hallietheswan.day09;

import java.util.HashSet;

public class Knot {
    private HashSet<String> positions;
    private Knot head;
    private Knot tail;

    private int row;
    private int col;

    public Knot(Knot head) {
        this.head = head;
        row = 0;
        col = 0;
        positions = new HashSet<>();
        recordPosition();
    }

    public void setTail(Knot tail) {
        this.tail = tail;
    }

    private boolean isTouching() {
        return Math.abs(head.getRow() - row) <= 1 && Math.abs(head.getCol() - col) <= 1;
    }

    private boolean shouldMoveVertically() {
        return !isTouching() && head.getCol() == col;
    }

    private boolean shouldMoveHorizontally() {
        return !isTouching() && head.getRow() == row;
    }

    private boolean shouldMoveDiagonally() {
        return !isTouching() && !shouldMoveVertically() && !shouldMoveHorizontally();
    }

    private void moveHorizontally() {
        col = head.getCol() > col ? col + 1 : col - 1;
    }

    private void moveVertically() {
        row = head.getRow() > row ? row + 1 : row - 1;
    }

    // tail - update position based on head
    public void updatePosition() {
        // update position
        boolean didMove = true;
        if (shouldMoveVertically()) {
            moveVertically();
        } else if (shouldMoveHorizontally()) {
            moveHorizontally();
        } else if (shouldMoveDiagonally()) {
            moveVertically();
            moveHorizontally();
        } else {
            didMove = false;
        }

        // move its tail, if it moved
        if (didMove) {
            recordPosition();
            updateTail();
        }
    }

    // head - move position in a direction
    public void movePosition(char direction) {
        int increment = direction == 'R' || direction == 'U' ? 1 : -1;
        boolean moveHorizontally = direction == 'R' || direction == 'L';
        if (moveHorizontally) {
            row += increment;
        } else {
            col += increment;
        }
        recordPosition();
        updateTail();
    }

    private void updateTail() {
        if (tail != null) {
            tail.updatePosition();
        }
    }

    private void recordPosition() {
        positions.add(String.format("[%s,%s]", row, col));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int positionsCount() {
        return positions.size();
    }
}
