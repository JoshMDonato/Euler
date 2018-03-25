/**
    =========================
    ===== PROJECT EULER =====
    =========================

    Problem 7

    https://projecteuler.net/problem=7

    By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
    What is the 10001st prime number?

	
	
	Optimized slightly by only checking numbers which are 1 mod 6 or 5 mod 6.
    Makes use of the functions developed for Problem 3, even though that makes for a slow solution.
**/

package io.github.joshmdonato.Euler;

public class Euler007 {

    private static final int N = 10001; //Normally 10001.

    //Program starts and stops here.
    public static void main(String[] args)
    {
        //Do it!
        getPrime(N);

        //Goodbye.
        System.out.format("%n%n");
        return;
    }

    //Finds (slowly) and returns the nth prime.
    public static long getPrime(int n)
    {
        //Check for small values of n.
        System.out.format("%nFirst prime is 2.");
        if(n <= 1)
        {
            return 2L;
        }

        System.out.format("%nSecond prime is 3.");
        if(n == 2)
        {
            return 3L;
        }

        int i = 2;
        long p = 3;

        while(i < n)
        {
            //Search from p+2 to find primes. They will take the form 6k-1 or 6k+1.
            for(long j = p+2; ; j += 2)
            {
                //Skip multiples of 3.
                if(j%3 == 0)
                {
                    j += 2;
                }

                if(Euler003.getLargestPrimeFactor(Euler003.getPrimeFactorization(j)) == j)
                {
                    //Next prime found. Record it and break out.
                    p = j;
                    i++;

                    //Also display to console to acknowledge program is still running.
                    System.out.format("%nPrime #%d is %d.",i,p);

                    break;
                }
            }
        }

        //Do it!
        return p;
    }
}