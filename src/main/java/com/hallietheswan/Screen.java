package com.hallietheswan;

public class Screen {
    private char[][] screen;
    private int screenWidth;
    private int screenHeight;

    public Screen(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        screen = new char[screenHeight][screenWidth];
    }

    public void updateScreen(int cycles, int register) {
        int pos = cycles - 1;
        int row = pos / screenWidth;
        int col = pos % screenWidth;
        if (row < screenHeight) {
            screen[row][col] = Math.abs(register - col) <= 1 ? '#' : '.';
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < screenHeight; row++) {
            sb.append('\n');
            for (int col = 0; col < screenWidth; col++) {
                sb.append(screen[row][col]);
            }
        }
        return sb.toString();
    }

}