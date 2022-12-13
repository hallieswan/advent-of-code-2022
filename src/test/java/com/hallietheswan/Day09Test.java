package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day09Test {

    @Test
    public void part1() throws URISyntaxException, IOException {
        Day09 day09 = new Day09("day09_test0.txt");
        assertEquals(13, day09.part1());
    }

    @Test
    public void part2() throws URISyntaxException, IOException {
        Day09 day09 = new Day09("day09_test0.txt");
        assertEquals(1, day09.part2());

        day09 = new Day09("day09_test1.txt");
        assertEquals(36, day09.part2());
    }
}
