package fr.dauphine.ja.sebaghyohan.shapes.model;


import fr.dauphine.ja.sebaghyohan.shapes.model.Point;
import fr.dauphine.ja.sebaghyohan.shapes.view.LineDrawer;
import java.util.LinkedList;

public class LigneBrisee extends Shape {
	
	private LinkedList<Point> listPoint;
	private int max;
	
	public LigneBrisee(int max) {
		listPoint = new LinkedList<>();
		this.max = max;
                super.setDrawer(new LineDrawer(this));
	}
        
        public int getSize(){
            return this.max;
        }
        
        public LinkedList<Point> getListPoint(){
            return this.listPoint;
        }
	
	public void add(Point p) {
		if(this.listPoint.size() > this.max) {
			listPoint.add(p);
		}
		
		
	}
	
	public int pointCapacity() {
		return this.max;
	}
	
	public int nbPoints() {
		return this.listPoint.size();
	}
	
        @Override
	public boolean contains(Point z) {
		for(Point point : this.listPoint) {
			if(point.equals(z)) return true;
		}
		return false;
	}
	
        @Override
	public void translate(int dx, int dy){
            for(Point p : this.listPoint){
                p.translate(dx, dy);
            }
        }
        
	public static void main( String[] args ) {
		LigneBrisee l = new LigneBrisee(10);
		Point p = null;
		Point p1 = new Point(1,2);
		l.add(null);
		System.out.println(l.contains(null));
		System.out.println(l);
		
		
	}
}
