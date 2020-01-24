/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.ja.sebaghyohan.shapes.view;

import fr.dauphine.ja.sebaghyohan.shapes.model.LigneBrisee;
import fr.dauphine.ja.sebaghyohan.shapes.model.Point;
import java.awt.Graphics;
import java.util.LinkedList;


public class LineDrawer implements Drawer {
    
    private LigneBrisee line;
    
    
    public LineDrawer(LigneBrisee line){
        this.line = line;
    }
    
    @Override
    public void draw(Graphics g) {
        
        if(line.getSize() == 1){
            PointDrawer pointDrawer = new PointDrawer(line.getListPoint().get(0));
            pointDrawer.draw(g);
        }
        else{
            int size = this.line.getSize();
            LinkedList<Point> listPoint = this.line.getListPoint();
            Point p0 = listPoint.get(0);
            for(int i = 1; i < size; i++){
                
                Point p1 = listPoint.get(i);
                g.drawLine(p0.getX(), p0.getY(), p1.getX(), p1.getY());
                p0 = p1;
                
            }
        }
        
    }
    
}
