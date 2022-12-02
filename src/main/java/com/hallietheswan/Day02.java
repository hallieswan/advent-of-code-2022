package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class Day02 implements Day {

    private enum Shape {
        ROCK,
        PAPER,
        SCISSORS
    }

    // Shape score - 1 for Rock, 2 for Paper, and 3 for Scissors
    private final Map<Shape, Integer> shapeScoreMap = Map.of(
            Shape.ROCK, 1,
            Shape.PAPER, 2,
            Shape.SCISSORS, 3
    );

    // Opponent shape map - A for Rock, B for Paper, and C for Scissors
    // Self shape map - X for Rock, Y for Paper, and Z for Scissors
    private final Map<String, Shape> shapeMap = Map.of(
            "A", Shape.ROCK,
            "B", Shape.PAPER,
            "C", Shape.SCISSORS,
            "X", Shape.ROCK,
            "Y", Shape.PAPER,
            "Z", Shape.SCISSORS
    );

    private List<String> instructions;

    public Day02(String fileName) throws URISyntaxException, IOException {
        // read in elf's input file
        // first column: opponent's play
        // second column: my play
        instructions = Utility.readFileLinesFromResources(fileName);
    }

    private int scoreShape(Shape myShape) {
        return shapeScoreMap.get(myShape);
    }

    //  Outcome score (0 for loss, 3 for draw, and 6 for win)
    private int scoreOutcome(Shape theirShape, Shape myShape) {

        // Winner selection
        // - Rock defeats Scissors
        // - Scissors defeats Paper
        // - Paper defeats Rock
        if ((theirShape == Shape.ROCK && myShape == Shape.SCISSORS) ||
                (theirShape == Shape.SCISSORS && myShape == Shape.PAPER) ||
                (theirShape == Shape.PAPER && myShape == Shape.ROCK)
        ) return 0;

        // If both players choose the same shape, the round instead ends in a draw.
        if (theirShape == myShape) return 3;

        // otherwise, win
        return 6;
    }

    // per round score: shape score + outcome score
    private int scoreRound(Shape theirShape, Shape myShape) {
        return scoreShape(myShape) + scoreOutcome(theirShape, myShape);
    }

    @Override
    public int part1() {

        int totalScore = 0;
        for (String round : instructions) {
            String[] shapes = round.split(" ");
            Shape theirShape = shapeMap.get(shapes[0]);
            Shape myShape = shapeMap.get(shapes[1]);
            totalScore += scoreRound(theirShape, myShape);
        }

        return totalScore;
    }

    @Override
    public int part2() {
        return -1;
    }
}
