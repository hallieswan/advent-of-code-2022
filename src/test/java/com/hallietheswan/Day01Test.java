package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {

    @Test
    void part1() throws URISyntaxException, IOException {
        Day01 day01 = new Day01("day01_test.txt");
        assertEquals(24000, day01.part1());
    }

    @Test
    void part2() throws URISyntaxException, IOException {
        Day01 day01 = new Day01("day01_test.txt");
        assertEquals(45000, day01.part2());
    }
}