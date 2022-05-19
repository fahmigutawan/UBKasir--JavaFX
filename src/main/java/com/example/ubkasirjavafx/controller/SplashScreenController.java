package com.example.ubkasirjavafx.controller;

import com.example.ubkasirjavafx.services.Services;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashScreenController implements Initializable {

    @FXML
    private ImageView splashscreen_icon_iv;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Services().postDelayed(
                () -> {
                    try {
                        new Services().transferScene("/com/example/ubkasirjavafx/mainmenu_activity.fxml", splashscreen_icon_iv.getScene().getWindow());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                , 2000);
    }


}
