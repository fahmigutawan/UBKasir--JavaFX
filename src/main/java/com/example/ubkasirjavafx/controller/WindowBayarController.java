package com.example.ubkasirjavafx.controller;

import com.example.ubkasirjavafx.services.MyContent;
import com.example.ubkasirjavafx.services.Services;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WindowBayarController implements Initializable {

    @FXML
    private TextField txtTotal;
    @FXML
    private TextField txtPembayaran;
    @FXML
    private TextField txtKembalian;
    @FXML
    private Button btnBayar;
    @FXML
    private Button btnPesananBaru;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Textfield Total
        txtTotal.setText(String.format("%d", MyContent.getTotalBayar()));

        //Define BtnBayar action
        btnBayar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    int bayar = Integer.parseInt(txtPembayaran.getText().trim());
                    int result = bayar - MyContent.getTotalBayar();

                    if (result >= 0) {
                        txtKembalian.setText(String.format("%d", result));
                    }
                    else {
                        txtKembalian.setText("Dasar Misqueen");
                    }
                }catch (Exception e) {
                    txtPembayaran.setText("INPUT TIDAK VALID");
                }
            }
        });
        
        //Define BtnPesananBaru action
        btnPesananBaru.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Services().postDelayed(
                        () -> {
                            try {
                                new Services().transferScene("/com/example/ubkasirjavafx/homemenu_activity.fxml", btnBayar.getScene().getWindow());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        , 0);
            }
        });

    }
}
