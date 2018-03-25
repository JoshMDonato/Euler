/**
    =========================
    ===== PROJECT EULER =====
    =========================

    Problem 3

    https://projecteuler.net/problem=3

    The prime factors of 13195 are 5, 7, 13 and 29.
    What is the largest prime factor of the number 600851475143?
	
	
	
	Generalized to find the largest prime factor of N.
	Not optimized very well; uses trial divisions but tries to minimize the amount of divisions as much as possible.
**/

package io.github.joshmdonato.Euler;

import java.util.Vector;

public class Euler003 {

    private static long PRODUCT_N = 600851475143L; //Normally 600851475143.

    //Program starts and stops here.
    public static void main(String[] args)
    {
        //Do it!
        System.out.format("%nThe largest prime factor of %d is %d.", PRODUCT_N,getLargestPrimeFactor(getPrimeFactorization(PRODUCT_N)));

        //Goodbye.
        System.out.format("%n%n");
        return;
    }

    //Gets and returns the largest prime factor of a list of prime factors.
    //In this case, it's always the last element of the vector.
    public static long getLargestPrimeFactor(Vector v)
    {
        return (long)v.lastElement();
    }

    //Finds and returns the prime factorization of n as an ordered vector of integers.
    public static Vector getPrimeFactorization(long n)
    {
        Vector v_Factors = new Vector();
        v_Factors.clear();


        //Try to find all even prime factors.
        while((n&1) == 0)
        {
            n /= 2;
            v_Factors.add(2L);
        }

        //Try to find all factors which equal 3.
        while((n%3) == 0)
        {
            n /= 3;
            v_Factors.add(3L);
        }

        //All other prime factors take the form of 6k-1 or 6k+1.
        for(long i = 5; i <= n; i += 2)
        {
            //Find prime factors which equal i.
            //If there is one, i must be prime, otherwise i could be factored into numbers already checked.
            while((n%i) == 0)
            {
                n /= i;
                v_Factors.add(i);
            }

            //Stop if the number is completely factorized.
            if(n==1)
            {
                break;
            }

            //Numbers of the form 6k+3 are not prime and can, and should, be skipped.
            if(i%6 == 1)
            {
                i += 2;
            }
        }

        return v_Factors;
    }
}