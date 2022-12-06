package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class Day05Test {

    @Test
    void part1() throws URISyntaxException, IOException {
        Day05 day05 = new Day05("day05_test.txt");
        assertEquals("CMZ", day05.part1());
    }

    @Test
    void part2() throws URISyntaxException, IOException {
        Day05 day05 = new Day05("day05_test.txt");
        assertEquals("MCD", day05.part2());
    }
}