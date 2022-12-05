package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day04Test {

    @Test
    public void part1() throws URISyntaxException, IOException {
        Day04 day04 = new Day04("day04_test.txt");
        assertEquals(2, day04.part1());
    }

    @Test
    public void part2() throws URISyntaxException, IOException {
        Day04 day04 = new Day04("day04_test.txt");
        assertEquals(4, day04.part2());
    }
}
