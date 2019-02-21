/**
 * CarlStackTester.java
 * Jeff Ondich, 31 January 2019
 *
 * A few tests for our CarlStack interface and its
 * implmentations CarlStackLL (based on Java's
 * LinkedList, pushing at the front), CarlStackAL
 * (based on ArrayList, pushing at the back), and
 * CarlStackALBad (based on ArrayList, pushing at
 * the front).
 */
public class CarlStackTester {
    public static void main(String[] args) {
        if (args.length == 0) {
            testStack(new CarlStackLL<String>());
            testStack(new CarlStackAL<String>());
            testStack(new CarlStackALBad<String>());
        } else {
            int N = Integer.parseInt(args[0]);
            timeTestStack(new CarlStackAL<String>(N), N);
            timeTestStack(new CarlStackALBad<String>(N), N);
        }
    }

    private static void testStack(CarlStack<String> stack) {
        System.out.format("====== Testing %s ======\n", stack.getClass().getName());

        // Push some stuff
        String[] animals = {"ant", "bat", "cat", "dog", "emu"};
        for (int k = 0; k < animals.length; k++) {
            System.out.format("Push: %s\n", animals[k]);
            stack.push(animals[k]);
        }

        // Peek, then pop everything
        System.out.format("Peek: %s\n", stack.peek());
        while (!stack.isEmpty()) {
            System.out.format("Pop: %s\n", stack.pop());
        }
        System.out.println();
    }

    private static void timeTestStack(CarlStack<String> stack, int N) {
        System.out.format("====== Time-testing %s ======\n", stack.getClass().getName());
        String[] animals = {"ant", "bat", "cat", "dog", "emu"};
        long startTime = System.currentTimeMillis();
        for (int k = 0; k < N; k++) {
            int index = k % animals.length;
            stack.push(animals[index]);
        }
        long timeElapsed = System.currentTimeMillis() - startTime;
        System.out.format("Pushing: %.4f seconds\n", (double)timeElapsed / 1000.0);
    }
}
