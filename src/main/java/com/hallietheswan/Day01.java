package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 implements Day {

    ArrayList<Integer> elfCalories;

    public Day01(String fileName) throws URISyntaxException, IOException {

        // load file from resources
        List<String> input = readFileLinesFromResources(fileName);

        // calculate each elf's calories
        elfCalories = new ArrayList();
        int thisElf = 0;
        for (String str : input) {
            if (str.equals("")) {
                elfCalories.add(thisElf);
                thisElf = 0;
            } else {
                thisElf += Integer.parseInt(str);
            }
        }
        // add in last elf
        if (thisElf > 0) elfCalories.add(thisElf);

        // sort the array of calories
        Collections.sort(elfCalories);
    }

    private List<String> readFileLinesFromResources(String fileName) throws URISyntaxException, IOException {
        // read file from resources
        // ...https://stackoverflow.com/a/58230499
        return Files.readAllLines(
                Paths.get(
                        getClass().getResource("/" +fileName).toURI()
                )
        );
    }

    private int getTotalElfCalories(int nElves) {
        if (elfCalories.size() < nElves) {
            throw new IllegalArgumentException("Too many elves specified.");
        }
        int elfIndex = elfCalories.size() - 1;
        int totalCalories = 0;
        for (int i = 0; i < nElves; i++) {
            totalCalories += elfCalories.get(elfIndex - i);
        }
        return totalCalories;
    }

    @Override
    public int part1() {
        return getTotalElfCalories(1);
    }

    @Override
    public int part2() {
        return getTotalElfCalories(3);
    }

}
