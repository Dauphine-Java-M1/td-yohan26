package fr.dauphine.ja.sebaghyohan.iterables;

import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class Mult {
    
    public static List<Integer> mult2(int coefficient, List<Integer> list){
        
        List<Integer> listInteger = new ArrayList<>();

        for(Integer integer : list){
            listInteger.add(integer * coefficient);
        }
        
        return listInteger;
    }
    
    public static List<Integer> mult(int coefficient, List<Integer> list){
        
        if(list instanceof RandomAccess){
            
            return new AbstractList<Integer>(){
            
                @Override
                public int size(){
                    return list.size();
                }
                
                @Override
                public Integer get(int index){
                    return list.get(index) * coefficient;
                }
                
            };
        }
        
        return new AbstractSequentialList<Integer>(){
            
            @Override
            public ListIterator<Integer> listIterator(final int index){
                
                return new ListIterator<Integer>(){
                    
                    ListIterator<Integer> listIt = list.listIterator(index);
                    
                    @Override
                    public boolean hasNext() {
                        return listIt.hasNext();
                    }

                    @Override
                    public Integer next() {
                        return listIt.next() * coefficient;
                    }

                    @Override
                    public boolean hasPrevious() {
                        return listIt.hasPrevious();
                    }

                    @Override
                    public Integer previous() {
                        return listIt.previous() * coefficient;
                    }

                    @Override
                    public int nextIndex() {
                        return listIt.nextIndex();
                    }

                    @Override
                    public int previousIndex() {
                        return listIt.previousIndex();
                    }

                    @Override
                    public void remove() {
                        listIt.remove();
                    }

                    @Override
                    public void set(Integer e) {
                        listIt.set(e);
                    }

                    @Override
                    public void add(Integer e) {
                        listIt.add(e);
                    }
                    
                };
            }
            
            @Override
            public int size(){
                return list.size();
            }
        };
    }
    
    
    public static void main(String[] args){
        
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            al.add(i);
        }
        long t0 = System.nanoTime();
        List<Integer> ret = Mult.mult(2, al);
        long sum=0;
        for(int val : ret) {
            sum+=val/2;
        }
        System.out.println((System.nanoTime() - t0));
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 1000000; i++) {
            ll.add(i);
        }
        t0 = System.nanoTime();
        sum=0;
        ret = Mult.mult(2, ll);
        for(int val : ret) {
            sum+=val/2;
        }
        System.out.println((System.nanoTime() - t0));
    }
}
