package fr.dauphine.ja.sebaghyohan.td00;

import java.util.ArrayList;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class PrimeCollection 
{
	private ArrayList<Integer> primeNumbers;
	
	public PrimeCollection() {
		primeNumbers = new ArrayList<>();
	}
	
    public static void main( String[] args )
    {
        PrimeCollection primes = new PrimeCollection();
        primes.initRandom(100, 2000);
        primes.printPrimes();
        
        
    }
    
   
    public void initRandom(int n, int m) {
    	
    	for(int i = 0; i < n; i++) {
    		Random random = new Random();
    		primeNumbers.add(random.nextInt(m+1));
    	}
    }
    
    public static boolean isPrime(int p) {
    	
    	int racine = (int) Math.sqrt(p);
    	
    	if(p == 0) return false;
    	
    	for (int i = 2; i <= racine; i++) {
    		if(p % i == 0 && i != p) {
    			return false;
    		}
    	}
    	return true;
    	
    }
    
    public void printPrimes() {
    	
    	int size = primeNumbers.size();
    	for(int i = 0; i < size; i++) {
    		int primeNumber = primeNumbers.get(i);
    		if(PrimeCollection.isPrime(primeNumber)) {
    			System.out.println(primeNumber);
    		}
    	}
    }
    
    
}
