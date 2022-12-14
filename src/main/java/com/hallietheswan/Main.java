package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.TreeMap;

public class Main {

    private static TreeMap<Integer, Day> days = new TreeMap<>();

    static {
        try {
            days.put(1, new Day01("day01_input.txt"));
            days.put(2, new Day02("day02_input.txt"));
            days.put(3, new Day03("day03_input.txt"));
            days.put(4, new Day04("day04_input.txt"));
            days.put(5, new Day05("day05_input.txt"));
            days.put(6, new Day06("day06_input.txt"));
            days.put(7, new Day07("day07_input.txt"));
            days.put(8, new Day08("day08_input.txt"));
            days.put(9, new Day09("day09_input.txt"));
            days.put(10, new Day10("day10_input.txt"));
            days.put(11, new Day11("day11_input.txt"));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Main() throws URISyntaxException, IOException {
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        for (int day : days.keySet()) {
            Day thisDay = days.get(day);
            System.out.printf("Day%02d ------------\n", day);
            System.out.print("Part 1: ");
            System.out.println(thisDay.part1());
            System.out.print("Part 2: ");
            System.out.println(thisDay.part2());
        }
    }
}