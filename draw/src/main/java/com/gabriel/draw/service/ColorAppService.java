package com.gabriel.draw.service;

import java.awt.Color;

public class ColorAppService {
    private Color currentColor = Color.BLACK;

    public void setColor(Color color) {
        this.currentColor = color;
    }

    public Color getColor() {
        return currentColor;
    }
}
