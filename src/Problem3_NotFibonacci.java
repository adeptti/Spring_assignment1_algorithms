import java.math.BigInteger;

public class Problem3_NotFibonacci {

    /*  Generates k terms of the "Not Fibonnaci" sequence:
    *   a0 = 0, a1 = 1
    *   ai = floor(1.5 * a(i-1)) + 2 * a(i-2) for i >= 2
    * 
    * We use BigInteger because the values grow quickly and will overflow into int/long.
    * 
    * Note on floor:
    * 1.5 * prev = (2 * prev) / 2.
    * Since all terms are nonnegative, integer division by 2 is equivalent to floor.
    */

    public static BigInteger[] notFibonacci(int k){
        if(k <= 0) return new BigInteger[0];

        BigInteger[] seq =  new BigInteger[k];

        // Base cases
        seq[0] = BigInteger.ZERO;
        if (k == 1) return seq;

        seq[1] = BigInteger.ONE;

        // prevPrev = a(i-2), prev = 1(i-1)
        BigInteger prevPrev = seq[0];
        BigInteger prev = seq[1];

        for (int i = 2; i < k; i++) {

            // term1 = floor(1.5 * prev) = floor((3*prev)/2) -> (3*prev)/2 with integer division
            BigInteger term1 = prev.multiply(BigInteger.valueOf(3)).divide(BigInteger.valueOf(2));

            // term2 = 2 * prevPrev
            BigInteger term2 = prevPrev.multiply(BigInteger.valueOf(2));

            //  next = ai
            BigInteger next = term1.add(term2);

            seq[i] = next;

            //  shift window forward
            prevPrev = prev;
            prev = next;
        }
        return seq;
    }

    private static void printSeq(BigInteger[] seq){
        for(int i = 0; i < seq.length; i++){
            System.out.print(seq[i]);
            if(i < seq.length-1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int k = (args.length >= 1) ? Integer.parseInt(args[0]) : 10;

        System.out.println("Problem 3: Not Fibonacci");
        System.out.println("Input terms = " + k);

        BigInteger[] seq = notFibonacci(k);

        System.out.println("Output sequence = ");
        printSeq(seq);
    }
}


