package com.hallietheswan;

import com.hallietheswan.day12.Coordinate;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class Day12 implements Day {

    private char[][] map;
    private int nCols;
    private int nRows;
    private Coordinate startPos;
    private Coordinate endPos;
    private final List<Coordinate> directions = List.of(
            new Coordinate(0, -1),
            new Coordinate(0, 1),
            new Coordinate(-1, 0),
            new Coordinate(1, 0)
    );

    public Day12(String fileName) throws URISyntaxException, IOException {
        List<String> input = Utility.readFileLinesFromResources(fileName);
        fillMap(input);
    }

    private void fillMap(List<String> input) {
        nRows = input.size();
        nCols = input.get(0).length();
        map = new char[nRows][nCols];

        for (int row = 0; row < nRows; row++) {
            String line = input.get(row);
            for (int col = 0; col < nCols; col++) {
                // set this position
                map[row][col] = line.charAt(col);

                // update the height for the start
                if (map[row][col] == 'S') {
                    startPos = new Coordinate(row, col);
                }

                // ...and end locations
                if (map[row][col] == 'E') {
                    endPos = new Coordinate(row, col);
                }
            }
        }
    }

    private char remapHeightStartEndCoordinates(char height) {
        if (height == 'E') {
            return 'z';
        } else if (height == 'S') {
            return 'a';
        }
        return height;
    }

    private boolean canReachNextPos(Coordinate currentCoordinate, Coordinate nextCoordinate) {
        char currentHeight = map[currentCoordinate.getRow()][currentCoordinate.getCol()];
        char nextHeight = map[nextCoordinate.getRow()][nextCoordinate.getCol()];
        return remapHeightStartEndCoordinates(nextHeight) -
                remapHeightStartEndCoordinates(currentHeight) <= 1;
    }

    private boolean isValidNextPos(Coordinate currentCoordinate, Coordinate nextCoordinate, Set<Coordinate> visited, boolean headingUpHill) {
        int nextRow = nextCoordinate.getRow();
        int nextCol = nextCoordinate.getCol();
        boolean isValid = nextRow >= 0 && nextRow < nRows &&
                nextCol >= 0 && nextCol < nCols &&
                !visited.contains(nextCoordinate);
        if (headingUpHill) {
            isValid = isValid && canReachNextPos(currentCoordinate, nextCoordinate);
        } else {
            isValid = isValid && canReachNextPos(nextCoordinate, currentCoordinate);
        }
        return isValid;
    }

    private void bfs(Coordinate currentCoordinate, Queue<Coordinate> queue, Set<Coordinate> visited, Map<Coordinate, Integer> path, boolean isHeadingUphill) {
        // continue searching
        for (Coordinate direction : directions) {
            int row = currentCoordinate.getRow() + direction.getRow();
            int col = currentCoordinate.getCol() + direction.getCol();
            Coordinate nextPos = new Coordinate(row, col);
            if (isValidNextPos(currentCoordinate, nextPos, visited, isHeadingUphill)) {
                // update shortest path
                path.put(nextPos, path.get(currentCoordinate) + 1);

                // mark as visited
                visited.add(nextPos);

                // add this to the queue
                queue.add(nextPos);
            }
        }
    }

    private boolean meetsEndingCriteria(Coordinate coordinate, char endingChar) {
        char currentChar = map[coordinate.getRow()][coordinate.getCol()];
        return currentChar == endingChar;
    }

    private int search(Coordinate startCoordinate, char endingChar, boolean isHeadingUphill) {
        // list of positions visited
        Set<Coordinate> visited = new HashSet<>();

        // queue to track positions to still visit
        Queue<Coordinate> queue = new LinkedList<>();

        // track shortest path to each position
        Map<Coordinate, Integer> path = new HashMap<>();

        // add the starting position
        visited.add(startCoordinate);
        queue.add(startCoordinate);
        path.put(startCoordinate, 0);

        // bfs search
        while (!queue.isEmpty()) {
            Coordinate currentCoordinate = queue.poll();
            if (meetsEndingCriteria(currentCoordinate, endingChar)) {
                return path.get(currentCoordinate);
            }
            bfs(currentCoordinate, queue, visited, path, isHeadingUphill);
        }

        return -1;
    }

    @Override
    public Object part1() {
        return search(startPos, 'E', true);
    }

    @Override
    public Object part2() {
        return search(endPos, 'a', false);
    }
}
