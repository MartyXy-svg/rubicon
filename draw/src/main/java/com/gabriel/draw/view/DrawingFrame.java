package com.gabriel.draw.view;

import com.gabriel.draw.controller.DrawingWindowController;
import com.gabriel.drawfx.DrawMode;
import com.gabriel.drawfx.ShapeMode;
import com.gabriel.drawfx.model.Drawing;
import com.gabriel.drawfx.service.AppService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingFrame extends JFrame {


    public DrawingFrame(AppService appService){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton lineButton = new JButton("Line");
        JButton ellipseButton = new JButton("Ellipse");
        JButton rectButton = new JButton("Rectangle");
        JButton colorButton = new JButton("Color");

        lineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                appService.setShapeMode(ShapeMode.Line);
                appService.setDrawMode(DrawMode.Idle);
                System.out.println("You are in Line Mode.");
            }
        });

        rectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                appService.setShapeMode(ShapeMode.Rectangle);
                appService.setDrawMode(DrawMode.Idle);
                System.out.println("You are in Rectangle Mode.");
            }
        });

        ellipseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                appService.setShapeMode(ShapeMode.Ellipse);
                appService.setDrawMode(DrawMode.Idle);
                System.out.println("You are in Ellipse Mode.");           }
        });

        colorButton.addActionListener(e -> {
            Color chosen = JColorChooser.showDialog(this, "Choose Drawing Color", Color.BLACK);
            if (chosen != null) {
                appService.setColor(chosen); // You need this method in AppService
                System.out.println("Color changed to: " + chosen);
            }
        });

        buttonPanel.add(lineButton);
        buttonPanel.add(ellipseButton);
        buttonPanel.add(rectButton);
        buttonPanel.add(colorButton);

        this.add(buttonPanel, BorderLayout.NORTH);

        DrawingWindowController drawingWindowController = new DrawingWindowController(appService);
        this.addWindowListener(drawingWindowController);
        this.addWindowFocusListener(drawingWindowController);
        this.addWindowStateListener(drawingWindowController);

        DrawingView drawingView = new DrawingView(appService);
        this.getContentPane().add(drawingView);
    }
}
