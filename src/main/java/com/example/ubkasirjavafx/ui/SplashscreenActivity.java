package com.example.ubkasirjavafx.ui;

import com.example.ubkasirjavafx.services.Delay;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SplashscreenActivity {
    @FXML
    private Label myId;

    SplashscreenActivity(){
        myId.setText("ASDASD");
    }
    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try { Thread.sleep(millis); }
                catch (InterruptedException e) { }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }
}
