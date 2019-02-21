/**
 * TimingDemo.java
 * Jeff Ondich, 13 February 2019
 *
 * A demonstration of simple timing code.
 */

public class TimingDemo {
    public static void main(String[] args) {
        // I'm not even putting a usage message here. You can figure out
        // how to run this program.
        int N = Integer.parseInt(args[0]);

        // Do a long silly triple loop and time it.
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // Nothing to see here. We're just counting a lot.
                }
            }
        }
        long timeElapsed = System.currentTimeMillis() - startTime;
        System.out.format("Pushing: %.4f seconds\n", (double)timeElapsed / 1000.0);
    }
}
