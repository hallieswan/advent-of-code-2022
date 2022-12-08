package com.hallietheswan;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Day07 implements Day {
    private List<String> navigation;
    private DirectoryNode root;

    public Day07(String fileName) throws URISyntaxException, IOException {
        this.navigation = Utility.readFileLinesFromResources(fileName);
        root = new DirectoryNode("/");
        buildDirectory();
    }

    private DirectoryNode cd(DirectoryNode current, String directory) {
        // change current parent node
        if (directory.equals("..") && current != root) {
            // move up a node
            current = current.moveToParent();
        } else if (directory.equals("/")) {
            // move to root
            current = root;
        } else {
            // move to child
            current = current.moveToChild(directory);
        }
        return current;
    }
    
    private void buildDirectory() {
        DirectoryNode current = root;
        for (String input : navigation) {
            input = input.replace("$ ", "");
            if (!input.equals("ls")) {
                String[] vals = input.split(" ");
                String first = vals[0];
                String second = vals[1];
                if (first.equals("dir")) {
                    // create directory
                    current.insertChildDirectory(second);
                } else if (first.matches("\\d+")) {
                    // create file
                    current.insertFile(second, Integer.parseInt(first));
                } else if (first.equals("cd")) {
                    // change directories
                    current = cd(current, second);
                }
            }
        }
    }

    @Override
    public Object part1() {
        int total = 0;
        Queue<DirectoryNode> queue = new ArrayDeque();
        queue.add(root);
        while (!queue.isEmpty()) {
            DirectoryNode current = queue.poll();
            int dirSize = current.getTotalFileSize();
            if (dirSize <= 100000) {
                total += dirSize;
            }
            for (DirectoryNode child : current.getChildren()) {
                queue.add(child);
            }
        }
        return total;
    }

    @Override
    public Object part2() {
        return -1;
    }
}
