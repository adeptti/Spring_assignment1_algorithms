import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;

public class ExtraCredit_NotFibPlot extends JPanel {

    private static final int N = 1200;
    private static double[] logValues;

    // Generate NotFibonacci sequence and store log10(values)
    private static void generate(){
        logValues = new double[N];

        BigInteger prevPrev = BigInteger.ZERO;
        BigInteger prev = BigInteger.ONE;

        logValues[0] = 0.0; // treat log10(0) as 0 for plotting
        logValues[1] = 0.0; // log10(1)=0

        for (int i = 2; i < N; i++){
            BigInteger next = prev.multiply(BigInteger.valueOf(3))
                    .divide(BigInteger.valueOf(2))
                    .add(prevPrev.multiply(BigInteger.valueOf(2)));

            logValues[i] = log10BigInteger(next); // <-- no doubleValue()

            prevPrev = prev;
            prev = next;
        }
    }

    private static double log10BigInteger(BigInteger x){
        if (x.signum() <= 0) return 0.0;

        // log10(x) = log2(x) / log2(10)
        int bitLen = x.bitLength();                 // bitLen >= 1
        int shift = Math.max(0, bitLen - 53);       // keep top ~53 bits for a safe double mantissa
        BigInteger top = x.shiftRight(shift);

        double topAsDouble = top.doubleValue();    // safe: top fits in ~53 bits
        double log2 = (bitLen - 1) + (Math.log(topAsDouble / Math.pow(2, top.bitLength() - 1)) / Math.log(2));

        return log2 / (Math.log(10) / Math.log(2));
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();
        int margin = 50;

        // Axes
        g.drawLine(margin, h - margin, w - margin, h - margin); // x-axis
        g.drawLine(margin, margin, margin, h - margin);         // y-axis

        double maxY = logValues[N - 1];
        if (!Double.isFinite(maxY) || maxY <= 0) maxY = 1.0;

        for (int i = 1; i < N; i++){
            int x1 = margin + (i - 1) * (w - 2 * margin) / N;
            int x2 = margin + i * (w - 2 * margin) / N;

            int y1 = h - margin - (int) ((logValues[i - 1] / maxY) * (h - 2 * margin));
            int y2 = h - margin - (int) ((logValues[i] / maxY) * (h - 2 * margin));

            g.drawLine(x1, y1, x2, y2);
        }

        g.drawString("Index", w / 2, h - 10);
        g.drawString("log10(value)", 5, margin - 10);
        g.drawString("NotFibonacci (first 1200 terms)", w / 2 - 120, 20);
    }

    public static void main(String[] args){
        generate();

        JFrame frame = new JFrame("NotFibonacci Plot (Java)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.add(new ExtraCredit_NotFibPlot());
        frame.setVisible(true);
    }
}
