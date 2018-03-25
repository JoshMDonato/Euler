/*
    =========================
    ===== PROJECT EULER =====
    =========================

    Problem 4

    https://projecteuler.net/problem=4

    A palindromic number reads the same both ways.
    The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    Find the largest palindrome made from the product of two 3-digit numbers.

	
	
	This solution uses a function which gets a complete list of factors.
	While this is almost certainly not necessary, the function will be useful in future problems.
	However, this function probably won't have to be called more than about 100 times.
*/

package io.github.joshmdonato.Euler;

import java.util.Vector;

public class Euler004 {

    //Program starts and stops here.
    public static void main(String[] args)
    {
        //Do it!
        findPalindrome();

        //Goodbye.
        System.out.format("%n%n");
        return;
    }

    //Finds and returns the palindrome described in the header.
    private static int findPalindrome()
    {
        /*
            Running on the assumption that the solution has 6 digits with digits ABCCBA.
            A, B, or C may possibly be equal to each other.
            Because 999*999 = 998001, the largest possible palindrome to check is 997799.
            Check that, then subtract (in most cases) 1100 to get the next palindrome to check.
        */

        for(int i = 997799; i >= 100001; i -= 1100)
        {
            //Get the submultiples of i.
            Vector v = getAllSubmultiples(i);

            while(v.size() > 2)
            {
                //Cut out the first and last submultiples.
                v.removeElementAt(0);
                v.removeElementAt(v.size() - 1);

                //Check what's now the first and last submultiple remaining.
                //a*b = i
                int a = (int)v.firstElement();
                int b = (int)v.lastElement();

                if(a >= 100 && a <= 999)
                {
                    //a is a three digit number
                    if(b >= 100 && b <= 999)
                    {
                        //So is b; i is the desired palindrome.
                        System.out.format("%n%d = %d*%d is the largest palindrome of two three-digit numbers.",i,a,b);
                        return i;
                    }
                }
            }

            if(Math.floor(i/1000)%10 == 0)
            {
                //If i takes the form AB00BA, only subtract 110 to get A'B'99B'A'.
                i += 990;

                if(Math.floor(i/10000)%10 == 0)
                {
                    //If i takes the form A0000A, only subtract 11 to get A'99999A'.
                    i += 99;
                }
            }
        }

        System.out.println("%nThe solution is less than 6 digits!");
        return 0;
    }

    //Finds and returns all aliquot parts of n as an ordered vector of integers.
    public static Vector getAllSubmultiples(long n)
    {
        Vector v_Factors = new Vector();
        Vector v_Aliquant = new Vector(); //Vector of numbers of whose multiples can be skipped.
        v_Factors.clear();
        v_Aliquant.clear();


        //Start to find all aliquot parts from 1 up to, but not including, the square root of n.
        for(int i = 1; i < Math.sqrt(n); i++)
        {
            boolean b_isAliquant = false;

            for(int j = 0; j < v_Aliquant.size(); j++)
            {
                //Is i a multiple of an aliquant part? If so, then so is i.
                if(i%(int)v_Aliquant.elementAt(j) == 0)
                {
                    b_isAliquant = true;
                    break;
                }
            }

            //Abort if i was found to be an aliquant part.
            if(b_isAliquant)
            {
                continue;
            }

            //Is i a submultiple of n? If so, record it. Otherwise, mark it as an aliquant part.
            if((n%i) == 0)
            {
                v_Factors.add(i); //Record i.
            } else {
                v_Aliquant.add(i); //Disregard this number, and all future multiples of this number.
            }
        }

        //Record the size of the vector before possibly including the square root.
        //If the square root is included, it will automatically be skipped over in the last step.
        int s = v_Factors.size()-1;

        //Record the square root if it is an integer.
        if(n%Math.sqrt(n) == 0)
        {
            v_Factors.add((int)Math.sqrt(n));
        }

        //Use the aliquot parts other than the square root to get the remaining aliquot parts.
        for(int k = s; k >= 0; k--)
        {
            v_Factors.add((int)(n/(int)v_Factors.elementAt(k)));
        }

        //Do it!
        return v_Factors;
    }
}