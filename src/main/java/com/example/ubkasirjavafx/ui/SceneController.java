package com.example.ubkasirjavafx.ui;

import com.example.ubkasirjavafx.services.Delay;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneController implements Initializable {

    /**[START]*/
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

    /**[START]*/
    /*SplashScreen*/
    @FXML private ImageView splashscreen_icon_iv;
    /**==[END]==*/

    /**[START]*/
    //Initializer
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*SPLASH SCREEN*/
        new Delay().postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println(getClass().getResource("/com/example/ubkasirjavafx/homemenu_activity.fxml"));
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ubkasirjavafx/homemenu_activity.fxml"));
                try {
                    Scene scene = new Scene(fxmlLoader.load(), 800, 600);
                    Stage stage = (Stage) splashscreen_icon_iv.getScene().getWindow();
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 2000);
    }
    /**==[END]==*/
}
