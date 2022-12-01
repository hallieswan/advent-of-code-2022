package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {
        System.out.println("Day01 ------------");
        Day01 day01 = new Day01("day01_input.txt");
        System.out.print("Part 1: ");
        System.out.println(day01.part1());
        System.out.print("Part 2: ");
        System.out.println(day01.part2());
    }
}