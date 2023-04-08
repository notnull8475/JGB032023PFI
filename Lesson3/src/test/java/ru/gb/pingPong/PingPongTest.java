package ru.gb.pingPong;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PingPongTest {
    private static final int ITERATIONS = 10;

    @Test
    public void testPingPong() throws InterruptedException {
        PingPong pingPong = new PingPong();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        Thread pingThread = new Thread(() -> {
            for (int i = 0; i < ITERATIONS; i++) {
                pingPong.ping();
            }
        });

        Thread pongThread = new Thread(() -> {
            for (int i = 0; i < ITERATIONS; i++) {
                pingPong.pong();
            }
        });

        pingThread.start();
        pongThread.start();

        pingThread.join();
        pongThread.join();

        String output = outputStream.toString();

        assertEquals("ping\npong\n".repeat(ITERATIONS), output);
    }
}
