package com.example.ubkasirjavafx.ui;

import com.example.ubkasirjavafx.services.Services;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneController implements Initializable {

    /**
     * [START]
     */
    /*HomeMenu*/
    @FXML
    private Button btnKembali;
    @FXML
    private AnchorPane scrlPesanan;
    @FXML
    private TextField textTotal;
    @FXML
    private Button btnCetak;
    @FXML
    private Button btnMakanan;
    @FXML
    private Button btnMinuman;
    @FXML
    private Button btnCamilan;
    /**==[END]==*/

    /**
     * [START]
     */
    /*SplashScreen*/
    @FXML
    private ImageView splashscreen_icon_iv;
    /**==[END]==*/

    /**
     * [START]
     */
    /*Initializer*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*SPLASH SCREEN*/
        new Services().postDelayed(
                () -> {
                    try {
                        new Services().transferScene("/com/example/ubkasirjavafx/homemenu_activity.fxml", splashscreen_icon_iv.getScene().getWindow());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                , 1800);
    }
    /**==[END]==*/
}
