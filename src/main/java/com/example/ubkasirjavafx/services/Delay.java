package com.example.ubkasirjavafx.services;

import javafx.application.Platform;

public class Delay {
    public void postDelayed(Runnable toRun, long wait) {
        Thread thread = new Thread();

        if (thread.isAlive()) {
            thread.interrupt();
        }
        thread = new Thread(() -> {
            boolean interrupted = false;
            try {
                Thread.sleep(wait);
            } catch (InterruptedException ignored) {
                interrupted = true;
            }
            if (!interrupted) {
                Platform.runLater(toRun);
            }
        });
        // Daemon - allows the thread to be terminated when JVM terminates
        thread.setDaemon(true);
        thread.start();
    }
}
