/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.ja.sebaghyohan.shapes.view;

import fr.dauphine.ja.sebaghyohan.shapes.model.Ring;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * 
 */
public class RingDrawer implements Drawer {
    
    private Ring ring;
    
    public RingDrawer(Ring ring){
        this.ring = ring;
    }
    
    @Override
    public void draw(Graphics g) {
        
        int innerRadius = (int) ring.getInnerRadius();
        int x = ring.getOuterCircle().getCenter().getX() - innerRadius;
        int y = ring.getOuterCircle().getCenter().getY() - innerRadius;
        CircleDrawer circleDrawer = new CircleDrawer(ring.getOuterCircle());
        circleDrawer.draw(g);
        g.drawOval(x, y, innerRadius*2, innerRadius*2);
        g.setColor(Color.BLUE);
    }
    
}
