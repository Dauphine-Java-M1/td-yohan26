package fr.dauphine.ja.sebaghyohan.shapes.model;

import fr.dauphine.ja.sebaghyohan.shapes.view.PointDrawer;
import java.util.ArrayList;

/**
 * 
 *
 */
public class Point extends Shape {
	
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
                super.setDrawer(new PointDrawer(this));
	}
	
	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	@Override 
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	
	@Override
	public boolean equals(Object z) {
		if(z == null) return false;
		Point tmp = (Point) z;
		if(tmp.x == this.x && tmp.y == this.y) return true;
		return false;
	}
	
      
        @Override
	public void translate(int dx, int dy) {
		this.x += dy;
		this.y += dx;
	}

        @Override
        public boolean contains(Point p) {
            return this.equals(p);
        }
}

class TestPoint {
	
	public static void main( String[] args )
    {
		// Exercice 1
        Point p = new Point(0,0);
        System.out.println(p);
        
        // Exercice 2
        Point p1 = new Point(1,2);
        Point p2 = p1;
        Point p3 = new Point(1,2);
        
        ArrayList<Point> list = new ArrayList<>();
        list.add(p1);
        System.out.println(list.indexOf(p2));
        System.out.println(list.indexOf(p3));
        
    }
}

