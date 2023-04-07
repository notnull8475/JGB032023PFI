package ru.gb.counter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CounterTest {
    @Test
    public void testCounter() throws InterruptedException {
        Counter counter = new Counter();
        int numThreads = 100;
        int numIncrementsPerThread = 10000;
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < numIncrementsPerThread; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < numThreads; i++) {
            threads[i].join();
        }
        assertEquals(numThreads * numIncrementsPerThread, counter.getValue());
    }
}

