package com.company.random;

import com.company.Main;

import java.util.stream.IntStream;

/**
 * If you choose to put the response in a git repository, a gist or similar, this is fine but with one big warning: please do not release any responses to the public.
 * <p>
 * Here is the coding challenge:
 * <p>
 * 1. In the below code, what does the retrieve() method do? Would you suggest any improvements? Specifically,
 * Are there any outcomes that should be made possible / prevented?
 * The invocation of this method is likely to occur on a performance-critical codepath. How will your proposed changes affect its performance characteristics?
 * <p>
 * Please suggest the bare minimum of changes that achieve the result.
 */
public class SynchronizedRetrieveTest {

    private static final Object LOCK = new Object();
    private static Object o = null;
    private static Integer count = 0;
    private static Integer totalCallCount = 0;
    private static final int TOTAL_COUNT = 1000000;

    public static Object retrieve() {
        totalCallCount++;
        if (o == null) {
            Main.println("inside 1");
            synchronized (LOCK) {
                Main.println("inside 2");
                o = create();
            }
        }
//        Main.println("called for count " + totalCallCount);
        return o;
    }

    private static Object create() {
        // mock implementation, would actually return a useful object
        count++;
        return new Object();
    }


    public static void main(String[] args) {

        Main.println("Starting");

        new Thread(() -> {
            IntStream.range(0, TOTAL_COUNT).forEach(key -> retrieve());
        }).start();

        while (totalCallCount < TOTAL_COUNT) {
            if (count > 5) {
                throw new RuntimeException("Our singleton does not work!");
            }
        }

        Main.println("Ending");

    }


    private void doStuff() {
    }

    private static void doStaticStuff() {
    }

    //  NOTES
//  #1 BELOW ARE THE SAME
//  When you use the synchronized modifier on an instance method (a non-static method),
//  it is very similar to having a synchronized block with "this" as the argument.
//  So in the following example, methodA() and methodB() will act the same way:
    public synchronized void methodA() {
        doStuff();
    }

    public void methodB() {
        synchronized (this) {
            doStuff();
        }
    }

//  #2 STATIC METHODS
    static synchronized void staticMethodA() {
        doStaticStuff();
    }

    public static void staticMethodB() {
        synchronized (SynchronizedRetrieveTest.class) {
            doStaticStuff();
        }
    }

}
