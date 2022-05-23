package com.example.ubkasirjavafx.controller;

import com.example.ubkasirjavafx.services.MyContent;
import com.example.ubkasirjavafx.services.MyMenu;
import com.example.ubkasirjavafx.services.Services;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeMenuController implements Initializable {

    private MyMenu mymenu;

    @FXML
    private Button btnKembali;
    @FXML
    private TextField textTotal;
    @FXML
    private Button btnBayar;
    @FXML
    private Button btnMakanan;
    @FXML
    private Button btnMinuman;
    @FXML
    private Button btnCamilan;
    @FXML
    private GridPane contentTable;
    @FXML
    private ListView listPesanan;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mymenu = new MyMenu(listPesanan, textTotal);
        textTotal.setFont(Font.font(24));
        textTotal.setText("0");

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

        btnMakanan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setPreviewMakanan();
            }
        });

        btnMinuman.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setPreviewMinuman();
            }
        });

        btnCamilan.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                setPreviewSnack();
            }
        });

        btnBayar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Services().postDelayed(
                        () -> {
                            try {
                                new Services().transferScene("/com/example/ubkasirjavafx/windowbayar_activity.fxml", btnKembali.getScene().getWindow());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        , 0);
            }
        });

        // Call default Preview (Makanan preview)
        contentTable.setHgap(32);
        contentTable.setVgap(16);
        contentTable.setPadding(new Insets(16, 16, 16, 16));
        contentTable.setAlignment(Pos.BASELINE_LEFT);

        setPreviewMakanan();
    }

    void setPreviewMakanan() {
        contentTable.getChildren().clear();

        //Menampilkan Menu
        int x = 0, y = 0;

        for (StackPane i : mymenu.makanan) {
            contentTable.add(i, x++, y);
            if (x == 5) {
                x = 0;
                y++;
            }
        }

    }

    void setPreviewMinuman() {
        contentTable.getChildren().clear();

        //Menampilkan Menu
        int x = 0, y = 0;

        for (StackPane i : mymenu.minuman) {
            contentTable.add(i, x++, y);
            if (x == 5) {
                x = 0;
                y++;
            }
        }

    }

    void setPreviewSnack() {
        contentTable.getChildren().clear();

        //Menampilkan Menu
        int x = 0, y = 0;

        for (StackPane i : mymenu.camilan) {
            contentTable.add(i, x++, y);
            if (x == 5) {
                x = 0;
                y++;
            }
        }

    }
}
