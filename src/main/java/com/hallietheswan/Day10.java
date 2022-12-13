package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Day10 implements Day {

    private int cycles;
    private int register;
    private int totalSignalStrength;
    private final int SCREEN_WIDTH = 40;
    private final int SCREEN_HEIGHT = 6;
    private Screen screen;


    public Day10(String fileName) throws URISyntaxException, IOException {
        processInput(Utility.readFileLinesFromResources(fileName));
    }

    private int getSignalStrength(int cycles, int register) {
        if (cycles == 20 || (cycles - 20) % 40 == 0) {
            return cycles * register;
        }
        return 0;
    }

    private void processInput(List<String> input) {
        cycles = 1;
        register = 1;
        totalSignalStrength = 0;
        screen = new Screen(SCREEN_WIDTH, SCREEN_HEIGHT);
        screen.updateScreen(cycles, register);

        for (String line : input) {
            cycles++;
            totalSignalStrength += getSignalStrength(cycles, register);
            screen.updateScreen(cycles, register);
            if (!line.equals("noop")) {
                cycles++;
                int v = Integer.parseInt(line.split(" ")[1]);
                register += v;
                totalSignalStrength += getSignalStrength(cycles, register);
                screen.updateScreen(cycles, register);
            }
        }
    }

    @Override
    public Object part1() {
        return totalSignalStrength;
    }

    @Override
    public Object part2() {
        return screen;
    }
}
