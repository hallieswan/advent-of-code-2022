package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

public class Day06 implements Day {

    private String input;

    public Day06(String fileName) throws URISyntaxException, IOException {
        input = Utility.readFileLinesFromResources(fileName).get(0);
    }

    private int getMessageStartIndex(int nDistinctMessageChars) {
        int left = 0;
        HashMap<Character, Integer> map = new HashMap();
        for (int right = 0; right < input.length(); right++) {
            // if right - left = nDistinctMessageChars
            // ...then we're good to go
            if (right - left == nDistinctMessageChars) {
                return right;
            }

            char c = input.charAt(right);
            if (map.containsKey(c)) {
                // move left forward
                left = Math.max(left, map.get(c) + 1);
            }

            // update the entry for this char
            map.put(c, right);
        }

        return -1;
    }

    @Override
    public Object part1() {
        return getMessageStartIndex(4);
    }

    @Override
    public Object part2() {
        return getMessageStartIndex(14);
    }
}
