/**
    =========================
    ===== PROJECT EULER =====
    =========================

    Problem 5

    https://projecteuler.net/problem=5

    2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

	
	
	In other words, what is LCM([1,20])?
	Generalized to find the LCM of an arbitrary array of longs.
	This solution uses two utility functions to get LCM and GCD of two numbers.
**/

package io.github.joshmdonato.Euler;

import java.util.Arrays;

public class Euler005 {

    //Program starts and stops here.
    public static void main(String[] args) {

        long[] l_Numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        System.out.format("%nLCM([%d,%d]) = %d",1,20, Arrays.stream(l_Numbers).reduce(1,(x,y)->lcm(x,y)));

        //Goodbye.
        System.out.format("%n%n");
        return;
    }

    //Finds and returns the least common multiple of a and b.
    public static long lcm(long a, long b)
    {
        //LCM of 0 and anything is 0.
        if(a == 0 || b == 0)
        {
            return 0;
        }

        return Math.abs(a*b)/gcd(a,b);
    }

    //Finds and returns the greatest common divisor of a and b.
    public static long gcd(long a, long b)
    {
        if(a==b)
        {
            //GCD of two equal numbers is that same number; abort entirely.
            return a;
        }

        //GCD of 0 and a number is the absolute value of that number.
        if(a == 0)
        {
            return Math.abs(b);
        } else if(b == 0)
        {
            return Math.abs(a);
        }

        //Use an improved version of the Euclidean algorithm.
        while(a%b != 0)
        {
            //Ensure a < b.
            if(a > b) {
                a ^= b;
                b ^= a;
                a ^= b;
            }

            b %= a;

            if(b == 0)
            {
                //GCD found; return now.
                return a;
            }
        }

        //b is now the GCD.
        return b;
    }


}