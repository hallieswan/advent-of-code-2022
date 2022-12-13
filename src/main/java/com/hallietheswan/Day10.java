package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Day10 implements Day {

    List<String> input;

    public Day10(String fileName) throws URISyntaxException, IOException {
        input = Utility.readFileLinesFromResources(fileName);
    }

    private int getSignalStrength(int cycles, int register) {
        if (cycles == 20 || (cycles - 20) % 40 == 0) {
            return cycles * register;
        }
        return 0;
    }

    private int processInput() {
        int cycles = 1;
        int register = 1;
        int totalSignalStrength = 0;
        for (String line : input) {
            cycles++;
            totalSignalStrength += getSignalStrength(cycles, register);
            if (!line.equals("noop")) {
                cycles++;
                int v = Integer.parseInt(line.split(" ")[1]);
                register += v;
                totalSignalStrength += getSignalStrength(cycles, register);
            }
        }
        return totalSignalStrength;
    }


    @Override
    public Object part1() {
        return processInput();
    }

    @Override
    public Object part2() {
        return -1;
    }
}
