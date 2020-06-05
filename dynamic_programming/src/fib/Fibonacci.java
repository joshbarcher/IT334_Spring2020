package fib;

public class Fibonacci
{
    private static long[] fibNums;

    public static void main(String[] args)
    {
        System.out.println(fib(115));
    }

    public static long fib(int n)
    {
        fibNums = new long[n];
        return recFib(n);
    }

    private static long recFib(int n)
    {
        //base cases
        if (n == 0 || n == 1)
        {
            return n;
        }

        //recurse
        long fibn1 = getFib(n - 1);
        long fibn2 = getFib(n - 2);

        return fibn1 + fibn2;
    }

    //use memoization technique to cache expensive calls
    private static long getFib(int n)
    {
        if (fibNums[n] == 0)
        {
            fibNums[n] = recFib(n);
        }
        return fibNums[n];
    }
}












