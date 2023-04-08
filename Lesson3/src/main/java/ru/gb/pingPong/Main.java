package ru.gb.pingPong;

public class Main {
    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        Thread pingThread = new PingThread(pingPong);
        Thread pongThread = new PongThread(pingPong);
        pingThread.start();
        pongThread.start();
    }
}