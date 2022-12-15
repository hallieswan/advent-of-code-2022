package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day11Test {

    @Test
    public void part1() throws URISyntaxException, IOException {
        Day11 day11 = new Day11("day11_test.txt");
        assertEquals(10605L, day11.part1());
    }

    @Test
    public void part2() throws URISyntaxException, IOException {
        Day11 day11 = new Day11("day11_test.txt");
        assertEquals(2713310158L, day11.part2());
    }
}
