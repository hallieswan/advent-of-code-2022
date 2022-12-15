package com.hallietheswan;

import com.hallietheswan.day09.Knot;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Day09 implements Day {

    ArrayList<Knot> knots;

    private List<String> input;

    public Day09(String fileName) throws URISyntaxException, IOException {
        input = Utility.readFileLinesFromResources(fileName);
    }

    private void createKnotsList(int nKnots) {
        knots = new ArrayList();
        knots.add(new Knot(null));
        for (int i = 1; i < nKnots; i++) {
            Knot prevKnot = knots.get(i - 1);
            Knot knot = new Knot(prevKnot);
            prevKnot.setTail(knot);
            knots.add(knot);
        }
    }

    private int getTailPositionsCount() {
        Knot tail = knots.get(knots.size() - 1);
        return tail.positionsCount();
    }

    private int executeInput(int nKnots) {

        // create this list of knots
        createKnotsList(nKnots);
        Knot head = knots.get(0);

        // update the head
        for (String steps : input) {
            String[] parts = steps.split(" ");
            char direction = parts[0].charAt(0);
            int iterations = Integer.parseInt(parts[1]);
            for (int i = 0; i < iterations; i++) {
                head.movePosition(direction);
            }
        }

        // return position of last element
        return getTailPositionsCount();
    }

    @Override
    public Object part1() {
        return executeInput(2);
    }

    @Override
    public Object part2() {
        return executeInput(10);
    }
}
