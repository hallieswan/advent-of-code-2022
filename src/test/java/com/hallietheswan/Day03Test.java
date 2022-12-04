package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class Day03Test {

    @Test
    void part1() throws URISyntaxException, IOException {
        Day03 day03 = new Day03("day03_test.txt");
        assertEquals(157, day03.part1());
    }
}