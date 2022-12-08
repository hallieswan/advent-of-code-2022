package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Array;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Day08 implements Day {

    private int[][] trees;
    private int nRows;
    private int nCols;

    public Day08(String fileName) throws URISyntaxException, IOException {
        List<String> input = Utility.readFileLinesFromResources(fileName);
        fillTrees(input);
    }

    private void fillTrees(List<String> input) {
        nRows = input.size();
        nCols = input.get(0).length();
        trees = new int[nRows][nCols];
        int row = 0;
        int col = 0;
        for (String rowInput : input) {
            String[] vals = rowInput.split("");
            for (String val : vals) {
                trees[row][col] = Integer.parseInt(val);
                col++;
            }
            row++;
            col = 0;
        }
    }

    // bfs from each node
    public boolean isVisible(int startRow, int startCol) {
        int val = trees[startRow][startCol];

        // look from here to left
        for (int row = startRow - 1; row >= -1; row--) {
            // went all the way outside, i.e. is visible
            if (row == -1) {
                return true;
            }
            // otherwise, break as soon as tree is not visible
            if (val <= trees[row][startCol]) {
                break;
            }
        }

        // look from here to right
        for (int row = startRow + 1; row <= nRows; row++) {
            // went all the way outside, i.e. is visible
            if (row == nRows) {
                return true;
            }
            // otherwise, break as soon as tree is not visible
            if (val <= trees[row][startCol]) {
                break;
            }
        }

        // look from here to top
        for (int col = startCol - 1; col >= -1; col--) {
            // went all the way outside, i.e. is visible
            if (col == -1) {
                return true;
            }
            // otherwise, break as soon as tree is not visible
            if (val <= trees[startRow][col]) {
                break;
            }
        }

        // look from here to bottom
        for (int col = startCol + 1; col <= nCols; col++) {
            // went all the way outside, i.e. is visible
            if (col == nCols) {
                return true;
            }
            // otherwise, break as soon as tree is not visible
            if (val <= trees[startRow][col]) {
                break;
            }
        }

        // never reached the outside of the grid, i.e. not visible
        return false;
    }

    @Override
    public Object part1() {
        // account for edges, which are visible by default
        int nVisible = (2 * (nRows)) + (2 * (nCols - 2));
        for (int row = 1; row < nRows - 1; row++) {
            for (int col = 1; col < nCols - 1; col++) {
                if (isVisible(row, col)) nVisible++;
            }
        }
        return nVisible;
    }

    @Override
    public Object part2() {
        return -1;
    }
}
