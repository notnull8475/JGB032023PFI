package ru.gb.pingPong;

public class PongThread extends Thread {
    private final PingPong pingPong;

    public PongThread(PingPong pingPong) {
        this.pingPong = pingPong;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            pingPong.pong();
        }
    }
}