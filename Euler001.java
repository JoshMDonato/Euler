import java.io.PrintStream;

public class Euler001 {

    /*
        =========================
        ===== PROJECT EULER =====
        =========================

        Problem 1

        https://projecteuler.net/problem=1

        If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
        The sum of these multiples is 23.
        Find the sum of all the multiples of 3 or 5 below 1000.



        Generalized to find the sum of all multiples of A or B below N.
        Optimized to O(1) by using arithmetic sum of first m integers in place of loops.
    */

    private static final int LIMSUP_N = 1000; //Normally 1000.
    private static final int FACTOR_A = 3; //Normally 3.
    private static final int FACTOR_B = 5; //Normally 5.

    //Program starts and stops here.
    public static void main(String []args)
    {
        //Get the sum and print it.
        System.out.format("%nThe sum of all multiples of %d and %d below %d is %d", FACTOR_A, FACTOR_B, LIMSUP_N, getSum(LIMSUP_N));
        return;
    }

    //Finds the sum of all multiples of A or B below n. Returns the sum.
    private static int getSum(int n)
    {
        //Do not include n itself.
        n--;

        //Set the sum.
        int s = 0;

        //Add in each multiple of A up to n.
        int m = (int)Math.floor(n/FACTOR_A);

        /*
            There are exactly m consecutive multiples to add in, starting with 1*A.
            This is exactly A * m*(m+1)/2.
        */
        s += FACTOR_A*(m*(m+1)/2);

        //Add in each multiple of B up to n. Same process as above.
        m = (int)Math.floor(n/FACTOR_B);
        s += FACTOR_B*(m*(m+1)/2);

        //Remove the intersection; that is, multiples of A*B which were doubly counted.
        m = (int)Math.floor(n/(FACTOR_A*FACTOR_B));
        s -= FACTOR_A*FACTOR_B*(m*(m+1)/2);

        //Do it!
        return s;
    }

}
