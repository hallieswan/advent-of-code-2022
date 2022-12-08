package com.hallietheswan;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day07Test {

    @Test
    public void part1() throws URISyntaxException, IOException {
        Day07 day07 = new Day07("day07_test.txt");
        assertEquals(95437, day07.part1());
    }
}
