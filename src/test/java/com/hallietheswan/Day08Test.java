package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day08Test {

    @Test
    public void part1() throws URISyntaxException, IOException {
        Day08 day08 = new Day08("day08_test.txt");
        assertEquals(21, day08.part1());
    }

    @Test
    public void part2() throws URISyntaxException, IOException {
        Day08 day08 = new Day08("day08_test.txt");
        assertEquals(8, day08.part2());
    }
}
