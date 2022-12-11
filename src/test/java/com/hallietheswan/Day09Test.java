package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day09Test {

    @Test
    public void part1() throws URISyntaxException, IOException {
        Day09 day09 = new Day09("day09_test.txt");
        assertEquals(13, day09.part1());
    }
}
