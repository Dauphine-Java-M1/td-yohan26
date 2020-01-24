/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.ja.sebaghyohan.shapes.model;

import fr.dauphine.ja.sebaghyohan.shapes.view.Drawer;

/**
 *
 * 
 */
public abstract class Shape {
    
    private Drawer drawer;
    
    public void setDrawer(Drawer d){
        this.drawer = d;
    }
    
    public Drawer getDrawer(){
        return this.drawer;
    }
    
    public abstract boolean contains(Point p);
    public abstract void translate(int dx, int dy);
    
}
