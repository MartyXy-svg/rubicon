package com.gabriel.draw.service;

import com.gabriel.draw.model.Line;
import com.gabriel.drawfx.service.RendererService;
import com.gabriel.drawfx.model.Shape;

import java.awt.*;


public class LineRendererService implements RendererService {

    @Override
    public void render(Graphics g, Shape shape, boolean xor) {
        System.out.println("Rendering line with color: " + shape.getColor());

        if (xor) {
            g.setXORMode(Color.WHITE);
        } else {
            g.setPaintMode();
        }
        g.setColor(shape.getColor());
        Line line = (Line) shape;
        g.drawLine(line.getLocation().x, line.getLocation().y,
                line.getEnd().x, line.getEnd().y);
    }

}