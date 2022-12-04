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

    private enum Outcome {
        LOSS,
        DRAW,
        WIN
    }

    // Outcome score - 0 for Loss, 3 for Draw, and 6 for Win
    private final Map<Outcome, Integer> outcomeScoreMap = Map.of(
            Outcome.LOSS, 0,
            Outcome.DRAW, 3,
            Outcome.WIN, 6
    );

    // Shape score - 1 for Rock, 2 for Paper, and 3 for Scissors
    private final Map<Shape, Integer> shapeScoreMap = Map.of(
            Shape.ROCK, 1,
            Shape.PAPER, 2,
            Shape.SCISSORS, 3
    );

    // Winner selection
    // - Rock defeats Scissors
    // - Scissors defeats Paper
    // - Paper defeats Rock
    // Key = Winner, Value = Loser
    private final Map<Shape, Shape> winShapeMap = Map.of(
            Shape.ROCK, Shape.SCISSORS,
            Shape.SCISSORS, Shape.PAPER,
            Shape.PAPER, Shape.ROCK
    );

    // Opponent shape map - A for Rock, B for Paper, and C for Scissors
    private final Map<String, Shape> opponentShapeMap = Map.of(
            "A", Shape.ROCK,
            "B", Shape.PAPER,
            "C", Shape.SCISSORS
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

    private Outcome evaluateOutcome(Shape theirShape, Shape myShape) {
        if (theirShape == myShape) return Outcome.DRAW;
        if (winShapeMap.get(theirShape) == myShape) return Outcome.LOSS;
        if (winShapeMap.get(myShape) == theirShape) return Outcome.WIN;
        // unexpected condition
        return null;
    }

    //  Outcome score (0 for loss, 3 for draw, and 6 for win)
    private int scoreOutcome(Outcome outcome) {
        return outcomeScoreMap.get(outcome);
    }

    private Shape getShapeForDesiredOutcome(Outcome outcome, Shape theirShape) {
        if (outcome == Outcome.DRAW) return theirShape;
        if (outcome == Outcome.LOSS) return winShapeMap.get(theirShape);

        // identify shape that will beat this shape
        for (Map.Entry<Shape, Shape> entry : winShapeMap.entrySet()) {
            if (entry.getValue() == theirShape) {
                return entry.getKey();
            }
        }
        // could not find a shape to beat this shape
        return null;
    }

    private int scoreRound(Outcome outcome, Shape myShape) {
        return scoreShape(myShape) + scoreOutcome(outcome);
    }

    @Override
    public int part1() {

        // Self shape map - X for Rock, Y for Paper, and Z for Scissors
        Map<String, Shape> myShapeMap = Map.of(
                "X", Shape.ROCK,
                "Y", Shape.PAPER,
                "Z", Shape.SCISSORS
        );

        int totalScore = 0;
        for (String round : instructions) {
            String[] shapes = round.split(" ");
            Shape theirShape = opponentShapeMap.get(shapes[0]);
            Shape myShape = myShapeMap.get(shapes[1]);
            Outcome outcome = evaluateOutcome(theirShape, myShape);
            totalScore += scoreRound(outcome, myShape);
        }

        return totalScore;
    }

    @Override
    public int part2() {
        // Desired Outcome map - X for Loss, Y for Draw, and Z for Win
        Map<String, Outcome> desiredOutcomeMap = Map.of(
                "X", Outcome.LOSS,
                "Y", Outcome.DRAW,
                "Z", Outcome.WIN
        );

        int totalScore = 0;
        for (String round : instructions) {
            String[] inputs = round.split(" ");
            Shape theirShape = opponentShapeMap.get(inputs[0]);
            Outcome outcome = desiredOutcomeMap.get(inputs[1]);
            Shape myShape = getShapeForDesiredOutcome(outcome, theirShape);
            totalScore += scoreRound(outcome, myShape);
        }

        return totalScore;
    }
}
