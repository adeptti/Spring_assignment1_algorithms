import java.math.BigInteger;

public class Problem4_WhereInSequence {

    public static int whereInSeq(BigInteger x){
        if (x.compareTo(BigInteger.ZERO) <= 0) return 0;

        if (x.equals(BigInteger.ZERO)) return 0;
        if (x.equals(BigInteger.ONE)) return 1;

        BigInteger prevPrev = BigInteger.ZERO;
        BigInteger prev = BigInteger.ONE;
        int idx = 1;

        while(true){
            BigInteger next = prev.multiply(BigInteger.valueOf(3)).divide(BigInteger.valueOf(2))
                    .add(prevPrev.multiply(BigInteger.valueOf(2)));
            idx++;

            int cmp = next.compareTo(x);
            if (cmp == 0) return idx;
            if (cmp > 0) return idx -1;

            prevPrev = prev;
            prev = next;
        }
    }

    public static void main(String[] args){
        BigInteger x = (args.length >= 1) ? new BigInteger(args[0]) : BigInteger.valueOf(1763);

        System.out.println("Problem 4: Where in Sequence");
        System.out.println("Input terms = " + x);
        System.out.println("Output index = " + whereInSeq(x));
    }
}
