package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day10Test {

    @Test
    public void part1() throws URISyntaxException, IOException {
        Day10 day10 = new Day10("day10_test.txt");
        assertEquals(13140, day10.part1());
    }

    @Test
    public void part2() throws URISyntaxException, IOException {
        // read day10 expected output
        List<String> input = Utility.readFileLinesFromResources("day10_testOutput.txt");
        StringBuilder sb = new StringBuilder();
        for (String line : input) {
            sb.append('\n');
            sb.append(line);
        }

        Day10 day10 = new Day10("day10_test.txt");
        assertEquals(sb.toString(), day10.part2().toString());
    }
}
