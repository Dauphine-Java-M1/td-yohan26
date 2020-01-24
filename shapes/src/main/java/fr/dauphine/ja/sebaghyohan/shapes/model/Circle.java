package fr.dauphine.ja.sebaghyohan.shapes.model;

import fr.dauphine.ja.sebaghyohan.shapes.model.Point;
import fr.dauphine.ja.sebaghyohan.shapes.view.CircleDrawer;


public class Circle extends Shape {
	
	private Point point;
	private double radius;
	
	public Circle(Point p, double r) {
		this.point = p;
		this.radius = r;
                super.setDrawer(new CircleDrawer(this));
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public Point getCenter() {
		return new Point(point.getX(),point.getY());
	}
        

	
	@Override
	public String toString() {

		return "Cercle de centre " + this.point.toString() + " et de rayon " + this.radius + "et de surface " +  this.surface();
	}
	
        @Override
	public void translate(int dx, int dy) {
		Point tmp = new Point(point.getX(),point.getY());
		tmp.translate(dx, dy);
		this.point = tmp;
	}
	
	public double surface() {
		return this.radius* this.radius * Math.PI;
	}
	
        @Override
	public boolean contains(Point p) {
		double distance = Math.sqrt((p.getX() - this.point.getX())*(p.getX() - this.point.getX()) + (p.getY() - this.point.getY())*(p.getY() - this.point.getY()));
		if(distance < this.radius) {
			return true;
		}
		return false;
	}
	
	public static boolean contains(Point p, Circle... circles) {
		for(Circle c : circles) {
			if(c!= null && c.contains(p)) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Point p = new Point(1,2);
		Circle c = new Circle(p,1);
		
		Circle c2 = new Circle(p,2);
		c2.translate(1, 1);
		
		System.out.println(c + " " + c2);
		
		
		Circle c1 = new Circle(new Point(1,2),1);
		c1.getCenter().translate(1, 1);
		System.out.println(c1);
	}
}
