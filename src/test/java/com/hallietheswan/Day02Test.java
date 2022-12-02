package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class Day02Test {

    @Test
    void part1() throws URISyntaxException, IOException {
        Day02 day02 = new Day02("day02_test.txt");
        assertEquals(15, day02.part1());
    }

}