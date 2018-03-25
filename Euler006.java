/*
    =========================
    ===== PROJECT EULER =====
    =========================

    Problem 6

    https://projecteuler.net/problem=6

    The sum of the squares of the first ten natural numbers is,
    1^2 + 2^2 + ... + 10^2 = 385

    The square of the sum of the first ten natural numbers is,
    (1 + 2 + ... + 10)^2 = 55^2 = 3025

    Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
    3025 − 385 = 2640

    Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
	
	
	
	When dealing with the first N natural numbers, known formulas can be used and combined.
	This allows the problem to be solved in O(1) time.
*/

package io.github.joshmdonato.Euler;

public class Euler006 {

    private static final int N = 100;

    //Program starts and stops here.
    public static void main(String[] args)
    {
        //Do it!
        System.out.format("%nDifference between sum of squares and square of sum of the first %d natural numbers is %d.",N,(6*N*N*N*N + 4*N*N*N - 6*N*N - 4*N)/24);

        //Goodbye.
        System.out.format("%n%n");
        return;
    }

}