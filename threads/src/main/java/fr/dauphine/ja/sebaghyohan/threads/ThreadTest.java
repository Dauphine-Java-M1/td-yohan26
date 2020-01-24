package fr.dauphine.ja.sebaghyohan.threads;

/**
 * Hello world!
 *
 */
public class ThreadTest {
    
    private static int n = 0;
    
    public static Runnable getRunnable(final int id){
        return new Runnable(){
          
            @Override
            public synchronized void run(){
                for(; n < 10000; n++) {
                    System.out.println("Je suis le Thread " + id + " et j'effecture l'iteration " + n);
                }
            }
        };
    }
    
    public static void main( String[] args ) {
        
        Thread t1 = new Thread(ThreadTest.getRunnable(1));
        Thread t2 = new Thread(ThreadTest.getRunnable(2));
        t1.start();
        t2.start();
    }
}
