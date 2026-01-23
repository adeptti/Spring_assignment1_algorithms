import java.math.BigInteger;

public class Problem3_NotFibonacci {

    // next floor(1.5*prev) + 2*prevPrev
    // floor(1.5*prev)= floor(3*prev/2) => (3*prev)/2 with integer division

    public static BigInteger[] notFibonacci(int k){
        if(k <= 0) return new BigInteger[0];

        BigInteger[] seq =  new BigInteger[k];
        seq[0] = BigInteger.ZERO;
        if (k == 1) return seq;

        seq[1] = BigInteger.ONE;
        BigInteger prevPrev = BigInteger.ZERO;
        BigInteger prev = BigInteger.ONE;

        for (int i = 2; i < k; i++) {
            BigInteger term1 = prev.multiply(BigInteger.valueOf(3)).divide(BigInteger.valueOf(2));
            BigInteger term2 = prevPrev.multiply(BigInteger.valueOf(2));
            BigInteger next = term1.add(term2);

            seq[i] = next;
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


