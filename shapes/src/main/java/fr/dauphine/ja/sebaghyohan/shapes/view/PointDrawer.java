/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.ja.sebaghyohan.shapes.view;

import fr.dauphine.ja.sebaghyohan.shapes.model.Point;
import java.awt.Graphics;

/**
 *
 * 
 */
public class PointDrawer implements Drawer {

    private Point point;
    
    public PointDrawer(Point p){
        this.point = p;
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawOval(point.getX(), point.getY(), 2, 2);
    }
    
}
