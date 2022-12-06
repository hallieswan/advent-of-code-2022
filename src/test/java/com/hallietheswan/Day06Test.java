package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class Day06Test {

    @Test
    void part1() throws URISyntaxException, IOException {
        Day06 day06 = new Day06("day06_test1.txt");
        assertEquals(5, day06.part1());

        day06 = new Day06("day06_test2.txt");
        assertEquals(6, day06.part1());

        day06 = new Day06("day06_test3.txt");
        assertEquals(10, day06.part1());

        day06 = new Day06("day06_test4.txt");
        assertEquals(11, day06.part1());
    }

    @Test
    void part2() throws URISyntaxException, IOException {
        Day05 day05 = new Day05("day05_test.txt");
        assertEquals("MCD", day05.part2());
    }
}