package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day12Test {

    @Test
    public void part1() throws URISyntaxException, IOException {
        Day12 day12 = new Day12("day12_test.txt");
        assertEquals(31, day12.part1());
    }

    @Test
    public void part2() throws URISyntaxException, IOException {
        Day12 day12 = new Day12("day12_test.txt");
        assertEquals(29, day12.part2());
    }
}
