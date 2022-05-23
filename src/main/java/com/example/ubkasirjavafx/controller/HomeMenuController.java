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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeMenuController implements Initializable {

    MyMenu mymenu;

    @FXML
    private Button btnKembali;
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
    @FXML
    private GridPane contentTable;

    @FXML
    private ListView listPesanan;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mymenu = new MyMenu(listPesanan);

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

        // Call default Preview (Makanan preview)
        contentTable.setHgap(32);
        contentTable.setVgap(16);
        contentTable.setPadding(new Insets(16, 16, 16, 16));
        contentTable.setAlignment(Pos.BASELINE_CENTER);

        setPreviewMakanan();
    }

    void setPreviewMakanan() {
        contentTable.getChildren().clear();
        contentTable.add(mymenu.makanan[0].build(getClass().getResourceAsStream("/com/example/ubkasirjavafx/res/dummy_food.png")),0,0);
    }

    void setPreviewMinuman() {
        contentTable.getChildren().clear();
    }

    void setPreviewSnack() {
        contentTable.getChildren().clear();
    }
}
