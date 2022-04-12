package ru.gb.lesson1;

import java.awt.*;

class Background {
    private static int[] directionRGB = {1, 1, 1};
    private static final int changeSpeed = 200;

    Background() {

    }

    public static void changeColor(GameCanvas canvas, float deltaTime) {
        int whatcolor = (int) (Math.random() * 3);
        int[] valueRGB = {canvas.getBackground().getRed(), canvas.getBackground().getGreen(), canvas.getBackground().getBlue()};
        int[] tmp = calcColor(valueRGB[whatcolor], directionRGB[whatcolor], deltaTime);
        valueRGB[whatcolor] = tmp[0];
        directionRGB[whatcolor] = tmp[1];
        canvas.setBackground(new Color(valueRGB[0], valueRGB[1], valueRGB[2]));
    }
    private static int[] calcColor(int colorValue, int valDown, float deltaTime) {
        int newValue = (int) (colorValue + deltaTime * changeSpeed * valDown);
        if (newValue < 0) {
            newValue = 0;
            valDown *= -1;
        } else if (newValue > 255) {
            newValue = 255;
            valDown *= -1;
        }
        int[] result = {newValue, valDown};
        return result;
    }
}