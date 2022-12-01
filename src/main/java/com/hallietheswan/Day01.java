package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day01 {

    private List<String> readFileLinesFromResources(String fileName) throws URISyntaxException, IOException {
        return Files.readAllLines(
                Paths.get(
                        getClass().getResource("/" +fileName).toURI()
                )
        );
    }

    public int part1(String fileName) throws URISyntaxException, IOException {
        // load file from resources
        // ...https://stackoverflow.com/a/58230499
        List<String> input = readFileLinesFromResources(fileName);

        // calculate totals for each elf
        int maxCalories = Integer.MIN_VALUE;
        int elfCalories = 0;
        for (String str : input) {
            if (str.equals("")) {
                maxCalories = Math.max(maxCalories, elfCalories);
                elfCalories = 0;
            } else {
                elfCalories += Integer.parseInt(str);
            }
        }

        return maxCalories;
    }

    public static void main(final String[] args) throws IOException, URISyntaxException {
        System.out.println("Day01 ------------");
        System.out.print("Part 1: ");
        Day01 day01 = new Day01();
        System.out.println(day01.part1("day01_part1_input.txt"));
    }
}
