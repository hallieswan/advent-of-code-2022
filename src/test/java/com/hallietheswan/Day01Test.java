package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class Day01Test {

    @Test
    void part1() throws URISyntaxException, IOException {
        Day01 day01 = new Day01();
        assertEquals(24000, day01.part1("day01_part1_input.txt"));
    }
}