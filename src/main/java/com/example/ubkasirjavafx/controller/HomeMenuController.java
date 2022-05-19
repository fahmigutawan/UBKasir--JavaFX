package com.example.ubkasirjavafx.controller;

import com.example.ubkasirjavafx.services.Services;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeMenuController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Define Kembali Button Action
        btnKembali.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Services().postDelayed(
                        () -> {
                            try {
                                new Services().transferScene("/com/example/ubkasirjavafx/mainmenu_activity.fxml", btnKembali.getScene().getWindow());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        , 0);
            }
        });

    }


}
