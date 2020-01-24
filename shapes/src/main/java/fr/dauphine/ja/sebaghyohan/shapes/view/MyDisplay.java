package fr.dauphine.ja.sebaghyohan.shapes.view;

import fr.dauphine.ja.sebaghyohan.shapes.model.LigneBrisee;
import fr.dauphine.ja.sebaghyohan.shapes.model.Point;
import fr.dauphine.ja.sebaghyohan.shapes.model.Shape;
import fr.dauphine.ja.sebaghyohan.shapes.model.World;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyDisplay extends JPanel {
    
    private World world;
    
    public MyDisplay(){
        super();
        this.world = new World();
    }
    
    public MyDisplay(World world){
        super();
        this.world = world;
    }
     
    @Override
    public void paintComponent(Graphics g) {
        for(Shape shape : world.getShapes()){
            shape.getDrawer().draw(g);
        }
    }
	
	
    public static void main(String[] args) {
        
	JFrame frame = new JFrame("Java Avancée - Graphic Display");
	frame.setSize(new Dimension(900,900));
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        World world = new World();
	Point p1 = new Point(10,20);
        Point p2 = new Point(20,30);
        Point p3 = new Point(30,40);
        Point p4 = new Point(40,50);
        Point p5 = new Point(60,100);
        Point p6 = new Point(200,300);
        Point p7 = new Point(15,35);
        
        LigneBrisee brokenLine = new LigneBrisee(20);
        
        
   
    }
}
