package fr.dauphine.ja.sebaghyohan.threads;


public class ScalarThread extends Thread{
    
    private MySafeList v1;
    private MySafeList v2;
    private int begin;
    private int end;
    private Double scalar;
    
    public ScalarThread(MySafeList l1, MySafeList l2, int begin, int end){
        this.v1 = l1;
        this.v2 = l2;
        this.begin = begin;
        this.end = end;
        this.start();
    }
    
    @Override
    public void run(){
        
        scalar = MySafeList.scalar(v1, v2, begin, end);
        
    }
    
    public Double getResult(){
        
        return scalar;
    }
}
