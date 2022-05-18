package com.example.ubkasirjavafx.services;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class Services {
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

    public void transferScene(String fxmlName, Window window) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlName));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage stage = (Stage) window;
        stage.setScene(scene);
    }
}
