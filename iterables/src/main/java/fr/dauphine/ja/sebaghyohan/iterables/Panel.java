package fr.dauphine.ja.sebaghyohan.iterables;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Panel extends AbstractList<Integer> {
    
    private Integer first;
    private Integer end;
  
    public Panel (int first, int end){
        if(first > end) throw new IllegalArgumentException(" The fisrt number has to be less or equal to end ! ");
        this.first = first;
        this.end = end;
    }
    
    public static void main( String[] args ) {
        // question 1
        /*Iterator<Integer> it=panel1(1,5);
        for(;it.hasNext();)
            System.out.println(it.next());
        */
        
        //question 3
        for(int i:panel2(1,5))
            System.out.println(i); 
        
        // question 5
        List<Integer> l = panel(-2,2);
        for(int i:l) {
            System.out.println(i);
            
        }
    }
    
    public static Iterator<Integer> panel1(int first, int end){
        
        // question 1
        /*
        Panel myPanel = new Panel();
        myPanel.firstNumber = begining;
        myPanel.nbNumbers = end - begining + 1;
        return myPanel;*/
        
        // question 2
        Iterator<Integer> iterator = new Iterator<Integer>(){
           
            int currentValue = first;
            
            public boolean hasNext(){
                
                return currentValue <= end;
            }
            
            public Integer next(){
                return currentValue++;
            }
        };
        
        return iterator;
     
    }
    // question 1
    /*
    public boolean hasNext() {
        if(nbNumbers > 0) {
            nbNumbers--;
            return true;
        }
        else return false;
    }

    public Integer next() {
        
        Integer tmp = this.firstNumber;
        firstNumber += 1;
        return tmp;
        
    }

   */
    
    public static Iterable<Integer> panel2(final int first,final int end){
        
        return new Iterable<Integer>(){
          
            @Override
            public Iterator<Integer> iterator(){
                return Panel.panel1(first, end);
            }
        };
    }
    
    @Override
    public int size(){
        return this.end - this.first + 1;
    }
    
    @Override
    public Integer get(int index){
        if(index > this.size() || index < 0) throw new IndexOutOfBoundsException("Index out of bounds !");
        return this.first + index;
    }
    
    public static List<Integer> panel(int begining, int end){
        return new Panel(begining, end);
    }
    
}
