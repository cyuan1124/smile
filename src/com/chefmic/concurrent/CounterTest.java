package com.chefmic.concurrent;

import org.junit.Test;

/**
 * Created by cyuan on 4/1/17.
 */
public class CounterTest {

    class Counter {
        int counter;

        public void increment() {
            System.out.println(Thread.currentThread().getName() + " : " + counter++);
        }
    }

    class CounterThread extends Thread {

        private Counter counter;

        public CounterThread(Counter counter, String name) {
            super(name);
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        }
    }

    @Test
    public void test() {
        Counter counter = new Counter();
        Thread t1 = new CounterThread(counter, "Thread-1");
        Thread t2 = new CounterThread(counter, "Thread-2");
        t1.start();
        t2.start();
    }
}
