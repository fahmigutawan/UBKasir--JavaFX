package com.example.ubkasirjavafx.ui;

import com.example.ubkasirjavafx.UbKasir;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.util.Objects;

public class SplashScreenWindow extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(UbKasir.class.getResource("splashscreen_activity.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),800, 600);
        stage.setResizable(false);
        stage.setTitle("UB KASIR");
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/icon_app.png"))));
        stage.setScene(scene);
        stage.show();
    }

    public void run() {
        launch();
    }

}
