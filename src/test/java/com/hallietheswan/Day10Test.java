package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day10Test {

    @Test
    public void part1() throws URISyntaxException, IOException {
        Day10 day10 = new Day10("day10_test.txt");
        assertEquals(13140, day10.part1());
    }
}
