import java.math.BigInteger;

public class Problem4_WhereInSequence {

    /*
    *   Determines where a given value x fits in the "Not Fibonnaci" sequence
    *   
    *   The sequence is defined as:
    *   a0 = 0, a1 = 1
    *   ai = floor(1.5 * a(i-1)) + 2 * a(i-2)
    * 
    *   If x is exactly a term in the sequence, this method returns its index.
    *   If x falls between two terms, it returns the index of the largest term.
    *   that is less than x
    */

    public static int whereInSeq(BigInteger x){

        // Any non-positive number cannot appear past index 0
        //  BigInteger is used because the sequence grows too fast for primitive numeric types
        if (x.compareTo(BigInteger.ZERO) <= 0) return 0;

        // Handle base cases explicitly
        if (x.equals(BigInteger.ZERO)) return 0;
        if (x.equals(BigInteger.ONE)) return 1;

        //  prevPrev = a(i-2), prev  a(i-1)
        BigInteger prevPrev = BigInteger.ZERO;
        BigInteger prev = BigInteger.ONE;

        //  Current index corresponding to 'prev'
        int idx = 1;

        // Generate the sequence iteratively until we reach or pass x
        while(true){

            /*  Compute the next term using the recurrence:
            *   floor(1.5*prev) is implemented as (3 * prev) / 2.
            *   Since all values are nonnegative, integer division correctly
            *   applies the floor operation
            */
            BigInteger next = prev.multiply(BigInteger.valueOf(3)).divide(BigInteger.valueOf(2))
                    .add(prevPrev.multiply(BigInteger.valueOf(2)));

            idx++; //   move to the next index

            //  compare the newly generated term with x
            int cmp = next.compareTo(x);

            //  If next == x, we found the exact position
            if (cmp == 0) return idx;
    
            //  If next > x, then x lies between prev and next,
            //  so the correct index is the previous one.
            if (cmp > 0) return idx -1;

            //  Shift forward to continue generating the sequence
            prevPrev = prev;
            prev = next;
        }
    }

    public static void main(String[] args){

        //  Read x from command line or use a default value.
        BigInteger x = (args.length >= 1) ? new BigInteger(args[0]) : BigInteger.valueOf(1763);

        System.out.println("Problem 4: Where in Sequence");
        System.out.println("Input terms = " + x);
        System.out.println("Output index = " + whereInSeq(x));
    }
}
