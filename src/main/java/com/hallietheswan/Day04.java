package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Day04 implements Day {

    class Range {
        private int start;
        private int end;
        public Range(String string) {
            String[] vals = string.split("-");
            start = Integer.parseInt(vals[0]);
            end = Integer.parseInt(vals[1]);
        }

        public int getStart() {
            return start;
        }
        public int getEnd() {
            return end;
        }

        public boolean contains(Range range) {
            return start <= range.getStart() && end >= range.getEnd();
        }

        public boolean overlaps(Range range) {
            return contains(range) || range.contains(this);
        }

    }

    private List<String> assignments;

    public Day04(String fileName) throws URISyntaxException, IOException {
        assignments = Utility.readFileLinesFromResources(fileName);
    }

    @Override
    public int part1() {
        int countOverlaps = 0;
        for (String str : assignments) {
            String[] rangeStrings = str.split(",");
            Range left = new Range(rangeStrings[0]);
            Range right = new Range(rangeStrings[1]);
            if (left.overlaps(right)) countOverlaps++;
        }
        return countOverlaps;
    }

    @Override
    public int part2() {
        return -2;
    }
}
