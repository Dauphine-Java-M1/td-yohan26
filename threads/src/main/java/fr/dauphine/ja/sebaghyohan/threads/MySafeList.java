package fr.dauphine.ja.sebaghyohan.threads;

import java.util.ArrayList;


public class MySafeList extends ArrayList<Double> {
    
    @Override
    public synchronized boolean add(Double d){
        return super.add(d);
    }
    
    @Override
    public int size(){
        return super.size();
    }
    
    @Override
    public Double get(int index){
        return super.get(index);
    }
    
    public static boolean stressTest(int n, final int m){
        
        final MySafeList list = new MySafeList();
        Thread[] threads = new Thread[n];
        
        try{
            for(int i = 0; i < n; i++){
                threads[i] = new Thread(new Runnable(){
           
                    public void run(){
                        for(int j = 0; j < m; j++){
                            list.add(new Double(2));
                        }
                    }
                });
            }
            
            for(int i = 0; i < n; i++){
                threads[i].start();
            }
            for(int i = 0; i < n; i++){
                threads[i].join();
            }
            
        //System.out.println(list);
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }catch(Exception e){
            return false;
        }
        
        if(list.size() == n * m) return true;
        return false;
    }
    
    public static Double scalar(MySafeList v1, MySafeList v2, int begin, int end){
        
        Double sum = 0.0;
        if(v1.size() != v2.size()) throw new IllegalArgumentException();
        if(begin < 0 || end > v1.size()) throw new IndexOutOfBoundsException();
        
        for(int i = begin; i < end; i++)
            sum += v1.get(i) * v2.get(i);
        
        return sum;
        
    }
    
    public static MySafeList generateSafeList(int size){
        
        MySafeList safeList = new MySafeList();
        Double min = 0.0;
        Double max = 10.0;
        for(int i = 0; i < size; i++){
            safeList.add(Math.random() * (max - min + 1.0));
        }
        return safeList;
    }
    
  
    
    public static Double parallelScalar(MySafeList v1, MySafeList v2, int n){
        
        Double resultParallelScalar = 0.0;
        ScalarThread[] threads = new ScalarThread[n];
        int sizeForThread = v1.size()/n;
        
        for(int i = 0; i < n-1; i++){
            threads[i] = new ScalarThread(v1, v2, i * sizeForThread, (i+1) * sizeForThread);
        }
        threads[n-1] = new ScalarThread(v1, v2,(n-1) * sizeForThread, v1.size());
       
        for(int i = 0; i < n; i++){
        	
            try{
                threads[i].join();
                result += threads[i].getResult();
                
            }catch(InterruptedException e){
                System.err.println("Error " + e);
            }
        }
        
        return resultParallelScalar;
    }
    
    
    
    public static void main(String[] args){
        
        // exercice 2 question 2, 3
        for(int i = 0; i < 10; i++){
            System.out.println(MySafeList.stressTest(10, 10000));
        }
        
        
        
        // exercice 3 question 5, 6
        int size = 100000;
        MySafeList l1 = generateSafeList(size);
        MySafeList l2 = generateSafeList(size);
        
        long start = System.nanoTime();
        Double result = MySafeList.scalar(l1, l2, 0, l1.size());
        long end = System.nanoTime();
        
        System.out.println("Temps d'execution implementation sequentielle : " + (end - start) *10E-9 + " s" );
        
        start = System.nanoTime();
        Double resultThread = MySafeList.parallelScalar(l1, l2, 10);
        end = System.nanoTime();
        System.out.println("Temps d'execution implementation 2 threads : " + (end - start)*10E-9 + " s" );
        
        System.out.println("resultat sequentielle : " + result);
        System.out.println("resultat 2 threads : " + resultThread);
        
    }
}
