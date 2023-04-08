package ru.gb.pingPong;

public class PingPong {
    private volatile boolean pingTurn = true;
    private final Object monitor = new Object();

    public void ping() {
        synchronized (monitor) {
            while (!pingTurn) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("ping");
            pingTurn = false;
            monitor.notify();
        }
    }

    public void pong() {
        synchronized (monitor) {
            while (pingTurn) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("pong");
            pingTurn = true;
            monitor.notify();
        }
    }
}
