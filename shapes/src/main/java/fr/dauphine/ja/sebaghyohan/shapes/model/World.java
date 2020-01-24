/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.dauphine.ja.sebaghyohan.shapes.model;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * 
 */
public class World {
    
    private List<Shape> shapes;
    
    public World(){
        shapes = new ArrayList<>();
    }
    
    public List<Shape> getShapes(){
        return this.shapes;
    }
    
    public void add(Shape shape){
        shapes.add(shape);
    }
    
}
