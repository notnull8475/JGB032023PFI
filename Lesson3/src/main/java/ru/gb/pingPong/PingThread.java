package ru.gb.pingPong;

public class PingThread extends Thread {
    private final PingPong pingPong;

    public PingThread(PingPong pingPong) {
        this.pingPong = pingPong;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            pingPong.ping();
        }
    }
}