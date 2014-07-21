package com.example.jason.theta_twist;

import processing.core.PApplet;
import controlP5.*;
import processing.core.PFont;
import android.util.DisplayMetrics;

public class MyActivity extends PApplet
  {
    float theta;
    float sz = 700;
    float x, y;
    int loops = 40;
    int colour = 50;
    ControlP5 controlP5;

    public void setup()
    {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        float density = dm.density;
        int densityDpi = dm.densityDpi;
        println("density is " + density);
        println("densityDpi is " + densityDpi);

        size(displayWidth, displayHeight, P2D);
        orientation(PORTRAIT);

        noFill();
        stroke(255);
        smooth(8);
        background(0);
        strokeWeight(1);
        x = width / 2;
        y = height / 2;

        // Create Control p5 GUI
        controlP5 = new ControlP5(this);
        PFont p = createFont("Verdana", 24);
        controlP5.setControlFont(p);
        controlP5.setColorLabel(color(255));
        controlP5.setColorForeground(color(255));
        controlP5.setColorBackground(color(90));
        controlP5.setColorValue(color(0));
        controlP5.setColorActive(color(224));
        controlP5.addSlider("loops", 0, 50, loops, 150, height - 180, 400, 40).setLabel("Loops");
        controlP5.addSlider("colour", 0, 180, colour, 150, height - 100, 400, 40).setLabel("Background");
    }

    public void draw()
    {
        background(colour);
        pushMatrix();
        translate(x, y);
        for (int i = 0; i < loops; i++) {
            rotate(theta);
            stroke(255);
            arc(0, 0, sz - i * 20, sz - i * 20, 0, PI);
        }
        popMatrix();
        theta += 0.0523 / 3;
    }

    public void mousePressed()
    {

    }

  }
